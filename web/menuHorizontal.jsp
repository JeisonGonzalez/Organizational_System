<%-- 
    Document   : menuHorizontal
    Created on : 26/03/2017, 09:52:42 AM
    Author     : Jeison
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>

<form class="form-horizontal" method="post" action="./MenuHorizontalServlet">
    <nav class="navbar navbar-default">
            <div class="container-fluid">
                    <div class="navbar-btn">
                            <button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
                    </div>
                    <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-menu">
                                    <span class="sr-only">Toggle Navigation</span>
                                    <i class="fa fa-bars icon-nav"></i>
                            </button>
                    </div>
                    <div id="navbar-menu" class="navbar-collapse collapse">
                            <ul class="nav navbar-nav navbar-right">
                                    <li class="dropdown">
                                            <a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
                                                    <i class="lnr lnr-alarm"></i>
                                                    <span class="badge bg-danger">5</span>
                                            </a>
                                            <ul class="dropdown-menu notifications">
                                                    <li><a href="#" class="notification-item"><span class="dot bg-warning"></span>System space is almost full</a></li>
                                                    <li><a href="#" class="notification-item"><span class="dot bg-danger"></span>You have 9 unfinished tasks</a></li>
                                                    <li><a href="#" class="notification-item"><span class="dot bg-success"></span>Monthly report is available</a></li>
                                                    <li><a href="#" class="notification-item"><span class="dot bg-warning"></span>Weekly meeting in 1 hour</a></li>
                                                    <li><a href="#" class="notification-item"><span class="dot bg-success"></span>Your request has been approved</a></li>
                                                    <li><a href="#" class="more">Ver todos los mensajes</a></li>
                                            </ul>
                                    </li>
                                    <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="lnr lnr-question-circle"></i> <span>Ayuda</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
                                            <ul class="dropdown-menu">
                                                    <li><a href="#">Manual de usuario</a></li>
                                            </ul>
                                    </li>
                                    <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="assets/img/user.png" class="img-circle" alt="Avatar"> <span>Jeison González Cifuentes</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
                                            <ul class="dropdown-menu">
                                                    <li><a href="perfil.jsp"><i class="lnr lnr-user"></i> <span>Mi perfil</span></a></li>
                                                    <li><a href="#"><i class="lnr lnr-cog"></i> <span>Configuración</span></a></li>
                                                    <li><button type="submit" name="salir" value="salir" class="btn btn-warning col-xs-12 pull-left"><i class="lnr lnr-exit"></i> <span>Cerrar sesión</span></button></li>
                                            </ul>
                                    </li>
                            </ul>
                    </div>
            </div>
    </nav>
</form>
<script src="js/menuHorizontal.js"></script>
<script>
    init();
</script>