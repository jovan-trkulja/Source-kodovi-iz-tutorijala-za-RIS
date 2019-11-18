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
	
	<form action="/PozoristeVezbaWeb/PrikaziUlogeGlumca" method="get">
		
		Unesite ime glumca: <input type="text" name="imeG"> <br><br>
		Unesite prezime glumca: <input type="text" name="prezG"> <br><br>
	
		<input type="submit" value="Prikazi"> 
	
	</form> <br><br>
	
	<c:if test="${!empty lista}">
		
		Nazivi uloga za unetog glumca su: <br><br>
		
		<c:forEach var="u" items="${lista}">
		
			${u.naziv} <br>
		
		</c:forEach>
	
	</c:if>
	
</body>
</html>