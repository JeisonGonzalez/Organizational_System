package Negocio;

import Entidades.Usuario;
import Persistencia.DaoUsuario;
import Utilidades.Conexion;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.util.List;

public class UsuarioNegocio {
    DaoUsuario daoUsuario;
    Connection conexion;
    
    public UsuarioNegocio (){
        daoUsuario = new DaoUsuario();
    }
    
    public List<Usuario> getUserList (int idUsuario, String nombre, String clave, String correo, int idPerfil, int inSession, String fechaNacimiento, String imagenPerfil) {
        try {
            conexion = (Connection) Conexion.getCon();
            return (List<Usuario>) daoUsuario.getUserList(conexion, idUsuario, nombre, clave, correo, idPerfil, inSession, fechaNacimiento, imagenPerfil);
        } catch (Exception e) {
            System.out.println("Excepción al buscar lista de usuarios en UsuarioNegocio.java : " + e);
            return null;
        }
    }
        
    public String deleteUser (int idUsuario) throws SQLException {
        conexion = (Connection) Conexion.getCon();
        return daoUsuario.deleteUser(conexion, idUsuario);
    }

    public String insertUser (String nombre, String clave, String correo,int idPerfil, String fechaNacimiento, String imagenPerfil) {
        String mensajes = "";
        
        if (nombre == null || nombre.isEmpty()) {
            mensajes += "<br/> Debe ingresar un nombre para el usuario";
        }

        if (clave == null || clave.isEmpty()) {
            mensajes += "<br/> Debe ingresar una clave para el usuario";
        }

        if (correo == null || correo.isEmpty()) {
            mensajes += "<br/> Debe ingresar un correo para contactar al usuario";
        }
        
        if (idPerfil <= 0) {
            mensajes += "<br/> Debe ingresar un perfil el usuario";            
        }
        
        if (mensajes.isEmpty()) {
            try {
                conexion = (Connection) Conexion.getCon();
                mensajes = daoUsuario.insertUser(conexion, nombre, clave, correo, idPerfil, fechaNacimiento, imagenPerfil);
            } catch (Exception e) {
                System.out.println("Error insertando el usuario en insertUser de UsuarioNegocio.java : " + e);
            }
        }
        return mensajes;
    }


    public String updateUser (int idUsuario, String nombre, String clave, String correo, int idPerfil) {
        String mensajes = "";
        
        if (nombre == null || nombre.isEmpty()) {
            mensajes += "<br/> Debe ingresar un nombre para el usuario";
        }

        if (clave == null || clave.isEmpty()) {
            mensajes += "<br/> Debe ingresar una clave para el usuario";
        }

        if (correo == null || correo.isEmpty()) {
            mensajes += "<br/> Debe ingresar un correo para contactar al usuario";
        }
        
        if (idPerfil <= 0) {
            mensajes += "<br/> Debe ingresar un perfil el usuario";            
        }
        
        if (mensajes.isEmpty()) {
            try {
                conexion = (Connection) Conexion.getCon();
                mensajes = daoUsuario.updateUser(conexion, idUsuario, nombre, clave, correo, idPerfil);
            } catch (Exception e) {
                System.out.println("Error modificando el usuario en updateUser de UsuarioNegocio.java : " + e);
            }
        }
        return mensajes;
    }
    
}

