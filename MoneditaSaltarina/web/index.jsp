<%-- 
    Document   : index
    Created on : 09-03-2018, 01:42:35 PM
    Author     : daniel.bonillausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>


    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div>
                        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #0000FF;">
                            <a class="navbar-brand" href="#" style = 'color: white'>Navbar</a>
                            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>

                            <div class="collapse navbar-collapse" id="navbarSupportedContent" >
                                <ul class="navbar-nav mr-auto" >
                                    <li class="nav-item active">
                                        <a class="nav-link" href="#" style = 'color: white'>Home <span class="sr-only">(current)</span></a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#" style = 'color: white'>Link</a>
                                    </li>
                                    <li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" 
                                           aria-haspopup="true" aria-expanded="false" style = 'color: white'> 
                                            Dropdown
                                        </a>
                                        <div class="dropdown-menu" aria-labelledby="navbarDropdown" >
                                            <a class="dropdown-item" href="#">Action</a>
                                            <a class="dropdown-item" href="#">Another action</a>
                                            <div class="dropdown-divider"></div>
                                            <a class="dropdown-item" href="#">Something else here</a>
                                        </div>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link disabled" href="#" style = 'color: white'>Disabled</a>
                                    </li>

                                </ul>
                                <ul class="nav navbar-nav navbar-right">
                                    <html:form action = "/accesoMantenimiento">
                                        <div>
                                            <span class="glyphicon glyphicon-exclamation-sign" ></span>
                                            <div><strong><bean:write name="ActionFormAcceso" property="error" filter="false"/></strong></div>
                                        </div>
                                    </html:form>

                                    <div class="btn-group dropleft">
                                        <button type="button" class="btn btn-outline-light dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            Iniciar Secion
                                        </button>
                                        <div class="dropdown-menu">
                                            <html:form action="/accesoMantenimiento" styleClass="px-4 py-3">

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
                                                        Remember me
                                                    </label>
                                                </div>
                                                <html:submit styleClass="btn btn-primary" property="action" value="Login">Iniciar Sesión</html:submit>

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
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-4"> 1</div>
                        <div class="col-4">2

                        </div>
                        <div class="col-4"> 3</div>
                    </div>
                </div>
            </div>



            <div class="container">
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10">
                        <h1>Index</h1>
                        <br>
                        <br>
                    <html:link page="/jsp/acceso/inicio.jsp">Acceso</html:link><br><br>
                    <html:link page="/jsp/configuracion/inicio.jsp">Configuración</html:link><br><br>
                    <html:link page="/jsp/moneda/inicio.jsp">Moneda</html:link><br><br>
                    <!--html:link page="/jsp/acceso/login.jsp">Login/html:link-->
                    <html:link page="/jsp/contactos/inicio.jsp">Contactos</html:link><br><br>
                    <html:link page="/jsp/producto/inicioP.jsp">Productos</html:link><br><br>
                    <html:link page="/jsp/producto/inicioP.jsp">Productos</html:link><br><br>

                </div>
                <div class="col-1"></div>
            </div>
        </div>
    </body>
</html>
