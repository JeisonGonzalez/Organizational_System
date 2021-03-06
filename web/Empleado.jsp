<%-- 
    Document   : Empleado
    Created on : 26/03/2017, 10:13:50 AM
    Author     : Jeison
--%>

<%@page import="java.util.List"%>
<%@page import="Entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
//  Se obtienen datos provenientes del servlet y se guardan en variables para ser usadas en la JSP.
    String nombreUsuario = request.getAttribute("nombreUsuario") != null ? request.getAttribute("nombreUsuario").toString() : null;
    String cargoUsuario = request.getAttribute("cargoUsuario") != null ? request.getAttribute("cargoUsuario").toString() : null;
    String fechaNacimiento = request.getAttribute("fechaNacimiento") != null ? request.getAttribute("fechaNacimiento").toString() : null;
    String correoUsuario = request.getAttribute("correoUsuario") != null ? request.getAttribute("correoUsuario").toString() : null;
    String mensajes = request.getAttribute("mensajes") != null ? request.getAttribute("mensajes").toString() : null;
    String claveUsuario = request.getAttribute("claveUsuario") != null ? request.getAttribute("claveUsuario").toString() : null;
    String codigoUsuario = request.getAttribute("codigoUsuario") != null ? request.getAttribute("codigoUsuario").toString() : null;
    String idUsuario = request.getAttribute("idUsuario") != null ? request.getAttribute("idUsuario").toString() : null;
    String success = request.getAttribute("success") != null ? request.getAttribute("success").toString() : null;
    List<Usuario> listadoEmpleado = (List<Usuario>) request.getAttribute("listadoEmpleado");
