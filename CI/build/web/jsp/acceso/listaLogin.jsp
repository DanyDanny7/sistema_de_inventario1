<%-- 
    Document   : listaLogin
    Created on : 08-27-2018, 02:32:14 PM
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
        <title>Lista Login</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <label>${nombre}</label>
        <label>${nAcceso}</label>
                    <div class="table table-striped">
                        <bean:write name="ActionFormAcceso" property="mensaje" filter="false"/>      
                        <table>
                                <thead>
                                    <tr>
                                        <td>Id Acceso</td>
                                        <td>Empresa</td>
                                        <td>Nombre</td>
                                        <td>Apellido</td>
                                        <td>Usuario</td>
                                        <td>Contraseña</td>
                                        <td>E-mail</td>
                                        <td>Tipo de Acceso</td>
                                        <td>Fecha de Registro</td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <logic:notEmpty name="ActionFormAcceso" property="listaAcceso">
                                        <logic:iterate id="ver" name="ActionFormAcceso" property="listaAcceso" >
                                            <tr>
                                                <html:form action = "/accesoMantenimiento" >
                                                <td><bean:write name="ver" property="idAcceso"/>
                                                    <html:hidden name="ver" property="idAcceso"/></td > 
                                                <td><bean:write name="ver" property="empresa.nombreEmpresa"/></td>
                                                <td><bean:write name="ver" property="nombreAcceso"/></td>
                                                <td><bean:write name="ver" property="apellidoAcceso"/></td>
                                                <td><bean:write name="ver" property="usuario"/></td>
                                                <td><bean:write name="ver" property="contrasena"/></td>
                                                <td><bean:write name="ver" property="email"/></td>
                                                <td><bean:write name="ver" property="tipoAcceso"/></td>
                                                <td><bean:write name="ver" property="fechaRegistroAcceso"/></td>
                                                <td><html:submit property="action" value="Eliminar"/></td>
                                                <td><html:submit property="action" value="ConsultarId"/></td>
                                                
                                            </html:form > 
                                            </tr>
                                        </logic:iterate>
                                    </logic:notEmpty>
                                </tbody>
                            </table>
                        <html:link page="/index.jsp">Index</html:link><br>
                            <html:link page="/jsp/acceso/inicio.jsp">Acceso</html:link><br><br>
                        
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
