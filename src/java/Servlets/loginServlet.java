package Servlets;

import Negocio.UsuarioNegocio;
import Persistencia.DaoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * * @author Jeison
 */

public class loginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String mensajes = "";
        String clave = request.getParameter("clave");
        String correo = request.getParameter("correo");
        String accion = request.getParameter("accion");
        
        UsuarioNegocio usuarioNegocio = new UsuarioNegocio();

        //Realizar acciones
        if (accion.equalsIgnoreCase("Ingresar")) {
            try {
                mensajes = usuarioNegocio.getUserByLogin(clave,correo) == true ? "Ingresando al sistema" : "Error : Ususario o contraseña incorrectos";
            } catch (Exception e) {
                mensajes += "<br/> Error : No se pudo guardar el registro";
                System.out.println("Error obteniendo método get Guardar : " + e);
            }
        }
        request.getRequestDispatcher("/Empleado.jsp").forward(request, response);
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
