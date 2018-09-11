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
        <html:form action="/contactosMantenimiento">
            <table border="0">
                <br>
                <tbody>
                <h3 class="text-dark font-weight-bold">Agregar Contactos</h3>
                         <tr>
                            <td class="font-weight-bold">Nombre del contacto</td>
                            <td>&nbsp;<html:text property="nombreContacto"></html:text> 
                        </tr>
                        <tr>
                            <td class="font-weight-bold">Direccion del contacto</td>
                            <td>&nbsp;<html:text property="direccionContacto"></html:text> 
                        </tr>
                        <tr>
                            <td class="font-weight-bold">Telefono del contacto</td>
                            <td>&nbsp;<html:text property="telefonoContacto"></html:text> 
                        </tr>
                        <tr>
                            <td class="font-weight-bold">Encargado</td>
                            <td>&nbsp;<html:text property="encargadoContacto"></html:text> 
                        </tr>
                        <tr>
                            <td class="font-weight-bold">Telefono del encargado</td>
                       
                            <td>&nbsp;<html:text property="telefonoEncargadoContacto"></html:text> 
                        </tr>
                        <tr>
                            <td class="font-weight-bold">Tipo de contacto</td>
                            <td>&nbsp;<html:select property="tipoContacto" >
                                    <html:option value="Seleccionar"></html:option> 
                                    <html:option value="Cliente">Cliente</html:option> 
                                    <html:option value="Proveedor">Proveedor</html:option>
                </html:select></td>
                    </tr>
                    <tr>
                        <td class="font-weight-bold">Email del contacto</td>
                        <td>&nbsp;<html:text property="emailContacto"></html:text> 
                    </tr>
                    <tr colspan="2">
                    <bean:write name="ActionFormContactos" property="error" filter="false"/>
                </tr>
            </tbody>  
        </table>
                <br>
        <html:submit property="action" value="AgregarContacto"/>
        &nbsp;<html:submit property="action" value="ConsultarContacto"/>
        


    </html:form>
  <!--  <html:link page="/jsp/login/index.jsp">Index</html:link> -->
 &emsp;&nbsp; <a class="font-weight-bold btn btn-primary" <html:link page="/jsp/contactos/inicioContacto.jsp" >Inicio</html:link>
</body>
</html>
