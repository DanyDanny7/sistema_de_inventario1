<%-- 
    Document   : inicio
    Created on : 09-27-2018, 01:32:44 PM
    Author     : diana.alcantarausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <html:form action = "/comprasMantenimiento">
        <html:submit property="action" value="irAgregar"/>
        </html:form>

    </body>
</html>
