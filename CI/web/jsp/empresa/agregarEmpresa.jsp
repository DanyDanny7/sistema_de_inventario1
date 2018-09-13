<%-- 
    Document   : agregarEmpresa
    Created on : 09-12-2018, 11:03:27 AM
    Author     : diana.alcantarausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento Empresa</title>
        <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="../../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../../js/jquery-3.3.1.min.js" type="text/javascript"></script>
    </head>
    <body>
        
        <h1>Agregar Empresa</h1>
<label>${nombre}</label>
<label>${nAcceso}</label><br>
        <html:form action = "/empresaMantenimiento">
            <br>
            <label>Nombre : </label><br>
            <html:text property="nombreEmpresa"></html:text><br><br>
                <label>NCR : </label><br>
            <html:text property="ncr"></html:text><br><br>
                <label>NIT : </label><br>
            <html:text property="nit"></html:text><br><br>
                <label>Direccion : </label><br>
            <html:text property="direccionEmpresa"></html:text><br><br>
                <label>E-Mail : </label><br>
            <html:text property="emailEmpresa"></html:text><br><br>
                <label>Encargado : </label><br>
            <html:text property="encargadoEmpresa"></html:text><br><br>
                <label>Telefono : </label><br>
            <html:text property="telefonoEmpresa"></html:text><br><br>

            
            <bean:write name="ActionFormEmpresa" property="error" filter="false"/>    


            <br>
            <html:submit property="action" value="Agregar"/>
            <html:submit property="action" value="Consultar"/>
      
        </html:form>
        <br>
        <html:link page="/index.jsp">Index</html:link>
    </body>
</html>

