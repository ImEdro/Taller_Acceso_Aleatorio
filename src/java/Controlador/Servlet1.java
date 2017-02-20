/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Profesor;
import Registros.Profesores;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro
 */
public class Servlet1 extends HttpServlet {

    private Profesores prof;

    public Servlet1() throws FileNotFoundException {
        this.prof = new Profesores();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            try {
                if (request.getParameter("Nombre").length() != 0 && request.getParameter("Apellido").length() != 0) {
                    int id = Integer.parseInt(request.getParameter("Id"));
                    char[] nombre = request.getParameter("Nombre").trim().toCharArray();
                    char[] apellido = request.getParameter("Apellido").trim().toCharArray();
                    int ext = 0;
                    if (request.getParameter("Ext") != null || request.getParameter("Ext").length() != 0) {
                        ext = Integer.parseInt(request.getParameter("Ext"));
                    }
                    Profesor p = new Profesor(id, nombre, apellido, ext);
                    boolean n = this.prof.agregar(p);
                    if (n) {
                        request.setAttribute("Mensaje", "Profesor agregado correctamente ");
                    } else {
                        request.setAttribute("Mensaje", "El Id ya había sido registrado, intente de nuevo ");
                    }
                } else {
                    request.setAttribute("Mensaje", "Alguno de los campos se encuentra vacío, intente nuevamente ");
                }
            } catch (java.lang.NumberFormatException e) {
                request.setAttribute("Mensaje", "Error desconocido intente nuevamente");
            }
            RequestDispatcher dispacher = request.getRequestDispatcher("NuevoProfesor.jsp");
            dispacher.forward(request, response);
        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
