package Servlets;

import Entidades.Usuario;
import Negocio.UsuarioNegocio;
import java.io.IOException;
import java.util.List;
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
        String action = request.getParameter("action");
        
        if (clave != null && !clave.isEmpty() && correo != null && !correo.isEmpty()) {
            UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
            //Realizar acciones
            if (action.equalsIgnoreCase("Ingresar")) {
                try {
                    List<Usuario> getUserSession = usuarioNegocio.getUserList(-1, null, clave, correo, -1, -1, null, null);
                    if (getUserSession.size() > 0) {
                        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
                    } else {
                        request.setAttribute("message", "Usuario o contraseña incorrectos");
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    }
                } catch (Exception e) {
                    mensajes += "<br/> Error : Error obteniendo usuario para el ingreso al sistema";
                    System.out.println("Error obteniendo usuario para el ingreso al sistema : " + e);
                }
            }
        } else {
            request.setAttribute("message", "Debe ingresar un usuario y una contraseña");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
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
