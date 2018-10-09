<%-- 
    Document   : agregarInventario
    Created on : 09-05-2018, 09:08:05 AM
    Author     : guillermo.bermudes
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
        <title>Mantenimiento de Inventario</title>
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
                                        
        <html:form action="/inventarioMantenimiento">
            
            <table border="0">
                
                <tbody>
                  <tr>
                        
                 <td>id inventario </td>
                 <td><html:text property="idInventario" size="20" ></html:text>   
                 
                 <td> 
                        
                </tr>
                    <tr>
                        
                 <td>id producto </td>
                 <td><html:text property="idProducto" size="20" ></html:text>   
                 
                 <td> 
                        
                </tr>
                    <tr>
                        <td>existencias</td>
                        <td><html:text property="existencia" size="20" ></html:text> 
                    </tr>
                    <tr>
                        <td>estado de existencias</td>
                        <td><html:text property="estadoExistencia" size="50" ></html:text> 
                    </tr>
                     <tr>
                        <td>stock minimo</td>
                        <td><html:text property="stockMinimo" size="50" ></html:text> 
                    </tr>
                      <tr>
                        <td>estado Fisico</td>
                        <td><html:text property="estadoFisico" size="50" ></html:text> 
                    </tr>
                    <tr>
                       
                    <tr colspan="2">
                    <bean:write name="ActionFormInventario" property="error" filter="false"/>
                    </tr>
                </tbody>  
            </table>
             
                    <html:submit property="action" value="Agregar"/>
                   
                    <html:submit property="action" value="Consultar"/>
               
        </html:form>
        <div id="error">${error}</div>
    <script type="text/javascript">
        if ($("#error").text() != "") {
            window.onload = function () {
                toastrs();
            };
        }
        ;
        toastr.options = {
            "debug": false,
            "positionClass": "toast-bottom-right",
            "onclick": null,
            "fadeIn": 300,
            "fadeOut": 100,
            "timeOut": 5000,
            "extendedTimeOut": 1000
        };
        var showToastrs = false;
        function toastrs() {
            if (!showToastrs) {
                toastr.error($("#error").text(), 'Error');
            } else {
                toastr.error('no se puede!\'t.', 'Otro error crítico');
            }
        }
    </script>
    </body>
</html>
