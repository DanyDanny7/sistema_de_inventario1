<%-- 
    Document   : listaContacto
    Created on : 08-30-2018, 11:02:21 AM
    Author     : diana.alcantarausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-faces" prefix="faces" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Contactos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
           integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    <body class=" p-3 mb-3 bg-success"> 
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="table table-hover table-sm">
                        <table class="bg-light">
                            <thead>
                            <h2 class="text-dark font-weight-bold">Lista de contactos</h2>&emsp;
                                <tr class="table-secondary">
                                    <td>ID contacto</td>
                                    <td>Nombre contacto</td>
                                    <td>Direccion contacto</td>
                                    <td>Telefono contacto</td>
                                    <td>Encargado</td>
                                    <td>Telefono encargado</td>
                                    <td>Tipo de contacto</td>
                                    <td>Email</td>
                                    <td>Fecha de Registro</td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                               <logic:notEmpty name="ActionFormContactos" property="listaContacto">
                                    <logic:iterate id="ver" name="ActionFormContactos" property="listaContacto">
                                        <tr>
                                            <html:form action="/contactosMantenimiento">
                                                <td class="table-secondary"><bean:write name="ver" property="idContacto"/>
                                                     <div hidden="hidden"><html:text name="ver" property="idContacto"/></div></td>
                                                <td ><bean:write name="ver" property="nombreContacto"/></td>
                                                <td ><bean:write name="ver" property="direccionContacto"/></td>
                                                <td ><bean:write name="ver" property="telefonoContacto"/></td>
                                                <td ><bean:write name="ver" property="encargadoContacto"/></td>
                                                <td ><bean:write name="ver" property="telefonoEncargadoContacto"/></td>
                                                <td ><bean:write name="ver" property="tipoContacto"/></td>
                                                <td ><bean:write name="ver" property="emailContacto"/></td>
                                                <td ><bean:write name="ver" property="fechaRegistroContacto"/></td>
                                                <td ><html:submit property="action" value="Eliminar"/></td>
                                                <td ><html:submit property="action" value="ConsultarId"/></td>
                                                <!-- td><!--html:submit property="action" value="ConsultarTipo"/></td -->
                                            </html:form>
                                        </tr>
                                    </logic:iterate>
                                </logic:notEmpty>
                            </tbody>
                        </table>
                        <br>
                        <a class="font-weight-bold btn btn-primary"<html:link page="/jsp/contactos/agregarContactos.jsp">Mantenimiento</html:link>&emsp;
                        <a class="font-weight-bold btn btn-primary"<html:link page="/jsp/contactos/inicio.jsp">Inicio</html:link><br><br>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
