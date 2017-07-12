package Entidades;

/**
 * @author Jeison González Cifuentes
 */

public class Perfil {
    
    private Integer idPerfil;
    private String nombre;
    private String descripcion;
    private Integer idArea;
    private Integer idPadre;
    private String nombre_padre;
    private String nombre_area;

    public Perfil() {
    }

    public Perfil(Integer idPerfil, String nombre, String descripcion, Integer idArea, Integer idPadre, String nombre_padre, String nombre_area) {
        this.idPerfil = idPerfil;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idArea = idArea;
        this.idPadre = idPadre;
        this.nombre_padre = nombre_padre;
        this.nombre_area = nombre_area;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
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

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public Integer getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Integer idPadre) {
        this.idPadre = idPadre;
    }

    public String getNombre_padre() {
        return nombre_padre;
    }

    public void setNombre_padre(String nombre_padre) {
        this.nombre_padre = nombre_padre;
    }

    public String getNombre_area() {
        return nombre_area;
    }

    public void setNombre_area(String nombre_area) {
        this.nombre_area = nombre_area;
    }

}
