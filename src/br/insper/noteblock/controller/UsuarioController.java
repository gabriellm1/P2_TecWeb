package br.insper.noteblock.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import br.insper.noteblock.model.Usuario;
import br.insper.noteblock.model.DAO;

@Controller
public class UsuarioController {
	

	
	@RequestMapping(value = "usuario", method = RequestMethod.POST)
	 public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 

		DAO dao = new DAO();
		Usuario usuario = new Usuario();
		usuario.setUser(request.getParameter("user"));
		usuario.setSenha(request.getParameter("senha"));
	 
		boolean repetido = dao.addUser(usuario);
		dao.close();
		 if(repetido) {
			return "criauser";
			}
		 else {
			 return "login";
		 	}
	 }

	@RequestMapping(value = "usuario", method = RequestMethod.PUT)
	
	 public @ResponseBody String alt(
			 @RequestBody String rawJson,
			 HttpServletRequest request, HttpServletResponse response
			 ) throws ServletException, IOException {	 
		
		 JSONObject parsedJson = new JSONObject(rawJson);
		 String user = parsedJson.getString("user");
		 String senha = parsedJson.getString("senha");
		 String uid = parsedJson.getString("uid");
		
		DAO dao = new DAO();
		
		Usuario usuario = new Usuario();
		usuario.setId(Integer.parseInt(uid));
		usuario.setUser(user);
		usuario.setSenha(senha);
		 
		dao.altUser(usuario);
		dao.close();
		
		request.setAttribute("uid",(uid).toString());

		return "notas";
	 }
	
	@RequestMapping(value = "usuario", method = RequestMethod.DELETE)
	 public String del(@RequestBody String rawJson)  {	 
		DAO dao = new DAO();
		 JSONObject parsedJson = new JSONObject(rawJson);
		 String uid = parsedJson.getString("uid");
		
		 dao.remUser(Integer.parseInt(uid));
		 
		 dao.close();
		 return "home";		 
	 }
	
	@RequestMapping(value = "usuario", method = RequestMethod.GET)
	 public String log(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 
		


		DAO dao = new DAO();
		
		 Usuario usuario = new Usuario();
		 usuario.setUser(request.getParameter("user"));
		 usuario.setSenha(request.getParameter("senha"));		
		 
		 Integer userid = dao.login(usuario);		 
		 dao.close();
		 if(userid != null) {
			request.setAttribute("uid",(userid).toString());
			return "display";
			}
		 else {
			 return "login";
		 }

	}	
	
	@RequestMapping(value = "dados", method = RequestMethod.GET)
	public String dir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 
		request.setAttribute("uid",request.getParameter("uid"));
		
		return "altdados";
}
}