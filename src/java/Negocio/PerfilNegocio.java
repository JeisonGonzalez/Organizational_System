package Negocio;

import Entidades.Areas;
import Entidades.Perfil;
import Persistencia.DaoAreas;
import Persistencia.DaoPerfil;
import Utilidades.Conexion;
import Utilidades.ControladorBásico;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Jeison González Cifuentes
 */

public class PerfilNegocio {
    DaoPerfil daoPerfil;
    DaoAreas daoArea;
    Connection conexion;
    
    public PerfilNegocio (){
        daoPerfil = new DaoPerfil();
        daoArea = new DaoAreas();
    }
    
    public List<Perfil> obtenerListadoDePerfiles (int idPerfil, String nombre, String descripcion, int idArea, int idPadre, String buscar) {
        try {
            conexion = (Connection) Conexion.getCon();
            return (List<Perfil>) daoPerfil.obtenerListadoDePerfiles(conexion, idPerfil, nombre, descripcion, idArea, idPadre, buscar);
        } catch (Exception e) {
            System.out.println("Excepción al buscar lista de perfiles en PerfilNegocio.java : " + e);
            return null;
        }
    }

    public Map<String, String> guardarPerfil(Perfil perfil) {
        Map<String, String> returnMap = new HashMap<>();
        String mensaje = "";
        String success = "success";
        try {
            // Se envían los datos obligatorios al método validarObligatoriedadDatos para que los valide
            Map<String, String> DatosMap = new HashMap<>();
            DatosMap.put("Nombre", perfil.getNombre());
            DatosMap.put("Descripción", perfil.getDescripcion());
            DatosMap.put("Area", perfil.getIdArea()!=null?perfil.getIdArea().toString():"0");
            if (ControladorBásico.validarObligatoriedadDatos(DatosMap)) {
                conexion = (Connection) Conexion.getCon();
                List <Perfil> listadoAreas = daoPerfil.obtenerListadoDePerfiles(conexion, -1, perfil.getNombre(), null, -1, -1, null);
                if (listadoAreas != null && listadoAreas.size() > 0) {
                    success = "warning";
                    mensaje = "Ya existe un registro con este nombre, por favor ingrese un nombre diferente";
                } else {
                    List <Perfil> perfilPadre = daoPerfil.obtenerListadoDePerfiles(conexion, perfil.getIdPadre(), null, null, -1, -1, null);
                    if (perfilPadre != null && perfilPadre.size() > 0 && perfilPadre.get(0).getNombre() != null) {
                        perfil.setNombre_padre(perfilPadre.get(0).getNombre());
                    } else {
                        perfil.setNombre_padre("Sin padre asignado");
                    }
                    List <Areas> areaPadre = daoArea.obtenerListadoDeAreas(conexion, perfil.getIdArea(), null, null, -1, null);
                    if (areaPadre != null && areaPadre.size() > 0 && areaPadre.get(0).getNombre() != null) {
                        perfil.setNombre_area(areaPadre.get(0).getNombre());
                    } else {
                        perfil.setNombre_area("Sin área asignada");
                    }
                    daoPerfil.guardarPerfil(conexion,perfil);
                    mensaje = "El perfil '" + perfil.getNombre() + "' ha sido ingresado correctamente";   
                }
            } else {
                success = "danger";
                mensaje = "Los campos marcados con '*' son obligarorios";               
            }
        } catch (SQLException e) {
            success = "danger";
            mensaje = "Ha ocurrido un error interno , por favor contacte a soporte técnico.";
            System.out.println("Excepción al ingresar el perfil en PerfilNegocio.java : " + e);
        } 
        returnMap.put("mensaje", mensaje);
        returnMap.put("success", success);
        return returnMap;
    }
    
