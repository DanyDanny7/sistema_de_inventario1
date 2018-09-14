<%-- 
    Document   : inicio
    Created on : 08-29-2018, 04:11:53 PM
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
        <title>inicio configuracion</title>
    </head>
    <body>
        <br>
        <h1>inicio Configuracion</h1>
        <html:link page="/jsp/configuracion/agregarConfiguracion.jsp">Agregar</html:link>
        <br>
        <br>
        <html:link page="/jsp/configuracion/modificarConfiguracion.jsp">Modificar</html:link>
        <br>
        <br>
        <html:form action = "/configuracionMantenimiento">
            
        <html:submit property="action" value="irAgregar"/>
        <br>
        <br>
        <html:text property="idConfiguracion"></html:text><br>
        <html:submit property="action" value="consultarId"/>
        </html:form>
        <br>
        <html:link page="/index.jsp">Index</html:link>
        <br>
    </body>
</html>
