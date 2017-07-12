package Persistencia;

import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

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
    
    public static String getUserListBySearch(String param){
        String select = "SELECT * FROM usuario WHERE";
        if (param != null && !param.isEmpty()) {
            select += " nombre like '%" + param + "%'";
            select += " OR correo like '%" + param + "%'";
            select += " OR idPerfil like '%" + param + "%'";
        }
        return select;
    }
    
    public static String getUserByLogin (String clave, String correo){
        return "SELECT COUNT(*) FROM usuario WHERE clave = '" + clave + "' AND correo = '" + correo + "'";
    }
    
    public static String updateUser (Integer idUsuario, String nombre, String clave, String correo, Integer idPerfil, String fechaNacimiento, String imagenPerfil) {
        String query = "UPDATE usuario SET";
        Integer countUpdates = 0;
            if (nombre != null && !nombre.isEmpty()) {
                query += " nombre = '" + nombre + "'";
                countUpdates ++;
            }
            if (clave != null && !clave.isEmpty()) {
                if (countUpdates > 0) {
                    query += " , clave = '" + clave + "'";
                } else {
                    query += " clave = '" + clave + "'";
                }
                countUpdates++;
            }
            if (correo != null && !correo.isEmpty()) {
                if (countUpdates > 0) {
                    query += " , correo = '" + correo + "'";
                } else {
                    query += " correo = '" + correo + "'";
                }
                countUpdates++;
            }
            if (idPerfil != null && idPerfil > 0) {
                if (countUpdates > 0) {
                    query += " , idPerfil = " + idPerfil;
                } else {
                    query += " idPerfil = " + idPerfil;
                }
                countUpdates++;
            }
            if (fechaNacimiento != null && !fechaNacimiento.isEmpty()) {
                if (countUpdates > 0) {
                query += " , fechaNacimiento = '" + fechaNacimiento + "'";
                } else {
                    query += " fechaNacimiento = '" + fechaNacimiento + "'";
                }
                countUpdates++;
            }
            if (imagenPerfil != null && !imagenPerfil.isEmpty()) {
                if (countUpdates > 0) {
                    query += " , imagenPerfil = '" + imagenPerfil + "'";
                } else {
                    query += " imagenPerfil = '" + imagenPerfil + "'";
                }
                countUpdates++;
            }
            if (countUpdates > 0 && idUsuario != null && idUsuario > 0) {
                query += " WHERE idUsuario = " + idUsuario;
            } else {
                query = "";
            }
        return query;
    }

    public static String insertUser() {
        return "INSERT INTO usuario (nombre, clave, correo,idPerfil,inSession,fechaNacimiento,imagenPerfil) VALUES (?,?,?,?,?,?,?)";
    }

    public static String deleteUser(int idUsuario) {
        return "DELETE FROM usuario WHERE idUsuario = '" + idUsuario + "'";
    }
    
    //-------------------------------------- AREA --------------------------------------
    
    static String setArea() {
        return "INSERT INTO AREA (idArea,nombre,descripcion,padre) VALUES (?, ?, ?, ?)";
    }

    static String setEliminarArea() {
        return "Delete from AREA where  idArea =?";
    }
    
    static String getAreasList(int idArea, String nombre, String descripcion, int padre, String buscar) {
        String select = "SELECT * FROM area WHERE 1 = 1";
        if (idArea > 0) {            
            select += " AND idArea = " + idArea;
        }
        if (nombre != null && !nombre.isEmpty()) {
            select += " AND nombre" + nombre;
        }
        if (descripcion != null && !descripcion.isEmpty()) {
            select += " AND descripcion = " + descripcion;            
        }
        if (padre > 0) {
            select += " AND padre = " + padre;            
        }
        if (buscar != null && !buscar.isEmpty()) {
            //buscar = "'" + buscar + "'";
            buscar = buscar + "'";
            buscar = "'" + buscar;
            select += " AND ( idArea = " + buscar + " OR nombre = " + buscar + " OR descripcion = " + buscar +" OR padre = " + buscar +")";  
        }
        return select;
    }

    static String getListAP() {
        return "select padre from area";
    }
    //-------------------------------------- Certificado --------------------------------------
    
    public static String getCertificado() {
        return "SELECT  idCertificacion,nombre,descripcion,avance,estado"
                + " FROM certificacion";
    }
    
    public static String getCertificado(String id) {
        int busc = Integer.parseInt(id);
        return "SELECT  idCertificacion,nombre,descripcion,avance,estado"
                + " FROM certificacion where idCertificacion ='" + busc + "' ";
    }
    
    public static String getCertificadoget(String id) {
        int busc = Integer.parseInt(id);
        return "SELECT *"
                + " FROM certificacion where idCertificacion ='" + busc + "' ";
    }
    
    public static String insertarCertificado() {
        return "INSERT INTO certificacion(idCertificacion,nombre,descripcion,avance,estado)"
                + "values(?,?,?,?,?)";
    }
    
    public static String eliminarCertificado() {
        return "DELETE FROM certificacion"
                + " WHERE idCertificacion=?";
    }
    
    
    //-------------------------Capacitaciones----------------------
    public static String getCapacitacion() {
        return "SELECT  idCapacitacion,idArea,nombre,descripcion,estado,fecha"
                + " FROM capacitacion";
    }
    
    public static String getCapacitacion(String id) {
        int busc = Integer.parseInt(id);
        return "SELECT  idCapacitacion,idArea,nombre,descripcion,estado,fecha FROM capacitacion where idCapacitacion ='" + busc + "' ";
    }
    
    public static String getCapacitacionget(String id) {
        int busc = Integer.parseInt(id);
        return "SELECT idCapacitacion,idArea,nombre,descripcion,estado,fecha FROM capacitacion where idCapacitacion ='" + busc + "' ";
    }
    
    public static String insertarCapacitacion() {
        return "INSERT INTO capacitacion(idCapacitacion,idArea,nombre,descripcion,estado,fecha)"
                + "values(?,?,?,?,?,?)";
    }
    
    public static String eliminarCapacitacion() {
        return "DELETE FROM capacitacion"
                + " WHERE idCapacitacion=?";
    }
}
