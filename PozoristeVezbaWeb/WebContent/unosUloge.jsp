<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unos uloge za glumca</title>
</head>
<body>
	
	Uspesno ste uneli glumca u bazu. ID glumca je ${glumac.idGlumac}. <br> <br>
	
	<form action="/PozoristeVezbaWeb/UnosUlogeServlet" method="post">
	
		Unesite naziv uloge: <input type="text" name="nazUloge"><br>
		
		<c:if test="${!empty listaPredstave}">
			<select name="predstave">
				<c:forEach var="p" items="${listaPredstave}">
			
					<option value="${p.idPredstava}">${p.naziv}</option>
				
				</c:forEach>
			</select>
		</c:if>
		
		<input type="submit" value="Unesi glumca">
	</form>
	
</body>
</html>