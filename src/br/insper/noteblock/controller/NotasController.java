package br.insper.noteblock.controller;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import
org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.insper.noteblock.model.Notas;
import br.insper.noteblock.model.Usuario;
import br.insper.noteblock.model.DAO;

@Controller
public class NotasController {
	
	@RequestMapping(value = "notas", method = RequestMethod.POST)
	 public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 
		DAO dao = new DAO();
		
		 Notas nota = new Notas();
		 nota.setNome(request.getParameter("nome"));
		 nota.setDescri(request.getParameter("descri"));
		 
		 String tempo = request.getParameter("data");
		 java.util.Date data = null;
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse(tempo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Calendar dataNota = Calendar.getInstance();
		 dataNota.setTime(data);
		 nota.setData(dataNota);
		
		 
		 /////////
		 nota.setIduser(Integer.parseInt(request.getParameter("uid")));
		 /////////
		 

		 dao.adiciona(nota);
		 
		 dao.close();
		request.setAttribute("uid",request.getParameter("uid"));
		return "display";
	}
	
	
	@RequestMapping(value = "notas", method = RequestMethod.DELETE, produces="text/plain")
	 public @ResponseBody String del(@RequestBody String rawJson,
			 HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 

		DAO dao = new DAO();
		 JSONObject parsedJson = new JSONObject(rawJson);
		 String uid = parsedJson.getString("uid");
		 String id = parsedJson.getString("id");

		 dao.remove(Integer.parseInt(id));
		 
		 dao.close();

		request.setAttribute("uid",uid);

		return "notas";
		
	}
	
	@RequestMapping(value = "notas", method = RequestMethod.GET)
		public void dir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 
			request.setAttribute("uid",request.getParameter("uid"));
			request.getRequestDispatcher("/display.jsp").forward(request, response);

	}

	
	

	
}