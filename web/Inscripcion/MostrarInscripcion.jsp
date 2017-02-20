
<%@page import="Registros.Profesores"%>
<%@page import="Modelo.Profesor"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Inscripciones</title>
    </head>
    <body>
        <h1>Listado Inscripciones</h1>
        <table border="0">
            <tr> 
                <td> ID</td> 
                <td> Nombre</td> 
                <td> Apellido</td> 
                <td> Ext</td> 
            </tr>

            <%ArrayList<Profesor> lis = new Profesores().leer();
                
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
                    out.println("<td> " + lis.get(i).getExt() + "</td>");
                      System.out.println(" ----- "+lis.get(i).getExt());
                    out.println("</tr>");
                }
            %>
            
        <h4><a href="InicioProfesor.jsp">Regresar</a></h4>
        
        </table>

    </body>
</html>
