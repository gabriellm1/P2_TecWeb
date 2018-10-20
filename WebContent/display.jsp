<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Criando Cards</title>
		  <link rel = "stylesheet"
			type ="text/css"
			href = "Form.css"
    />
	</head>
  <body>
  

  <div class="sidenav">
    
    <h3>Novo evento</h3>
    
    <form action="Adicionar">
       <br>
        <input type="text" name="nome"placeholder="Titulo">
        <br>
        <input type="text" name="descri" placeholder="Descrição">
        <br>
        <input type="date" id="myDate" name="data" value="Data">
        <br>
        <input style="display: none" type="text" name="uid" value="<%=request.getAttribute("uid")%>">
        <input type="submit" name="Save" class="form form-Save" value="Adicionar"> 
      </form>
       <form action="AttributePasser">
          <input style="display: none" type="text" name="uid" value="<%=request.getAttribute("uid")%>">
          <input style="display: none" type="text" name="local" value="/editar.jsp">
	      <input type="submit" class="form form-Save" value="Editar">
      </form>  
  
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}
/* Button used to open the contact form - fixed at the bottom of the page */
.config-button {
  color: white;
  padding: 0px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 23px;
  left: 0%;
}
.filter-button {
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 23px;
  left: 9%;
}
/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
  bottom: 0;
  left: 15px;
  border: 3px solid #f1f1f1;
  z-index: 9;
    background-color: white;
  
}
/* Add styles to the form container */
.form-container {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}
/* Full-width input fields */
/* Set a style for the submit/login button */
.form-container .btn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}
/* Add a red background color to the cancel button */
.form-container .btn-cancel {
  background-color: red;
  color:red
}
/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}
</style>

<input type="image" src="https://image.flaticon.com/icons/svg/61/61094.svg" width="68" height="68" class="config-button" onclick="openForm()"></input>

<div class="form-popup" id="myForm">
  <form action ="Config" class="form-container">
    <h1>Configurações</h1>

	<form>
		<input style="display: none" type="text" name="uid" value="<%=request.getAttribute("uid")%>">
		
	</form>

	<form >
    	<input type="button" name="sair" class="form form-Save" value="Sair"  onclick="window.location='login.jsp';">
    </form>

      <form action="AttributePasser">
          <input style="display: none" type="text" name="uid" value="<%=request.getAttribute("uid")%>">
          <input style="display: none" type="text" name="local" value="/altdados.jsp">
	      <input type="submit" class="form form-Save" value="Editar">
      </form> 
    
    <form action=DelUsuario>
    	<input style="display: none" type="text" name="uid" value="<%=request.getAttribute("uid")%>">
    	<input type="submit"  class="form form-Save" value="Apagar Conta"> 
    </form>
    
    <button type="button" class="btn-cancel" onclick="closeForm()">X</button>
  </form>
</div>

<script>
function openForm() {
    document.getElementById("myForm").style.display = "block";
}

function closeForm() {
    document.getElementById("myForm").style.display = "none";
}
</script>
 <form action="AttributePasser">
          <input style="display: none" type="text" name="uid" value="<%=request.getAttribute("uid")%>">
          <input style="display: none" type="text" name="local" value="/filtro.jsp">
		  <input type="image" src="https://www.materialui.co/materialIcons/action/search_white_72x72.png" width="68" height="68" class="filter-button" ></input>
 </form> 
</div>



</body>
  
  <div class="main">
      <section class="card-container">
      
				<%@ page import="java.util.*,br.insper.noteblock.model.*" %>
		<table border='1'>
		<%  
		DAO dao = new DAO();
		 List<Notas> Notas = dao.getLista();
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
              	    <input style="display: none" type="text" name="uid" value="<%=request.getAttribute("uid")%>">
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