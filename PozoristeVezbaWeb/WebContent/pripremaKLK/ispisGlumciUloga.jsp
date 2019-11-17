<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${!empty uloge}">
	
		<table border="1">
		
			<tr>
				<th>Ime glumca</th>
				<th>Prezime glumca</th>
				<th>Naziv uloge</th>
				<th>Predstava</th>
			</tr>
		
			<c:forEach var="u" items="${uloge}">
			
				<tr>
					<td>${u.glumac.ime}</td>
					<td>${u.glumac.prezime}</td>
					<td>${u.naziv}</td>
					<td>${u.predstava.naziv}</td>
				</tr>
			</c:forEach>
		</table>

	</c:if>
</body>
</html>