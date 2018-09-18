<%-- 
    Document   : listaInventario
    Created on : 09-05-2018, 09:08:30 AM
    Author     : guillermo.bermudes
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        <title>Lista Login</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
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
                                <td>Id Inventario</td>
                                <td>Id Producto</td>
                                <td>existencia</td>
                                <td>estado de existencia </td>
                                <td> stock minimo</td>
                                <td> estado fisico</td>
                                <td></td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <logic:notEmpty name="ActionFormInventario" property="listai">
                                <logic:iterate id="ver" name="ActionFormInventario" property="listai" >
                                    <tr>
                                        <html:form action = "/inventarioMantenimiento">
                                            <td><bean:write name="ver" property="idInventario"/>
                                                <div hidden="hidden"> <html:text name="ver" property="idInventario"/></div> </td>
                                            <td><bean:write name="ver" property="productos.idProducto"/></td>
                                            <td><bean:write name="ver" property="existencia"/></td>
                                            <td><bean:write name="ver" property="estadoExistencia"/></td>
                                            <td><bean:write name="ver" property="stockMinimo"/></td>
                                            <td><bean:write name="ver" property="estadoFisico"/></td>
                                          
                                            <td><html:submit property="action" value="Eliminar"/></td>
                                            <td><html:submit property="action" value="Modificar"/></td>


                                        </html:form>
                                    </tr>
                                </logic:iterate>
                            </logic:notEmpty>
                        </tbody>
                        <bean:write name="ActionFormInventario" property="error" filter="false"/>
                    </table>
                    <bean:write name="ActionFormInventario" property="error" filter="false"/>
                    <html:link page="/jsp/inventario/agregarInventario.jsp">regresar</html:link>


                </div>
            </div>
        </div>
    </div>
</body>
</html>
