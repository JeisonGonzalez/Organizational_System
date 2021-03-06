package Servlets;

import Entidades.Areas;
import Negocio.AreasNegocio;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Juan
 */
public class AreasServlet extends HttpServlet {

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
        String submit = request.getParameter("submit");
        String mensajes = "";
        String success = "true";
        AreasNegocio areaNegocio = new AreasNegocio();
        String buscar = request.getParameter("search");
        
        if (submit != null && !submit.isEmpty()) {
            switch (submit) {
                case "Guardar":
                    {
                        Areas areas =  new Areas();
                        areas.setIdArea(request.getParameter("id_Area"));
                        areas.setNombre(request.getParameter("Nombre"));
                        areas.setDescripcion(request.getParameter("Descripcion"));
                        areas.setArea_Padre(request.getParameter("Area_Padre"));
                        Map<String, String> returnMap = new HashMap<>();
                        if (request.getParameter("id_Area") == null || request.getParameter("id_Area").isEmpty()) {
                            returnMap = areaNegocio.guardarArea(areas);
                        } else {
                            returnMap = areaNegocio.actualizarArea(areas);                        
                        }
                        success = returnMap.get("success");
                        mensajes = returnMap.get("mensaje");
                        break;
                    }
                case "Eliminar":
                    {
                        Map<String, String> returnMap = new HashMap<>();
                        String  Id = request.getParameter("id_Area");
                        returnMap = areaNegocio.setEliminar(Id);
                        success = returnMap.get("success");
                        mensajes = returnMap.get("mensaje");
                        break;
                    }
            }
        }
        
        try {
            request.setAttribute("listadoAreas", areaNegocio.obtenerListadoDeAreas(-1, null, null, -1, buscar));
        } catch (NumberFormatException e) {
            System.out.println("Error seteando atributo en opción Listar áreas : " + e);
        }
        
        request.setAttribute("success", success);
        request.setAttribute("mensajes", mensajes);
        request.getRequestDispatcher("/Areas.jsp").forward(request, response);
        
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
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