%>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <title>Empleados | Organizational System</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
        <!-- CSS -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/vendor/icon-sets.css">
        <link rel="stylesheet" href="assets/css/main.min.css">
        <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
        <link rel="stylesheet" href="assets/css/demo.css">
        <!-- GOOGLE FONTS -->
        <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
        <!-- ICONS -->
        <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
        <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
    </head>

    <body>
        <!-- WRAPPER -->
        <div id="wrapper">
            <!-- menú ateral -->
            <%@include file="menuVertical.jsp"  %>

                <div class="main">
                    <!-- Menú superior -->
                    <%@include file="menuHorizontal.jsp"  %>
                        <!-- Contenido principal -->
                        <div class="main-content">
                            <form method="post" action="./UsuarioSrvlet">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-xs-12">                                              
                                            <%if (mensajes != null && !mensajes.isEmpty()) {%>
                                                <%if (success != null && success.equals("true")) {%>     
                                                    <div class="alert alert-success alert-dismissible" role="alert">
                                                <% } else { %>
                                                    <div class="alert alert-danger alert-dismissible" role="alert">
                                                <% } %>
                                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                        <i class="fa fa-times-circle"></i> <%=mensajes%>
                                                </div>
                                            <% } %>
                                            <!-- Tabla de empleados -->
                                            <div class="panel">
                                                <div class="panel-heading">
                                                    <h3 class="panel-title">Empleados<h3>
                                                </div>
                                                <div class="panel-body">
                                                    <%if (listadoEmpleado != null && !listadoEmpleado.isEmpty()) {%> 
                                                        <div style="overflow-x: auto;">
                                                            <table class="table table-hover">
                                                                <thead>
                                                                    <tr>
                                                                        <th>Código interno</th>
                                                                        <th>Nombre completo</th>
                                                                        <th>Correo electrónico</th>
                                                                        <th>Perfil ocupacional</th>
                                                                        <th>Fecha de nacimiento</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <% for (Usuario empleado : listadoEmpleado) {%>
                                                                        <tr onclick="cargarFormulario('<%=empleado.getIdUsuario()%>','<%=empleado.getNombre()%>','<%=empleado.getClave()%>','<%=empleado.getCorreo()%>','<%=empleado.getIdPerfil()%>','<%=empleado.getFechaNacimiento()%>');">
                                                                            <td><%=empleado.getIdUsuario()%></td>
                                                                            <td><%=empleado.getNombre()%></td>
                                                                            <td><%=empleado.getCorreo()%></td>
                                                                            <td><%=empleado.getIdPerfil()%></td>
                                                                            <td><%=empleado.getFechaNacimiento()%></td>
                                                                        </tr>
                                                                    <%}%>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    <%} else  {%>
                                                        <div class="alert alert-danger alert-dismissible" role="alert">
                                                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                                <i class="fa fa-times-circle"></i> No se encontraron datos para mostrar
                                                        </div>
                                                    <%}%>
                                                    <br>
                                                    <div class="input-group">
                                                        <input class="form-control" id="search" name="search" placeholder="Buscar empleado por nombre o correo electrónico ..." type="text">
                                                        <span class="input-group-btn"><button class="btn btn-primary" type="submit" name="submit" value="Buscar">Buscar</button></span>
                                                    </div>
                                                    <br>
                                                    <p class="demo-button">
                                                        <button onclick="cargarFormulario('','','','',0,'')" type="button" class="btn btn-success"><i class="fa fa-check-circle"></i> Nuevo</button>
                                                    </p>
                                                </div>
                                            </div>

                                            <!-- Formulario Empleado -->
                                            <div class="modal fade" id="modalEmpleado" role="dialog">
                                                <div class="modal-dialog">
                                                    <!-- Modal content-->
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                            <h4 class="modal-title">Formulario de empleado</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div id="input-group-idUsuario" class="input-group hide">
                                                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                                <input class="form-control" id="idUsuario" name="idUsuario" value="<%=idUsuario==null?"":idUsuario%>" placeholder="Código interno del empleado" type="number">
                                                            </div>
                                                            <br>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                                <input class="form-control" id="nombreUsuario" name="nombreUsuario" value="<%=nombreUsuario==null?"":nombreUsuario%>" placeholder="Nombre completo" type="text">
                                                            </div>
                                                            <br>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-certificate"></i></span>
                                                                <input class="form-control" maxlength="8" id="claveUsuario" name="claveUsuario" value="<%=claveUsuario==null?"":claveUsuario%>" placeholder="Contraseña para el ingreso del empleado al sistema" type="password">
                                                            </div>
                                                            <br>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-mail-forward"></i></span>
                                                                <input class="form-control" id="correoUsuario" name="correoUsuario" value="<%=correoUsuario==null?"":correoUsuario%>" placeholder="Correo electrónico" type="email">
                                                            </div>
                                                            <br>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-male"></i></span>
                                                                <select class="form-control" id="cargoUsuario" name="cargoUsuario">
                                                                    <option value="0">Cargo que desempeña el empleado</option>
                                                                    <option value="1">Administrador</option>
                                                                </select>
                                                            </div>
                                                            <br>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                                                <input class="form-control" id="fechaNacimiento" name="fechaNacimiento" value="<%=fechaNacimiento==null?"":fechaNacimiento%>" placeholder="Fecha de nacimiento" type="text">
                                                            </div>
                                                            <br>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <p class="demo-button">
                                                                <button type="submit" name="submit" value="Guardar" class="btn btn-success"><i class="fa fa-check-circle"></i> Guardar</button>
                                                                <button type="submit" name="submit" value="Eliminar" class="btn btn-danger"><i class="fa fa-trash-o"></i> Eliminar</button>
                                                                <button type="button" class="btn btn-warning" data-dismiss="modal"><i class="fa fa-remove"></i> Cancelar</button>
                                                            </p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <!-- pié de página -->
                            <footer>
                                <%@include file="footer.jsp"  %>
                            </footer>
                        </div>
                        <!-- END MAIN -->
                </div>
                <!-- END WRAPPER -->
                <!-- Javascript -->
                <script src="assets/js/jquery/jquery-2.1.0.min.js"></script>
                <script src="assets/js/bootstrap/bootstrap.min.js"></script>
                <script src="assets/js/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
                <script src="assets/js/klorofil.min.js"></script>
                <script src="js/Empleado.js"></script>
    </body>

    </html>