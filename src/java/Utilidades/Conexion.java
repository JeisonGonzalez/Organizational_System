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
                cnx = DriverManager.getConnection("jdbc:mysql://localhost/proyectodesarrollodb", "root", "");
            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return cnx;
    }

//    public static void cerrar() throws SQLException {
//        if (cnx != null) {
//            cnx.close();
//        }
//    }

    public static String main(String[] args) {
        Conexion conectar = new Conexion();
        try {
            ResultSet r = conectar.getCon().prepareStatement(SQLHelpers.getValidarIngreso("checho9991@hotmail.com", "123")).executeQuery();
            if (r.next()) {
                String user = (r.getString(1) + " -> " + r.getString(2) + " -> " + r.getString(3) + " -> " + r.getString(4));
                System.out.println(user);
                return user;
            } else {
                System.out.println("No hay registros");
            }
            return "No se ha podido conectar a la db";
        } catch (Exception e) {
            System.out.println("Exception creando conexión"+ e.getMessage());
        } finally {
        }
        return "No se ha podido conectar a la db";
    }

}
