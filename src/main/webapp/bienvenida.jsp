<%@ page import="com.loginapp.model.User" %>
<%@ page session="true" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp?error=Debe iniciar sesión");
        return;
    }
%>
<html>
<head>
    <title>Bienvenida</title>
</head>
<body>
    <h2>Usuario logueado satisfactoriamente</h2>
    <p>Bienvenido, <%= user.getEmail() %>!</p>
    <a href="logout.jsp">Cerrar sesión</a>
</body>
</html>
