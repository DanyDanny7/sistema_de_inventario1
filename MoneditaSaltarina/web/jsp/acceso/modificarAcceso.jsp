<%-- 
    Document   : confirmacionNuevoAcceso
    Created on : 08-21-2018, 03:38:42 PM
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
        <title>Mantenimiento Acceso</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <br>
        <br>
        <h1>Modificar Acceso</h1>
        <label>${nombre}</label>
        <label>${nAcceso}</label>
        <html:form action = "/accesoMantenimiento">

            <label>Id Empresa : </label><br>
            
            <html:select property="idEmpresa">
                <logic:notEmpty name="ActionFormAcceso" property="listaEmpresa">
                    <logic:iterate id="ver" name="ActionFormAcceso" property="listaEmpresa">
                        <html:option value="${ver.idEmpresa}">${ver.nombreEmpresa}</html:option>
                    </logic:iterate>
                </logic:notEmpty>
            </html:select>
            <br><br>
                <label>Nombre : </label><br>
            <html:text property="nombreAcceso"></html:text><br><br>
                <label>Apellido : </label><br>
            <html:text property="apellidoAcceso"></html:text><br><br>
                <label>Usuario : </label><br>
            <html:text property="usuario"></html:text><br><br>

                <label>E-Mail : </label><br>
            <input type="email" name="email" ><br><br>
                <label>Nivel de Acceso : </label><br>
                
            <html:select property="tipoAcceso">
                <html:option value="${tipoAcceso}" ></html:option>
                <html:option value="Solo Consulta"></html:option>
                <html:option value="Consulta e Ingresar"></html:option>
                <html:option value="Administrador"></html:option>
                <html:option value="Super Administrador"></html:option>
            </html:select>
            <br>
            <br>
            <div hidden="hidden">
                <label>Id Acceso : </label><br>
                <html:text property="idAcceso"></html:text><br><br>
                    <label>Fecha de Registro : </label><br>
                <html:text property="fechaRegistroAcceso"></html:text><br><br>
                    <label>Contraseña : </label><br>
                <html:text property="contrasena"></html:text><br><br>
                </div>


            <bean:write name="ActionFormAcceso" property="error" filter="false"/>    


            <br>
            <html:submit property="action" value="modificar"/>
            <html:submit property="action" value="Consultar"/>
        </html:form>
        <br>
        <html:link page="/index.jsp">Index</html:link>
    </body>
</html>
