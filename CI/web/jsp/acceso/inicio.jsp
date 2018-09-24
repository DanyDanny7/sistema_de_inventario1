<%-- 
    Document   : confirmacionNuevoAcceso
    Created on : 08-21-2018, 03:38:42 PM
    Author     : Admin105
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="http://codeseven.github.com/toastr/toastr.js"></script>
        <link href="http://codeseven.github.com/toastr/toastr.css" rel="stylesheet"/>
        <link href="http://codeseven.github.com/toastr/toastr-responsive.css" rel="stylesheet"/>
    </head>
    <body>
        
        <br>
        <h1>Inicio Acceso</h1>
        <br>
        <label>${nombre}</label>
        <label>${nAcceso}</label>
      
            <br>
        <html:form action = "/accesoMantenimiento">
            <html:submit property="action" value="Consultar"/><br><br>
            <html:submit property="action" value="irAgregar"/>
        </html:form>
        <br>
        <html:link page="/index.jsp">Index</html:link>
    </body>
</html>
