/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Areas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan
 */
public class DaoAreas {
        public List<Areas> obtenerListadoDeAreas(Connection conexion, int idArea, String nombre, String descripcion, int padre, String buscar) {
        List<Areas> areaList = new ArrayList<Areas>();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) conexion.prepareStatement(SQLHelpers.obtenerListadoDeAreas(idArea, nombre, descripcion, padre, buscar));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Areas area = new Areas();
                area.setIdArea(resultSet.getString(1));
                area.setNombre(resultSet.getString(2));
                area.setDescripcion(resultSet.getString(3));
                area.setArea_Padre(resultSet.getString(4));
                area.setNombre_Padre(resultSet.getString(5));
                areaList.add(area);
            }
        } catch (Exception e) {
            System.out.println("Error en DaoAreas / obtenerListadoDeAreas : " + e);
        }
        return areaList;
    }

    public void guardarArea(Connection conexion, Areas area) throws SQLException {
        try {
            PreparedStatement p = conexion.prepareStatement(SQLHelpers.guardarArea());
            p.setString(1, area.getNombre());
            p.setString(2, area.getDescripcion());
            p.setString(3, area.getArea_Padre());
            p.setString(4, area.getNombre_Padre());
            p.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en DaoAreas.java/setArea : " + e);
        }
    }
    
    public void actualizarArea(Connection conexion, Areas area) throws SQLException {
        try {
            PreparedStatement p = conexion.prepareStatement(SQLHelpers.actualizarArea());
            p.setString(1, area.getNombre());
            p.setString(2, area.getDescripcion());
            p.setString(3, area.getArea_Padre());
            p.setString(4, area.getNombre_Padre());
            p.setString(5, area.getIdArea());
            p.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en DaoAreas.java/setArea : " + e);
        }
    }

    public void eliminarArea(Connection conexion, String idArea) {
        try {
            conexion.prepareStatement(SQLHelpers.eliminarArea(idArea)).executeUpdate();
        } catch (Exception e) {
            System.out.println("Error ejecutando DELETE en DaoAreas.eliminarArea");
        }
    }
}
