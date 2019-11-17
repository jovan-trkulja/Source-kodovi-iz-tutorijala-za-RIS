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

	<jsp:useBean id="zanroviObj" class="beans.ZanrBean" scope="session">

		<form action="/PozoristeVezbaWeb/PrikazZanraServlet" method="get">
			
			Izaberite zanr predstave:
			
			<select name="comboZanr">
				
				<c:forEach var="z" items="${zanroviObj.zanrovi}">
					
					<option value="${z.idZanr}">${z.naziv}</option>
				
				</c:forEach>
			
			</select> <br><br>
			
			<input type="submit" value="Prikazi predstave za izabrani zanr">
			
		</form>

	</jsp:useBean>
	
	<c:if test="${!empty lista}">
	
		<table border="1">
		
			<tr>
				<th>Naziv predstave</th>
				<th>Opis predstave</th>
				<th>Trajanje predstave</th>
				<th>Ime rezisera</th>
				<th>Prikaz glumaca sa ulogama</th>
			</tr>
		
			<c:forEach var="p" items="${lista}">
			
				<tr>
					<td>${p.naziv}</td>
					<td>${p.opis}</td>
					<td>${p.trajanje}</td>
					<td>${p.reziser.ime}</td>
					<td><a href="/PozoristeVezbaWeb/UlogeZanrGlumci?idPredstava=${p.idPredstava}">Prikazi</a></td>
				</tr>
			
			</c:forEach>
		</table>

	</c:if>
	
	
	
</body>
</html>