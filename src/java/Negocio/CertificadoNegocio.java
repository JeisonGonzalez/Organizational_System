package Negocio;

import Entidades.Certificado;
import Persistencia.DaoCertificado;
import Utilidades.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
public class CertificadoNegocio {
    
    public DaoCertificado dao;
    Connection c;
    public CertificadoNegocio() {
        dao = new DaoCertificado();
    }
    
    public List<Certificado> listadoCertificado(){
        try{
        c = new Conexion().getCon();
        return dao.listaCertificado(c);
        }catch(Exception e){
            return null;
        }
    }
    
    public List<Certificado> listadoCertificadoget(String id){
        try{
        c = new Conexion().getCon();
        return dao.listaCertificadoget(c, id);
        }catch(Exception e){
            System.out.println("Excepción al buscar lista : " + e);
            return null;
        }
    }
    
    public Certificado getCertificado(String id){
        try {
        c = new Conexion().getCon();
        return dao.getCertificado(c, id);
        }catch (Exception e) {
            System.out.println("Excepción al buscar lista : " + e);
            return null;
        }
    }
    
    public void insertarCertificado(Certificado IdCertificado){
        try{
        c = new Conexion().getCon();
        String mensajeError = "";
        String IdCertificacion = IdCertificado.getIdCertificacion();
        String Nombre = IdCertificado.getNombre();
        String Descripcion = IdCertificado.getDescripcion();
        String Avance = IdCertificado.getAvance();
        String Estado = IdCertificado.getEstado();
        if ("".equals(IdCertificacion) || null == IdCertificacion) {
            mensajeError += "<br>Debe ingresar un id";
        }
        
        if ("".equals(Nombre) || null == Nombre) {
            mensajeError += "<br>Debe ingresar el nombre";
        }
        if ("".equals(Descripcion) || null == Descripcion) {
            mensajeError += "<br>Debe ingresar una descripción";
        }
        if ("".equals(Avance) || null == Avance) {
            mensajeError += "<br>Debe ingresar el avance";
        }
        if ("".equals(Estado) || null == Estado) {
            mensajeError += "<br>Debe ingresar un estado";
        }
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }
        mensajeError = dao.InsertarCertificado(c, IdCertificacion, Nombre, Descripcion, Avance, Estado);
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }
        }catch(Exception e){
            System.out.println("Excepción al buscar lista : " + e);
        }
    }
    
    public void elimnarCertificado(Certificado IdCertificado){
        try{
        Conexion con = new Conexion();
        String mensajeError = "";
        String IdCertificacion = IdCertificado.getIdCertificacion();
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }
        mensajeError = dao.eliminarCertificado(con.getCon(), IdCertificacion);
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }
        }catch(Exception e){
            System.out.println("Excepción al buscar lista : " + e);
        }
    }
}
