<%-- 
    Document   : listaLogin
    Created on : 08-27-2018, 02:32:14 PM
    Author     : Admin105
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
        <title>Lista Fabricante</title>
        
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        
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
                    <div class="table table-striped">
                        <h4>${mensaje}</h4>
                        <table>
                            <thead>
                                <tr>
                                    <td>Id fabricante</td>
                                    <td>Nombre Fabricante</td>
                                    <td>Numero de productos</td>
                                    <td>descripcion de productos</td>
                                    <td> fecha de registro</td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                                <logic:notEmpty name="ActionFormFabricante" property="listaFabricante">
                                    <logic:iterate id="ver" name="ActionFormFabricante" property="listaFabricante" >
                                        <tr>
                                            <html:form action = "/fabricanteMantenimiento">
                                                <td><bean:write name="ver" property="idFabricante"/>
                                                    <div hidden="hidden"><html:text name="ver" property="idFabricante"/></div></td>
                                                <td><bean:write name="ver" property="nombreFabricante"/></td>
                                                <td><bean:write name="ver" property="numeroProductos"/></td>
                                                <td><bean:write name="ver" property="descripcionFabricante"/></td>
                                                <td><bean:write name="ver" property="fechaRegistroFabricante"/></td>

                                                <td><html:submit property="action" value="Eliminar"/></td>
                                                <td><html:submit property="action" value="Modificar"/></td>


                                            </html:form>
                                        </tr>
                                    </logic:iterate>
                                </logic:notEmpty>
                            </tbody>
                            <bean:write name="ActionFormFabricante" property="error" filter="false"/>
                        </table>
                          <bean:write name="ActionFormFabricante" property="error" filter="false"/>
                        <html:link page="/jsp/fabricante/agregarFabricante.jsp">regresar</html:link>
                        

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
