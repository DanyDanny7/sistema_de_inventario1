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
                        <bean:write name="ActionFormIva" property="mensaje" filter="false"></bean:write>
                        <br>
                        <table>
                            <thead>
                                <tr>
                                    <td>Id Iva </td>
                                    <td>Tasa </td>
                                    <td>Iva Retenido</td>
                                    <td>Iva Pagado</td>
                                    <td>Iva Total</td>
                                    <td></td>
                                    <td></td>
                                    </tr>
                                </thead>
                                <tbody>
                                <logic:notEmpty name="ActionFormIva" property="listaIva">
                                    <logic:iterate id="ver" name="ActionFormIva" property="listaIva" >
                                        <tr>
                                            <html:form action = "/ivaMantenimiento" >
                                                <td><bean:write name="ver" property="idIva"/>
                                                    <html:hidden name="ver" property="idIva"/></td>
                                                <td><bean:write name="ver" property="ivaTasa"/></td>
                                                <td><bean:write name="ver" property="ivaRetenido"/></td>
                                                <td><bean:write name="ver" property="ivaPagado"/></td>
                                                <td><bean:write name="ver" property="ivaTotal"/></td>
                                                <td><html:submit property="action" value="eliminar"/></td>
                                                <td><html:submit property="action" value="consultarId"/></td>

                                            </html:form > 
                                        </tr>
                                    </logic:iterate>
                                </logic:notEmpty>
                            </tbody>
                        </table>
                        <html:link page="/index.jsp">Index</html:link><br>
                        <html:link page="/jsp/iva/inicio.jsp">Iva</html:link><br><br>

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
