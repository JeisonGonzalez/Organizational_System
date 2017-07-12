package Entidades;
public class Capacitaciones {
    String idCapacitacion, idArea, nombre, descripcion, estado, fecha;

    public Capacitaciones() {
    }

    public Capacitaciones(String idCapacitacion, String idArea, String nombre, String descripcion, String estado, String fecha) {
        this.idCapacitacion = idCapacitacion;
        this.idArea = idArea;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha = fecha;
    }

    public String getIdCapacitacion() {
        return idCapacitacion;
    }

    public void setIdCapacitacion(String idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
