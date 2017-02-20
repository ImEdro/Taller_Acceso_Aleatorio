<%-- 
    Document   : NuevoProfesor
    Created on : 20/02/2017, 07:23:55 AM
    Author     : Pedro
--%>

<%@page import="Controlador.Servlet1"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Profesor</title>
    </head>
    <body>
        <form  method ="POST" action="Servlet1">
            ID: <input name="Id" type="text"><br>
            Nombre: <input name="Nombre" type="text"><br>
            Apellido: <input name="Apellido" type="text"><br>
            Extension: <input name="Ext" type="text"><br>
            <input name="Enviar" type="submit">
        </form>
        
    </body>
</html>
