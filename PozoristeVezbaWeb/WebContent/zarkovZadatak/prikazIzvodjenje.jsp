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
	
	<c:if test="${!empty izvodjenja}">
		
		<table border="1">
			
			<tr>
				<th>Datum izvodjenja</th>
				<th>Naziv predstave</th>
				<th>Trajanje predstave</th>
				<th>Detalji</th>
			</tr>
			
			<c:forEach var="i" items="${izvodjenja}">
			
				<tr>
					<td>${i.datum}</td>
					<td>${i.predstava.naziv}</td>
					<td>${i.predstava.trajanje}</td>
					<td><a href="/PozoristeVezbaWeb/ReziserPredstavaServlet?idP=${i.predstava.idPredstava}">Prikazi</a></td>
					
				</tr>
			
			</c:forEach>
			
		</table>
	
	</c:if>
</body>
</html>