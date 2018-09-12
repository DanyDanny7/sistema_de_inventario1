<%-- 
    Document   : inicio
    Created on : 09-12-2018, 11:03:05 AM
    Author     : diana.alcantarausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="../../js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <br>
        <h1>Inicio Empresa</h1>
        <br>
        <label>${nombre}</label>
        <label>${nAcceso}</label>
      
            <br>
        <html:form action = "/empresaMantenimiento">
            <html:submit property="action" value="Consultar"/><br><br>
            <a class="font-weight-bold btn btn-light btn-sm"<html:link page="/jsp/empresa/agregarEmpresa.jsp">Agregar</html:link>
        </html:form>
        <br>
        <html:link page="/index.jsp">Index</html:link>
    </body>
</html>
