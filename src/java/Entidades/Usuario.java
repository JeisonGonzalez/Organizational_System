package Entidades;

public class Usuario {
    
    int idUsuario;
    String nombre;
    String clave;
    String correo;
    int idPerfil;
    int inSession;
    String fechaNacimiento;
    String imagenPerfil;
    
    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String clave, String correo, int idPerfil, int inSession, String fechaNacimiento, String imagenPerfil) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.clave = clave;
        this.correo = correo;
        this.idPerfil = idPerfil;
        this.inSession = inSession;
        this.fechaNacimiento = fechaNacimiento;
        this.imagenPerfil = imagenPerfil;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
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

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public int getInSession() {
        return inSession;
    }

    public void setInSession(int inSession) {
        this.inSession = inSession;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

}