    public Map<String, String> actualizarPerfil(Perfil perfil) {
        Map<String, String> returnMap = new HashMap<>();
        String mensaje = "";
        String success = "success";
        try {
            // Se envían los datos obligatorios al método validarObligatoriedadDatos para que los valide
            Map<String, String> DatosMap = new HashMap<>();
            DatosMap.put("Código interno", perfil.getIdPerfil()!=null?perfil.getIdPerfil().toString():"0");
            DatosMap.put("Nombre", perfil.getNombre());
            DatosMap.put("Descripción", perfil.getDescripcion());
            DatosMap.put("Area", perfil.getIdArea()!=null?perfil.getIdArea().toString():"0");
            if (!Objects.equals(perfil.getIdPadre(), perfil.getIdPerfil())) {
                if (ControladorBásico.validarObligatoriedadDatos(DatosMap)) {
                    conexion = (Connection) Conexion.getCon();
                    List <Perfil> listadoPerfil = daoPerfil.obtenerListadoDePerfiles(conexion, -1, perfil.getNombre(), perfil.getDescripcion(), perfil.getIdArea(), perfil.getIdPadre(), null);
                    if (listadoPerfil != null && listadoPerfil.size() > 0 && !listadoPerfil.get(0).getIdPerfil().equals(perfil.getIdPerfil())) {
                        success = "warning";
                        mensaje = "Ya existe un registro con este nombre, por favor ingrese un nombre diferente";
                    } else {
                        listadoPerfil = daoPerfil.obtenerListadoDePerfiles(conexion, perfil.getIdPadre(), null, null, -1, -1, null);
                        if (perfil.getIdPadre() != 0 && listadoPerfil != null && listadoPerfil.size() > 0 && listadoPerfil.get(0).getIdPerfil()!= null && Objects.equals(listadoPerfil.get(0).getIdPerfil(), perfil.getIdPerfil())) {
                            success = "danger";
                            mensaje = "Error de jerarquía , por favor verificar el perfil padre que intenta seleccionar"; 
                        } else {   
                            List <Perfil> perfilPadre = daoPerfil.obtenerListadoDePerfiles(conexion, perfil.getIdPadre(), null, null, -1, -1, null);
                            if (listadoPerfil != null && listadoPerfil.size() > 0 && listadoPerfil.get(0).getNombre() != null) {
                                perfil.setNombre_padre(listadoPerfil.get(0).getNombre());
                            } else {
                                perfil.setNombre_padre("Sin padre asignado");
                            }
                            List <Areas> areaPadre = daoArea.obtenerListadoDeAreas(conexion, perfil.getIdArea(), null, null, -1, null);
                            if (areaPadre != null && areaPadre.size() > 0 && areaPadre.get(0).getNombre() != null) {
                                perfil.setNombre_area(areaPadre.get(0).getNombre());
                            } else {
                                perfil.setNombre_area("Sin área seleccionada");
                            }
                            daoPerfil.actualizarPerfil(conexion,perfil);
                            mensaje = "El perfil '" + perfil.getNombre() + "' ha sido actualizado correctamente";
                        }
                    }
                } else {
                    success = "danger";
                    mensaje = "Los campos marcados con '*' son obligarorios";               
                }
            } else {
                success = "warning";
                mensaje = "Un perfil no puede ser padre de sí mismo";
            }
        } catch (SQLException e) {
            success = "danger";
            mensaje = "Ha ocurrido un error inesperado , por favor comuniquese con soporte técnico.";    
            System.out.println("Excepción al actualizar el perfil en PerfilNegocio.java : " + e);
        }
        returnMap.put("mensaje", mensaje);
        returnMap.put("success", success);
        return returnMap;
    }
    
    public Map<String, String> eliminarPerfil(Integer idPerfil) {
        Map<String, String> returnMap = new HashMap<>();
        String mensaje = "";
        String success = "success";
        try {
            Map<String, String> DatosMap = new HashMap<>();
            DatosMap.put("Código interno", idPerfil != null ? idPerfil.toString() : "0");
            if (ControladorBásico.validarObligatoriedadDatos(DatosMap)) {
                conexion = (Connection) Conexion.getCon();
                List <Perfil> perfilesHijos = daoPerfil.obtenerListadoDePerfiles(conexion, -1, null, null, -1, idPerfil, null);
                if (perfilesHijos != null && perfilesHijos.size() > 0) {
                    success = "warning";
                    mensaje = "El perfil con código interno '" + idPerfil + "' no se puede eliminar porque es padre de otro(s)";
                } else {
                    daoPerfil.eliminarPerfil(conexion,idPerfil);
                    mensaje = "El perfil con código interno '" + idPerfil + "' ha sido eliminado correctamente";
                }
            } else {
                success = "danger";
                mensaje = "Los campos marcados con '*' son obligarorios";               
            }
        } catch (SQLException e) {
            success = "danger";
            mensaje = "Ha ocurrido un error inesperado , por favor comuniquese con soporte técnico.";
            System.out.println("Excepción al eliminar el perfíl " + idPerfil + "en PerfilNegocio.java : " + e);
        }
        returnMap.put("mensaje", mensaje);
        returnMap.put("success", success);
        return returnMap;
    }

}
