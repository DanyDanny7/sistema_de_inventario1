<%-- 
    Document   : modificarConfiguracion
    Created on : 08-29-2018, 04:09:01 PM
    Author     : daniel.bonillausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h4>Modificar</h4>
        <div class="container">
            <div class="row">
                <div class="col-1"></div>
                <div class="col-10">
                    <html:form action="/configuracionMantenimiento">
                        <table>
                            <tr>
                                <label>ID Configuracion :</label><br>
                        <html:text property="idConfiguracion"></html:text><br><br>
                                <label>ID Acceso :</label><br>
                        <html:text property="idAcceso"></html:text><br><br>
                        <label>ID Empresa :</label><br>
                        <html:text property="idEmpresa"></html:text><br><br>
                        <label>Moneda :</label><br>
                        <html:text property="nombreMoneda"></html:text><br><br>
                        <label>Simbolo Moneda :</label><br>
                        <html:text property="simboloMoneda"></html:text><br><br>
                        <label>Codigo de Moneda :</label><br>
                        <html:text property="codigoMoneda"></html:text><br><br>
                        <label>Tasa de Iva :</label><br>
                        <html:text property="iva"></html:text><br><br>
                        <label>Zona Horaria :</label><br>
                        <html:text property="zonaHoraria"></html:text><br><br>
                    
                        <bean:write name="ActionFormConfiguracion" property="error" filter="false"></bean:write>
                        </tr>
                        <html:submit property="action" value="Modificar"/>
                            
                        </table>
                        
                    </html:form>
                        
                        <html:link page="/jsp/configuracion/inicio.jsp">Inicio</html:link>
                        <h5>${error}</h5>
                </div>
                <div class="col-1"></div>
            </div>
        </div>
    </body>
</html>
