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
        <html:form action="/comprasMantenimiento">
            <table border="0">
                <tbody>
                   <tr>
                        <td>Id Compras </td>
                       <td><html:text property="idCompra" size="20" ></html:text>  </td> 
                    </tr>
                    <tr>
                        <td>Id Contactos </td>
                        <td><html:text property="idContacto" size="10"></html:text> 
                    </tr>
                    <tr>
                        <td>Id Inventario</td>
                        <td><html:text property="idInventario" size="10"></html:text> 
                    </tr>
                    <tr>
                        
                        <td>id iva </td>
                        <td><html:text property="idIva" size="10" maxlength="20"></html:text> 
                    </tr>
                    <tr>
                        <td>id productos</td>
                        <td><html:text property="idProducto" size="10" maxlength="10"></html:text> 
                    </tr>
                    <tr>
                        <td>Total Compra</td>
                        <td><html:text property="totalCompra" size="3" ></html:text> 
                    </tr>
                     
                        
                       
                    <tr colspan="2">
                    <bean:write name="ActionFormCompras" property="error" filter="false"/>
                    </tr>
                </tbody>  
            </table>
             
                    <html:submit property="action" value="Actualizar"/>
                   
                   
                    
        </html:form>
        <html:link page="/index.jsp">Index</html:link>
    </body>
</html>
