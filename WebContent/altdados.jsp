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
	  <form action=AltUsuario >
	  <%@ page import="java.util.*,br.insper.noteblock.model.*"  %>
	  <% 	DAO dao = new DAO();
	  Usuario atual = dao.showUser((Integer.parseInt((String)request.getAttribute("uid"))));%>
	  	<input style="display: none" type="text" name="uid" value="<%=request.getAttribute("uid")%>">
	    <input type="text" name="user" value="<%=atual.getUser()%>">
	    <input type="senha" name="senha" value="<%=atual.getSenha()%>">
	    <input type="submit" name="alterar" class="login login-submit" value="Alterar dados">
	  </form>
	</div>
	
	</body>
</html>