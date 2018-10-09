<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
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
                                            <br>
           <div class="container-fluid">
            <div id="demo" class="carousel slide" data-ride="carousel">

                <!-- Indicators -->
                <ul class="carousel-indicators">
                    <li data-target="#demo" data-slide-to="0" class="active"></li>
                    <li data-target="#demo" data-slide-to="1"></li>
                    <li data-target="#demo" data-slide-to="2"></li>
                    <li data-target="#demo" data-slide-to="3"></li>
                    <li data-target="#demo" data-slide-to="4"></li>
                </ul>

                <!-- The slideshow -->
                <div class="carousel-inner">



                    <div class="carousel-item active">
                        <img src="img/carousel/inventario1.jpg" alt="Los Angeles" width="200" height="300">
                    </div>
                    <div class="carousel-item">
                        <img src="img/carousel/inventario2.jpg" alt="Chicago" width="200" height="300">
                    </div>
                    <div class="carousel-item">
                        <img src="img/carousel/inventario3.jpg" alt="New York" width="200" height="300">
                    </div>
                    <div class="carousel-item">
                        <img src="img/carousel/inventario4.jpg" alt="New York" width="200" height="300">
                    </div>
                    <div class="carousel-item">
                        <img src="img/carousel/inventario5.jpg" alt="New York" width="200" height="300">
                    </div>
                </div>

                <!-- Left and right controls -->
                <a class="carousel-control-prev" href="#demo" data-slide="prev">
                    <span class="carousel-control-prev-icon"></span>
                </a>
                <a class="carousel-control-next" href="#demo" data-slide="next">
                    <span class="carousel-control-next-icon"></span>
                </a>

                <style>
                    /* Make the image fully responsive */
                    .carousel-inner img {
                        width: 1650px;
                        height: 700px;
                    }
                </style>

            </div>
            </div>
        <div id="error" hidden="hidden">${mensaje}</div>
        <p id="info" hidden="hidden">${info}</p>
        <script type="text/javascript">
            window.onload = function () {
                if ($("#error").text() != "") {
                    error();
                }
                if ($("#mensaje").text() != "") {
                    mensaje();
                }
                if ($("#info").text() != "") {
                    info();
                }
            };
            toastr.options = {
                "debug": false,
                "onclick": null,
                "fadeIn": 300,
                "fadeOut": 100,
                "timeOut": 5000,
                "extendedTimeOut": 1000
            };
            var showToastrs = false;
            function error() {
                if (!showToastrs) {
                    toastr.error($("#error").text(), 'Error');
                }
            }
            function mensaje() {
                if (!showToastrs) {
                    toastr.success($("#mensaje").text(), 'Confirmacion');
                }
            }
            function info() {
                if (!showToastrs) {
                    toastr.info($("#info").text(), 'Informacion');
                }
            }
        </script>
    </body>
</html>