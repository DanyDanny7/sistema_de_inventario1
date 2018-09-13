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
    </head>
    <body>
        <html:form action="/fabricanteMantenimiento">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Id fabricante</td>
                        <td><html:text property="idFabricante" size="100"></html:text> 
                    </tr>
                    
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
             
                    <html:submit property="action" value="Actualizar"/>
                   
                   
                    
        </html:form>
        <html:link page="/index.jsp">Index</html:link>
    </body>
</html>
