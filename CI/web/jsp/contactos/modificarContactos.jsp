<%-- 
    Document   : modificarContactos
    Created on : 08-28-2018, 04:17:56 PM
    Author     : diana.alcantarausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class=" p-3 mb-3 bg-success">
        <h2 class="font-weight-bold">MODIFICAR</h2><br>
        <label>${nombre}</label>
        <label>${nAcceso}</label>
        <html:form action="/contactosMantenimiento">
           
                        <label class="font-weight-bold">ID Contacto:</label><br>
                       <html:text property="idContacto" ></html:text><br><br>
                        
                            <label class="font-weight-bold">Nombre del contacto:</label><br>
                            <html:text property="nombreContacto" ></html:text> <br><br>
                        
                            <label class="font-weight-bold">Direccion del contacto:</label><br>
                            <html:text property="direccionContacto" ></html:text> <br><br>
                       
                            <label class="font-weight-bold">Telefono del contacto:</label><br>
                            <html:text property="telefonoContacto" ></html:text> <br><br>
                       
                            <label class="font-weight-bold">Encargado:</label><br>
                            <html:text property="encargadoContacto" ></html:text> <br><br>
                       
                            <label class="font-weight-bold">Telefono del encargado:</label><br>
                            <html:text property="telefonoEncargadoContacto" ></html:text> <br><br>
                       
                            <label class="font-weight-bold">Tipo de contacto:</label><br>
                            <html:select property="tipoContacto">
                                <html:option value="Cliente">Cliente</html:option> 
                                <html:option value="Proveedor">Proveedor</html:option>
                            </html:select><br><br> 
                   
                        <label class="font-weight-bold">Email del contacto:</label><br>
                        <html:text property="emailContacto" size="25" maxlength="20"></html:text> <br><br>
                     
                        <html:hidden property="fechaRegistroContacto"></html:hidden> 
                        
                        <tr colspan="2">
                        <bean:write name="ActionFormContactos" property="error" filter="false"/>
                  
            <br> 
            <html:submit property="action" value="Modificar"/>

        </html:form><br>
    poner inicio    &nbsp;<a class="font-weight-bold btn btn-primary " <html:link page="/index.jsp">Index</html:link>
    </body>
</html>
