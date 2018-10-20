package br.insper.noteblock;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.insper.noteblock.model.DAO;

/**
 * Servlet implementation class Filtrar
 */
@WebServlet("/Filtrar")
public class Filtrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Filtrar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		
		 //Notas nota = new Notas();
		 String ini = request.getParameter("dataInicial");
		 String fin = request.getParameter("dataFinal");
		 String uid = request.getParameter("uid");

		 
				 
		dao.close();
		request.setAttribute("ini",ini);
		request.setAttribute("fin",fin);
		request.setAttribute("uid",uid);
		request.getRequestDispatcher("/filtro.jsp").forward(request, response);

	}
}
