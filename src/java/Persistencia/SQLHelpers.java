package Persistencia;

public class SQLHelpers {

    //-------------------------------------- Login --------------------------------------

    public static String getValidarIngreso(String correo, String contraseña) {
        return "SELECT id_usuario,nombre,clave,correo FROM usuario WHERE correo = '" + correo + "' AND clave = '" + contraseña + "'";
    }
    
    //-------------------------------------- USUARIO --------------------------------------
    public static String getUserList(){
        return "SELECT * FROM usuario";
    }

    public static String getUserById(int idUsuario){
        return "SELECT * FROM usuario where idUsuario = " + idUsuario;
    }
    
    public static String updateUser (int idUsuario){
        return "UPDATE usuario SET idUsuario=?, nombre=?, clave=?, correo=?, idPerfil WHERE idUsuario = " + idUsuario;
    }

    public static String insertUser() {
        return "INSERT INTO usuario (nombre, clave, correo, idPerfil) VALUES (?,?,?,?)";
    }

    public static String deleteUsuario(int idUsuario) {
        return "DELETE FROM usuario WHERE idUsuario = '" + idUsuario + "'";
    }
}
