package br.insper.noteblock;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.insper.noteblock.model.DAO;
import br.insper.noteblock.model.Usuario;

/**
 * Servlet implementation class AltUsuario
 */
@WebServlet("/AltUsuario")
public class AltUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		
		 Usuario usuario = new Usuario();
		 usuario.setId(Integer.parseInt((String)request.getParameter("uid")));
		 usuario.setUser(request.getParameter("user"));
		 usuario.setSenha(request.getParameter("senha"));
		 

		
		 

		 dao.altUser(usuario);
		 
		 dao.close();
		request.setAttribute("uid",request.getParameter("uid"));
		request.getRequestDispatcher("/display.jsp").forward(request, response);	
		 }

}
