package br.insper.noteblock;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.insper.noteblock.model.DAO;
import br.insper.noteblock.model.Notas;

/**
 * Servlet implementation class Lista
 */
@WebServlet("/Home")
public class Lista extends HttpServlet {
	
	protected void service(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
	DAO dao = new DAO();
	List<Notas> notas = dao.getLista();
	PrintWriter out = response.getWriter();
	out.println("<html><body><table border='1'>");
	out.println("<tr><td>ID</td><td>Nome</td>" +
	 "<td>Altura</td></tr>");
	for (Notas nota : notas) {
		 out.println("<tr><td>" + nota.getId() + "</td>");
		 out.println("<td>" + nota.getNome() + "</td>");
		 out.println("<td>" + nota.getData().getTime() + "</td>");
	}
	out.println("</table></body></html>");
	
	dao.close();
	
	 }

}
