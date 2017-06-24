<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Areas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
//  Se obtienen datos provenientes del servlet y se guardan en variables para ser usadas en la JSP.
   List<Areas> listadoAreas = (List<Areas>) request.getAttribute("listadoAreas");
   ArrayList<String> listaApadre = (ArrayList<String>) request.getAttribute("ListaAP");
//   List listadoAP = request.getAttribute("ListadoAP");
%>
    <!DOCTYPE html>

        <head>
            <title>Empleados | Organizational System</title>
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
                                            <!-- Tabla de empleados -->
                                            <div class="panel">
                                                <div class="panel-heading">
                                                    <h3 class="panel-title">Areas </h3>
                                                </div>
                                                <div class="panel-body">
                                                    <div style="overflow-x: auto;">
                                                        <table class="table table-hover">
                                                            <thead>
                                                                <tr>
                                                                    <th>id</th>
                                                                    <th>Nombre Area</th>
                                                                    <th>Descripción</th>
                                                                    <th>Area padre</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>                                                                
                                                                <%if (listadoAreas != null && !listadoAreas.isEmpty()) {%>                                                                    
                                                                    <% for (Areas area : listadoAreas) {%>
                                                                        <tr>
                                                                            <td><%=area.getIdAreas()%></td>
                                                                            <td><%=area.getNombre()%></td>
                                                                            <td><%=area.getDescripcion()%></td>
                                                                            <td><%=area.getArea_Padre()%></td>
                                                                        </tr>
                                                                    <%}%>
                                                                <%}%>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                    <br>
                                                    <div class="input-group">
                                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                        <input class="form-control" id = "buscar" name="buscar" placeholder="Buscar Area ..." type="text">
                                                        <span class="input-group-btn"><button class="btn btn-primary" type="submit" name="submit" id="submit" value="Buscar">Buscar</button></span>
                                                    </div>

                                                    <br>
                                                    <p class="demo-button">
                                                        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#modalArea"><i class="fa fa-check-circle"></i> Nueva Area</button>
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
                                                        <h4 class="modal-title">Registro Areas</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                            <br>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                                <input class="form-control" placeholder="identificación" type="text" Id="id_Area" name="id_Area" />
                                                            </div>

                                                            <br>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                                <input class="form-control" placeholder="Nombre" type="text" id="Nombre" name="Nombre" />
                                                            </div>
                                                            <br>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                                <input class="form-control" placeholder="Descripción" type="text" id="Descripcion" name="Descripcion" />
                                                            </div>
<!--                                                            <br>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                                <input class="form-control" placeholder="Area Padre" type="text" Id="Area_Padre" name="Area_Padre" />
                                                            </div>-->
                                                        
                                                        <!--<li class="dropdown">-->
                                                        
                                                            <br> 
                                                            <div class="input-group">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="" class="img-circle" alt=""> <span>Area Padre</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
								<ul class="dropdown-menu">
                                                                    <li><a href="#"><i class="lnr lnr-exit"></i> <span> Dirección General </span></a></li>
                                                                        <%if (listaApadre != null && !listaApadre.isEmpty()) {%>                                                                    
                                                                            <% for (String padre : listaApadre) {%>
                                                                                <tr>
                                                                                    <li><a href="#"><i class="lnr lnr-envelope"></i> <span><%=padre%></span></a></li>
                                                                                </tr>
                                                                            <%}%>
                                                                        <%}%>
								</ul>
                                                            </div>
                                                            <br>
                                                            <div class="input-group">
                                                                <span class="input-group-btn"><input type = "submit" name="submit" id ="submit" class="btn btn-primary" value = "Registrar"></span>
                                                            </div> 
                                                        
                                                            <br>
                                                            <div class="input-group">
                                                                <span class="input-group-btn"><input type = "submit" name="submit" id ="submit" class="btn btn-primary" value = "Eliminar"></span>
                                                            </div>
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
                </div>
        </div>