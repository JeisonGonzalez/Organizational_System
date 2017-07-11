<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Certificado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
//  Se obtienen datos provenientes del servlet y se guardan en variables para ser usadas en la JSP.
   //List<Certificado> listaCertificado = (List<Certificado>) request.getAttribute("listado");
    List<Certificado> listaCertificado = (List<Certificado>) request.getAttribute("listado") != null ? (List<Certificado>) request.getAttribute("listado") : null;
%>

<html>
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
                            <form name="Reistrar Certificado" action="CertificadoServlet" method="POST">
                               <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-xs-12">
                                            <!-- Tabla de empleados -->
                                            <div class="panel">
                                                <div class="panel-heading">
                                                    <h3 class="panel-title">Certificación </h3>
                                                </div>
                                                
                                                <div class="panel-body">
                                                    <%if (listaCertificado != null) {%> 
                                                    <div style="overflow-x: auto;">
                                                        <table class="table table-hover">
                                                            <thead>
                                                                <tr>
                                                                    <th>id</th>
                                                                    <th>Nombre Certificado</th>
                                                                    <th>Descripción</th>
                                                                    <th>Avance</th>
                                                                    <th>Estado</th>
                                                                </tr>
                                                            </thead> 
                                                            <tbody>                                                                
                                                                                                                                   
                                                                    <% for (Certificado Certi : listaCertificado) {%>
                                                                        <tr>
                                                                            <td><%=Certi.getIdCertificacion()%></td>
                                                                            <td><%=Certi.getNombre()%></td>
                                                                            <td><%=Certi.getDescripcion()%></td>
                                                                            <td><%=Certi.getAvance()%></td>
                                                                            <td><%=Certi.getEstado()%></td>
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
                                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                        <input class="form-control" id = "buscar" name="buscar" placeholder="Buscar certificado ..." type="text">
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
                                                        <h4 class="modal-title">Registro Certificado</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                            <br>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                                <input class="form-control" placeholder="identificación" type="text" Id="id" name="txtid" />
                                                            </div>

                                                            <br>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                                <input class="form-control" placeholder="Nombre" type="text" id="Nombre" name="txtnombre" />
                                                            </div>
                                                            <br>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                                <input class="form-control" placeholder="Descripción" type="text" id="Descripcion" name="txtdescripcion" />
                                                            </div>
                                                            <br>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                                <input class="form-control" placeholder="Avance" type="text" id="Avance" name="txtavance" />
                                                            </div>
                                                            <br>
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                                <input class="form-control" placeholder="Estado" type="text" id="Estado" name="txtestado" />
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
