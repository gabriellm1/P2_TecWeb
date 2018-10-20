<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Filtro de Cards</title>
		  <link rel = "stylesheet"
			type ="text/css"
			href = "Form.css"
    />
	</head>
  <body>
  
  <div class="sidenav">
    
    <h3>Filtro</h3>
    
     <form action="AttributePasser">
          <input style="display: none" type="text" name="uid" value="<%=request.getAttribute("uid")%>">
          <input style="display: none" type="text" name="local" value="/display.jsp">
    <input type="image" src="https://static.thenounproject.com/png/344330-200.png" width="68" height="68" class="back-button" ></input>
      </form>
        
    <form action=Filtrar>
    	<input style="display: none" type="text" name="uid" value="<%=request.getAttribute("uid")%>">
	    <h6>De:</h6>
		<input type="date" id="myDate" name="dataInicial" value="Data"><br>
		<h6>Até:</h6>
		<input type="date" id="myDate" name="dataFinal" value="Data"><br>
		<input type="submit" name="Filter" class="form form-Save" value="Filtrar">
	 </form>
	 
  
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}



.back-button {
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 90%;
  left: -1%;
}

/* The popup form - hidden by default */

</style>


 </div>

</body>
  
  <div class="main">
      <section class="card-container">
      
				<%@ page import="java.util.*,br.insper.noteblock.model.*, org.w3c.dom.Document" %>
		<table border='1'>
		
		
		
		<% DAO dao = new DAO();
		String date1 = request.getParameter("dataInicial");
		String date2 = request.getParameter("dataFinal");
		

				

		 List<Notas> Notas = dao.getFilter(date1,date2);
		 for (Notas nota : Notas ) { 
		 	if(nota.getIduser().equals(Integer.parseInt((String)request.getAttribute("uid")))){%>

			  <article class="card">
              	<header class="card__title">
                  	<h3><%=nota.getNome()%></h3>
                  	<h6><%=nota.getDescri()%></h6>
                  	<h5><%=nota.getData().getTime()%></h5>
              	</header>
              
              	<main class="card__description">
                  
              	</main>
           
              	<form action="Remover">
              		<input style="display: none" type="text" name="id" value="<%=nota.getId()%>">
              		<input type="submit" value="Delete">
      			</form>
          		</article>
		<% }} %>
		</table>

      </section>
  </div>
 

</body>
</html>