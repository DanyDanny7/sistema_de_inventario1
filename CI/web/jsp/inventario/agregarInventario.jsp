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
    
      
        
        <html:form action="/inventarioMantenimiento">
            
            <table border="0">
                
                <tbody>
                  <tr>
                        
                 <td>id inventario </td>
                 <td><html:text property="idInventario" size="20" ></html:text>   
                 
                 <td> 
                        
                </tr>
                    <tr>
                        
                 <td>id producto </td>
                 <td><html:text property="idProducto" size="20" ></html:text>   
                 
                 <td> 
                        
                </tr>
                    <tr>
                        <td>existencias</td>
                        <td><html:text property="existencia" size="20" ></html:text> 
                    </tr>
                    <tr>
                        <td>estado de existencias</td>
                        <td><html:text property="estadoExistencia" size="50" ></html:text> 
                    </tr>
                     <tr>
                        <td>stock minimo</td>
                        <td><html:text property="stockMinimo" size="50" ></html:text> 
                    </tr>
                      <tr>
                        <td>estado Fisico</td>
                        <td><html:text property="estadoFisico" size="50" ></html:text> 
                    </tr>
                    <tr>
                       
                    <tr colspan="2">
                    <bean:write name="ActionFormInventario" property="error" filter="false"/>
                    </tr>
                </tbody>  
            </table>
             
                    <html:submit property="action" value="Agregar"/>
                   
                    <html:submit property="action" value="Consultar"/>
               
        </html:form>
        <html:link page="/index.jsp">Index</html:link>
    </body>
</html>
