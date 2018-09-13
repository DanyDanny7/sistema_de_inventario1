<%-- 
    Document   : AgregarContactos
    Created on : 08-28-2018, 04:17:42 PM
    Author     : diana.alcantarausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Contactos</title>
        <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="../../js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="../../js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body class=" p-3 mb-3 bg-success">
        <h1 class="font-weight-bold">Agregar Contacto</h1>
        <label>${nombre}</label>
        <label>${nAcceso}</label>
        <html:form action="/contactosMantenimiento">
            <table border="0">
                
                <label class="font-weight-bold">Nombre del contacto:</label><br>
                <html:text property="nombreContacto"></html:text><br><br> 

                    <label class="font-weight-bold">Direccion del contacto:</label><br>
                <html:text property="direccionContacto"></html:text> <br><br>

                    <label class="font-weight-bold">Telefono del contacto:</label><br>
                <html:text property="telefonoContacto"></html:text><br><br> 

                    <label class="font-weight-bold">Encargado:</label><br>
                <html:text property="encargadoContacto"></html:text><br><br> 

                    <label class="font-weight-bold">Telefono del encargado:</label><br>
                <html:text property="telefonoEncargadoContacto"></html:text><br><br> 

                    <label class="font-weight-bold">Tipo de contacto:</label><br>
                <html:select property="tipoContacto">
                    <html:option value="Seleccionar"></html:option> 
                    <html:option value="Cliente">Cliente</html:option> 
                    <html:option value="Proveedor">Proveedor</html:option>
                </html:select><br><br>

                <label class="font-weight-bold">Email del contacto:</label><br>
                <html:text property="emailContacto"></html:text><br><br>

                    <tr colspan="2">
                    <bean:write name="ActionFormContactos" property="error" filter="false"/>
         
        <br>
        <html:submit property="action" value="Agregar"/>
        &nbsp;<html:submit property="action" value="Consultar"/>



    </html:form>
  <!--  <html:link page="/index.jsp">Index</html:link> -->
    &emsp;&nbsp; <a class="font-weight-bold btn btn-primary" <html:link page="/jsp/contactos/inicio.jsp" >Inicio</html:link>
</body>
</html>
