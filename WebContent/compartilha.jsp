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
	    

	  <form action="message" method="post">
	    <input type="text" name="telefone" placeholder="Número de Celular">
	   	<input style="display: none" type="text" name="descri" value="<%=request.getAttribute("descri")%>">
	    <input style="display: none" type="text" name="uid" value="<%=request.getAttribute("uid")%>">
	    
	    <input type="submit" name="send" class="login login-submit" value="Enviar SMS" >
	  </form>
	
	  <div class="login-help">
	    <a href="notas?"+"<%=request.getAttribute("uid")%>">Voltar</a>
	  </div>
	</div>
	

	
	</body>
</html>
