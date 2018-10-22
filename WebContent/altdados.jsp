<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Editando dados</title>
	  <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
	
	    <link rel="stylesheet" href="Login.css" media="screen" type="text/css" />
	</head>
	
	<body>
	
	  <div class="login-card">
	    <h1>Dados</h1><br>
	    
	<script>
		function dados1(){
			let username = document.getElementById("formuser").value
			let password = document.getElementById("formsenha").value
			let userid = document.getElementById("formid").value

			
			data = {
				"user":username,
				"senha":password,
				"uid":userid
			}

			fetch("/NoteBlock/usuario",{
				method: "put",
				body: JSON.stringify(data)})		.then(function(response) {
					  response.text().then(function(data) {
						  redirect: window.location.replace(data+"?uid="+userid)})
						  });
				}
		
		function dados2(){
			let username = document.getElementById("formuser").value
			let password = document.getElementById("formsenha").value
			let userid = document.getElementById("formid").value

			
			data = {
				"user":username,
				"senha":password,
				"uid":userid
			}

			fetch("/NoteBlock/usuario",{
				method: "delete",
				body: JSON.stringify(data)})		.then(function(response) {
					  response.text().then(function(data) {
							  redirect: window.location.replace("home")
						  })
					  
				})
 }
	    

	</script>
	    
	  <%@ page import="java.util.*,br.insper.noteblock.model.*"  %>
	  <% 	DAO dao = new DAO();
	  Usuario atual = dao.showUser((Integer.parseInt((String)request.getAttribute("uid"))));%>
	  	
	   <!-- opção de editar conta -->
	   <div>
	  	<input style="display: none" type="text" id="formid" name="uid" value="<%=request.getAttribute("uid")%>">
	    <input type="text" id="formuser" name="user" value="<%=atual.getUser()%>">
	    <input type="text"  id="formsenha" name="senha" value="<%=atual.getSenha()%>">
	    <input onclick=dados1() type="button" name="alterar" class="botaoscript" value="Alterar dados">
	   </div>
	   
	   
	   <div> 
	    <!-- opção de apagar conta -->
    	<input type="button" onclick=dados2() class="form form-Save" class="botaoscript" value="Apagar Conta"> 
	   </div>
		
	</div>
	
	</body>
</html>