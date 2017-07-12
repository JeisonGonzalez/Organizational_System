package Persistencia;

import Entidades.Motivacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoMotivacion {
    
     public List<Motivacion> getMotivacionListBySearch(Connection conexion, String param) {
        List<Motivacion> motivacionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) conexion.prepareStatement(SQLHelpers.getMensajesListBySearch(param));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Motivacion motivacion = new Motivacion();
                motivacion.setIdMensaje(resultSet.getInt(1));
                motivacion.setIdReceptor(resultSet.getString(3));
                motivacion.setAsunto(resultSet.getString(4));
                motivacion.setMensaje(resultSet.getString(5));
                motivacionList.add(motivacion);
            }
        } catch (Exception e) {
            System.out.println("Error en DaoMotivacion / getMotivacionBySearch : "+e);
        }
        return motivacionList;
     }
     
     public List<Motivacion> getMotivacionList(Connection conexion, int idMensaje, int idUsuarioEmisor, String idUsuarioReceptor, String asunto, String mensaje) {
        List<Motivacion> motivacionList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) conexion.prepareStatement(SQLHelpers.getMotivacionList(idMensaje,idUsuarioEmisor,idUsuarioReceptor,asunto,mensaje));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Motivacion motivacion = new Motivacion();
                motivacion.setIdMensaje(resultSet.getInt(1));
                motivacion.setIdReceptor(resultSet.getString(3));
                motivacion.setAsunto(resultSet.getString(4));
                motivacion.setMensaje(resultSet.getString(5));
                motivacionList.add(motivacion);
            }
        } catch (Exception e) {
            System.out.println("Error en DaoMotivacion / getMotivacionList : "+e);
        }
        return motivacionList;
    }

    public String insertMotivacion(Connection conexion, String idReceptor, String Asunto, String mensajeEnviado,Integer idEmisor) {
        String mensajes = "";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(SQLHelpers.insertMotivacion());
            preparedStatement.setInt(1, idEmisor);
            preparedStatement.setString(2, idReceptor);
            preparedStatement.setString(3, Asunto);
            preparedStatement.setString(4, mensajeEnviado);
            preparedStatement.execute();
            if (preparedStatement.getUpdateCount() > 0) {
                mensajes = "Mensaje guardado exitosamente.";
            } else {
                mensajes = "El mensaje no pudo ser guardado";
            }
        } catch (Exception e) {
            mensajes += e.getMessage();
        }
        return mensajes;
    }

    public String deleteMotivacion(Connection conexion, Integer idMensaje) {
        String mensajes = "";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(SQLHelpers.deleteMotivacion(idMensaje));
            preparedStatement.execute();
            mensajes = "Mensaje " + idMensaje + " borrado exitosamente";
        } catch (Exception e) {
            mensajes = "El Mensaje no pudo ser borrado";
            System.out.println("Error intentando borrar mensaje en DaoMensaje : " + e);
        }
        return mensajes;
    }

    public String updateMotivacion(Connection conexion, String Asunto, Integer idMensaje, String idReceptor, String mensajeEnviado) {
        String mensajes = "";
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement(SQLHelpers.updateMotivacion(idMensaje,idReceptor,Asunto,mensajeEnviado));
            preparedStatement.execute();
            if (preparedStatement.getUpdateCount() > 0) {
                mensajes = "Mensaje '" + Asunto + "' ha sido modificado exitosamente.";
            } else {
                mensajes = "El mensaje no pudo ser modificado.";
            }
        } catch (Exception e) {
            mensajes += e.getMessage();
        }
        return mensajes;
    }

    public Integer getEmisor(Connection conexion, String correo) throws SQLException {
        int id = 0;
            PreparedStatement preparedStatement = conexion.prepareStatement(SQLHelpers.getIdEmisor(correo));
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            id = resultSet.getInt(1);
//            mensajes = "Mensaje " + idMensaje + " borrado exitosamente";
//            mensajes = "El Mensaje no pudo ser borrado";
        return id;
    }
}
