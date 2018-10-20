package br.insper.noteblock.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import
org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	 public String alt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 
		
		DAO dao = new DAO();
		
		Usuario usuario = new Usuario();
		usuario.setId(Integer.parseInt((String)request.getParameter("uid")));
		usuario.setUser(request.getParameter("user"));
		usuario.setSenha(request.getParameter("senha"));
		 
		dao.altUser(usuario);
		dao.close();
		//request.setAttribute("uid",(uid).toString());
		return "display";
	 }
	
	@RequestMapping(value = "usuario", method = RequestMethod.DELETE)
	 public String del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 
		
		DAO dao = new DAO();
		
		 dao.remUser(Integer.parseInt((String)request.getParameter("uid")));
		 
		 dao.close();
		 
		 return "login";		 
	 }
	
	@RequestMapping(value = "usuario", method = RequestMethod.GET)
	 public String log(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	 
		
		DAO dao = new DAO();
		
		 Usuario usuario = new Usuario();
		 usuario.setUser(request.getParameter("user"));
		 usuario.setSenha(request.getParameter("senha"));		
		 
		 Integer userid = dao.login(usuario);		 
		 
		 if(userid != null) {
			request.setAttribute("uid",(userid).toString());
			request.getRequestDispatcher("/display.jsp").forward(request, response);
			}
		 else {
			response.sendRedirect("/NoteBlock/login.jsp");}
		 
		 dao.close();
		 
		 return "display";
	 }


	
	
	
	
	
}