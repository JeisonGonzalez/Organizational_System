package Entidades;
public class Usuarios {
    
    String idUsuario;
    String nombre;
    String clave;
    String correo;
    String idPerfil;

    public Usuarios() {
    }

    public Usuarios(String idUsuario, String nombre, String clave, String correo, String idPerfil) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.clave = clave;
        this.correo = correo;
        this.idPerfil = idPerfil;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }
    
    
    
}
