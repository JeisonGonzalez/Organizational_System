/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidades.Areas;
import Negocio.AreasNegocio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
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
        String mensajes = "";
        String submit = request.getParameter("submit");       
        AreasNegocio areaNegocio = new AreasNegocio();
        
        if (submit != null) {
            if (submit.equals("Registrar")){
                Areas areas =  new Areas();
                String  Id = request.getParameter("id_Area");
                String  Nombre = request.getParameter("Nombre");
                String  Descripcion = request.getParameter("Descripcion");
                String  Area_Padre = request.getParameter("Area_Padre");
                System.out.println("Id area: "+Id);
                System.out.println("Nombre : "+Nombre);
                System.out.println("Descripcion: "+Descripcion);
                System.out.println("Area padre: "+Area_Padre);
                areas.setIdAreas(Id);
                areas.setDescripcion(Descripcion);
                areas.setArea_Padre(Area_Padre);
                areas.setNombre(Nombre);
                //AreasNegocio areaNegocio = new AreasNegocio();
                areaNegocio.setArea(areas);
            }else 
                if (submit.equals("Eliminar")){
                    String  Id = request.getParameter("id_Area");
                    System.out.println("id eliminar  : "+Id);
                    areaNegocio.setEliminar(Id);
                }
        }
//            //if (submit.equals("Buscar")){
                
            //}
            String buscar = request.getParameter("buscar");
        
            try {
                
                request.setAttribute("listadoAreas", areaNegocio.getUserList(-1, null, null, -1, buscar));
                request.setAttribute("ListaAP", areaNegocio.getAreasP());
            } catch (NumberFormatException e) {
                System.out.println("Error seteando atributo en opción Listar usuario : " + e);
            }
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
        //AreasNegocio areaNegocio = new AreasNegocio();
        
        //String buscar = request.getParameter("buscar");
        
        //try {
//            request.setAttribute("listadoAreas", areaNegocio.getUserList(-1, null, null, -1, buscar));
//        } catch (NumberFormatException e) {
//            System.out.println("Error seteando atributo en opción Listar usuario : " + e);
//        }
//        request.getRequestDispatcher("/Areas.jsp").forward(request, response);   
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
//        Connection con = null;
//        try {
//            con = new Conexion().getCon();
//        } catch (SQLException ex) {
//            Logger.getLogger(ServletAreas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        String  accion = request.getParameter("FormularioArea");
//        System.out.println("accion"+accion);
//        if (accion.equals("Registrar") == true){
//            String  Id = request.getParameter("id_Area");
//            String  Nombre = request.getParameter("Nombre");
//            String  Descripcion = request.getParameter("Descripcion");
//            String  Area_Padre = request.getParameter("Area_Padre");
//            System.out.println("Id area: "+Id);
//            System.out.println("Nombre : "+Nombre);
//            System.out.println("Descripcion: "+Descripcion);
//            System.out.println("Area padre: "+Area_Padre);
//            Areas area = new Areas(Id, Nombre, Descripcion, Area_Padre);
//            DaoIngreso daoI = null;
//            try {
//                daoI = new DaoIngreso();
//                DaoConsulta daoC = new DaoConsulta();
//            } catch (SQLException ex) {
//                Logger.getLogger(ServletAreas.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        
//            try {
//                daoI.ingresarArea(area);
//            } catch (SQLException ex) {
//                Logger.getLogger(ServletAreas.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }else 
//            if (accion.equals("Eliminar") == true)
//            {
//                String  id_eliminar = request.getParameter("id_eliminar");
//                System.out.println("id eliminar  : "+id_eliminar);
//                DaoEliminar daoe = null;
//                try {
//                    daoe = new DaoEliminar();
//                    daoe.EliminarArea(id_eliminar);
//                } catch (SQLException ex) {
//                    Logger.getLogger(ServletAreas.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }else
//            if (accion.equals("Buscar") == true)
//            {
//                String  id_buscar = request.getParameter("id_Modificar");
//                System.out.println("id buscar"+id_buscar);
//                DaoConsulta daoc = null;
//                Areas area = null;
//            try {
//                daoc = new DaoConsulta();
//                area = daoc.ConsultarArea(id_buscar);
//            } catch (SQLException ex) {
//                Logger.getLogger(ServletAreas.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//                System.out.println("area retornada"+area.getArea_Padre());
//                System.out.println("area retornada"+area.getDescripcion());
//                System.out.println("area retornada"+area.getIdAreas());
//                System.out.println("area retornada"+area.getNombre());
//                request.setAttribute("Area", area);
//                request.getRequestDispatcher("Areas.jsp").forward(request, response);
//                //request.getRequestDispatcher("http://localhost:8084/Organizational_System/Areas.jsp").forward(request, response);
//                //response.sendRedirect("http://localhost:8084/Organizational_System/Areas.jsp");  //http://localhost:8084/Organizational_System/Areas.jsp
//            }else {
//                String  id_modificar = request.getParameter("id_modificar");
//            }
        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
