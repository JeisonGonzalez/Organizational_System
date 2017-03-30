<%-- 
    Document   : Empleado
    Created on : 26/03/2017, 10:13:50 AM
    Author     : Jeison
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
				<div class="container-fluid">
					<div class="row">
						<div class="col-xs-12">
                                                        <!-- Tabla de empleados -->
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title">Empleados ${nombre_organización}</h3>
								</div>
								<div class="panel-body">
                                                                    <div style="overflow-x: auto;">
									<table class="table table-hover">
										<thead>
											<tr>
												<th>id</th>
												<th>Nombre completo</th>
												<th>Cargo</th>
												<th>Teléfono</th>
												<th>Fecha de nacimiento</th>
												<th>Correo electrónico</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>1</td>
												<td>Steve</td>
												<td>Jobs</td>
												<td>@steve</td>
											</tr>
											<tr>
												<td>2</td>
												<td>Simon</td>
												<td>Philips</td>
												<td>@simon</td>
											</tr>
											<tr>
												<td>3</td>
												<td>Jane</td>
												<td>Doe</td>
												<td>@jane</td>
											</tr>
										</tbody>
									</table> 
                                                                        </div>
                                                                    <br>
									<div class="input-group">
										<input class="form-control" placeholder="Buscar empleado ..." type="text">
										<span class="input-group-btn"><button class="btn btn-primary" type="button">Buscar</button></span>
									</div>  
                                                                    <br>
									<p class="demo-button">
                                                                            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#modalEmpleado"><i class="fa fa-check-circle"></i> Nuevo</button>
									</p>
								</div>
							</div>
						
							<!-- Formulario Empleado -->
                                                        <div class="modal fade" id="modalEmpleado" role="dialog">
                                                             <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
									<div class="input-group">
										<input class="form-control" placeholder="Buscar empleado ..." type="text">
										<span class="input-group-btn"><button class="btn btn-primary" type="button">Buscar</button></span>
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user"></i></span>
										<input class="form-control" placeholder="Nombre completo" type="text">
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user"></i></span>
										<input class="form-control" placeholder="Cargo" type="text">
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user"></i></span>
										<input class="form-control" placeholder="Teléfono" type="text">
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user"></i></span>
										<input class="form-control" placeholder="Fecha de nacimiento" type="text">
									</div>
									<br>
									<div class="input-group">
										<span class="input-group-addon"><i class="fa fa-user"></i></span>
										<input class="form-control" placeholder="Correo electrónico" type="text">
									</div>
									<br>
									<br>
									<p class="demo-button">
										<button type="button" class="btn btn-warning"><i class="fa fa-refresh"></i> Modificar</button>
										<button type="button" class="btn btn-danger"><i class="fa fa-trash-o"></i> Eliminar</button>
									</p>
						</div></div>
                                                </div>
					</div>
				</div>
			</div>
                        
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
</body>

</html>
