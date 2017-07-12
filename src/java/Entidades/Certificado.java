package Entidades;
public class Certificado {
    
    String idCertificacion;
    String nombre;
    String descripcion;
    String avance;
    String estado;

    public Certificado() {
    }

    public Certificado(String idCertificacion, String nombre, String descripcion, String avance, String estado) {
        this.idCertificacion = idCertificacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.avance = avance;
        this.estado = estado;
    }

    public String getIdCertificacion() {
        return idCertificacion;
    }

    public void setIdCertificacion(String idCertificacion) {
        this.idCertificacion = idCertificacion;
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

    public String getAvance() {
        return avance;
    }

    public void setAvance(String avance) {
        this.avance = avance;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
     
}
