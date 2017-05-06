package Utilidades;

import Persistencia.SQLHelpers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

    private static Connection cnx = null;

    public static Connection getCon() throws SQLException {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost/organizationalsystemdb", "root", "");
            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return cnx;
    }
    
    public static void main(String[] args) {
        try {
            System.out.println("-------------------------- Creando conexión a DB : --------------------------");
            System.out.println();
            ResultSet resulSet = Conexion.getCon().prepareStatement(SQLHelpers.getUserList(-1, null, null, null, -1, -1, null, null)).executeQuery();
            if (resulSet.next()) {
                System.out.println("CONEXIÓN ESTABLECIDA CORRECTAMENTE");
                System.out.println("");
                System.out.println("");
            } else {
                System.out.println("No hay registros o no se ha conectado correctamente a la DB");
            }
        } catch (Exception e) {
            System.out.println("Exception creando conexión"+ e.getMessage());
        }
    }

}
