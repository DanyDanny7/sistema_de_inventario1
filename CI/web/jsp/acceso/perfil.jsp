<%-- 
    Document   : confirmacionNuevoAcceso
    Created on : 08-21-2018, 03:38:42 PM
    Author     : Admin105
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
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
                        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #000;">
                            <a class="navbar-brand" href="accesoMantenimiento.do?action=portada" style = 'color: white'>${img}</a>
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>

                            <div class="collapse navbar-collapse" id="navbarSupportedContent" >
                                <ul class="navbar-nav mr-auto" >

                                    <li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" 
                                           aria-haspopup="true" aria-expanded="false" style = 'color: white'> 
                                            Fabricantes
                                        </a>
                                        <div class="dropdown-menu" aria-labelledby="navbarDropdown" >
                                            <a class="dropdown-item " href="fabricanteMantenimiento.do?action=irAgregar">Agregar Fabricantes</a>
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
                                            <a class="dropdown-item" href="comprasMantenimiento.do?action=irAgregar">Agregar Compra</a>
                                            <a class="dropdown-item" href="comprasMantenimiento.do?action=Consultar">Consultar Compras</a>
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
                                            <a class="dropdown-item" href="inventarioMantenimiento.do?action=existenciabajaa">Productos en Stock Bajo</a>
                                            <a class="dropdown-item" href="inventarioMantenimiento.do?action=existenciacero">Productos sin Stock</a>
                                        </div>
                                    </li>
                                    <li class="nav-item dropdown">
                                    <li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" 
                                           aria-haspopup="true" aria-expanded="false" style = 'color: white'> 
                                            Factura
                                        </a>
                                        <div class="dropdown-menu" aria-labelledby="navbarDropdown" >
                                            <a class="dropdown-item" href="facturaMantenimiento.do?action=irAgregar">Agregar Factura</a>
                                            <a class="dropdown-item" href="facturaMantenimiento.do?action=Consultar">Consultar Factura</a>
                                        </div>
                                    </li>
                                    <!--<li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" 
                                           aria-haspopup="true" aria-expanded="false" style = 'color: white'> 
                                            Empresas
                                        </a>
                                        <div class="dropdown-menu" aria-labelledby="navbarDropdown" >
                                            <a class="dropdown-item" href="empresaMantenimiento.do?action=irAgregar">Agregar Empresa</a>
                                            <a class="dropdown-item" href="empresaMantenimiento.do?action=Consultar">Consultar Empresa</a>
                                        </div>
                                    </li>-->
                                    <li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" 
                                           aria-haspopup="true" aria-expanded="false" style = 'color: white'> 
                                            Consultas
                                        </a>
                                        <div class="dropdown-menu" aria-labelledby="navbarDropdown" >




                                            <a class="dropdown-item" href="contactosMantenimiento.do?action=Consultar">Contactos</a>
                                            <a class="dropdown-item" href="comprasMantenimiento.do?action=Consultar">Compras</a>
                                            <a class="dropdown-item" href="facturaMantenimiento.do?action=Consultar">Facturas</a>
                                            <a class="dropdown-item" href="fabricanteMantenimiento.do?action=Consultar">Fabricantes</a>
                                            <a class="dropdown-item" href="ivaMantenimiento.do?action=Consultar">Iva </a>
                                            <a class="dropdown-item" href="monedaMantenimiento.do?action=Consultar">Monedas</a>
                                            <a class="dropdown-item" href="productosMantenimiento.do?action=Consultar">Productos</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Cliente">Consultar Clientes</a>
                                            <a class="dropdown-item" href="contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Proveedor">Consultar Proveedores</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="fabricanteMantenimiento.do?action=Consultar2">Productos por Fabricante</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="inventarioMantenimiento.do?action=existenciabajaa">Productos en Stock Bajo</a>
                                            <a class="dropdown-item" href="inventarioMantenimiento.do?action=existenciacero">Productos sin Stock</a>

                                        </div>
                                    </li>
                                </ul>
                                <ul class="nav navbar-nav navbar-right">
                                    <div class="btn-group dropleft">
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" 
                                               aria-haspopup="true" aria-expanded="false" style = 'color: white'> 
                                                <img src="img/configuracion/configuración.png" width="40" height="40" alt=""/>
                                            </a>
                                            <div class="dropdown-menu" aria-labelledby="navbarDropdown" >
                                                <a class="dropdown-item" text-dark href="configuracionMantenimiento.do?action=consultaId">Configuración</a>
                                            </div>
                                        </li>
                                    </div>
                                    <div>   </div>
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
        <br>
        <div class="container">
            <div class="row">
                <div class="col-12 text-center">
                    <div class="card-header" style="color: white"><h1 class="font-weight-bold">Perfil</h1></div>
                    <html:form action = "/accesoMantenimiento">
                        <div class="card-header" style="background-color: #D8D8D8;">
                            <div class="row">
                                <div class="form-group col-6">
                                    <label>Nombre : </label><br>
                                    <html:text property="nombreAcceso" styleClass="form-control"></html:text>
                                    </div>
                                    <br>
                                    <div class="form-group col-6">
                                        <label>Apellido : </label><br>
                                    <html:text property="apellidoAcceso" styleClass="form-control"></html:text>
                                    </div>
                                    <br>
                                </div>
                                <div class="row">
                                    <div class="form-group col-6">
                                        <label>Usuario : </label><br>
                                    <html:text property="usuario" styleClass="form-control"></html:text>
                                    </div>
                                    <br>
                                    <div class="form-group col-6">
                                        <label>E-Mail : </label><br>         
                                    <html:text  property="eMail" styleClass="form-control"></html:text>
                                    </div>
                                    <br>  
                                </div>
                                <div class="row">
                                    <div class="form-group col-4"></div>
                                    <div class="form-group col-4">
                                        <label>Nivel de Acceso : </label><br>
                                        <label class="btn"  style="background-color: #e9ecef;">${tipoAcceso}</label>

                                </div>
                            </div> 
                            <br>

                            <div hidden="hidden">

                                <label>Id Acceso : </label><br>
                                <html:text property="idAcceso"></html:text><br><br>
                                    <label>Fecha de Registro : </label><br>
                                <html:text property="fechaRegistroAcceso"></html:text><br><br>
                                    <label>Contraseña : </label><br>
                                <html:text property="contrasena"></html:text><br><br>
                                    <label>Id Empresa : </label><br>
                                <html:text property="idEmpresa" styleClass="form-control"></html:text>
                                    <br>
                                </div>
                            </div>
                            <br>
                    </html:form>
                    <br>

                </div>
            </div>
        </div>
    </body>
</html>
