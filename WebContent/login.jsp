<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login NoteBlock</title>
	  <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
	
	    <link rel="stylesheet" href="Login.css" media="screen" type="text/css" />
	</head>
	
	<body>
	
	  <div class="login-card">
	    <h1>Card Block</h1><br>
	  <form action=usuario  method="get">
	    <input type="text" name="user" placeholder="Usuário">
	    <input type="text" name="senha" placeholder="Senha">
	    <input type="submit" name="login" class="login login-submit" value="Login">
	  </form>
	
	  <div class="login-help">
	    <a href="criauser.jsp">Criar Usuário</a>
	  </div>
	</div>
	
	</body>
</html>