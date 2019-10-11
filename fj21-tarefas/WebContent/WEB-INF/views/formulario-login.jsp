<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h2>Página de Login das Tarefas</h2>
<form action="efetuaLogin" method="POST">
	Login: <input type="text" name="login">
	Senha:<input type="text" name="senha">
	<input type="submit" value="Entrar nas tarefas"/>
</form>
</body>
</html>