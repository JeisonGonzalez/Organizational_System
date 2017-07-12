package Negocio;

import Entidades.Areas;
import Persistencia.DaoAreas;
import Utilidades.Conexion;
import Utilidades.ControladorBásico;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Juan
 */
public class AreasNegocio {
    DaoAreas daoArea;
    Connection conexion;
    
    public AreasNegocio (){
        daoArea = new DaoAreas();
    }
    
    public List<Areas> obtenerListadoDeAreas (int idArea, String nombre, String descripcion, int padre, String buscar) {
        try {
            conexion = (Connection) Conexion.getCon();
            return (List<Areas>) daoArea.obtenerListadoDeAreas(conexion, idArea, nombre, descripcion, padre, buscar);
        } catch (Exception e) {
            System.out.println("Excepción al buscar lista de áreas en AreasNegocio.java : " + e);
            return null;
        }
    }

    public Map<String, String> guardarArea(Areas area) {
        Map<String, String> returnMap = new HashMap<>();
        String mensaje = "";
        String success = "success";
        try {
            // Se envían los datos obligatorios al método validarObligatoriedadDatos para que los valide
            Map<String, String> DatosMap = new HashMap<>();
            DatosMap.put("Nombre", area.getNombre());
            DatosMap.put("Descripción", area.getDescripcion());
            DatosMap.put("Padre", area.getArea_Padre());
            if (ControladorBásico.validarObligatoriedadDatos(DatosMap)) {
                conexion = (Connection) Conexion.getCon();
                List <Areas> listadoAreas = daoArea.obtenerListadoDeAreas(conexion, -1, area.getNombre(), null, -1, null);
                if (listadoAreas != null && listadoAreas.size() > 0) {
                    success = "warning";
                    mensaje = "Ya existe un registro con este nombre, por favor ingrese un nombre diferente";
                } else {
                    List <Areas> areaPadre = daoArea.obtenerListadoDeAreas(conexion, Integer.parseInt(area.getArea_Padre()), null, null, -1, null);
                    if (areaPadre != null && areaPadre.size() > 0 && areaPadre.get(0).getNombre() != null) {
                        area.setNombre_Padre(areaPadre.get(0).getNombre());
                    } else {
                        area.setNombre_Padre("Sin padre asignado");
                    }
                    daoArea.guardarArea(conexion,area);
                    mensaje = "El área '" + area.getNombre() + "' ha sido ingresada correctamente";   
                }
            } else {
                success = "danger";
                mensaje = "Los campos marcados con '*' son obligarorios";               
            }
        } catch (SQLException e) {
            success = "danger";
            mensaje = "Ha ocurrido un error interno , por favor contacte a soporte técnico.";
            System.out.println("Excepción al ingresar el área en AreasNegocio.java : " + e);
        } 
        returnMap.put("mensaje", mensaje);
        returnMap.put("success", success);
        return returnMap;
    }
    
    public Map<String, String> actualizarArea(Areas area) {
        Map<String, String> returnMap = new HashMap<>();
        String mensaje = "";
        String success = "success";
        try {
            // Se envían los datos obligatorios al método validarObligatoriedadDatos para que los valide
            Map<String, String> DatosMap = new HashMap<>();
            DatosMap.put("Código interno", area.getIdArea());
            DatosMap.put("Nombre", area.getNombre());
            DatosMap.put("Descripción", area.getDescripcion());
            DatosMap.put("Padre", area.getArea_Padre());
            if (!area.getArea_Padre().equals(area.getIdArea())) {
                if (ControladorBásico.validarObligatoriedadDatos(DatosMap)) {
                    conexion = (Connection) Conexion.getCon();
                    List <Areas> listadoAreas = daoArea.obtenerListadoDeAreas(conexion, -1, area.getNombre(), null, -1, null);
                    if (listadoAreas != null && listadoAreas.size() > 0 && !listadoAreas.get(0).getIdArea().equals(area.getIdArea())) {
                        success = "warning";
                        mensaje = "Ya existe un registro con este nombre, por favor ingrese un nombre diferente";
                    } else {
                        List <Areas> areaPadre = daoArea.obtenerListadoDeAreas(conexion, Integer.parseInt(area.getArea_Padre()), null, null, -1, null);
                        if (areaPadre != null && areaPadre.size() > 0 && areaPadre.get(0).getArea_Padre() != null && areaPadre.get(0).getArea_Padre().equals(area.getIdArea())) {
                            success = "danger";
                            mensaje = "Error de jerarquía , por favor verificar el área padre que intenta seleccionar"; 
                        } else {   
                            if (areaPadre != null && areaPadre.size() > 0 && areaPadre.get(0).getNombre() != null) {
                                area.setNombre_Padre(areaPadre.get(0).getNombre());
                            } else {
                                area.setNombre_Padre("Sin padre asignado");
                            }
                            daoArea.actualizarArea(conexion,area);
                            mensaje = "El área '" + area.getNombre() + "' ha sido actualizada correctamente";
                        }
                    }
                } else {
                    success = "danger";
                    mensaje = "Los campos marcados con '*' son obligarorios";               
                }
            } else {
                success = "warning";
                mensaje = "Un área no puede ser padre de sí misma";
            }
        } catch (SQLException e) {
            success = "danger";
            mensaje = "Ha ocurrido un error inesperado , por favor comuniquese con soporte técnico.";    
            System.out.println("Excepción al actualizar el área en AreasNegocio.java : " + e);
        }
        returnMap.put("mensaje", mensaje);
        returnMap.put("success", success);
        return returnMap;
    }
    
    public Map<String, String> setEliminar(String IdArea) {
        Map<String, String> returnMap = new HashMap<>();
        String mensaje = "";
        String success = "success";
        try {
            Map<String, String> DatosMap = new HashMap<>();
            DatosMap.put("Código interno", IdArea);
            if (ControladorBásico.validarObligatoriedadDatos(DatosMap)) {
                conexion = (Connection) Conexion.getCon();
                List <Areas> areasHijas = daoArea.obtenerListadoDeAreas(conexion, -1, null, null, Integer.parseInt(IdArea), null);
                if (areasHijas != null && areasHijas.size() > 0) {
                    success = "warning";
                    mensaje = "El área con código interno '" + IdArea + "' no se puede eliminar porque es padre de otra(s)";
                } else {
                    daoArea.eliminarArea(conexion,IdArea);
                    mensaje = "El área con código interno '" + IdArea + "' ha sido eliminada correctamente";
                }
            } else {
                success = "danger";
                mensaje = "Los campos marcados con '*' son obligarorios";               
            }
        } catch (SQLException e) {
            success = "danger";
            mensaje = "Ha ocurrido un error inesperado , por favor comuniquese con soporte técnico.";
            System.out.println("Excepción al eliminar el área " + IdArea + "en AreasNegocio.java : " + e);
        }
        returnMap.put("mensaje", mensaje);
        returnMap.put("success", success);
        return returnMap;
    }
    
}
