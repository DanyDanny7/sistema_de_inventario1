<%-- 
    Document   : agregarInventario
    Created on : 09-05-2018, 09:08:05 AM
    Author     : guillermo.bermudes
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-faces" prefix="faces" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Inventario</title>
    </head>
    <body>



        <html:form action="/comprasMantenimiento">

            <table border="0">

                <tbody>
                    <tr>
                        
                        <td>id Compras </td>
                        <td><html:text property="idCompra" size="20" ></html:text>  </td> 
                            
                        
                            <td>
                        
                    </tr>
                    
                    <tr>
                        <td>documento </td>
                        <td><html:text property="nDocumento" size="20" ></html:text>  </td> 
                            
                        
                            <td>
                    </tr>
                        
                        
                    <tr>
                       <td>id Contactos </td>
                        <td><html:text property="idContacto" size="20" ></html:text>   
 
                        
                    </tr>
                         
                     
                        <tr>

                            <td>id Inventario </td>
                            <td><html:text property="idInventario" size="20" ></html:text>   

                            <td> 

                        </tr>
                        <tr>

                            <td>cantidad</td>
                            <td><html:text property="cantidad" size="20" ></html:text>   

                            <td> 
                        <tr>

                            <td>id Iva  </td>
                            <td><html:text property="idIva" size="20" ></html:text>   

                            <td> 

                        </tr>
                        <tr>
                            <td>id productos</td>
                            <td><html:text property="idProducto" size="20" ></html:text> 
                        </tr>
                        <tr>
                            <td>total de compra</td>
                            <td><html:text property="totalCompra" size="20" ></html:text> 
                        </tr>
                        
                       
                           
                        <tr>

                        <tr colspan="2">
                        <bean:write name="ActionFormCompras" property="error" filter="false"/>
                    </tr>
                </tbody>  
            </table>

            <html:submit property="action" value="Agregar"/>

            <html:submit property="action" value="Consultar"/>

        </html:form>
        <html:link page="/index.jsp">Index</html:link>
    </body>
</html>
