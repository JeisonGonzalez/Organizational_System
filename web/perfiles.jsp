<%-- 
    Document   : perfiles
    Created on : 2/07/2017, 11:23:21 PM
    Author     : Jeison
--%>

<%@page import="Entidades.Areas"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
//  Se obtienen datos provenientes del servlet y se guardan en variables para ser usadas en la JSP.
    String mensajes = request.getAttribute("mensajes") != null ? request.getAttribute("mensajes").toString() : null;
    String success = request.getAttribute("success") != null ? request.getAttribute("success").toString() : null;
    List<Perfil> listadoPerfil = (List<Perfil>) request.getAttribute("listadoPerfil");
    List<Areas> listadoAreas = (List<Areas>) request.getAttribute("listadoAreas");
%>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <title>Perfiles | Organizational System</title>
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
                            <form method="post" action="./PerfilesServlet">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <%if (mensajes != null && !mensajes.isEmpty()) {%>
                                                <%if (success != null && success.equals("success")) {%>     
                                                    <div class="alert alert-success alert-dismissible" role="alert">
                                                <% } else if (success != null && success.equals("warning")) { %>
                                                    <div class="alert alert-warning alert-dismissible" role="alert">
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
                                                    <h3 class="panel-title">Perfiles<h3>
                                                </div>
                                                <div class="panel-body">
                                                    <%if (listadoPerfil != null && !listadoPerfil.isEmpty()) {%> 
                                                        <div style="overflow-x: auto;">
                                                            <table class="table table-hover">
                                                                <thead>
                                                                    <tr>
                                                                        <th>Código interno</th>
                                                                        <th>Nombre</th>
                                                                        <th>Descripción</th>
                                                                        <th>Área</th>
                                                                        <th>Perfil padre</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                    <% for (Perfil perfil : listadoPerfil) {%>
                                                                        <tr onclick="cargarFormulario('<%=perfil.getIdPerfil()%>','<%=perfil.getNombre()%>','<%=perfil.getDescripcion()%>','<%=perfil.getIdArea()%>','<%=perfil.getIdPadre()%>');">
                                                                            <td><%=perfil.getIdPerfil()%></td>
                                                                            <td><%=perfil.getNombre()%></td>
                                                                            <td><%=perfil.getDescripcion()%></td>
                                                                            <td><%=perfil.getNombre_area()%></td>
                                                                            <td><%=perfil.getNombre_padre()%></td>
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
                                                        <input class="form-control" id="search" name="search" placeholder="Buscar perfil por código interno, nombre o descripción ..." type="text">
                                                        <span class="input-group-btn"><button class="btn btn-primary" type="submit" name="submit" value="Buscar">Buscar</button></span>
                                                    </div>
                                                    <br>
                                                    <p class="demo-button">
                                                        <button onclick="cargarFormulario('','','',0,-2)" type="button" class="btn btn-success"><i class="fa fa-check-circle"></i> Nuevo</button>
                                                    </p>
                                                </div>
                                            </div>

                                            <!-- Formulario Empleado -->
                                            <div class="modal fade" id="modalPerfil" role="dialog">
                                                <div class="modal-dialog">
                                                    <!-- Modal content-->
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                            <h4 class="modal-title">Formulario de pefiles</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                            <div class="form-group hide">
                                                                <label for="idPerfil" class="col-xs-12 no-padding">Código interno</label>
                                                                <div class="input-group">
                                                                    <span class="input-group-addon"><i class="fa fa-certificate"></i></span>
                                                                    <input class="form-control" type="text" Id="idPerfil" name="idPerfil"/>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="nombre" class="col-xs-12 no-padding">* Nombre de perfíl</label>
                                                                <div class="input-group">
                                                                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                                    <input class="form-control" type="text" id="nombre" name="nombre" required="Campo obligatorio"/>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="descripcion" class="col-xs-12 no-padding">* Descripción de perfíl</label>
                                                                <div class="input-group">
                                                                    <span class="input-group-addon"><i class="fa fa-bars"></i></span>
                                                                    <input class="form-control" type="text" id="descripcion" name="descripcion" required="Campo obligatorio"/>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="idArea" class="col-xs-12 no-padding">* Área</label>
                                                                <div class="input-group">
                                                                    <span class="input-group-addon"><i class="fa fa-group"></i></span>
                                                                    <select class="form-control" id="idArea" name="idArea" required="Campo obligatorio">
                                                                            <option value="0">Seleccione un área</option>
                                                                            <%if (listadoAreas != null && !listadoAreas.isEmpty()) {%>                                                                   
                                                                                <% for (Areas area : listadoAreas) {%>
                                                                                    <option value="<%=area.getIdArea()%>"><%=area.getNombre()%></option>
                                                                                <%}%>
                                                                            <%}%>
                                                                    </select>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="idPadre" class="col-xs-12 no-padding">Perfil padre (Si aplica)</label>
                                                                <div class="input-group">
                                                                    <span class="input-group-addon"><i class="fa fa-male"></i></span>
                                                                    <select class="form-control" id="idPadre" name="idPadre">
                                                                            <option value="-2">Seleccione un perfil</option>
                                                                            <%if (listadoPerfil != null && !listadoPerfil.isEmpty()) {%>                                                                
                                                                                <% for (Perfil perfil : listadoPerfil) {%>
                                                                                    <option value="<%=perfil.getIdPerfil()%>"><%=perfil.getNombre()%></option>
                                                                                <%}%>
                                                                            <%}%>
                                                                    </select>
                                                                </div>
                                                            </div>
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
                <script src="js/Perfil.js"></script>
    </body>

    </html>