package Negocio;

import Entidades.Motivacion;
import Persistencia.DaoMotivacion;
import Utilidades.Conexion;
import com.mysql.jdbc.Connection;
import java.sql.SQLException;
import java.util.List;

public class MotivacionNegocio {
    DaoMotivacion daoMotivacion;
    Connection conexion;

    public MotivacionNegocio() {
        daoMotivacion = new DaoMotivacion();
    }

    public List<Motivacion> getMotivacionListBySearch(String param) {
        try {
            conexion = (Connection) Conexion.getCon();
            return (List<Motivacion>) daoMotivacion.getMotivacionListBySearch(conexion, param);
        } catch (Exception e) {
            System.out.println("Excepción al buscar lista de mensajes en MotivacionNegocio.java > getMotivacionListBySearch : " + e);
            return null;
        }
    }

    public Object getMensajesList(int idMensaje, int idUsuarioEmisor, String idUsuarioReceptor, String asunto, String mensaje) {
       try {
            conexion = (Connection) Conexion.getCon();
            return (List<Motivacion>) daoMotivacion.getMotivacionList(conexion, idMensaje, idUsuarioEmisor, idUsuarioReceptor, asunto, mensaje);
        } catch (Exception e) {
            System.out.println("Excepción al buscar lista de Mensajes en MotivaciónNegocio.java : " + e);
            return null;
        }
    }


    public String insertMotivacion(String idReceptor, String Asunto, String mensajeEnviado, Integer idEmisor) {
        String mensajes = "";
        
        if (idReceptor == null || idReceptor.isEmpty()) {
            mensajes += "<br> Debe ingresar un nombre para el usuario";
        }
        if (Asunto == null || Asunto.isEmpty()) {
            mensajes += "<br> Debe ingresar un correo para contactar al usuario";
        }
        
        if (mensajeEnviado == null || mensajeEnviado.isEmpty()) {
            mensajes += "<br> Debe ingresar un perfil el usuario";            
        }
        
        if (mensajes.isEmpty()) {
            try {
                conexion = (Connection) Conexion.getCon();
                mensajes = daoMotivacion.insertMotivacion(conexion, idReceptor, Asunto, mensajeEnviado, idEmisor );
            } catch (Exception e) {
                System.out.println("Error insertando el mensaje en insertMotivación de MotivacionNegocio.java : " + e);
            }
        }
        return mensajes;
    }

    public String deleteMotivacion(Integer idMensaje) throws SQLException {
        conexion = (Connection) Conexion.getCon();
        return daoMotivacion.deleteMotivacion(conexion, idMensaje);
    }

    public String updateMotivacion(Integer idMensaje, String idReceptor, String Asunto, String mensajeEnviado) {
        String mensajes = "";
        
        if (idMensaje == null || idMensaje <= 0) {
            mensajes += "<br> Debe ingresar la identificación del mensaje";
        }
        
        if (idReceptor == null || idReceptor.isEmpty()) {
            mensajes += "<br> Debe ingresar las id Receptor";
        }

        if (Asunto == null || Asunto.isEmpty()) {
            mensajes += "<br> Debe ingresar un Asunto para el mensaje";
        }

        if (mensajeEnviado == null || mensajeEnviado.isEmpty()) {
            mensajes += "<br> Debe ingresar el cuerpo del mensaje";
        }
        
        if (mensajes.isEmpty()) {
            try {
                conexion = (Connection) Conexion.getCon();
                mensajes = daoMotivacion.updateMotivacion(conexion,Asunto,idMensaje,idReceptor,mensajeEnviado);
            } catch (Exception e) {
                System.out.println("Error modificando el usuario en updateUser de UsuarioNegocio.java : " + e);
            }
        }
        return mensajes;
    }

    public Integer getidEmisor(String correo) throws SQLException {
        conexion = (Connection) Conexion.getCon();
        return daoMotivacion.getEmisor(conexion, correo);
    }
    
    
}
