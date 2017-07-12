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
    
    //-------------------------------------- ÁREA --------------------------------------
    
    static String guardarArea() {
        return "INSERT INTO area (nombre,descripcion,padre,nombre_padre) VALUES (?, ?, ?, ?)";
    }

    static String actualizarArea() {
        return "UPDATE area SET nombre = ?,descripcion = ?,padre = ?,nombre_padre = ? WHERE idArea = ?";
    }
    
    static String eliminarArea(String idArea) {
        return "DELETE FROM area WHERE idArea = " + idArea;
    }
    
    static String obtenerListadoDeAreas(int idArea, String nombre, String descripcion, int padre, String buscar) {
        String select = "SELECT * FROM area WHERE 1 = 1";
        if (idArea > 0) {            
            select += " AND idArea = " + idArea;
        }
        if (nombre != null && !nombre.isEmpty()) {
            select += " AND nombre = '" + nombre + "'";
        }
        if (descripcion != null && !descripcion.isEmpty()) {
            select += " AND descripcion = '" + descripcion + "'";            
        }
        if (padre > 0) {
            select += " AND padre = " + padre;            
        }
        if (buscar != null && !buscar.isEmpty()) {
            select += " AND ( idArea = " + buscar + " OR nombre = '" + buscar + "' OR descripcion = '" + buscar +"' OR nombre_padre = '" + buscar +"')";  
        }
        return select;
    }
    
    
    //-------------------------------------- Perfil --------------------------------------
    
    
    static String guardarPerfil() {
        return "INSERT INTO perfil (idArea,nombre,descripcion,padre,nombre_padre,nombre_area) VALUES (?, ?, ?, ?, ?, ?)";
    }
    
    static String obtenerListadoDePerfiles(int idPerfil, String nombre, String descripcion, int idArea, int idPadre, String buscar) {
        String select = "SELECT * FROM perfil WHERE 1 = 1";
        if (idPerfil > 0 || idPerfil == -2) {            
            select += " AND idPerfil = " + idPerfil;
        }
        if (nombre != null && !nombre.isEmpty()) {
            select += " AND nombre = '" + nombre + "'";
        }
        if (descripcion != null && !descripcion.isEmpty()) {
            select += " AND descripcion = '" + descripcion + "'";            
        }
        if (idArea > 0) {
            select += " AND idArea = " + idArea;            
        }
        if (idPadre > 0) {
            select += " AND padre = " + idPadre;            
        }
        if (buscar != null && !buscar.isEmpty()) {
            select += " AND ( idPerfil = " + buscar + " OR nombre = '" + buscar + "' OR descripcion = '" + buscar +"')";  
        }
        return select;
    }
 
    static String eliminarPerfil(Integer idPerfil) {
        return "DELETE FROM perfil WHERE idPerfil = " + idPerfil;
    }
    
    static String actualizarPerfil() {
        return "UPDATE perfil SET idArea = ?, nombre = ?,descripcion = ?,padre = ?,nombre_padre = ?, nombre_area = ? WHERE idPerfil = ?";
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
        
    static String getMensajesListBySearch(String param) {
        String select = "SELECT * FROM mensaje WHERE";
        if (param != null && !param.isEmpty()) {
            select += " asunto like '%" + param + "%'";
            select += " OR idMensaje like '%" + param + "%'";
            select += " OR idUsuarioReceptor like '%" + param + "%'";
            select += " OR mensaje like '%" + param + "%'";
        }
        return select;
    }

    static String getMotivacionList(int idMensaje, int idUsuarioEmisor, String idUsuarioReceptor, String asunto, String mensaje) {
        String select = "SELECT * FROM mensaje WHERE 1 = 1";
        if (idMensaje > 0) {
            select += " AND idMensaje = " + idMensaje;
        }
        if (idUsuarioEmisor > 0) {
            select += " AND idUsuarioEmisor = " + idUsuarioEmisor;
        }
        if (idUsuarioReceptor != null && !idUsuarioReceptor.isEmpty()) {
            select += " AND idUsuarioReceptor = '" + idUsuarioReceptor + "'";
        }
        if (asunto != null && !asunto.isEmpty()) {
            select += " AND asunto = '" + asunto + "'";
        }
        if (mensaje != null && !mensaje.isEmpty()) {
            select += " AND mensaje = '" + mensaje + "'";
        }
        return select;
    }

    static String insertMotivacion() {
        return "INSERT INTO mensaje (idUsuarioEmisor, idUsuarioReceptor, asunto, mensaje) VALUES (?,?,?,?)";
    }

    static String deleteMotivacion(Integer idMensaje) {
        return "DELETE FROM mensaje WHERE idMensaje = '" + idMensaje + "'";
    }

    static String updateMotivacion(Integer idMensaje, String idReceptor, String Asunto, String mensajeEnviado) {
        String query = "UPDATE mensaje SET";
                
        Integer countUpdates = 0;
            if (idReceptor != null && !idReceptor.isEmpty()) {
                query += " idUsuarioReceptor = '" + idReceptor + "'";
                countUpdates ++;
            }
            if (Asunto != null && !Asunto.isEmpty()) {
                if (countUpdates > 0) {
                    query += " , asunto = '" + Asunto + "'";
                } else {
                    query += " asunto = '" + Asunto + "'";
                }
                countUpdates++;
            }
            if (mensajeEnviado != null && !mensajeEnviado.isEmpty()) {
                if (countUpdates > 0) {
                    query += " , mensaje = '" + mensajeEnviado + "'";
                } else {
                    query += " mensaje = '" + mensajeEnviado + "'";
                }
                countUpdates++;
            }
            if (countUpdates > 0 && idMensaje != null && idMensaje > 0) {
                query += " WHERE idMensaje = " + idMensaje;
            } else {
                query = "";
            }
        return query;
    }

    static String getIdEmisor(String correo) {
        return "SELECT idUsuario FROM usuario WHERE correo = '" + correo + "'";
    }
}