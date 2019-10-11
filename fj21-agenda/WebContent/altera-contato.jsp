<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
	Nome: <input type="text" name="nome" value="${contato.nome}"><br/>
	E-mail: <input type="text" name="email" value="${contato.email}"/><br/>
	Endereço: <input type="text" name="endereco"/><br/>
	Data de Nacimento: <caelum:campoData id="dataNascimento"/><br/>
		<input type="submit" value="Atualizar"/>
	
	</form>
	
</body>
</html>