package Servlets;

import Entidades.Perfil;
import Negocio.AreasNegocio;
import Negocio.PerfilNegocio;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jeison González Cifuentes
 */

public class PerfilesServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String submit = request.getParameter("submit");
        String mensajes = "";
        String success = "true";
        PerfilNegocio perfilNegocio = new PerfilNegocio();
        AreasNegocio areaNegocio = new AreasNegocio();
        String buscar = request.getParameter("search");
        
        if (submit != null && !submit.isEmpty()) {
            switch (submit) {
                case "Guardar":
                    {
                        Perfil perfil =  new Perfil();
                        if (request.getParameter("idPerfil") != null && request.getParameter("idPerfil") != "") {
                            perfil.setIdPerfil(Integer.parseInt(request.getParameter("idPerfil")));
                        } else {
                            perfil.setIdPerfil(0);
                        }
                        perfil.setNombre(request.getParameter("nombre"));
                        perfil.setDescripcion(request.getParameter("descripcion"));
                        if (request.getParameter("idArea") != null && request.getParameter("idArea") != "") {
                            perfil.setIdArea(Integer.parseInt(request.getParameter("idArea")));
                        } else {
                            perfil.setIdArea(0);
                        }
                        if (request.getParameter("idPadre") != null && request.getParameter("idPadre") != "") {
                            perfil.setIdPadre(Integer.parseInt(request.getParameter("idPadre")));
                        } else {
                            perfil.setIdPerfil(0);
                        }
                        Map<String, String> returnMap = new HashMap<>();
                        if (request.getParameter("idPerfil") == null || request.getParameter("idPerfil").isEmpty()) {
                            returnMap = perfilNegocio.guardarPerfil(perfil);
                        } else {
                            returnMap = perfilNegocio.actualizarPerfil(perfil);                        
                        }
                        success = returnMap.get("success");
                        mensajes = returnMap.get("mensaje");
                        break;
                    }
                case "Eliminar":
                    {
                        Map<String, String> returnMap = new HashMap<>();
                        if (request.getParameter("idPerfil") != null && !request.getParameter("idPerfil").isEmpty()) {
                            returnMap = perfilNegocio.eliminarPerfil(Integer.parseInt(request.getParameter("idPerfil")));
                            success = returnMap.get("success");
                            mensajes = returnMap.get("mensaje");
                        } else {
                            success = returnMap.get("warning");
                            mensajes = returnMap.get("El perfil seleccionado no se puede eliminar");
                        }
                        break;
                    }
            }
        }
        
        try {
            request.setAttribute("listadoPerfil", perfilNegocio.obtenerListadoDePerfiles(-1, null, null, -1, -1, buscar));
            request.setAttribute("listadoAreas", areaNegocio.obtenerListadoDeAreas(-1, null, null, -1, null));
        } catch (NumberFormatException e) {
            System.out.println("Error seteando atributo en opción Listar perfiles : " + e);
        }
        
        request.setAttribute("success", success);
        request.setAttribute("mensajes", mensajes);
        request.getRequestDispatcher("/perfiles.jsp").forward(request, response);
        
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
