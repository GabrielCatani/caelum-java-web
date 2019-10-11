<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Tarefas</title>
</head>
<body>

<a href="novaTarefa">Criara Nova Tarefa</a>
<br /><br />

<table>
	<tr>
		<th>Id</th>
		<th>Descrição</th>	
		<th>Finalizado?</th>
		<th>Data de finalização</th>			
	</tr>
<c:forEach var="tarefa" items="${lista}">
<tr>
	<td>${tarefa.id}</td>
	<td>${tarefa.descricao}</td>
	<c:if test="${tarefa.finalizado eq false}">
		<td style="color:red">Não finalizado</td>
	</c:if>
	<c:if test="${tarefa.finalizado eq true}">	
		<td style="color:green">Finalizado</td> 
	</c:if>
	<td><fmt:formatDate value="${tarefa.dataFinalizacao.time }" pattern="dd/MM/yyyy"/></td>	
</tr>
</c:forEach> 

</table>

</body>
</html>