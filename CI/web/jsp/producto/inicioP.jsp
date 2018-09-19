<%-- 
    Document   : inicioP
    Created on : 09-05-2018, 08:23:11 AM
    Author     : diana.alcantarausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib   uri="http://struts.apache.org/tags-bean"  prefix="bean"%>
<%@taglib   uri="http://struts.apache.org/tags-html"  prefix="html"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio Productos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
               crossorigin="anonymous">
    </head>
    <body class="bg-success">
        <h1 class="text-dark font-weight">INICIO PRODUCTO:</h1><br>
 
         
        &nbsp;<html:form action="/productosMantenimiento">
            &nbsp;&nbsp;<html:submit property="action" value="Consultar"/><br><br>
            &nbsp;&nbsp;<html:submit property="action" value="irAgregar"/><br><br>
           
            </html:form> 
                
            &nbsp;&nbsp;&nbsp;<a class="font-weight-bold btn btn-primary"<html:link page="/index.jsp">Index</html:link>
                                 </body>
                </html>
