<%-- 
    Document   : inicio
    Created on : 08-29-2018, 04:11:53 PM
    Author     : daniel.bonillausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>inicio Iva</title> 
    </head>
    <body>
        <br>
        <h1>inicio Iva</h1>
        <br>
        <br>
        <html:link page="/jsp/iva/agregarIva.jsp">Agregar</html:link>
        <br>
        <br>
        <html:form action="/ivaMantenimiento">
            <html:submit property="action" value="consultar">Mostrar</html:submit>
        </html:form>
            <br>
        <html:link page="/index.jsp">Index</html:link>
     
        
        <br>
    </body>
</html>
