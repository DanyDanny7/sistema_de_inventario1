<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html"  prefix="html"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Fabricante</title>
    </head>
    <body>
        <h2>El fabricante fue agregado satidfactoriamente.</h2>
        <br>
        
        <html:form action="/fabricanteMantenimiento">
            <html:submit property="action" value="Consultar"></html:submit>
            <html:submit property="action" value="irAgregar"></html:submit>
            
        </html:form>
        <br>
</body>
</html>
