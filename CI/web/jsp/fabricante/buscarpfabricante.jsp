<%-- 
    Document   : buscarpfabricante
    Created on : 09-28-2018, 09:21:41 AM
    Author     : guillermo.bermudes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="http://codeseven.github.com/toastr/toastr.js"></script>
        <link href="http://codeseven.github.com/toastr/toastr.css" rel="stylesheet"/>
        <link href="http://codeseven.github.com/toastr/toastr-responsive.css" rel="stylesheet"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-12 text-center">
                <html:form action = "/fabricanteMantenimiento">
                    <div class="card-header" style="background-color:#f0f3f4;">

                        <div class="row">
                            <div class="form-group col-3"></div>
                            <div class="form-group col-3">
                                <label class="font-weight-bold">Fabricante: </label><br>
                                <html:select property="idFabricante" styleClass="form-control">
                                    <html:option value="Seleccionar"></html:option>
                                    <logic:notEmpty name="ActionFormFabricante" property="listaFabricante">
                                        <logic:iterate id="ver" name="ActionFormFabricante" property="listaFabricante">
                                            <html:option value="${ver.idFabricante}" >${ver.nombreFabricante}</html:option>
                                        </logic:iterate>
                                    </logic:notEmpty>
                                </html:select>
                            </div><br>
                            <div class="form-group col-3"><html:submit property="action" value="fproductos"/></div>  
                        </div>


                    </html:form>
                    <br>
                    <br>
                    <br>
                    <div class="table table-hover table-sm">
                        <table class="bg-light">
                            <thead>
                                <tr class="table-secondary">
                                   
                                   <td>Nombre del producto</td>
                                    <td>Precio del producto</td>
                                    <td>Descripción del producto</td>
                                    <td>Modelo del producto</td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                                <logic:notEmpty name="ActionFormFabricante" property="listaProductos">
                                    <logic:iterate id="ver" name="ActionFormFabricante" property="listaProductos">
                                        <tr>
                                            <html:form action="/FabricanteMantenimiento">
                                                
                                                <td ><bean:write name="ver" property="nombreProducto"/></td>
                                                <td ><bean:write name="ver" property="precioUnitario"/></td>
                                                <td ><bean:write name="ver" property="descripcionProducto"/></td>
                                                <td ><bean:write name="ver" property="modelo"/></td>
                                              
                                                <!-- td><!--html:submit property="action" value="ConsultarTipo"/></td -->
                                            </html:form>
                                        </tr>
                                    </logic:iterate>
                                </logic:notEmpty>
                            </tbody>
                        </table>
                        <br>
                    </div>
                </div>               
            </div>                           
    </body>
</html>
