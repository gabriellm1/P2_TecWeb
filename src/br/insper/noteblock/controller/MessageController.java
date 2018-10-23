package br.insper.noteblock.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import
org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.insper.noteblock.model.Notas;
import br.insper.noteblock.model.Usuario;
import br.insper.noteblock.model.DAO;

@Controller
public class MessageController {

	@RequestMapping(value = "message", method = RequestMethod.GET)
	public String dir( @RequestParam("cont") String descri,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 
		request.setAttribute("uid",request.getParameter("uid"));
		request.setAttribute("descri",request.getParameter("cont"));
		return "compartilha";
	}
		
		@RequestMapping(value = "message", method = RequestMethod.POST)
		public String env(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 
					
			DAO dao = new DAO();

			String telefone = request.getParameter("telefone");
			String descri = request.getParameter("descri");
			dao.message(descri,telefone);
			
			String uid = request.getParameter("uid");
			request.setAttribute("uid",uid);
			return "display";
}
		
		
}