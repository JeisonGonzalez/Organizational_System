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
        public List<Areas> getUserList(Connection conexion, int idArea, String nombre, String descripcion, int padre, String buscar) {
        List<Areas> areaList = new ArrayList<Areas>();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) conexion.prepareStatement(SQLHelpers.getAreasList(idArea, nombre, descripcion, padre, buscar));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Areas area = new Areas();
                area.setIdAreas(resultSet.getString(1));
                area.setNombre(resultSet.getString(2));
                area.setDescripcion(resultSet.getString(3));
                area.setArea_Padre(resultSet.getString(4));
                areaList.add(area);
            }
        } catch (Exception e) {
            System.out.println("Error en DaoUsuario / getUserList : "+e);
        }
        return areaList;
    }

    public void setArea(Connection conexion, Areas area) throws SQLException {
        PreparedStatement p = conexion.prepareStatement(SQLHelpers.setArea());
        p.setInt(1,Integer.parseInt(area.getIdAreas()));
        p.setString(2, area.getNombre());
        p.setString(3, area.getDescripcion());
        p.setString(4, area.getArea_Padre());
        p.executeUpdate();
    }

    public ArrayList getListAP(Connection conexion) throws SQLException {
        ArrayList<String> ListaAP = new ArrayList<String>();
        PreparedStatement p = conexion.prepareStatement(SQLHelpers.getListAP());
        ResultSet resultSet = p.executeQuery();
        while (resultSet.next()) {
            ListaAP.add(resultSet.getString(1));
        }
        return ListaAP;
    }

    public void EliminarArea(String Id, Connection conexion) throws SQLException {
       PreparedStatement p = conexion.prepareStatement(SQLHelpers.setEliminarArea());
       p.setString(1, Id);
       p.executeUpdate();
    }
}
