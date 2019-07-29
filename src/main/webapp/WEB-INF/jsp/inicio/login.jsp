<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body onload='document.loginForm.username.focus();'>
    <h1>DannaSoft</h1>
 
    <c:if test="${not empty errorMessge}"><div style="color:red; font-weight: bold; margin: 30px 0px;">${errorMessge}</div></c:if>
    <c:if test="${not empty succesMessge}"><div style="color:green; font-weight: bold; margin: 30px 0px;">${succesMessge}</div></c:if>

    <form name='login' action="${pageContext.request.contextPath}/login" method='POST'>
        <table>
            <tr>
                <td>Usuario:</td>
                <td><input type='text' name='username' value=''></td>
            </tr>
            <tr>
                <td>Clave</td>
                <td><input type='password' name='password' /></td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit" value="Ingresar" /></td>
            </tr>
        </table>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</body>
</html>