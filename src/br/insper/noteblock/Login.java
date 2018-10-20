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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		 usuario.setUser(request.getParameter("user"));
		 usuario.setSenha(request.getParameter("senha"));		
		 
		 Integer userid = dao.login(usuario);
		 
		 
		 
		 if(userid != null) {
			request.setAttribute("uid",(userid).toString());
			request.getRequestDispatcher("/display.jsp").forward(request, response);
			}
		 else {
			response.sendRedirect("/NoteBlock/login.jsp");}
		 
		 dao.close();	}




}
