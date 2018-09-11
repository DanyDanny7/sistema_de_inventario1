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
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"> 
        
    </head>
    <body class=" p-3 mb-3 bg-success">
        <h2 class="text-dark font-weight-bold">MODIFICAR</h2><br>
        <html:form action="/contactosMantenimiento">
            <table border="0">
                <tbody>
                    <tr>
                        <td class="bg-dark text-white">ID Contacto</td>
                        <td>&nbsp;<html:text property="idContacto" ></html:text></td>
                        </tr>  
                        <tr>
                            <td class="bg-dark text-white">Nombre del contacto</td>
                            <td>&nbsp;<html:text property="nombreContacto" ></html:text> 
                        </tr>
                        <tr>
                            <td class="bg-dark text-white">Direccion del contacto</td>
                            <td>&nbsp;<html:text property="direccionContacto" ></html:text> 
                        </tr>
                        <tr>
                            <td class="bg-dark text-white">Telefono del contacto</td>
                            <td>&nbsp;<html:text property="telefonoContacto" ></html:text> 
                        </tr>
                        <tr>
                            <td class="bg-dark text-white">Encargado</td>
                            <td>&nbsp;<html:text property="encargadoContacto" ></html:text> 
                        </tr>
                        <tr>
                            <td class="bg-dark text-white">Telefono del encargado</td>
                            <td>&nbsp;<html:text property="telefonoEncargadoContacto" ></html:text> 
                        </tr>
                        <tr>
                            <td class="bg-dark text-white">Tipo de contacto</td>
                            <td>&nbsp;<html:select property="tipoContacto">
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
            <html:submit property="action" value="ModificarContacto"/>

        </html:form><br>
    poner inicio    &nbsp;<a class="font-weight-bold btn btn-primary " <html:link page="/jsp/login/index.jsp">Index</html:link>
    </body>
</html>
