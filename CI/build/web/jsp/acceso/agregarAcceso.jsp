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
        <title>Agregar Acceso</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
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
        <br>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h1>Agregar Acceso</h1>
                    
     <%--               <ul class="nav nav-tabs"><li class="nav-item " ><a class="nav-link active" style="background-color: #2E9AFE; color: white "  href="contactosMantenimiento.do?action=Consultar">Todo</a>
                        </li><li class="nav-item"><a class="nav-link" href="contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Cliente">
                        Clientes</a></li><li class="nav-item"><a class="nav-link" href="contactosMantenimiento.do?action=ConsultarTipo&tipoContacto=Proveedor">"Proveedores</a></li></ul>
                    
     --%>           
                    
                    
                    <br>
                    <html:form action = "/accesoMantenimiento">
                        <div class="row">
                            <div class="form-group col-md-">
                                <label class="font-weight-bold">Empresa : </label><br>
                                <html:select property="idEmpresa" styleClass="form-control">
                                    <html:option value="Seleccionar"></html:option>
                                    <logic:notEmpty name="ActionFormAcceso" property="listaEmpresa">
                                        <logic:iterate id="ver" name="ActionFormAcceso" property="listaEmpresa">
                                            <html:option value="${ver.idEmpresa}" >${ver.nombreEmpresa}</html:option>
                                        </logic:iterate>
                                    </logic:notEmpty>
                                </html:select>
                            </div>
                        </div>
                        <br>

                        <label class="font-weight-bold">Nombre : </label><br>
                        <html:text property="nombreAcceso" styleClass="form-control"></html:text><br><br>
                            <label class="font-weight-bold">Apellido : </label><br>
                        <html:text property="apellidoAcceso" styleClass="form-control"></html:text><br><br>
                            <label class="font-weight-bold">Usuario : </label><br>
                        <html:text property="usuario" styleClass="form-control"></html:text><br><br>
                            <label class="font-weight-bold">Contraseña : </label><br>
                        <html:text property="contrasena" styleClass="form-control"></html:text><br><br>
                            <label class="font-weight-bold">E-Mail : </label><br>
                            <input type="email" name="email" class="form-control"><br><br>

                            <label class="font-weight-bold">Nivel de Acceso : </label><br>
                        <html:select property="tipoAcceso" styleClass="form-control">
                            <html:option value="Seleccionar"></html:option>
                            <html:option value="Solo Consulta"></html:option>
                            <html:option value="Consulta e Ingresar"></html:option>
                            <html:option value="Administrador"></html:option>
                            <html:option value="Super Administrador"></html:option>
                        </html:select>
                        <br>

                        <bean:write name="ActionFormAcceso" property="error" filter="false"/>    


                        <br>
                        <html:submit property="action" value="Agregar"/>
                        <html:submit property="action" value="Consultar"/>

                    </html:form>
                    <br>
                    <html:link page="/index.jsp">Index</html:link>
                </div>
            </div>
        </div> 
    </body>
</html>
