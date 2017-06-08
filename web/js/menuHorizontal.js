/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function init () {
    cargarDatosUsuario ();
}

function cargarDatosUsuario() {
    $.ajax({
        url: "/MenuHorizontalServlet",
        type: "POST",
        success: function(){
        // Se ejecuta cuando se ha recibido correctamente
        // los datos de la url
        },
        error: function(){
        // Se ejecuta cuando es imposible obtener
        // los datos de la url
        },
        async: false, // La petición es síncrona
        cache: false // No queremos usar la caché del navegador
    });
}