<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Security 5</title>
</head>
<body>
<h1>Bienvenido a Dannasoft</h1>
<h2>${message}</h2>

<form action="${pageContext.request.contextPath}/logout" method="post">
	<input value="Logout" type="submit">
</form>
        <a href="${pageContext.request.contextPath}/usuarios">Ver Usuarios BDD</a>
</body>
</html>