package Utilidades;

import java.util.Map;

/**
 * @author Jeison
 */
public class ControladorBásico {
    public static Boolean validarObligatoriedadDatos (Map<String, String> datosParaValidar){
        return datosParaValidar.entrySet().stream().noneMatch((entrySet) -> (entrySet.getValue() == null || entrySet.getValue().isEmpty() || entrySet.getValue().equalsIgnoreCase("0")));
    }
}
