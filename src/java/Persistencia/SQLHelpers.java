package Persistencia;

public class SQLHelpers {

    //-------------------------------------- Login --------------------------------------

    public static String getValidarIngreso(String correo, String clave) {
        return "SELECT * FROM usuario WHERE correo = '" + correo + "' AND clave = '" + clave + "'";
    }
    
    //-------------------------------------- USUARIO --------------------------------------
    public static String getUserList(){
        return "SELECT * FROM usuario";
    }

    public static String getUserById(int idUsuario){
        return "SELECT * FROM usuario where idUsuario = " + idUsuario;
    }
    
    public static String updateUser (int idUsuario){
        return "UPDATE usuario SET nombre=?, clave=?, correo=?, idPerfil=? WHERE idUsuario = " + idUsuario;
    }

    public static String insertUser() {
        return "INSERT INTO usuario (nombre, clave, correo, idPerfil) VALUES (?,?,?,?)";
    }

    public static String deleteUser(int idUsuario) {
        return "DELETE FROM usuario WHERE idUsuario = '" + idUsuario + "'";
    }
}
