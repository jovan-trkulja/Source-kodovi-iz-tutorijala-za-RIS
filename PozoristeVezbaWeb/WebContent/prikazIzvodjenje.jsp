<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/PozoristeVezbaWeb/PrikazServlet" method="get">
	
		Unesite naziv predstave: <input type="text" name="nazPredstave"> <br><br>
		
		<input type="submit" value="Prikazi">
	
	</form>
	
	<c:if test="${!empty lista}">
	
		<table border="1">
		
			<tr>
				<th>Naziv predstave</th>
				<th>Trajanje predstave</th>
				<th>Datum izvodjenja</th>
			</tr>
			
			<c:forEach var="i" items="${lista}">
			
				<tr>
					<td>${i.predstava.naziv}</td>
					<td>${i.predstava.trajanje}</td>
					<td>${i.datum}</td>
				</tr>
				
			</c:forEach>
		
		</table>
	
	</c:if>
</body>
</html>