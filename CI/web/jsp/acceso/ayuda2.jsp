<%-- 
    Document   : ayuda
    Created on : 09-04-2018, 11:38:50 AM
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
        <title>Ayuda</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="http://codeseven.github.com/toastr/toastr.js"></script>
        <link href="http://codeseven.github.com/toastr/toastr.css" rel="stylesheet"/>
        <link href="http://codeseven.github.com/toastr/toastr-responsive.css" rel="stylesheet"/>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div>
                        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #000;">
                            <a class="navbar-brand" href="accesoMantenimiento.do?action=index" style = 'color: white'>Inicio</a>
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>

                            <div class="collapse navbar-collapse" id="navbarSupportedContent" >
                                <ul class="navbar-nav mr-auto" >
                                </ul>
                                <ul class="nav navbar-nav navbar-right">
                                    <div class="btn-group dropleft">
                                        <li class="nav-item dropdown">
                                            <a class="nav-link dropdown" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" 
                                               aria-haspopup="true" aria-expanded="false" style = 'color: white'> 
                                                <img src="img/configuracion/configuración.png" width="40" height="40" alt=""/>
                                            </a>
                                            <div class="dropdown-menu" aria-labelledby="navbarDropdown" >
                                                <a class="dropdown-item" text-dark href="empresaMantenimiento.do?action=irAgregar">Configuración Inicial</a>
                                            </div>
                                        </li>
                                    </div>
                                    <div>   </div>
                                    <div class="btn-group dropleft">
                                        <button type="button" class="btn btn-outline-light dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            Iniciar Secion
                                        </button>
                                        <div class="dropdown-menu">
                                            <html:form action="/accesoMantenimiento" styleClass="px-4 py-3 ">

                                                <div class="form-group">
                                                    <label for="usuario">Usuario :</label>
                                                    <input type="text" class="form-control" name="usuario" id="usuario" placeholder="escriba su usuario" required="">
                                                </div>
                                                <div class="form-group">
                                                    <label for="contrasena">Contraseña :</label>
                                                    <input type="password" class="form-control" name="contrasena" id="contrasena" placeholder="escriba su contraseña" required="">
                                                </div>
                                                <div class="form-check">
                                                    <input type="checkbox" class="form-check-input" id="dropdownCheck">
                                                    <label class="form-check-label" for="dropdownCheck">
                                                        Recordarme
                                                    </label>
                                                </div>
                                                <html:submit styleClass="btn btn-dark" property="action" value="Login">Iniciar Sesión</html:submit>

                                            </html:form>

                                            <div class="dropdown-divider"></div>
                                            <html:link styleClass="dropdown-item" page="/jsp/acceso/ayuda1.jsp">¿Olvidaste tu contraseña?</html:link>
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
                <br>
                <div class="row">
                    <div class="col-3"><br></div>
                    <div class="col-6"><h1>Restauracion de Contraseña</h1></div>
                    <div class="col-3"></div>
                </div><br>
                <div class="row">
                    <div class="col-1"><br></div>
                    <div class="col-10"> <h3>Por politicas internas la restauracion de contraseña no está habilitada 
                            continuacion le presentamos una lista usuarios y su correo electronico a los que puede solicitar ayuda. </h3></div>
                    <div class="col-1"></div>
                </div><br>
                <div class="row">
                <div class="col-4"><br></div>
                <div class="col-4" >
                    <div class="card-header" style="background-color:#007bff;">
                    <table class="bg-light">
                        <thead class="text-uppercase">
                            <tr class="table-default" style="background-color: #000; color: white;font-family: Arial">
                                <td style="width:200px">Nombre</td>
                                <td style="width:200px">E-mail</td>
                            </tr>
                        </thead>
                        <tbody>
                        <logic:notEmpty name="ActionFormAcceso" property="listaAcceso">
                            <logic:iterate id="ver" name="ActionFormAcceso" property="listaAcceso" >
                                <tr>
                                    <html:form action = "/accesoMantenimiento" >
                                        <td><bean:write name="ver" property="nombreAcceso"/></td>
                                        <td><bean:write name="ver" property="email"/></td>
                                    </html:form > 
                                </tr>
                            </logic:iterate>
                        </logic:notEmpty>
                    </tbody>
                </table>
            </div>
            </div>
            <div class="col-4"></div>
            </div>
        </div>                             

    </body>
</html>
