package Servlets;

import Negocio.UsuarioNegocio;
import Persistencia.DaoUsuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioSrvlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DaoUsuario daoUsuario = new DaoUsuario();
        String mensajes = "";
        int idUsuario = request.getParameter("idUsuario") != null ? Integer.parseInt(request.getParameter("idUsuario")) : 0;
        String nombre = request.getParameter("nombre");
        String clave = request.getParameter("clave");
        String correo = request.getParameter("clave");
        int idPerfil = request.getParameter("idPerfil") != null ? Integer.parseInt(request.getParameter("idPerfil")) : 0;
        String accion = request.getParameter("action");
        
        UsuarioNegocio usuarioNegocio = new UsuarioNegocio();

        //Realizar acciones
        if (accion.equalsIgnoreCase("Guardar")) {
            try {
                mensajes = usuarioNegocio.insertUser(nombre,clave,correo,idPerfil);
            } catch (Exception e) {
                mensajes += "<br/> No se pudo guardar el registro";
                System.out.println("Error obteniendo método get Guardar : " + e);
            }
        }
        
        try {
            request.setAttribute("listado", usuarioNegocio.getUserList(-1, null, null, null, -1, 1, null, null));
        } catch (NumberFormatException e) {
            System.out.println("Error seteando atributo en opción Listar usuario : " + e);
        }
        request.getRequestDispatcher("/Empleado.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
