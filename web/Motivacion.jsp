<%-- 
    Document   : Mensaje
    Created on : 28/06/2017, 9:10:00 AM
    Author     : Juan David
--%>

<%@page import="java.util.List"%>
<%@page import="Entidades.Motivacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
      String mensajes = request.getAttribute("mensajes") != null ? request.getAttribute("mensajes").toString() : null;
      String success = request.getAttribute("success") != null ? request.getAttribute("success").toString() : null;
      List<Motivacion> listadoMensaje = (List<Motivacion>) request.getAttribute("listadoMensaje");
      String idMensaje = request.getAttribute("idMensaje") != null ? request.getAttribute("idMensaje").toString() : null;
      String UsuarioR = request.getAttribute("UsuarioR") != null ? request.getAttribute("UsuarioR").toString() : null;
      String Mensaje = request.getAttribute("Mensaje") != null ? request.getAttribute("Mensaje").toString() : null;
      String Asunto = request.getAttribute("Asunto") != null ? request.getAttribute("Asunto").toString() : null;
%>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <title>Motivación | Organizational System</title>
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
                            <form method="post" action="./MotivacionServlet">
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
                                                    <h3 class="panel-title">Motivación<h3>
                                                </div>
                                                <div class="panel-body">
                                                    <%if (listadoMensaje != null && !listadoMensaje.isEmpty()) {%> 
                                                        <div style="overflow-x: auto;">
                                                            <table class="table table-hover">
                                                                <thead>
                                                                    <tr>
                                                                        <th>Código mensaje</th>
                                                                        <th>Codigo Usuario Receptor</th>
                                                                        <th>Asunto</th>
                                                                        <th>Mensaje</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <% for (Motivacion mensaje : listadoMensaje) {%>
                                                                        <tr onclick="cargarFormulario('<%=mensaje.getIdMensaje()%>','<%=mensaje.getIdReceptor()%>','<%=mensaje.getAsunto()%>','<%=mensaje.getMensaje()%>');">
                                                                            <td><%=mensaje.getIdMensaje()%></td>
                                                                            <td><%=mensaje.getIdReceptor()%></td>
                                                                            <td><%=mensaje.getAsunto()%></td>
                                                                            <td><%=mensaje.getMensaje()%></td>
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
                                                        <input class="form-control" id="search" name="search" placeholder="Buscar mensaje por Código, Usuario receptor, Asunto o mensaje..." type="text">
                                                        <span class="input-group-btn"><button class="btn btn-primary" type="submit" name="submit" value="Buscar">Buscar</button></span>
                                                    </div>
                                                    <br>
                                                    <p class="demo-button">
                                                        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#modalMotivacion"><i class="fa fa-check-circle"></i> Nuevo</button>
                                                    </p>
                                                </div>
                                            </div>

                                            <!-- Formulario Mensaje -->
                                            <div class="modal fade" id="modalMotivacion" role="dialog">
                                                <div class="modal-dialog">
                                                    <!-- Modal content-->
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                            <h4 class="modal-title">Formulario de mensaje</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div id="input-group-idMensaje" class="input-group hide">
                                                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                                <input class="form-control" id="idMensaje" name="idMensaje" value="<%=idMensaje==null?"":idMensaje%>" placeholder="Código Del Mensaje" type="number">
                                                            </div>
                                                            <br>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                                <input class="form-control" id="UsuarioR" name="UsuarioR" value="<%=UsuarioR==null?"":UsuarioR%>" placeholder="Usuarios Receptores del mensaje" type="text">
                                                            </div>
                                                            <br>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                                <input class="form-control" id="Asunto" name="Asunto" value="<%=Asunto==null?"":Asunto%>" placeholder="Asunto del mensaje" type="text">
                                                            </div>
                                                            <br>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                                <input class="form-control" id="Mensaje" name="Mensaje" value="<%=Mensaje==null?"":Mensaje%>" placeholder="Texto del mensaje" type="text">
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
                <script src="js/Mensaje.js"></script>
    </body>

    </html>