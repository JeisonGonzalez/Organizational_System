/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Michael
 */
public class DaoIngreso {
    
    public Usuarios ValidarIngreso(Connection con, String correo, String contraseña) {
        Usuarios usuario = new Usuarios();
        //usuario.setIdUsuario("0");
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getValidarIngreso(correo, contraseña));
            ResultSet r = p.executeQuery();
            while (r.next()) {
                usuario.setIdUsuario(r.getString(1));
                usuario.setNombre(r.getString(2));
                usuario.setClave(r.getString(3));
                usuario.setCorreo(r.getString(4));
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
