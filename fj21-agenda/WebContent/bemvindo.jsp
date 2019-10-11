<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bem vindo!</title>
</head>
<body>
	<%-- cometário em JSP aqui: nossa primeira página JSP --%>
	
	<%String mensagem = "Bem vindo ao sistema de agenda do FJ-21"; %>
	
	<%out.println(mensagem); %>
	
	<br/>
	
	<% String desenvolvido = "Desenvolvido por Gabriel"; %>
	
	<%=desenvolvido %>
	
	<br/>
	
	<%System.out.println("Tudo foi executado!"); %>
	
</body>
</html>