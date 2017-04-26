package Negocio;

import Entidades.Usuario;
import Persistencia.DaoIngreso;
import Utilidades.Conexion;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginN {
    public DaoIngreso dao;

    public LoginN() {
        dao = new DaoIngreso();
    }

    public Usuario ValidarIngreso(String correo, String clave) throws SQLException {
        Connection con;
        con = new Conexion().getCon();
        return dao.ValidarIngreso(con, correo, clave);
    }
    
}
