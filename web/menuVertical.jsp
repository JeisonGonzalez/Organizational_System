<%-- 
    Document   : menuVertical
    Created on : 26/03/2017, 09:52:21 AM
    Author     : Jeison
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<div class="sidebar">
        <div class="brand">
            <h3>Organizational System</h3>
        </div>
        <div class="sidebar-scroll">
                <nav>
                        <ul class="nav">
                            <li>
                                <a href="#subPagesInicio" data-toggle="collapse" class="collapsed"><i class="fa fa-home"></i> <span>Inicio</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                                <div id="subPagesInicio" class="collapse ">
                                        <ul class="nav">
                                                <li><a href="page-profile.html" class="">Mi tablero</a></li>
                                                <li><a href="perfil.jsp" class="">Mi perfil</a></li>
                                        </ul>
                                </div>
                            </li>
                            <li>
                                <a href="#subPagesPlanificacion" data-toggle="collapse" class="collapsed"><i class="fa fa-pencil-square-o"></i> <span>Planificación</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                                <div id="subPagesPlanificacion" class="collapse ">
                                        <ul class="nav">
                                                <li><a href="page-profile.html" class="">Bodega</a></li>
                                                <li><a href="page-login.html" class="">Metas</a></li>
                                                <li><a href="page-lockscreen.html" class="">Comercial</a></li>
                                                <li><a href="page-lockscreen.html" class="">Marketing</a></li>
                                        </ul>
                                </div>
                            </li>
                            <li>
                                <a href="#subPagesOrganizacion" data-toggle="collapse" class="collapsed"><i class="fa fa-users"></i> <span>Organización</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                                <div id="subPagesOrganizacion" class="collapse ">
                                        <ul class="nav">
                                                <li><a href="page-profile.html" class="">Áreas</a></li>
                                                <li><a href="UsuarioSrvlet" class="">Empleados</a></li>
                                        </ul>
                                </div>
                            </li>
                            <li>
                                <a href="#subPagesDireccion" data-toggle="collapse" class="collapsed"><i class="fa fa-handshake-o"></i> <span>Dirección</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                                <div id="subPagesDireccion" class="collapse ">
                                        <ul class="nav">
                                                <li><a href="page-login.html" class="">Motivación</a></li>
                                                <li><a href="page-lockscreen.html" class="">Informativo</a></li>
                                        </ul>
                                </div>
                            </li>
                            <li>
                                <a href="#subPagesControl" data-toggle="collapse" class="collapsed"><i class="fa fa-area-chart"></i> <span>Control</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                                <div id="subPagesControl" class="collapse ">
                                        <ul class="nav">
                                                <li><a href="page-profile.html" class="">Certificaciones</a></li>
                                        </ul>
                                </div>
                            </li>
                            <li>
                                <a href="#" data-toggle="collapse" class="collapsed"><i class="lnr lnr-cog"></i> <span>Parametrización</span></a>
                            </li>
                        </ul>
                </nav>
        </div>
</div>