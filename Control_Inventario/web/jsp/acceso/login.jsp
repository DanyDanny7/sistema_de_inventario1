<%-- 
    Document   : login
    Created on : 08-23-2018, 08:19:16 AM
    Author     : Admin105
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
    <html:form action = "/accesoMantenimiento">
        <table border="0">
            <tbody>
                <tr>
                    <td>Usuario :</td>
                    <td><input name="usuario" type="text">
                </tr>
                <tr>
                    <td>Contraseña :</td>
                    <td><input name="contrasena" type="password">
                </tr>
            <br>
            <tr colspan="2">
            <bean:write name="ActionFormAcceso" property="error" filter="false"/>
            </tr>
            </tbody>
        </table>
            <br>
            <html:submit property="action" value="Login"/>
            <br>
            <html:link page="/jsp/acceso/ayuda1.jsp">¿Olvidaste tu contraseña?</html:link>
    </html:form>
            <br>
            <html:link page="/index.jsp">Index</html:link>
    </body>
</html>
