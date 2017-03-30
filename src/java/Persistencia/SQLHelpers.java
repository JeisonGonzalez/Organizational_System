package Persistencia;

public class SQLHelpers {

    //-------------------------------------- USUARIO --------------------------------------

    public static String getValidarIngreso(String correo, String contraseña) {
        return "SELECT id_usuario,nombre,contraseña,correo FROM usuario WHERE correo = '" + correo + "' AND contraseña = '" + contraseña + "'";
    }

}
