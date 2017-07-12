/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidades.Areas;
import Persistencia.DaoAreas;
import Utilidades.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class AreasNegocio {
    DaoAreas daoArea;
    Connection conexion;
    
    public AreasNegocio (){
        daoArea = new DaoAreas();
    }
    
    public List<Areas> getUserList (int idArea, String nombre, String descripcion, int padre, String buscar) {
        try {
            conexion = (Connection) Conexion.getCon();
            return (List<Areas>) daoArea.getUserList(conexion, idArea, nombre, descripcion, padre, buscar);
        } catch (Exception e) {
            System.out.println("Excepción al buscar lista de usuarios en UsuarioNegocio.java : " + e);
            return null;
        }
    }

    public void setArea(Areas areas) {
        try {
            conexion = (Connection) Conexion.getCon();
            daoArea.setArea(conexion,areas);
        } catch (SQLException e) {
            System.out.println("Excepción al ingresar el area en UsuarioNegocio.java : " + e);
        }
        
    }

    public ArrayList<String> getAreasP() {
        try {
            conexion = (Connection) Conexion.getCon();
            return daoArea.getListAP(conexion);
        } catch (SQLException e) {
            System.out.println("Excepción al buscar la lista de areas padre : " + e);
            return null;
        }        
    }

    public void setEliminar(String Id) {
        try {
            conexion = (Connection) Conexion.getCon();
            daoArea.EliminarArea(Id,conexion);
        } catch (SQLException e) {
            System.out.println("Excepción al eliminar el area : " + e);
        }
    }
}
