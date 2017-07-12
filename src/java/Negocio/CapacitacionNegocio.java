package Negocio;

import Entidades.Capacitaciones;
import Persistencia.DaoCapacitacion;
import Utilidades.Conexion;
import java.sql.Connection;
import java.util.List;

public class CapacitacionNegocio {
    
    public DaoCapacitacion dao;
    Connection c;
    public CapacitacionNegocio() {
        dao = new DaoCapacitacion();
    }
    
    public List<Capacitaciones> listadoCertificado(){
        try{
        c = new Conexion().getCon();
        return dao.listaCapacitacion(c);
        }catch(Exception e){
            return null;
        }
    }
    
    public List<Capacitaciones> listadoCapacitacionesGet(String id){
        try{
        c = new Conexion().getCon();
        return dao.listaCapacitacionget(c, id);
        }catch(Exception e){
            System.out.println("Excepción al buscar lista : " + e);
            return null;
        }
    }
    
    public Capacitaciones getCapacitacion(String id){
        try {
        c = new Conexion().getCon();
        return dao.getCapacitacion(c, id);
        }catch (Exception e) {
            System.out.println("Excepción al buscar lista : " + e);
            return null;
        }
    }
    
    public void insertarCapacitacion(Capacitaciones Id){
        try{
        c = new Conexion().getCon();
        String mensajeError = "";
        String IdCapacitacion = Id.getIdCapacitacion();
        String IdArea = Id.getIdArea();
        String Nombre = Id.getNombre();
        String Descripcion = Id.getDescripcion();
        String Estado = Id.getEstado();
        String Fecha = Id.getFecha();
        if ("".equals(IdCapacitacion) || null == IdCapacitacion) {
            mensajeError += "<br>Debe ingresar un id";
        }
        if ("".equals(IdArea) || null == IdArea) {
            mensajeError += "<br>Debe ingresar un area";
        }
        
        if ("".equals(Nombre) || null == Nombre) {
            mensajeError += "<br>Debe ingresar el nombre";
        }
        if ("".equals(Descripcion) || null == Descripcion) {
            mensajeError += "<br>Debe ingresar una descripción";
        }
        if ("".equals(Estado) || null == Estado) {
            mensajeError += "<br>Debe ingresar un estado";
        }
        if ("".equals(Fecha) || null == Fecha) {
            mensajeError += "<br>Debe ingresar una fecha";
        }
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }
        mensajeError = dao.InsertarCapacitacion(c, IdCapacitacion, IdArea, Nombre, Descripcion, Estado, Fecha);
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }
        }catch(Exception e){
            System.out.println("Excepción al buscar lista : " + e);
        }
    }
    
    public void elimnarCapacitacion(Capacitaciones Id){
        try{
        Conexion con = new Conexion();
        String mensajeError = "";
        String IdCapacitacion = Id.getIdCapacitacion();
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }
        mensajeError = dao.eliminarCapacitacion(con.getCon(), IdCapacitacion);
        if (!"".equals(mensajeError)) {
            throw new Exception(mensajeError);
        }
        }catch(Exception e){
            System.out.println("Excepción al buscar lista : " + e);
        }
    }
}
