<%-- 
    Document   : AgregarContactos
    Created on : 08-28-2018, 04:17:42 PM
    Author     : diana.alcantarausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html>
<html> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Contactos</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
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
                <div class="col-12">
                    <br>

                    <div class="col-6">
                        <div class=" col-auto">
                            <div class="card">

                                <div class="card-header" style="background-color: #D8D8D8;"><h1 class="font-weight-bold">Agregar Contacto</h1></div>
                            </div> 
                        </div>
                    </div>



                    <br>
                    <html:form action="/contactosMantenimiento"> 
                        <div class="row">
                            <div class="form-group col-md-6">
                                <label class="font-weight-bold">Nombre del contacto:</label><br>
                                <html:text property="nombreContacto" styleClass="form-control"></html:text><br>
                                </div>

                                <div class="form-group col-md-5">
                                    <label class="font-weight-bold">Email del contacto:</label><br>
                                    <input type="email" name="emailContacto" class="form-control"><br>
                                </div>


                            </div>
                            <div class="row"> 
                                <div class="form-group col-md-6">
                                    <label class="font-weight-bold">Direccion del contacto:</label><br>
                                <html:text property="direccionContacto" styleClass="form-control"></html:text> <br>
                                </div>                                    

                                <div class="form-group col-md-5">
                                    <label class="font-weight-bold">Telefono del contacto:</label><br>
                                <html:text property="telefonoContacto" styleClass="form-control"></html:text><br>
                                </div>

                            </div> 

                            <div class="row">

                                <div class="form-group col-md-6">
                                    <label class="font-weight-bold">Encargado:</label><br>
                                <html:text property="encargadoContacto" styleClass="form-control"></html:text><br>
                                </div>
                                <div class="form-group col-md-5">
                                    <label class="font-weight-bold">Telefono del encargado:</label><br>
                                <html:text property="telefonoEncargadoContacto" styleClass="form-control"></html:text><br>
                                </div>
                            </div> 

                            <div class="row">    
                                <div class="form-group col-md-3">
                                    <label class="font-weight-bold">Tipo de contacto:</label><br>
                                <html:select property="tipoContacto" styleClass="form-control">
                                    <html:option value="Seleccionar"></html:option> 
                                    <html:option value="Cliente">Cliente</html:option> 
                                    <html:option value="Proveedor">Proveedor</html:option>
                                </html:select><br>

                                <bean:write name="ActionFormContactos" property="error" filter="false"/>
                            </div>
                        </div>

                        <div class="row">  

                            <div class="form-group col-md-auto">
                                <html:submit property="action" value="Agregar" styleClass="btn  font-weight-bold" style="background-color: #04B404;"/>
                                <html:submit property="action" value="Consultar" styleClass="btn  font-weight-bold" style="background-color: #04B404;"/>
                                <a class="font-weight-bold btn text-dark" <html:link page="/jsp/contactos/inicio.jsp" style="background-color: #04B404;">Inicio</html:link>
                            </div>
                        </div>

                </html:form>
                <!-- <div class="row">
                     <div class="form-group col-5">
                          <a class="font-weight-bold btn btn-primary"<html:link page="/index.jsp">Index</html:link> 
                            <a class="font-weight-bold btn btn-primary" <html:link page="/jsp/contactos/inicio.jsp" >Inicio</html:link>

                            </div> -->


            </div>

        </div>

    </div>

</div>




</body>

</html>
