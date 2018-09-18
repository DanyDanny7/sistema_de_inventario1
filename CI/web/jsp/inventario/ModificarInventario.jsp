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
        <html:form action="/inventarioMantenimiento">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Id inventario</td>
                        <td><html:text property="idInventario" size="10"></html:text> 
                    </tr>
                    <tr>
                        <td>Id Productos</td>
                        <td><html:text property="idProducto" size="10"></html:text> 
                    </tr>
                    <tr>
                        
                        <td>Existencia</td>
                        <td><html:text property="existencia" size="10" maxlength="20"></html:text> 
                    </tr>
                    <tr>
                        <td>Estado de Existencia</td>
                        <td><html:text property="estadoExistencia" size="10" maxlength="10"></html:text> 
                    </tr>
                    <tr>
                        <td>Stock minimo</td>
                        <td><html:text property="stockMinimo" size="3" ></html:text> 
                    </tr>
                     <tr>
                        <td>Estado Fisico</td>
                        <td><html:text property="estadoFisico" size="50" ></html:text> 
                    </tr>
                    <tr>
                       
                    <tr colspan="2">
                    <bean:write name="ActionFormInventario" property="error" filter="false"/>
                    </tr>
                </tbody>  
            </table>
             
                    <html:submit property="action" value="Actualizar"/>
                   
                   
                    
        </html:form>
        <html:link page="/index.jsp">Index</html:link>
    </body>
</html>
