package Servlets;

import Entidades.Capacitaciones;
import Entidades.Certificado;
import Negocio.CapacitacionNegocio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CapacitacionesServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String modulo = "Capacitacion.jsp";// enviar respuesta
        Capacitaciones capacitacion = new Capacitaciones();
        
        String idCapacitacion = request.getParameter("txtid");
        String idArea = request.getParameter("txtarea");
        String nombre = request.getParameter("txtnombre");
        String descripcion = request.getParameter("txtdescripcion");
        String estado = request.getParameter("txtestado");
        String fecha = request.getParameter("txtfecha");
        
        String mensaje = "";

        CapacitacionNegocio capacitacionN = new CapacitacionNegocio();
        
        request.setAttribute("listado", null);
        request.setAttribute("mensaje", null);
        request.setAttribute("datos", null);
        
        try {
            request.setAttribute("listado", capacitacionN.listadoCertificado());
        } catch (Exception er) {
            request.setAttribute(mensaje, er.getMessage());
        }
        
        if ("guardar".equals(request.getParameter("action"))) {
            try {
                capacitacion.setIdCapacitacion(idCapacitacion);
                capacitacion.setIdArea(idArea);
                capacitacion.setNombre(nombre);
                capacitacion.setDescripcion(descripcion);
                capacitacion.setEstado(estado);
                capacitacion.setFecha(fecha);
                //AreasNegocio areaNegocio = new AreasNegocio();
                capacitacionN.insertarCapacitacion(capacitacion);
                request.setAttribute("listado", capacitacionN.listadoCertificado());
                request.getRequestDispatcher(modulo).forward(request, response);
            } catch (Exception er) {
                request.setAttribute(mensaje, er.getMessage());
            }
        }
        
        if ("buscar".equals(request.getParameter("action"))) {
            try {
                request.setAttribute("datos", capacitacionN.getCapacitacion(idCapacitacion));
                request.setAttribute("listado", capacitacionN.listadoCapacitacionesGet(idCapacitacion));
            } catch (Exception e) {
            }
        }
        
        if ("eliminar".equals(request.getParameter("action"))) {
            try {
                capacitacionN.elimnarCapacitacion(new Capacitaciones(idCapacitacion, idArea, nombre, descripcion, estado, fecha));
                request.setAttribute("listado", capacitacionN.listadoCertificado());
            } catch (Exception er) {
            }
        }
        
        request.setAttribute("mensajes", mensaje);
        request.getRequestDispatcher(modulo).forward(request, response);
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
