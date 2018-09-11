<%-- 
    Document   : inicioContacto
    Created on : 08-31-2018, 11:25:34 AM
    Author     : diana.alcantarausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib   uri="http://struts.apache.org/tags-bean"  prefix="bean"%>
<%@taglib   uri="http://struts.apache.org/tags-html"  prefix="html"%>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Contactos</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
           integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    </head>
    <body class="bg-success">
        <h1 class="text-DARK font-weight-bold">SELECCIONE :</h1>
        <h4>${msg}</h4>
        &nbsp;<html:form action="/contactosMantenimiento">
            &nbsp;&nbsp;<html:submit property="action" value="ConsultarContacto"/><br><br>
           <!-- html:submit property="action" value="AgregarContacto"/>-->
           &nbsp;&nbsp;<a class="font-weight-bold btn btn-light btn-sm"<html:link page="/jsp/contactos/agregarContactos.jsp">Agregar</html:link>
                          <br>
               <br>

            &nbsp;&nbsp;<html:submit property="action" value="ConsultarTipo"/><br>&nbsp;
            <html:select property="tipoContacto" >
                <html:option value="Seleccionar"></html:option> 
                <html:option value="Cliente">Cliente</html:option> 
                <html:option value="Proveedor">Proveedor</html:option>
            </html:select><br>
        </html:form> 
            <br>
        &nbsp;&nbsp;&nbsp;<a class="font-weight-bold btn btn-primary"<html:link page="/jsp/login/index.jsp">Index</html:link>
    </body>
</html>