/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function cargarFormulario(id,nombre,clave,correo,perfil,fechaNacimiento){
    $("#codigoUsuario").val(id);
    $("#nombreUsuario").val(nombre);
    $("#claveUsuario").val(clave);
    $("#correoUsuario").val(correo);
    $("#cargoUsuario").val(perfil);
    $("#fechaNacimiento").val(fechaNacimiento);
    $("#modalEmpleado").modal();
}