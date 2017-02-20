

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Inscripcion</title>
    </head>
    <body>

        <form method= "POST" action="Servlet2">
            <h1>               Buscar Inscripcion</h1>
            <p> Ingrese el Id:     <input type="number" name="id" size="2"/>  </p> 
            <p> <input type="submit" name="buscar" value="Buscar"/>  </p>   
              <p> <input type="hidden" name="tipo" value="1"/>  </p>   
        </form>
        <%
            if (request.getAttribute("Mensaje") != null) {%>
        <h1><%=(String) request.getAttribute("Mensaje")%></h1> 
        <% request.removeAttribute("Mensaje");%>
        <h4><a href="InicioProfesor.jsp">Regresar</a></h4>
        <%
            }
        %>
    </body>
</html>
