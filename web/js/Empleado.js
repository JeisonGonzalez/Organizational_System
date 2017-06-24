function cargarFormulario(id,nombre,clave,correo,perfil,fechaNacimiento){
    $("#idUsuario").val(id);
    $("#nombreUsuario").val(nombre);
    $("#claveUsuario").val(clave);
    $("#correoUsuario").val(correo);
    $("#cargoUsuario").val(perfil);
    $("#fechaNacimiento").val(fechaNacimiento);
    $("#modalEmpleado").modal();
}