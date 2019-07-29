<%-- 
    Document   : list-of-users
    Created on : 26 jul. 2019, 12:15:20
    Author     : sistemas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         
            <h1>Lista de Usuarios</h1>
            <table border="1px" cellpadding="0" cellspacing="0">
            <thead>
                <tr>
                    <th width="10%">Rol</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="rol" items="${roles}" varStatus="status">
                    <tr>
                        <td><b>${rol.nombreTus}</b></td>
                    </tr>
                </c:forEach>
            </tbody>
            </table>
    </body>
</html>
