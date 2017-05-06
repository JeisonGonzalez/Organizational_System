package Persistencia;

import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoIngreso {
    
    public Usuario ValidarIngreso(Connection con, String correo, String contraseña) {
        Usuario usuario = new Usuario();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(SQLHelpers.getValidarIngreso(correo, contraseña));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                usuario.setClave(resultSet.getString(3));
                usuario.setCorreo(resultSet.getString(4));
            }
        } catch (Exception e) {
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }
        return usuario;
    }
    
}
