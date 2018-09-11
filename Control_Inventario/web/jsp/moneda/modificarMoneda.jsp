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
        <title>ModificarMoneda</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Modificar Moneda</h1>
        <div class="container">
            <div class="row">
                <div class="col-1"></div>
                <div class="col-10">
                    <html:form action="/monedaMantenimiento">
                        <table>
                            <tr>
                            <label>Nombre de la Moneda : </label><br>
                            <html:text property="nombreMoneda"></html:text><br><br>
                                <label>Simbolo de la Moneda : </label><br>
                            <html:text property="simboloMoneda"></html:text><br><br>
                                <label>Codigo de la Moneda : </label><br>
                            <html:text property="codigoMoneda"></html:text><br><br>
                                <label>Equivalencia : </label><br>
                            <html:text property="equivalencia"></html:text><br><br>
                                <label>Moneda de Referencia de Cambio:</label><br>
                            <html:select property="monedaReferencia">
                                    <logic:notEmpty name="ActionFormMoneda" property="listaMoneda">
                                        <logic:iterate id="ver" name="ActionFormMoneda" property="listaMoneda">
                                        <html:option value="${ver.nombreMoneda}" ></html:option>
                                        </logic:iterate>
                                    </logic:notEmpty>
                            </html:select><br><br>

                            <bean:write name="ActionFormMoneda" property="error" filter="false"></bean:write>
                                </tr>
                            <html:submit property="action" value="modificar"/>

                        </table>

                    </html:form>

                    <html:link page="/jsp/moneda/inicio.jsp">Inicio</html:link>
                    <h5>${error}</h5>
                </div>
                <div class="col-1"></div>
            </div>
        </div>
    </body>
</html>
