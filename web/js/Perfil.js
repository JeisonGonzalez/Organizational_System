function cargarFormulario(idPerfil,nombre,descripcion,idArea,idPadre){
    $("#idPerfil").val(idPerfil);
    $("#nombre").val(nombre);
    $("#descripcion").val(descripcion);
    if (idArea != "null") {
        $("#idArea").val(idArea);
    } else {
        $("#idArea").val(0);
    }
    if (idPadre != "null") {
        $("#idPadre").val(idPadre);    
    } else {
        $("#idPadre").val(-2);
    }
    $("#modalPerfil").modal();
}