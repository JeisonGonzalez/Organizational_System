/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeison
 */
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
    
}
