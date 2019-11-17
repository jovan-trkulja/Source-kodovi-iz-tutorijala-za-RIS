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
	
	<form action="/PozoristeVezbaWeb/PosetilacServlet" method="post">
	
		Ime: <input type="text" name="imeP"><br><br>
		
		Prezime: <input type="text" name="prezimeP"><br><br>
		
		<input type="submit" value="Unesi posetioca">
		
	</form>
	
	<c:if test="${!empty posetilac}">
	
		Uspesno dodat posetilac u bazu. ID posetioca je : ${posetilac.idPosetilac}.
	</c:if>
	
	<c:if test="${neuspesno == true}">
	
		Greska prilikom dodavanja posetioca u bazu.
		
	</c:if>
	
</body>
</html>