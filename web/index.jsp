<%-- 
    Document   : index
    Created on : 26/03/2017, 09:46:48 AM
    Author     : Jeison
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String message = request.getParameter("message");
%>
<!DOCTYPE html>
<html lang="en">

<head>
	<title>Ingreso | Organizational System</title>
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
		<div class="vertical-align-wrap">
			<div class="vertical-align-middle">
				<div class="auth-box ">
					<div class="left">
						<div class="content">                                                            
<!--                                                        <div class="alert alert-danger alert-dismissible" role="alert">
                                                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                                                <i class="fa fa-times-circle"></i>
                                                        </div>-->
                                                    <h2>Organizational System</h2>
                                                    <br>
                                                    <form class="form-horizontal" method="post" action="./loginServlet">
                                                            <div class="form-group">
                                                                    <label for="correo" class="control-label sr-only">Correo electrónico</label>
                                                                    <input type="email" class="form-control" name="correo" id="correo" placeholder="Ingrese correo de usuario">
                                                            </div>
                                                            <div class="form-group">
                                                                    <label for="clave" class="control-label sr-only">Contraseña</label>
                                                                    <input type="password" class="form-control" id="clave" name="clave" placeholder="Ingrese contraseña de usuario ...">
                                                            </div>
                                                            <button type="submit" id="accion" name="action" value="ingresar" class="btn btn-primary btn-lg btn-block">Ingresar</button>
                                                            <br>
                                                            <div class="bottom form-group-lg">
                                                                    <span><i class="fa fa-lock"></i> <a href="#">¿ Olvidó su contraseña ?</a></span>
                                                            </div>
                                                    </form>
						</div>
					</div>
					<div class="right">
						<div class="overlay"></div>
						<div class="content text">
							<h1 class="heading">Genera un alineamiento eficiente entre la estructura y los valores compartidos de una organización ...</h1>
							<p>De forma que los rumbos estratégicos se vean fortalecidos.</p>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- END WRAPPER -->
</body>

</html>
