package Persistencia;

import Entidades.Capacitaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoCapacitacion {

    public DaoCapacitacion() {
    }
    
    public List<Capacitaciones> listaCapacitacion(Connection con) {
        List<Capacitaciones> resultado = new ArrayList<Capacitaciones>();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getCapacitacion());
            ResultSet registros = p.executeQuery();
            while (registros.next()) {
                Capacitaciones capacitacion = new Capacitaciones();
                capacitacion.setIdCapacitacion(registros.getString(1));
                capacitacion.setIdArea(registros.getString(2));
                capacitacion.setNombre(registros.getString(3));
                capacitacion.setDescripcion(registros.getString(4));
                capacitacion.setEstado(registros.getString(5));
                capacitacion.setFecha(registros.getString(6));
                resultado.add(capacitacion);
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        return resultado;
    }
    
    public List<Capacitaciones> listaCapacitacionget(Connection con, String id) {
        List<Capacitaciones> resultado = new ArrayList<Capacitaciones>();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getCapacitacion(id));
            ResultSet registros = p.executeQuery();
            while (registros.next()) {
                Capacitaciones capacitacion = new Capacitaciones();
                capacitacion.setIdCapacitacion(registros.getString(1));
                capacitacion.setIdArea(registros.getString(2));
                capacitacion.setNombre(registros.getString(3));
                capacitacion.setDescripcion(registros.getString(4));
                capacitacion.setEstado(registros.getString(5));
                capacitacion.setFecha(registros.getString(6));
                resultado.add(capacitacion);
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        return resultado;
    }
    
    public Capacitaciones getCapacitacion(Connection con, String id) {
        Capacitaciones capacitacion = new Capacitaciones();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getCapacitacion(id));
            ResultSet registros = p.executeQuery();
            while (registros.next()) {
                capacitacion.setIdCapacitacion(registros.getString(1));
                capacitacion.setIdArea(registros.getString(2));
                capacitacion.setNombre(registros.getString(3));
                capacitacion.setDescripcion(registros.getString(4));
                capacitacion.setEstado(registros.getString(5));
                capacitacion.setFecha(registros.getString(6));
            }// fin mientras
        } catch (Exception e) {
        }
        return capacitacion;
    }
    
    public String InsertarCapacitacion(Connection con, String IdCapacitacion, String IdArea, String Nombre, String Descripcion, String Estado, String Fecha) {
        String res = "";
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.insertarCapacitacion());

            p.setString(1, IdCapacitacion);
            p.setString(2, IdArea);
            p.setString(3, Nombre);
            p.setString(4, Descripcion);
            p.setString(5, Estado);
            p.setString(6, Fecha);
            p.executeUpdate();
            
        } catch (Exception e) {
            res += "" + e.getMessage() + " Causa :" + e.getCause();
        } 
        return res;
    }
    
    public String eliminarCapacitacion(Connection con, String Id) {
        String res = "";
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.eliminarCapacitacion());
            p.setString(1, Id);
            p.execute();
            if (p.getUpdateCount() > 0) {
                res = "¡Se ha eliminado correctamente!";
            } else {
                res = "No se ha podido elimnar";
            }
        } catch (Exception e) {
            res += "" + e.getMessage() + " Causa :" + e.getCause();
        }
        return res;
    }
    
}
