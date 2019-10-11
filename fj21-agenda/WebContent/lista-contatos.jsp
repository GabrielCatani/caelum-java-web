<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:import url="cabecalho.jsp"/>

<table>
	<tr>
		<td><b>Nome</b></td>
		<td><b>E-Mail</b></td>
		<td><b>E-mail (Usando Choose)</b></td>
		<td><b>Endereço</b></td>
		<td><b>Data de Nascimento</b></td>
		<td><b>Remover</b></td>
		<td><b>Alterar</b></td>
	</tr>
	<c:forEach var="contato" items="${lista}" varStatus="id">
	<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff'}"}>
		<td>${contato.nome}</td>
		
		<!---Utilizando c:if --->
		<c:if test="${not empty contato.email}">
			<td><a href="mailto:${contato.email}">${contato.email}</a></td></c:if>
		<c:if test="${empty contato.email}">
			<td>Email não informado.</td>
		</c:if>	
		<!---Utilizando c:choose --->
		<c:choose>
			<c:when test="${not empty contato.email}">
				<td><a href="mailto:${contato.email}">${contato.email}</a></td>
			</c:when>
			<c:otherwise><td>E-Mail não informado!</td></c:otherwise>
		</c:choose>
		
		<td>${contato.endereco}</td>
		<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
		<td>
		<a href="mvc?logica=RemoveContatoLogica&id=${contato.id}">Remover ${contato.nome}</a>
		</td>
		<td>
			<a href="mvc?logica=MostraContatoLogica&id=${contato.id}">Editar ${contato.nome}</a>
		</td>
	</tr>
	</c:forEach>

</table>

<c:import url="rodape.jsp"/>
</body>
</html>