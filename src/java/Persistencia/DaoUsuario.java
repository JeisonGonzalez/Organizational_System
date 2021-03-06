package Persistencia;

import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuario {
    
    public List<Usuario> getUserList(Connection conexion, int idUsuario, String nombre, String clave, String correo, int idPerfil, int inSession, String fechaNacimiento, String imagenPerfil) {
        List<Usuario> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) conexion.prepareStatement(SQLHelpers.getUserList(idUsuario,nombre,clave,correo,idPerfil,inSession,fechaNacimiento,imagenPerfil));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Usuario user = new Usuario();
                user.setIdUsuario(resultSet.getInt(1));
                user.setNombre(resultSet.getString(2));
                user.setClave(resultSet.getString(3));
                user.setCorreo(resultSet.getString(4));
                user.setIdPerfil(resultSet.getInt(5));
                user.setInSession(resultSet.getInt(6));
                user.setFechaNacimiento(resultSet.getString(7));
                user.setImagenPerfil(resultSet.getString(8));
                userList.add(user);
            }
        } catch (Exception e) {
            System.out.println("Error en DaoUsuario / getUserList : "+e);
        }
        return userList;
    }
      
    public List<Usuario> getUserListBySearch(Connection conexion, String param) {
        List<Usuario> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) conexion.prepareStatement(SQLHelpers.getUserListBySearch(param));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Usuario user = new Usuario();
                user.setIdUsuario(resultSet.getInt(1));
                user.setNombre(resultSet.getString(2));
                user.setClave(resultSet.getString(3));
                user.setCorreo(resultSet.getString(4));
                user.setIdPerfil(resultSet.getInt(5));
                user.setInSession(resultSet.getInt(6));
                user.setFechaNacimiento(resultSet.getString(7));
                user.setImagenPerfil(resultSet.getString(8));
                userList.add(user);
            }
        } catch (Exception e) {
            System.out.println("Error en DaoUsuario / getUserListBySearch : "+e);
        }
        return userList;
    }
            
    public String deleteUser(Connection conexion, int idUsuario) {
        String mensajes = "";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(SQLHelpers.deleteUser(idUsuario));
            preparedStatement.execute();
            mensajes = "Empleado " + idUsuario + " borrado exitosamente";
        } catch (Exception e) {
            mensajes = "El empleado no pudo ser borrado";
            System.out.println("Error intentando borrar usuario en DaoUsuario : " + e);
        }
        return mensajes;
    }
    
    public String insertUser (Connection conexion, String nombre, String clave, String correo, int idPerfil, String fechaNacimiento, String imagenPerfil) {
        String mensajes = "";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(SQLHelpers.insertUser());
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, clave);
            preparedStatement.setString(3, correo);
            preparedStatement.setInt(4, idPerfil);
            preparedStatement.setInt(5, 0);
            preparedStatement.setString(6, fechaNacimiento);
            preparedStatement.setString(7, imagenPerfil);
            preparedStatement.execute();
            if (preparedStatement.getUpdateCount() > 0) {
                mensajes = "Usuario '" + nombre + "' guardado exitosamente.";
            } else {
                mensajes = "El usuario no pudo ser guardado.";
            }
        } catch (Exception e) {
            mensajes += e.getMessage();
        }
        return mensajes;
    }

    public String updateUser (Connection conexion, Integer idUsuario, String nombre, String clave, String correo, Integer idPerfil, String fechaNacimiento, String imagenPerfil) {
        String mensajes = "";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(SQLHelpers.updateUser(idUsuario, nombre, clave, correo, idPerfil, fechaNacimiento, imagenPerfil));
            preparedStatement.execute();
            if (preparedStatement.getUpdateCount() > 0) {
                mensajes = "Usuario '" + nombre + "' ha sido modificado exitosamente.";
            } else {
                mensajes = "El usuario no pudo ser modificado.";
            }
        } catch (Exception e) {
            mensajes += e.getMessage();
        }
        return mensajes;
    }
    
}
