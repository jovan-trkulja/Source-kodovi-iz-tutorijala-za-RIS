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
	
	<form action="/PozoristeVezbaWeb/GlumacServlet" method="post">
	
		Unesite ime glumca: <input type="text" name="imeG"> <br>
		Unesite prezime glumca: <input type="text" name="prezG"> <br>
		Unesite jmbg: <input type="text" name="jmbg"> <br>
		
		<input type="submit" value="Unesi glumca">
	
	</form>
	
	<c:if test="${greska == true}">
		
		Greska prilikom upisivanja glumca u bazu.
	
	</c:if>
	
</body>
</html>