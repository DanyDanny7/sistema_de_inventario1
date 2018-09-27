<%-- 
    Document   : agregarConfiguracion
    Created on : 08-29-2018, 04:08:52 PM
    Author     : daniel.bonillausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Factura</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="http://codeseven.github.com/toastr/toastr.js"></script>
        <link href="http://codeseven.github.com/toastr/toastr.css" rel="stylesheet"/>
        <link href="http://codeseven.github.com/toastr/toastr-responsive.css" rel="stylesheet"/>
    </head>
    <body background="img/fondos/fondo1.jpg">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div> 
                        <nav class="navbar navbar-expand-lg navbar" style="background-color: #000;">
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
                <div class="col-12 text-center">
                    <div class="card-header" style="color: white"><h1 class="font-weight-bold">Agregar Factura</h1></div>
                    <br>
                    <html:form action="/facturaMantenimiento">
                        <div class="card-header" style="background-color:#f0f3f4;">
                            <div class="row">
                                <div class="col-9">
                                    <h2 class="text-center">${nombreEmpresa}</h2>
                                    <h6 class="text-center">${direccionEmpresa}</h6>
                                    <div class="text-left"><label >Cliente</label></div>
                                    <html:select property="idContacto" styleClass="form-control">
                                        <html:option value="Seleccionar"></html:option>
                                        <logic:notEmpty name="ActionFormFactura" property="listaContactos">
                                            <logic:iterate id="ver" name="ActionFormFactura" property="listaContactos">
                                                <html:option value="${ver.idContacto}" >${ver.nombreContacto}</html:option>
                                            </logic:iterate>
                                        </logic:notEmpty>
                                    </html:select>
                                </div>
                                <div class="col-3">
                                    <div class="text-left"><label>Numero de Factura : </label></div>
                                    <h2 class="text-center" style="color: red">00</h2>
                                    <div class="text-left"><label >Fecha : </label></div>
                                    <html:text property="fechaFactura"></html:text>
                                    </div>
                                </div>    
                            </div>
                            <br>
                            <div class="card-header" style="background-color:#f0f3f4;">
                                <div class="row">
                                    <div class="col-10">
                                        <table>
                                            <thead>
                                                <tr style="width:100%">
                                                    <td style="width:700px">Producto</td>
                                                    <td>    </td>
                                                    <td style="width:400px">Cantidad</td>
                                                </tr>
                                            </thead>
                                            <tbody class="align-content-center">
                                                <tr>
                                                    <td>
                                                    <html:select property="idProducto" styleClass="form-control" >
                                                        <html:option value="Seleccionar"></html:option>
                                                        <logic:notEmpty name="ActionFormFactura" property="listaProductos">
                                                            <logic:iterate id="ver" name="ActionFormFactura" property="listaProductos">
                                                                <html:option value="${ver.idProducto}" >${ver.nombreProducto}</html:option>
                                                            </logic:iterate>
                                                        </logic:notEmpty>
                                                    </html:select> 
                                                </td>
                                                <td>  </td>
                                                <td><html:text property="cantidad" styleClass="form-control"></html:text></td>
                                                </tr>
                                            </tbody>
                                        </table>

                                    </div>
                                    <div class="col-2">
                                        <br>
                                    <html:submit  property="action" value="Agregar" styleClass="btn  font-weight-bold " style="background-color:#000; color: white"></html:submit>
                                    </div>
                                </div>
                            </div>
                            <div class="card-header" style="background-color:#f0f3f4;">
                                <div class="row">
                                    <div class="col-12">
                                        <table>
                                            <thead>
                                                <tr style="width:100%"> 
                                                    <td style="width:400px">Producto : </td>
                                                    <td style="width:250px">Cantidad : </td>
                                                    <td style="width:250px">Precio Unitario : </td>
                                                    <td style="width:250px">Total :</td>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                            <br>
                        <html:submit property="action" value="Guardar" styleClass="btn  font-weight-bold" style="background-color:#f0f3f4; color: black"/>

                    </html:form>
                    <h5>${error}</h5>
                </div>
                <div class="col-1"></div>
            </div>
        </div>
    </body>
</html>
<%--
<label class="font-weight-bold">Empresa : </label><br>
                                    <html:select property="idEmpresa" styleClass="form-control">
                                        <html:option value="Seleccionar"></html:option>
                                        <logic:notEmpty name="ActionFormAcceso" property="listaEmpresa">
                                            <logic:iterate id="ver" name="ActionFormAcceso" property="listaEmpresa">
                                                <html:option value="${ver.idEmpresa}" >${ver.nombreEmpresa}</html:option>
                                            </logic:iterate>
                                        </logic:notEmpty>
   *                                </html:select>  --%>