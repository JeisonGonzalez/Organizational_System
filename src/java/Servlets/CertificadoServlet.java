package Servlets;

import Entidades.Certificado;
import Negocio.CertificadoNegocio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CertificadoServlet extends HttpServlet {

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
        String modulo = "Certficado.jsp";// enviar respuesta
        Certificado certi = new Certificado();
        String nombre = request.getParameter("txtnombre");
        String descripcion = request.getParameter("txtdescripcion");
        String avance = request.getParameter("txtavance");
        String estado = request.getParameter("txtestado");
        String idCertificado = request.getParameter("txtid");
        /*Integer idCertificado = null;
        if (request.getParameter("txtid") != null && !request.getParameter("txtid").isEmpty()) {
            idCertificado = Integer.parseInt(request.getParameter("txtid"));
        }*/
                
        String mensaje = "";

        CertificadoNegocio certificacion = new CertificadoNegocio();

        request.setAttribute("listado", null);
        request.setAttribute("mensaje", null);
        request.setAttribute("datos", null);
        
        try {
            request.setAttribute("listado", certificacion.listadoCertificado());
        } catch (Exception er) {
            request.setAttribute(mensaje, er.getMessage());
        }
        
        if ("guardar".equals(request.getParameter("action"))) {
            try {
                certi.setIdCertificacion(idCertificado);
                certi.setNombre(nombre);
                certi.setDescripcion(descripcion);
                certi.setAvance(avance);
                certi.setEstado(estado);
                //AreasNegocio areaNegocio = new AreasNegocio();
                certificacion.insertarCertificado(certi);
                request.setAttribute("listado", certificacion.listadoCertificado());
                request.getRequestDispatcher("Certficado.jsp").forward(request, response);
            } catch (Exception er) {
                request.setAttribute(mensaje, er.getMessage());
            }
        }
        
        if ("buscar".equals(request.getParameter("action"))) {
            try {
                request.setAttribute("datos", certificacion.getCertificado(idCertificado));
                request.setAttribute("listado", certificacion.listadoCertificadoget(idCertificado));
            } catch (Exception e) {
            }
        }

        if ("eliminar".equals(request.getParameter("action"))) {
            try {
                certificacion.elimnarCertificado(new Certificado(idCertificado, nombre, descripcion, avance, estado));
                request.setAttribute("listado", certificacion.listadoCertificado());
            } catch (Exception er) {
            }
        }
        
        
        request.setAttribute("mensajes", mensaje);
        request.getRequestDispatcher("Certficado.jsp").forward(request, response);
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
