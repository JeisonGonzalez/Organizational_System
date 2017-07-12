/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Negocio.MotivacionNegocio;
import Negocio.UsuarioNegocio;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juan
 */
public class MotivacionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        String mensajes = "";
        String success = "true";
        String idReceptor = request.getParameter("UsuarioR");
        String Asunto = request.getParameter("Asunto");
        String mensajeEnviado = request.getParameter("Mensaje");
        Integer idMensaje = null;
        Integer idEmisor = 1;
        String submit = request.getParameter("submit");
        String correo = (String) session.getAttribute("correoInSession");
        if (request.getParameter("idMensaje") != null && !request.getParameter("idMensaje").isEmpty()) {
            idMensaje = Integer.parseInt(request.getParameter("idMensaje"));
        }
          MotivacionNegocio motivacionNegocio = new MotivacionNegocio();  
        try {
            idEmisor = motivacionNegocio.getidEmisor(correo);
        } catch (SQLException ex) {
            Logger.getLogger(MotivacionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            if (submit != null && !submit.isEmpty()) {
                if ("Eliminar".equals(submit)) {
                    if (idMensaje != null && idMensaje > 0) {
                        try {
                            mensajes = motivacionNegocio.deleteMotivacion(idMensaje);
                        } catch (SQLException ex) {
                            Logger.getLogger(MotivacionServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        success = "true";
                    } else {
                        mensajes = "Debe ingresar la identificación del mensaje a eliminar";
                        success = "false";
                    }
                } else {
                    if ("Guardar".equals(submit)) {
                        if (idMensaje != null && idMensaje > 0) {
                            mensajes = motivacionNegocio.updateMotivacion(idMensaje,idReceptor, Asunto, mensajeEnviado);
                        } else {
                            mensajes = motivacionNegocio.insertMotivacion(idReceptor, Asunto, mensajeEnviado, idEmisor);
                        }
                    }
                }
            }
        
        try {
            if (submit != null && !submit.isEmpty() && "Buscar".equals(submit) && request.getParameter("search") != null && !request.getParameter("search").isEmpty()) {
                request.setAttribute("listadoMensaje", motivacionNegocio.getMotivacionListBySearch(request.getParameter("search")));
            } else {
                request.setAttribute("listadoMensaje", motivacionNegocio.getMensajesList(-1, -1, null, null, null));
            }
        } catch (NumberFormatException e) {
            System.out.println("Error seteando atributo en opción Listar mensaje : " + e);
        }
        request.setAttribute("success", success);
        request.setAttribute("mensajes", mensajes);
        request.getRequestDispatcher("/Motivacion.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
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
