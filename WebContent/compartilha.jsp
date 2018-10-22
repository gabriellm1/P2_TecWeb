<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Compartilhar Jogo</title>
	  <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
	
	    <link rel="stylesheet" href="Login.css" media="screen" type="text/css" />
	</head>
	
	<body>
	
	  <div class="login-card">
	    <h1>Compartilhar Jogo</h1><br>
	    
	    
	  <form action="sendSMS"  method="get">
	  	<input type="text" name="msg" placeholder="Mensagem...">
	    <input type="text" name="num" placeholder="Número de Celular">
	    <input type="submit" name="send" class="login login-submit" value="Enviar SMS">
	  </form>
	
	  <div class="login-help">
	    <a href="display.jsp">Cancelar</a>
	  </div>
	</div>
	
	</body>
</html>
