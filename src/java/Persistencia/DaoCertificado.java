package Persistencia;

import Entidades.Certificado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoCertificado {

    public DaoCertificado() {
    }
    
    public List<Certificado> listaCertificado(Connection con) {
        List<Certificado> resultado = new ArrayList<Certificado>();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getCertificado());
            ResultSet registros = p.executeQuery();
            while (registros.next()) {
                Certificado certificado = new Certificado();
                certificado.setIdCertificacion(registros.getString(1));
                certificado.setNombre(registros.getString(2));
                certificado.setDescripcion(registros.getString(3));
                certificado.setAvance(registros.getString(4));
                certificado.setEstado(registros.getString(5));
                resultado.add(certificado);
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        return resultado;
    }
    
    public List<Certificado> listaCertificadoget(Connection con, String id) {
        List<Certificado> resultado = new ArrayList<Certificado>();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getCertificadoget(id));
            ResultSet registros = p.executeQuery();
            while (registros.next()) {
                Certificado certificado = new Certificado();
                certificado.setIdCertificacion(registros.getString(1));
                certificado.setNombre(registros.getString(2));
                certificado.setDescripcion(registros.getString(3));
                certificado.setAvance(registros.getString(4));
                certificado.setEstado(registros.getString(5));
                resultado.add(certificado);
            }
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        return resultado;
    }
    
    public Certificado getCertificado(Connection con, String id) {
        Certificado certificado = new Certificado();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getCertificado(id));
            ResultSet registros = p.executeQuery();
            while (registros.next()) {
                certificado.setIdCertificacion(registros.getString(1));
                certificado.setNombre(registros.getString(2));
                certificado.setDescripcion(registros.getString(3));
                certificado.setAvance(registros.getString(4));
                certificado.setEstado(registros.getString(5));
            }// fin mientras
        } catch (Exception e) {
        }
        return certificado;
    }
    
    public String InsertarCertificado(Connection con, String IdCertificacion, String Nombre, String Descripcion, String Avance, String Estado) {
        String res = "";
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.insertarCertificado());

            p.setString(1, IdCertificacion);
            p.setString(2, Nombre);
            p.setString(3, Descripcion);
            p.setString(4, Avance);
            p.setString(5, Estado);
            p.executeUpdate();
            
        } catch (Exception e) {
            res += "" + e.getMessage() + " Causa :" + e.getCause();
        } 
        return res;
    }
    
    public String eliminarCertificado(Connection con, String IdCertificado) {
        String res = "";
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.eliminarCertificado());
            p.setString(1, IdCertificado);
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
