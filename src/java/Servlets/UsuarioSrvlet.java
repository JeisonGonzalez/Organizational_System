package Servlets;

import Negocio.UsuarioNegocio;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioSrvlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String mensajes = "";
        String success = "true";
        String nombreUsuario = request.getParameter("nombreUsuario");
        String cargoUsuario = request.getParameter("cargoUsuario");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String correoUsuario = request.getParameter("correoUsuario");
        String clave = request.getParameter("claveUsuario");
        String submit = request.getParameter("submit");
        Integer idUsuario = null;
        if (request.getParameter("idUsuario") != null && !request.getParameter("idUsuario").isEmpty()) {
            idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        }
        UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
        
        try {
            if (submit != null && !submit.isEmpty()) {
                if ("Eliminar".equals(submit)) {
                    if (idUsuario != null && idUsuario > 0) {
                        mensajes = usuarioNegocio.deleteUser(idUsuario);
                        success = "true";
                    } else {
                        mensajes = "Debe ingresar la identificación del usuario a eliminar";
                        success = "false";
                    }
                } else {
                    if ("Guardar".equals(submit)) {
                        if (idUsuario != null && idUsuario > 0) {
                            mensajes = usuarioNegocio.updateUser(idUsuario, nombreUsuario, clave, correoUsuario, 1, fechaNacimiento, "");
                        } else {
                            mensajes = usuarioNegocio.insertUser(nombreUsuario, clave, correoUsuario, 1, fechaNacimiento, "");
                        }
                    }
                }
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Error ejecutando submit en usuarioServlet : " + e);
        }
        
        try {
            if (submit != null && !submit.isEmpty() && "Buscar".equals(submit) && request.getParameter("search") != null && !request.getParameter("search").isEmpty()) {
                request.setAttribute("listadoEmpleado", usuarioNegocio.getUserListBySearch(request.getParameter("search")));
            } else {
                request.setAttribute("listadoEmpleado", usuarioNegocio.getUserList(-1, null, null, null, -1, -1, null, null));
            }
        } catch (NumberFormatException e) {
            System.out.println("Error seteando atributo en opción Listar usuario : " + e);
        }
        request.setAttribute("success", success);
        request.setAttribute("mensajes", mensajes);
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
