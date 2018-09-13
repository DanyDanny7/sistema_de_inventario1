<%-- 
    Document   : listaEmpresa
    Created on : 09-12-2018, 11:03:48 AM
    Author     : diana.alcantarausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Empresa</title>
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
                        <bean:write name="ActionFormEmpresa" property="mensaje" filter="false"/>      
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
                                <logic:notEmpty name="ActionFormEmpresa" property="listaEmpresa">
                                    <logic:iterate id="ver" name="ActionFormEmpresa" property="listaEmpresa" >
                                        <tr>
                                            <html:form action = "/empresaMantenimiento" >
                                                <td><bean:write name="ver" property="idEmpresa"/>
                                                    <html:hidden name="ver" property="idEmpresa"/></td > 
                                                <td><bean:write name="ver" property="nombreEmpresa"/></td>
                                                <td><bean:write name="ver" property="ncr"/></td>
                                                <td><bean:write name="ver" property="nit"/></td>
                                                <td><bean:write name="ver" property="direccionEmpresa"/></td>
                                                <td><bean:write name="ver" property="emailEmpresa"/></td>
                                                <td><bean:write name="ver" property="encargadoEmpresa"/></td>
                                                <td><bean:write name="ver" property="telefonoEmpresa"/></td>
                                                <td><html:submit property="action" value="Eliminar"/></td>
                                                <td><html:submit property="action" value="ConsultarId"/></td>

                                            </html:form > 
                                        </tr>
                                    </logic:iterate>
                                </logic:notEmpty>
                            </tbody>
                        </table>
                        <html:link page="/index.jsp">Index</html:link><br>
                        <html:link page="/jsp/empresa/inicio.jsp">Regresar</html:link><br><br>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

