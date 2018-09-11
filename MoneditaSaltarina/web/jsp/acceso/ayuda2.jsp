<%-- 
    Document   : ayuda
    Created on : 09-04-2018, 11:38:50 AM
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
        <title>Ayuda</title>
    </head>
    <body>
        <h1>Restauracion de Contraseña</h1>
        <h3>Por politicas internas la restauracion de contraseña no está habilitada 
             continuacion le presentamos una lista usuarios y su correo electronico a los que puede solicitar ayuda. </h3>
        <bean:write name="ActionFormAcceso" property="mensaje" filter="false"/>
        <table>
            <thead>
                <tr>
                    <td>Nombre</td>
                    <td>E-mail</td>
                </tr>
            </thead>
            <tbody>
            <logic:notEmpty name="ActionFormAcceso" property="listaAcceso">
                <logic:iterate id="ver" name="ActionFormAcceso" property="listaAcceso" >
                    <tr>
                    <html:form action = "/accesoMantenimiento" >
                        <td><bean:write name="ver" property="nombreAcceso"/></td>
                        <td><bean:write name="ver" property="email"/></td>
                    </html:form > 
                    </tr>
                </logic:iterate>
            </logic:notEmpty>
        </tbody>
    </table>
        <br>
<html:link page="/index.jsp">Index</html:link><br><br>
<html:link page="/jsp/acceso/inicio.jsp">Acceso</html:link><br><br>
</body>
</html>
