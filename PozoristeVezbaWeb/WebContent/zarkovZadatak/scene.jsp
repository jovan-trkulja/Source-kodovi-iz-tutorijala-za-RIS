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

	<jsp:useBean id="sceneB" class="beans.SceneBean" scope="session">

		<form action="/PozoristeVezbaWeb/IzvodjenjaScenaServlet" method="get">

			<table border="1">
				<tr>
					<td><select name="comboScene">

					 <c:forEach var="s" items="${sceneB.scene}">
						
						<option value="${s.idScena}">${s.naziv}</option>
								
					</c:forEach>

					</select></td>
				
				
					<td><input type="submit" value="Prikazi"></td>
				</tr>


			</table>

		</form>

	</jsp:useBean>

</body>
</html>