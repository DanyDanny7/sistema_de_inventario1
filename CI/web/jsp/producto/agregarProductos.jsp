<%-- 
    Document   : agregarProductos
    Created on : 09-05-2018, 08:29:45 AM
    Author     : diana.alcantarausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Productos</title>
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css">
    </head>
    <body class=" p-3 mb-3 bg-success">

        <h3 class="font-weight-bold">Formulario de productos</h3>
        <html:form action="/productosMantenimiento">
            
            <label class="font-weight-bold">ID Fabricante:</label><br>
            &nbsp;<html:select property="idFabricantes">
                <html:option value="Seleccione"></html:option>
                <logic:notEmpty name="ActionFormProductos" property="listaFabricantes">
                    <logic:iterate id="ver" name="ActionFormProductos" property="listaFabricantes">
                        <html:option value="${ver.idFabricante}">${ver.nombreFabricante}</html:option>
                    </logic:iterate>
                </logic:notEmpty>
            </html:select> <br>
            <br>
            <label class="font-weight-bold">Nombre del Producto:</label><br>
            &nbsp;<html:text property="nombreProducto"></html:text> <br><br>
       
            <label class="font-weight-bold">Precio del Producto:</label><br>
            &nbsp;<html:text property="precioUnitario" ></html:text> <br><br>
      
            <label class="font-weight-bold">Descripción del producto:</label><br>
           &nbsp;<html:text property="descripcionProducto" ></html:text> <br><br>
       
            <label class="font-weight-bold">Modelo:</label><br>
           &nbsp;<html:text property="modelo"></html:text> <br><br>
     
        <tr colspan="2">
        <bean:write name="ActionFormProductos" property="error" filter="false"/>
    </tr>

    <br>
    &nbsp;&nbsp;<html:submit property="action" value="Agregar"/>
    &nbsp;<html:submit property="action" value="Consultar"/>



</html:form><br>
<!--  <html:link page="/index.jsp">Index</html:link> -->
&emsp; &nbsp;&nbsp; <a class="font-weight-bold btn btn-primary btn-sm" <html:link page="/jsp/producto/inicioP.jsp" >Inicio</html:link>

</body>
</html>
