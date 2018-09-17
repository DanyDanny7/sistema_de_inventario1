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
        <title>Agregar Configuracion</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Agregar Configuracion</h1>
        <div class="container">
            <div class="row">
                <div class="col-1"></div>
                <div class="col-10">
                    <html:form action="/configuracionMantenimiento">
                        
                                
                            <label>ID Acceso :</label><br>
                            <html:text property="idAcceso"></html:text><br><br>
                                <label>ID Empresa :</label><br>
                            <html:text property="idEmpresa"></html:text><br><br>
                            <label>Nombre de Moneda :</label><br>
                            <html:text property="nombreMoneda"></html:text><br><br>
                           
                                <label>Tasa de Iva :</label><br>
                            <html:text property="iva"></html:text><br><br>

                            <bean:write name="ActionFormConfiguracion" property="error" filter="false"></bean:write>
                        
                            <label>Logo :</label><br>
                            <html:file property="file" ></html:file>
                            <br><br>
                            <html:submit property="action" value="cargar"/>
                            <br><br>
                            <html:submit property="action" value="Agregar"/>

                    </html:form>

                    <html:link page="/jsp/configuracion/inicio.jsp">Inicio</html:link>
                    <h5>${error}</h5>
                </div>
                <div class="col-1"></div>
            </div>
        </div>
    </body>
</html>
