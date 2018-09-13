<%-- 
    Document   : listaProductos
    Created on : 09-05-2018, 08:30:14 AM
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
        <title>JSP Page</title>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
           integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    <body>
        <body class=" p-3 mb-3 bg-success"> 
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="table table-hover table-sm">
                        <table class="bg-light">
                            <thead>
                            <h2 class="text-dark font-weight-bold">Lista de Productos</h2>&emsp;
                                <tr class="table-secondary">
                                    <td>ID Producto</td>
                                    <td>Fabricante</td>
                                    <td>Nombre del producto</td>
                                    <td>Precio del producto</td>
                                    <td>Descripción del producto</td>
                                    <td>Modelo del producto</td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                               <logic:notEmpty name="ActionFormProductos" property="listaProductos">
                                    <logic:iterate id="ver" name="ActionFormProductos" property="listaProductos">
                                        <tr>
                                            <html:form action="/productosMantenimiento">
                                                <td class="table-secondary"><bean:write name="ver" property="idProducto"/>
                                                     <div hidden="hidden"><html:text name="ver" property="idProducto"/></div></td>
                                                <td ><bean:write name="ver" property="fabricantes.nombreFabricante"/></td>
                                                <td ><bean:write name="ver" property="nombreProducto"/></td>
                                                <td ><bean:write name="ver" property="precioUnitario"/></td>
                                                <td ><bean:write name="ver" property="descripcionProducto"/></td>
                                                <td ><bean:write name="ver" property="modelo"/></td>
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
                       <html:form action="/productosMantenimiento">
                           <html:submit property="action" value="irAgregar" style="btn-primary"/>
                       </html:form><br>
                           <a class="font-weight-bold btn btn-primary"<html:link page="/jsp/producto/inicioP.jsp">Inicio</html:link><br><br>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
