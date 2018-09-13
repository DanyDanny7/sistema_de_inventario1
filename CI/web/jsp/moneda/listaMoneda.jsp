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
        <title>Lista Moneda</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="table table-striped">
                        <br>
                        <bean:write name="ActionFormMoneda" property="mensaje" filter="false"></bean:write>
                        <br>
                        <table>
                            <thead>
                                <tr>
                                    <td>Nombre </td>
                                    <td>Simbolo </td>
                                    <td>Codigo</td>
                                    <td>Equivalencia</td>
                                    <td>Moneda de Referencia</td>
                                    <td></td>
                                    <td></td>
                                    </tr>
                                </thead>
                                <tbody>
                                <logic:notEmpty name="ActionFormMoneda" property="listaMoneda">
                                    <logic:iterate id="ver" name="ActionFormMoneda" property="listaMoneda" >
                                        <tr>
                                            <html:form action = "/monedaMantenimiento" >
                                                <td><bean:write name="ver" property="nombreMoneda"/>
                                                    <div hidden="hidden"><html:text name="ver" property="nombreMoneda" styleClass="hidden"/></div></td>

                                                <td><bean:write name="ver" property="simboloMoneda"/></td>
                                                <td><bean:write name="ver" property="codigoMoneda"/></td>
                                                <td><bean:write name="ver" property="equivalencia"/></td>
                                                <td><bean:write name="ver" property="monedaReferencia"/></td>
                                                <td><html:submit property="action" value="eliminar"/></td>
                                                <td><html:submit property="action" value="consultarId"/></td>

                                            </html:form > 
                                        </tr>
                                    </logic:iterate>
                                </logic:notEmpty>
                            </tbody>
                        </table>
                        <html:link page="/index.jsp">Index</html:link><br>
                        <html:link page="/jsp/moneda/inicio.jsp">Moneda</html:link><br><br>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
