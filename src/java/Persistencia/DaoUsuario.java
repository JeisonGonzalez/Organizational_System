package Persistencia;

import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuario {
    
    public List<Usuario> getUserList(Connection conexion) {
        List<Usuario> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) conexion.prepareStatement(SQLHelpers.getUserList());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Usuario user = new Usuario();
                user.setIdUsuario(resultSet.getInt(1));
                user.setNombre(resultSet.getString(2));
                user.setClave(resultSet.getString(3));
                user.setCorreo(resultSet.getString(4));
                user.setIdPerfil(resultSet.getString(5));
                userList.add(user);
            }
        } catch (Exception e) {
            System.out.println("Error en DaoEmpresa / ListadoEmpresas : "+e);
        }
        return userList;
    }
    
    public List<Usuario> getUserById(Connection conexion, int idUsuario) {
        List<Usuario> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) conexion.prepareStatement(SQLHelpers.getUserById(idUsuario));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Usuario user = new Usuario();
                user.setIdUsuario(resultSet.getInt(1));
                user.setNombre(resultSet.getString(2));
                user.setClave(resultSet.getString(3));
                user.setCorreo(resultSet.getString(4));
                user.setIdPerfil(resultSet.getString(5));
                userList.add(user);
            }
        } catch (Exception e) {
            System.out.println("Error en DaoEmpresa / ListadoEmpresas : "+e);
        }
        return userList;
    }
    
    public String deleteUser(Connection conexion, int idUsuario) {
        String mensajes = "";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(SQLHelpers.deleteUser(idUsuario));
            preparedStatement.execute();
            mensajes = "Usuario borrado exitosamente";
        } catch (Exception e) {
            System.out.println("Error intentando borrar usuario en DaoUsuario : " + e);
        }
        return mensajes;
    }
    
    public String insertUser (Connection conexion, String nombre, String clave, String correo, int idPerfil) {
        String mensajes = "";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(SQLHelpers.insertUser());
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, clave);
            preparedStatement.setString(3, correo);
            preparedStatement.setInt(4, idPerfil);
            preparedStatement.execute();
            if (preparedStatement.getUpdateCount() > 0) {
                mensajes = "<br/>Usuario '" + nombre + "' guardado exitosamente.";
            } else {
                mensajes = "<br/>El usuario no pudo ser guardado.";
            }
        } catch (Exception e) {
            mensajes += e.getMessage();
        }
        return mensajes;
    }

    public String updateUser (Connection conexion, int idUsuario, String nombre, String clave, String correo, int idPerfil) {
        String mensajes = "";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(SQLHelpers.updateUser(idUsuario));
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, clave);
            preparedStatement.setString(3, correo);
            preparedStatement.setInt(4, idPerfil);
            preparedStatement.execute();
            if (preparedStatement.getUpdateCount() > 0) {
                mensajes = "<br/>Usuario '" + nombre + "' modificado exitosamente.";
            } else {
                mensajes = "<br/>El usuario no pudo ser modificado.";
            }
        } catch (Exception e) {
            mensajes += e.getMessage();
        }
        return mensajes;
    }
    
}
