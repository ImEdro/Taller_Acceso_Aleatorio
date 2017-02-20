
<%@page import="Modelo.Estudiante"%>
<%@page import="Registros.Estudiantes"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Estudiantes</title>
    </head>
    <body>
        <h1>Listado Estudiantes</h1>
        <table border="0">
            <tr> 
                <td> ID</td> 
                <td> Nombre</td> 
                <td> Apellido</td> 
                <td> Telefono</td> 
            </tr>

            <%ArrayList<Estudiante> lis = new Estudiantes().leer();
                
                for (int i = 0; i < lis.size(); i++) {
                    out.println("<tr>");
                    out.println("<td>" + lis.get(i).getId() + "</td>");
                    System.out.println(" ----- "+lis.get(i).getId());
                    String nom=String.copyValueOf(lis.get(i).getNombre());
                    System.out.println(" ----- "+nom);
                    out.println("<td> " + nom + "</td>");
                    String ape=String.copyValueOf(lis.get(i).getApellido());
                    out.println("<td> " + ape + "</td>");
                     System.out.println(" ----- "+ape);
                    out.println("<td> " + lis.get(i).getTelefono()+ "</td>");
                      System.out.println(" ----- "+lis.get(i).getTelefono());
                    out.println("</tr>");
                }
            %>
            
        <h4><a href="InicioEstudiante.jsp">Regresar</a></h4>
        
        </table>

    </body>
</html>
