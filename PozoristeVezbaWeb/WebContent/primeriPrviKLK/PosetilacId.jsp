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
	
	<form action="/PozoristeVezbaWeb/IdPosetilacServlet" method="get">
	
		Unesite ID posetioca: <input type="text" name="idPosetilac"> <br><br>
		
		<input type="submit" value="Prikazi"> <br><br>
	
	</form>
	
	<c:if test="${neuspesno == true}">
		
		Posetilac sa unetim ID - om ne postoji u bazi.
		
	</c:if>
	
	<c:if test="${!empty karte}">
		
		Uneti ID je vezan za sledeceg posetioca: <br> <br>
		
		Ime: ${posetilac.ime} <br>
		Prezime: ${posetilac.prezime} <br><br>
		
		<table border="1">
		
			<tr>
				<th>Mesto rezervisane karte</th>
				<th>Datum izvodjenja predstave za kartu</th>
				<th>Naziv predstave</th>
				<th>Cena karte</th>
				<th>Provera placanja</th>
			</tr>
			
			<c:forEach var="k" items="${karte}">
				
				<tr>
				
					<td>${k.mesto.broj} | ${k.mesto.red} | ${k.mesto.sekcija}</td>
					<td>${k.izvodjenje.datum}</td>
					<td>${k.izvodjenje.predstava.naziv}</td>
					<td>${k.cena}</td>
					<td><a href="/PozoristeVezbaWeb/ProveriPlacanjeS?idKarta=${k.idKarta}">Proveri</a></td>
					
				</tr>
			
			</c:forEach>
			
		</table> <br><br>
		
	</c:if>
	
	<c:if test="${ok}">
		
		Izabrana karta je placena.
	
	</c:if>
	
	<c:if test="${ok == false}">
		
		Izabrana karta nije placena.
	
	</c:if>
</body>
</html>