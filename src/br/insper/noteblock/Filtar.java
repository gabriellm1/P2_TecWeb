package br.insper.noteblock;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.insper.noteblock.model.DAO;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Filtar extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DAO dao = new DAO();
		
		 //Notas nota = new Notas();
		 String ini = request.getParameter("dataInicial");
		 String fin = request.getParameter("dataFinal");
		 System.out.println(ini);
		System.out.println(fin);
		 
		
		/*java.util.Date dataI = null;
		java.util.Date dataF = null;

		try {
			dataI = new SimpleDateFormat("yyyy-MM-dd").parse(ini);
			dataF = new SimpleDateFormat("yyyy-MM-dd").parse(fin);

			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Calendar dataNotaI = Calendar.getInstance();
		 Calendar dataNotaF = Calendar.getInstance();

		 dataNotaI.setTime(dataI);
		 nota.setDataInicial(dataNotaI);
		 dataNotaF.setTime(dataF);
		 nota.setDataFinal(dataNotaF);*/

		 dao.getFilter(ini,fin);
		 
		 dao.close();
		request.setAttribute("ini",ini);
		request.setAttribute("fin",fin);
		request.getRequestDispatcher("/filtro.jsp").forward(request, response);
		
	}
}
