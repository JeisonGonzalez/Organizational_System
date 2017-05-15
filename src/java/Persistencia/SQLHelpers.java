package Persistencia;

public class SQLHelpers {

    //-------------------------------------- Login --------------------------------------

    public static String getValidarIngreso(String correo, String clave) {
        return "SELECT * FROM usuario WHERE correo = '" + correo + "' AND clave = '" + clave + "'";
    }
    
    //-------------------------------------- USUARIO --------------------------------------
    public static String getUserList(int idUsuario, String nombre, String clave, String correo, int idPerfil, int inSession, String fechaNacimiento, String imagenPerfil){
        String select = "SELECT * FROM usuario WHERE 1 = 1";
        if (idUsuario > 0) {
            select += " AND idUsuario = " + idUsuario;
        }
        if (nombre != null && !nombre.isEmpty()) {
            select += " AND nombre = '" + nombre + "'";
        }
        if (clave != null && !clave.isEmpty()) {
            select += " AND clave = '" + clave + "'";
        }
        if (correo != null && !correo.isEmpty()) {
            select += " AND correo = '" + correo + "'";
        }
        if (idPerfil > 0) {
            select += " AND idPerfil = " + idPerfil;
        }
        if (inSession > 0) {
            select += " AND inSession = " + inSession;
        }
        if (fechaNacimiento != null && !fechaNacimiento.isEmpty()) {
            select += " AND fechaNacimiento = '" + fechaNacimiento + "'";
        }
        if (imagenPerfil != null && !imagenPerfil.isEmpty()) {
            select += " AND imagenPerfil = '" + imagenPerfil + "'";
        }
        return select;
    }
    
    public static String getUserByLogin (String clave, String correo){
        return "SELECT COUNT(*) FROM usuario WHERE clave = '" + clave + "' AND correo = '" + correo + "'";
    }
    
    public static String updateUser (int idUsuario){
        return "UPDATE usuario SET nombre=?, clave=?, correo=?, idPerfil=? WHERE idUsuario = " + idUsuario;
    }

    public static String insertUser() {
        return "INSERT INTO usuario (nombre, clave, correo,idPerfil,inSession,fechaNacimiento,imagenPerfil) VALUES (?,?,?,?,?,?,?)";
    }

    public static String deleteUser(int idUsuario) {
        return "DELETE FROM usuario WHERE idUsuario = '" + idUsuario + "'";
    }
}
