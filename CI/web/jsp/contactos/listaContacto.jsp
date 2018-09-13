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
        
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
    </head>
    <body> 
        <div class="container">
             <div class="container-fluid">
                <div class="row">
                    <div class="col-xl">
                        <div> 
                            <nav class="navbar navbar-expand-lg navbar" style="background-color: #2E9AFE;">
                                <a class="navbar-brand" href="accesoMantenimiento.do?action=portada" style = 'color: white'>Inicio</a>
                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>

                                <div class="collapse navbar-collapse" id="navbarSupportedContent" >
                                    <ul class="navbar-nav mr-auto" >
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" 
                                               aria-haspopup="true" aria-expanded="false" style = 'color: white'> 
                                                Parametros
                                            </a>
                                            <div class="dropdown-menu" aria-labelledby="navbarDropdown" >
                                                <a class="dropdown-item" href="#">Configuración Inicial</a>
                                            </div>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" 
                                               aria-haspopup="true" aria-expanded="false" style = 'color: white'> 
                                                Fabricantes
                                            </a>
                                            <div class="dropdown-menu" aria-labelledby="navbarDropdown" >
                                                <a class="dropdown-item" href="fabricanteMantenimiento.do?action=irAgregar">Agregar Fabricantes</a>
                                                <a class="dropdown-item" href="fabricanteMantenimiento.do?action=Consultar">Consultar Fabricantes</a>
                                            </div>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" 
                                               aria-haspopup="true" aria-expanded="false" style = 'color: white'> 
                                                Contactos
                                            </a>
                                            <div class="dropdown-menu" aria-labelledby="navbarDropdown" >
                                                <a class="dropdown-item" href="contactosMantenimiento.do?action=irAgregar">Agregar Contacto</a>
                                                <a class="dropdown-item" href="contactosMantenimiento.do?action=Consultar">Consultar Contactos</a>
                                                <div class="dropdown-divider"></div>
                                                <a class="dropdown-item" href="contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Cliente">Consultar Clientes</a>
                                                <a class="dropdown-item" href="contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Proveedor">Consultar Proveedores</a>
                                            </div>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" 
                                               aria-haspopup="true" aria-expanded="false" style = 'color: white'> 
                                                Compras
                                            </a>
                                            <div class="dropdown-menu" aria-labelledby="navbarDropdown" >
                                                <a class="dropdown-item" href="#">Agregar Compra</a>
                                                <a class="dropdown-item" href="#">Consultar Compras</a>
                                                <div class="dropdown-divider"></div>
                                                <a class="dropdown-item" href="#">Consultas por Documento</a>
                                            </div>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" 
                                               aria-haspopup="true" aria-expanded="false" style = 'color: white'> 
                                                Productos
                                            </a>
                                            <div class="dropdown-menu" aria-labelledby="navbarDropdown" >
                                                <a class="dropdown-item" href="productosMantenimiento.do?action=irAgregar">Agregar Producto</a>
                                                <a class="dropdown-item" href="productosMantenimiento.do?action=Consultar">Consultar Productos</a>
                                                <div class="dropdown-divider"></div>
                                                <a class="dropdown-item" href="#">Consulta de productos en Stock Bajo</a>
                                                <a class="dropdown-item" href="#">Consulta de productos en sin Stock</a>
                                            </div>
                                        </li>
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" 
                                               aria-haspopup="true" aria-expanded="false" style = 'color: white'> 
                                                Consultas
                                            </a>
                                            <div class="dropdown-menu" aria-labelledby="navbarDropdown" >
                                                <a class="dropdown-item" href="#">Compras</a>
                                                <a class="dropdown-item" href="contactosMantenimiento.do?action=Consultar">Contactos</a>
                                                <a class="dropdown-item" href="fabricanteMantenimiento.do?action=Consultar">Fabricantes</a>
                                                <a class="dropdown-item" href="monedaMantenimiento.do?action=Consultar">Monedas</a>
                                                <a class="dropdown-item" href="productosMantenimiento.do?action=Consultar">Productos</a>
                                            </div>
                                        </li>
                                    </ul>
                                    <ul class="nav navbar-nav navbar-right">
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-secondary">
                                                ${nombre}
                                            </button>
                                            <div class="btn-group dropleft" role="group">
                                                <button type="button" class="btn btn-secondary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    <span class="sr-only">Toggle Dropleft</span>
                                                </button>
                                                <div class="dropdown-menu" aria-labelledby="navbarDropdown" >
                                                    <html:form action="/accesoMantenimiento">
                                                        <a class="dropdown-item" href="#">${nAcceso}</a>
                                                        <html:submit styleClass="dropdown-item" property="action" value="Perfil"></html:submit>
                                                            <div class="dropdown-divider"></div>
                                                        <html:submit styleClass="dropdown-item" property="action" value="Cerrar Session"></html:submit>
                                                    </html:form>
                                                </div>
                                            </div>
                                        </div>
                                    </ul>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>

            </div>
        <div class="container">
            <div class="row">
                <div class="col-12">
                   <div class="col-6">
                       <br>
                            <div class=" col-auto">
                                <div class="card">

                                    <div class="card-header" style="background-color: #D8D8D8;"><h2 class="font-weight-bold">LISTA CONTACTOS</h2></div>
                                </div> 
                            </div>
                        </div>
                    <br>
                    <div class="col-md-4">
                    ${codigo}
                    </div>
                    <br>
                    
                    <div class="table table-hover table-sm ">
                        <table class="bg-light ">
                            <thead>
                            
                                <tr class="table-warning">
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
                                                <td><bean:write name="ver" property="idContacto"/>
                                                     <div hidden="hidden"><html:text name="ver" property="idContacto"/></div></td>
                                                <td ><bean:write name="ver" property="nombreContacto"/></td>
                                                <td ><bean:write name="ver" property="direccionContacto"/></td>
                                                <td ><bean:write name="ver" property="telefonoContacto"/></td>
                                                <td ><bean:write name="ver" property="encargadoContacto"/></td>
                                                <td ><bean:write name="ver" property="telefonoEncargadoContacto"/></td>
                                                <td ><bean:write name="ver" property="tipoContacto"/></td>
                                                <td ><bean:write name="ver" property="emailContacto"/></td>
                                                <td ><bean:write name="ver" property="fechaRegistroContacto"/></td>
                                                <td ><html:submit property="action" value="Eliminar" styleClass="btn  font-weight-bold" style="background-color: #04B404;"/></td>
                                                <td ><html:submit property="action" value="ConsultarId" styleClass="btn  font-weight-bold" style="background-color: #04B404;"/></td>
                                                <!-- td><!--html:submit property="action" value="ConsultarTipo"/></td -->
                                            </html:form>
                                        </tr>
                                    </logic:iterate>
                                </logic:notEmpty>
                            </tbody>
                        </table>                      
                        <br>
                        <a class="font-weight-bold btn text-white"<html:link page="/jsp/contactos/agregarContactos.jsp" style="background-color: #0174DF;">Formulario</html:link>&emsp;
                       
                    </div>
                </div>
            </div>
        </div>
        </div>
    </body>
</html>