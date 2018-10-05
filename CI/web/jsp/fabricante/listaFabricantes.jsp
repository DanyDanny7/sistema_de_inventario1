<%-- 
    Document   : listaLogin
    Created on : 08-27-2018, 02:32:14 PM
    Author     : Admin105
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
        <title>Lista Fabricante</title>
        
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        
    <body>
        
    </head>
   
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="table table-striped">
                        <h4>${mensaje}</h4>
                        <table>
                            <thead>
                                <tr>
                                    <td>Id fabricante</td>
                                    <td>Nombre Fabricante</td>
                                    <td>Numero de productos</td>
                                    <td>descripcion de productos</td>
                                    <td> fecha de registro</td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                                <logic:notEmpty name="ActionFormFabricante" property="listaFabricante">
                                    <logic:iterate id="ver" name="ActionFormFabricante" property="listaFabricante" >
                                        <tr>
                                            <html:form action = "/fabricanteMantenimiento">
                                                <td><bean:write name="ver" property="idFabricante"/>
                                                    <div hidden="hidden"><html:text name="ver" property="idFabricante"/></div></td>
                                                <td><bean:write name="ver" property="nombreFabricante"/></td>
                                                <td><bean:write name="ver" property="numeroProductos"/></td>
                                                <td><bean:write name="ver" property="descripcionFabricante"/></td>
                                                <td><bean:write name="ver" property="fechaRegistroFabricante"/></td>

                                                <td><html:submit property="action" value="Eliminar"/></td>
                                                <td><html:submit property="action" value="Modificar"/></td>


                                            </html:form>
                                        </tr>
                                    </logic:iterate>
                                </logic:notEmpty>
                            </tbody>
                            <bean:write name="ActionFormFabricante" property="error" filter="false"/>
                        </table>
                          <bean:write name="ActionFormFabricante" property="error" filter="false"/>
                        <html:link page="/jsp/fabricante/agregarFabricante.jsp">regresar</html:link>
                        

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
