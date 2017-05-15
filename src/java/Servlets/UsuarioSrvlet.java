package Servlets;

import Negocio.UsuarioNegocio;
import Persistencia.DaoUsuario;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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
        String success = "true";
        String nombreUsuario = request.getParameter("nombreUsuario");
        String cargoUsuario = request.getParameter("cargoUsuario");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String correoUsuario = request.getParameter("correoUsuario");
        String clave = request.getParameter("claveUsuario");
        String submit = request.getParameter("submit");
        request.setAttribute("nombreOrganizacion", "Organizational system");
        UsuarioNegocio usuarioNegocio = new UsuarioNegocio();
        
        if (submit != null && !submit.isEmpty()) {
            Random rnd = new Random();
            Map<String, String> datosUsuario = new HashMap<String, String>();
            datosUsuario.put("nombreUsuario", nombreUsuario);
            datosUsuario.put("cargoUsuario", cargoUsuario);
            datosUsuario.put("cumpleañosUsuario", fechaNacimiento);
            datosUsuario.put("correoUsuario", correoUsuario);
            validarDatosObligatorios(datosUsuario);
            mensajes = usuarioNegocio.insertUser(nombreUsuario, clave, correoUsuario, 1, fechaNacimiento, "");
        }
        
        try {
            request.setAttribute("listadoEmpleado", usuarioNegocio.getUserList(-1, null, null, null, -1, -1, null, null));
        } catch (NumberFormatException e) {
            System.out.println("Error seteando atributo en opción Listar usuario : " + e);
        }
        request.setAttribute("success", success);
        request.setAttribute("mensajes", mensajes);
        request.getRequestDispatcher("/Empleado.jsp").forward(request, response);
    }
    
    public static String validarDatosObligatorios(Map<String, String> datos) {
        String mensaje = null;
        for (Map.Entry<String, String> entrySet : datos.entrySet()) {
            if (entrySet == null || entrySet.toString().isEmpty()) {
                mensaje = "Debe ingresar todos los campos obligatorios.";
            }
        }
        return mensaje;
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
