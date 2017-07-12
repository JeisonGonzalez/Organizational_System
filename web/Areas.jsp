<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Areas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
//  Se obtienen datos provenientes del servlet y se guardan en variables para ser usadas en la JSP.
   List<Areas> listadoAreas = (List<Areas>) request.getAttribute("listadoAreas");
   String success = request.getAttribute("success") != null ? request.getAttribute("success").toString() : null;
   String mensajes = request.getAttribute("mensajes") != null ? request.getAttribute("mensajes").toString() : null;
%>
    <!DOCTYPE html>

        <head>
            <title>Áreas | Organizational System</title>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
            <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
            <!-- CSS -->
            <link rel="stylesheet" href="assets/css/bootstrap.min.css">
            <link rel="stylesheet" href="assets/css/vendor/icon-sets.css">
            <link rel="stylesheet" href="assets/css/main.min.css">
            <link rel="stylesheet" href="assets/js/AbrirModal.js">
            <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
            <link rel="stylesheet" href="assets/css/demo.css">
            <!-- GOOGLE FONTS -->
            <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
            <!-- ICONS -->
            <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
            <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
        </head>
        <!--AbrirModal(  indicador  )-->


        
        <!-- WRAPPER -->
        <div id="wrapper">
            <!-- menú ateral -->
            <%@include file="menuVertical.jsp" %>

                <div class="main">
                    <!-- Menú superior -->
                    <%@include file="menuHorizontal.jsp" %>

                        <!-- Contenido principal -->
                        <div class="main-content">
                            <form name="Reistrar Area" action="AreasServlet" method="POST">
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
                                            <!-- Tabla de Áreas -->
                                            <div class="panel">
                                                <div class="panel-heading">
                                                    <h3 class="panel-title">Áreas </h3>
                                                </div>
                                                <div class="panel-body">
                                                    <div style="overflow-x: auto;">
                                                        <table class="table table-hover">
                                                            <thead>
                                                                <tr>
                                                                    <th>Código interno</th>
                                                                    <th>Nombre área</th>
                                                                    <th>Descripción</th>
                                                                    <th>Área padre</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>                                                                
                                                                <%if (listadoAreas != null && !listadoAreas.isEmpty()) {%>                                                                    
                                                                    <% for (Areas area : listadoAreas) {%>
                                                                        <tr onclick="cargarFormulario('<%=area.getIdArea()%>','<%=area.getNombre()%>','<%=area.getDescripcion()%>','<%=area.getArea_Padre()%>')">
                                                                            <td><%=area.getIdArea()%></td>
                                                                            <td><%=area.getNombre()%></td>
                                                                            <td><%=area.getDescripcion()%></td>
                                                                            <td><%=area.getNombre_Padre()%></td>
                                                                        </tr>
                                                                    <%}%>
                                                                <%}%>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                    <br>
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><i class="fa fa-group"></i></span>
                                                        <input class="form-control" id = "search" name="search" placeholder="Buscar área por nombre , descripción , código interno o código interno de área padre ..." type="text">
                                                        <span class="input-group-btn"><button class="btn btn-primary" type="submit" name="submit" id="submit" value="Buscar">Buscar</button></span>
                                                    </div>

                                                    <br>
                                                    <p class="demo-button">
                                                        <button type="button" class="btn btn-success" onclick="cargarFormulario('','','','0')"><i class="fa fa-check-circle"></i> Nueva Area</button>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!--  #################################################       Formulario Area - Registro       ###################################################  -->
                                        <div class="modal fade" id="modalArea" role="dialog">
                                            <!-- Modal content-->
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                        <h4 class="modal-title">Registro áreas</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="form-group hide">
                                                            <label for="id_Area" class="col-xs-12 no-padding">Código interno</label>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-certificate"></i></span>
                                                                <input class="form-control" type="text" Id="id_Area" name="id_Area"/>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="Nombre" class="col-xs-12 no-padding">* Nombre de área</label>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-group"></i></span>
                                                                <input class="form-control" type="text" id="Nombre" name="Nombre" required="Campo obligatorio"/>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="Descripcion" class="col-xs-12 no-padding">* Descripción del área</label>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-bars"></i></span>
                                                                <input class="form-control" type="text" id="Descripcion" name="Descripcion" required="Campo obligatorio"/>
                                                            </div>     
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="Area_Padre" class="col-xs-12 no-padding">* Área padre</label>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-male"></i></span>
                                                                <select class="form-control" id="Area_Padre" name="Area_Padre" required="Campo obligatorio">
                                                                        <option value="0">Seleccione un área padre</option>
                                                                        <%if (listadoAreas != null && !listadoAreas.isEmpty()) {%>                                                                   
                                                                            <% for (Areas area : listadoAreas) {%>
                                                                                <option value="<%=area.getIdArea()%>"><%=area.getNombre()%></option>
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
                            </form>
                        </div>   
                        <!-- END WRAPPER -->
                        <!-- Javascript -->
                        <script src="assets/js/jquery/jquery-2.1.0.min.js"></script>
                        <script src="assets/js/bootstrap/bootstrap.min.js"></script>
                        <script src="assets/js/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
                        <script src="assets/js/klorofil.min.js"></script>
                        <script src="js/Area.js"></script>
                </div>
        </div>