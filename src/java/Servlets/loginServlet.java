package Servlets;

import Entidades.Usuario;
import Negocio.UsuarioNegocio;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * * @author Jeison
 */

public class loginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String clave = request.getParameter("clave");
        String correo = request.getParameter("correo");
        String submit = request.getParameter("submit");
        HttpSession session = request.getSession();
        if (session.getAttribute("correoInSession") == null && session.getAttribute("claveInSession") == null) {
            if (clave != null && !clave.isEmpty() && correo != null && !correo.isEmpty()) {
                UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
                //Realizar acciones
                if (submit.equalsIgnoreCase("Ingresar")) {
                    try {
                        List<Usuario> getUserSession = usuarioNegocio.getUserList(-1, null, clave, correo, -1, -1, null, null);
                        if (getUserSession != null && getUserSession.size() > 0) {
                            session.setAttribute("correoInSession", correo);
                            session.setAttribute("claveInSession", clave);
                            session.setAttribute("userSessionName", getUserSession.get(0).getNombre());
                            request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
                        } else {
                            session.setAttribute("correoInSession", null);
                            session.setAttribute("claveInSession", null);
                            session.setAttribute("userSessionName", null);
                            request.setAttribute("mensajes", "Usuario y/o contraseña incorrectos");
                            request.getRequestDispatcher("/index.jsp").forward(request, response);                        
                        }
                    } catch (Exception e) {
                        System.out.println("Error obteniendo usuario para el ingreso al sistema : " + e);
                    }
                }
            } else {
                request.setAttribute("mensajes", "Debes ingresar un usuario y una contraseña");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
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
