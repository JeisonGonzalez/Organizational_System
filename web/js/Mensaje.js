function cargarFormulario(id,receptor,asunto,mensaje){
    $("#idMensaje").val(id);
    $("#UsuarioR").val(receptor);
    $("#Asunto").val(asunto);
    $("#Mensaje").val(mensaje);
    $("#modalMotivacion").modal();
}