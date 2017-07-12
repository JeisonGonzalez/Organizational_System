package Entidades;

public class Motivacion {
    int idMensaje;
    String idReceptor;
    String Asunto;
    String Mensaje;
    
    public Motivacion() {
    }
    
    public Motivacion(int idMensaje, String idReceptor, String Asunto, String Mensaje) {
        this.idMensaje = idMensaje;
        this.idReceptor = idReceptor;
        this.Asunto = Asunto;
        this.Mensaje = Mensaje;
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getIdReceptor() {
        return idReceptor;
    }

    public void setIdReceptor(String idReceptor) {
        this.idReceptor = idReceptor;
    }

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String Asunto) {
        this.Asunto = Asunto;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }
    
    
    
}
