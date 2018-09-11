<%-- 
    Document   : mantenimientoAcceso
    Created on : 08-21-2018, 03:21:37 PM
    Author     : Admin100
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
     
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Acceso</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
           integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    <body class="p-3 mb-3 bg-success">
        <html:form action="/fabricanteMantenimiento">
            <table border="0">
                <tbody>
                    <tr>
                        
                        <td>Nombre Fabricante</td>
                        <td><html:text property="nombreFabricante" size="30" maxlength="20"></html:text> 
                    </tr>
                    <tr>
                        <td>Numero de productos</td>
                        <td><html:text property="numeroProductos" size="10" maxlength="10"></html:text> 
                    </tr>
                    <tr>
                        <td>Descripcion de el fabricante</td>
                        <td><html:text property="descripcionFabricante" size="50" ></html:text> 
                    </tr>
                    <tr>
                       
                    <tr colspan="2">
                    <bean:write name="ActionFormFabricante" property="error" filter="false"/>
                    </tr>
                </tbody>  
            </table>
             
                    <html:submit property="action" value="Agregar"/>
                   
                    <html:submit property="action" value="Consultar"/>
                    
        </html:form>
        <html:link page="/jsp/login/index.jsp">Index</html:link>
    </body>
</html>
