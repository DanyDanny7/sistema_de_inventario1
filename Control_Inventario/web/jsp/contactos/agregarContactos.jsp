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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    </head>
    <body class=" p-3 mb-3 bg-success">
        <html:form action="/contactosMantenimiento">
            <table border="0">
                <br>
                <tbody>
                <h3 class="text-dark font-weight-bold">Agregar Contactos</h3>
                         <tr>
                            <td class="bg-dark text-white">Nombre del contacto</td>
                            <td>&nbsp;<html:text property="nombreContacto" size="25" maxlength="20"></html:text> 
                        </tr>
                        <tr>
                            <td class="bg-dark text-white">Direccion del contacto</td>
                            <td>&nbsp;<html:text property="direccionContacto" size="25" maxlength="35"></html:text> 
                        </tr>
                        <tr>
                            <td class="bg-dark text-white">Telefono del contacto</td>
                            <td>&nbsp;<html:text property="telefonoContacto" size="25" maxlength="15"></html:text> 
                        </tr>
                        <tr>
                            <td class="bg-dark text-white">Encargado</td>
                            <td>&nbsp;<html:text property="encargadoContacto" size="25" maxlength="20"></html:text> 
                        </tr>
                        <tr>
                            <td class="bg-dark text-white">Telefono del encargado</td>
                            <td>&nbsp;<html:text property="telefonoEncargadoContacto" size="25" maxlength="15"></html:text> 
                        </tr>
                        <tr>
                            <td class="bg-dark text-white">Tipo de contacto</td>
                            <td>&nbsp;<html:select property="tipoContacto" >
                                    <html:option value="Seleccionar"></html:option> 
                                    <html:option value="Cliente">Cliente</html:option> 
                                    <html:option value="Proveedor">Proveedor</html:option>
                </html:select></td>
                    </tr>
                    <tr>
                        <td class="bg-dark text-white">Email del contacto</td>
                        <td>&nbsp;<html:text property="emailContacto" size="25" maxlength="20"></html:text> 
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
