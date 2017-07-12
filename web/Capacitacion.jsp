<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Capacitaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<Capacitaciones> listaCapacitacion = (List<Capacitaciones>) request.getAttribute("listado") != null ? (List<Capacitaciones>) request.getAttribute("listado") : null;
%>
<html>
    <head>
        <title>Certificados | Organizational System</title>
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
                <form name="Reistrar Capacitacion" action="CapacitacionesServlet" method="POST">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-xs-12">
                                <!-- Tabla de empleados -->
                                <div class="panel">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">Capacitaciones </h3>
                                    </div>

                                    <div class="panel-body">
                                        <%if (listaCapacitacion != null) {%> 
                                        <div style="overflow-x: auto;">
                                            <table class="table table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>Id</th>
                                                        <th>Area</th>
                                                        <th>Nombre</th>
                                                        <th>Descripcion</th>
                                                        <th>Estado</th>
                                                        <th>Fecha</th>
                                                    </tr>
                                                </thead> 
                                                <tbody>                                                                

                                                    <% for (Capacitaciones Cap : listaCapacitacion) {%>
                                                    <tr>
                                                        <td><%=Cap.getIdCapacitacion()%></td>
                                                        <td><%=Cap.getIdArea()%></td>
                                                        <td><%=Cap.getNombre()%></td>
                                                        <td><%=Cap.getDescripcion()%></td>
                                                        <td><%=Cap.getEstado()%></td>
                                                        <td><%=Cap.getFecha()%></td>
                                                    </tr>
                                                    <%}%>
                                                </tbody>
                                            </table>
                                        </div>
                                        <%} else {%>
                                        <div class="alert alert-danger alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <i class="fa fa-times-circle"></i> No se encontraron datos para mostrar
                                        </div>
                                        <%}%>
                                        <br>
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                            <input class="form-control" id = "buscar" name="buscar" placeholder="Buscar capacitación ..." type="text">
                                            <span class="input-group-btn"><button class="btn btn-primary" type="submit" name="action" id="buscar" value="buscar">Buscar</button></span>
                                        </div>

                                        <br>
                                        <p class="demo-button">
                                            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#modalArea"><i class="fa fa-check-circle"></i> Nuevo Certificado</button>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal fade" id="modalArea" role="dialog">
                        <!-- Modal content-->
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Registro Capacitación</h4>
                                </div>
                                <div class="modal-body">
                                    <br>
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <input class="form-control" placeholder="Identificación" type="text" Id="id" name="txtid" />
                                    </div>

                                    <br>
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <input class="form-control" placeholder="Area" type="text" id="area" name="txtarea" />
                                    </div>
                                    <br>
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <input class="form-control" placeholder="Nombre" type="text" id="nombre" name="txtnombre" />
                                    </div>
                                    <br>
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <input class="form-control" placeholder="Descripción" type="text" id="descripcion" name="txtdescripcion" />
                                    </div>
                                    <br>
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <select class="form-control" placeholder="Estado" type="text" id="estado" name="txtestado" >
                                            <option placeholder="Estado">Seleccione un estado</option>
                                            <option>Activo</option>
                                            <option>Inactivo</option>
                                        </select>
                                    </div>
                                    <br>
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <input class="form-control" placeholder="Fecha" type="date" id="fecha" name="txtfecha" />
                                    </div>
                                    <br>
                                    <div class="input-group">
                                        <span class="input-group-btn"><input type="submit" name="action" id ="guardar" class="btn btn-primary" value="guardar"></span>
                                    </div> 

                                    <br>
                                    <div class="input-group">
                                        <span class="input-group-btn"><input type="submit" name="action" id ="eliminar" class="btn btn-primary" value="eliminar"></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>   
            </html><!-- END WRAPPER -->
            <!-- Javascript -->
            <script src="assets/js/jquery/jquery-2.1.0.min.js"></script>
            <script src="assets/js/bootstrap/bootstrap.min.js"></script>
            <script src="assets/js/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
            <script src="assets/js/klorofil.min.js"></script>
        </div>
    </div>