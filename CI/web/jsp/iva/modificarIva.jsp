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
        <title>Modificar Iva</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="js/popper.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="http://codeseven.github.com/toastr/toastr.js"></script>
        <link href="http://codeseven.github.com/toastr/toastr.css" rel="stylesheet"/>
        <link href="http://codeseven.github.com/toastr/toastr-responsive.css" rel="stylesheet"/>
    </head>
    <body>
        <h1>Modificar Iva</h1>
        <div class="container">
            <div class="row">
                <div class="col-1"></div>
                <div class="col-10">
                    <html:form action="/ivaMantenimiento">
                        
                            
                            <label>Id Iva : </label><br>
                            <html:text property="idIva"></html:text><br><br>
                            <label>Tasa Iva : </label><br>
                            <html:text property="ivaTasa"></html:text><br><br>
                                <label>Iva Retenido : </label><br>
                            <html:text property="ivaRetenido"></html:text><br><br>
                                <label>Iva Pagado : </label><br>
                            <html:text property="ivaPagado"></html:text><br><br>
                                <label>Total Iva : </label><br>
                            <html:text property="ivaTotal" ></html:text><br><br>
                            <bean:write name="ActionFormIva" property="error" filter="false"></bean:write>
                            <br>
                            <html:submit property="action" value="Modificar"/>
                            <br>
                            <br>
                        
                    </html:form>

                    <html:link page="/jsp/iva/inicio.jsp">Inicio</html:link>
                    <h5>${error}</h5>
                </div>
                <div class="col-1"></div>
            </div>
        </div>
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
