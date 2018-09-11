<%-- 
    Document   : ayuda
    Created on : 09-04-2018, 11:38:50 AM
    Author     : daniel.bonillausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ayuda</title>
    </head>
    <body>
        <h1>Restauracion de Contraseña</h1>
        <html:form action = "/accesoMantenimiento">
        
                <label>Usuario :</label>
                <html:text property="usuario"></html:text>
                        <br>
                        <br>
                        <br>
            <html:submit property="action" value="Restaurar"/>
            
    </html:form>
    </body>
</html>
