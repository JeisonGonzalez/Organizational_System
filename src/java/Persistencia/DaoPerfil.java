package Persistencia;

import Entidades.Perfil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeison González Cifuentes
 */
public class DaoPerfil {
        public List<Perfil> obtenerListadoDePerfiles(Connection conexion, int idPerfil, String nombre, String descripcion, int area, int padre, String buscar) {
        List<Perfil> perfilList = new ArrayList<Perfil>();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) conexion.prepareStatement(SQLHelpers.obtenerListadoDePerfiles(idPerfil, nombre, descripcion, area, padre, buscar));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Perfil perfil = new Perfil();
                perfil.setIdPerfil(resultSet.getInt(1));
                perfil.setIdArea(resultSet.getInt(2));
                perfil.setNombre(resultSet.getString(3));
                perfil.setDescripcion(resultSet.getString(4));
                perfil.setIdPadre(resultSet.getInt(5));
                perfil.setNombre_padre(resultSet.getString(6));
                perfil.setNombre_area(resultSet.getString(7));
                perfilList.add(perfil);
            }
        } catch (Exception e) {
            System.out.println("Error en DaoPerfil / obtenerListadoDePerfiles : " + e);
        }
        return perfilList;
    }

    public void guardarPerfil(Connection conexion, Perfil perfil) throws SQLException {
        try {
            PreparedStatement p = conexion.prepareStatement(SQLHelpers.guardarPerfil());
            p.setInt(1, perfil.getIdArea());
            p.setString(2, perfil.getNombre());
            p.setString(3, perfil.getDescripcion());
            p.setInt(4, perfil.getIdPadre());
            p.setString(5, perfil.getNombre_padre());
            p.setString(6, perfil.getNombre_area());
            p.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en DaoPerfil.java/guardarPerfil : " + e);
        }
    }
    
    public void actualizarPerfil(Connection conexion, Perfil perfil) throws SQLException {
        try {
            PreparedStatement p = conexion.prepareStatement(SQLHelpers.actualizarPerfil());
            p.setInt(1, perfil.getIdArea());
            p.setString(2, perfil.getNombre());
            p.setString(3, perfil.getDescripcion());
            p.setInt(4, perfil.getIdPadre());
            p.setString(5, perfil.getNombre_padre());
            p.setString(6, perfil.getNombre_area());
            p.setInt(7, perfil.getIdPerfil());
            p.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en DaoPerfil.java/actualizarPerfil : " + e);
        }
    }

    public void eliminarPerfil(Connection conexion, Integer idPerfil) {
        try {
            conexion.prepareStatement(SQLHelpers.eliminarPerfil(idPerfil)).executeUpdate();
        } catch (Exception e) {
            System.out.println("Error ejecutando DELETE en DaoPerfil.eliminarPerfil");
        }
    }
}
