<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Criando usuário</title>
	  <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>
	
	    <link rel="stylesheet" href="Login.css" media="screen" type="text/css" />
	</head>
	
	<body>
	
	  <div class="login-card">
	    <h1>Insira seus dados</h1><br>
	  <form action=usuario method="post">
	    <input type="text" name="user" placeholder="Usuário">
	    <input type="text" name="senha" placeholder="Senha">
	    <input type="submit" name="Criar conta" class="login login-submit" value="Criar">
	   <h6> Caso o usuário esteja disponivel, você será redirecionado para a página de login.</h6>
	  </form>
	

	</div>
	
	</body>
</html>