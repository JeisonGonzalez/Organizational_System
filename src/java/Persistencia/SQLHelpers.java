package Persistencia;

public class SQLHelpers {

    //-------------------------------------- Login --------------------------------------

    public static String getValidarIngreso(String correo, String contraseña) {
        return "SELECT id_usuario,nombre,clave,correo FROM usuario WHERE correo = '" + correo + "' AND clave = '" + contraseña + "'";
    }
    
    //-------------------------------------- USUARIO --------------------------------------

}
