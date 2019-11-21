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
	
	<c:if test="${!empty glumci}">
		
		Ime rezisera predstave koja se izvodi: {p.reziser.ime} <br>
		Prezime rezisera predstave koja se izvodi: {p.reziser.prezime} <br>
		Zanr predstave: ${p.zanr.naziv} <br>
		
		Glumci koji glume u toj predstavi: <br>
		
		<c:forEach var="g" items="${glumci}">
		
			${g.ime} | ${g.prezime} <br>
		</c:forEach>
		
		<br><br>
		
		<c:if test="${!empty uloge}">
			Uloge u predstavi: <br>
			<c:forEach var="u" items="${uloge}">
		
			${u.naziv} <br>
		</c:forEach>
		</c:if>
	</c:if>
</body>
</html>