<%-- 
    Document   : modificarProductos
    Created on : 09-05-2018, 08:30:34 AM
    Author     : diana.alcantarausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    <body class=" p-3 mb-3 bg-success"> 
        <h2 class="text-dark font-weight-bold">MODIFICAR</h2>
        <html:form action="/productosMantenimiento">
        <table border="0">
            <tbody>           
            <tr>
                <td class="bg-dark text-white">ID Producto</td>
                <td>&nbsp;<html:text property="idProducto" size="10" maxlength="5"></html:text> 
            </tr>
            <tr>
            <tr>
                <td class="bg-dark text-white">ID Fabricante</td>
                <td>&nbsp;<html:text property="idFabricantes" size="10" maxlength="5"></html:text> 
            </tr>
            <tr>
                <td class="bg-dark text-white">Nombre del Producto</td>
                <td>&nbsp;<html:text property="nombreProducto" size="25" maxlength="35"></html:text> 
            </tr>
            <tr>
                <td class="bg-dark text-white">Precio del Producto</td>
                <td>&nbsp;<html:text property="precioUnitario" size="20" maxlength="15"></html:text> 
            </tr>
            <tr>
                <td class="bg-dark text-white">Descripción del producto</td>
                <td>&nbsp;<html:text property="descripcionProducto" size="25" maxlength="35"></html:text> 
            </tr>
            <tr>
                <td class="bg-dark text-white">Modelo</td>
                <td>&nbsp;<html:text property="modelo" size="25" maxlength="20"></html:text> 
            </tr>
            <tr colspan="2">
            <bean:write name="ActionFormProductos" property="error" filter="false"/>
            </tr>
            </tbody>  
        </table>
            <br>
            <html:submit property="action" value="Modificar"/>
        </html:form><br>
        <a class="font-weight-bold btn btn-primary btn-sm" <html:link page="/jsp/producto/inicioP.jsp" >Inicio</html:link>
    </body>
</html>
