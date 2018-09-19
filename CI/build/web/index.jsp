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
                <div class="col-12"> primary
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
                <div class="row">
                    <div class="col-1"></div>
                    <div class="col-10">
                        <h1>Index</h1>
                        <br>
                        <br>

                    </div>
                    <div class="col-1"></div>
                </div>

                <p id="hola" hidden="hidden">${mensaje}</p>
        </div>
        <script type="text/javascript">

            if ($("#hola").text() != "") {
                window.onload = function () {
                    toastrs();
                };
            };

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
                    toastr.error($("#hola").text(), 'Error');


                } else {
                    toastr.error('no se puede!\'t.', 'Otro error crítico');
                }
            }
        </script>
    </body>
</html>