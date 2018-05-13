<%-- 
    Document   : Inicio
    Created on : 27-abr-2018, 15:52:48
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>¡Inicio!</title>
        <link rel="stylesheet" href="../css/Style.css" type="text/css">
    </head>
    <body>
        <div id="cabecera">
            <nav id="Inicio">
                <ul>
                    <img src="../Imagenes/Worldcad.png" width="100" height="56" alt="logo_wc" />
                    <li><font><a href="../LinksInicio/QuienesSomos.jsp" target="presentacion">Quienes Somos</a></font></li>
                    <li><font><a href="../LinksInicio/PrincipiosYValores.jsp" target="presentacion">Principios y Valores</a></font></li>
                    <li><font><a href="../LinksInicio/Documentacion.jsp" target="presentacion">Documentación</a></font></li>
                    <li><font>Contacto</font></li>
                </ul>
            </nav>
            <form name='login' action="../LoginServerlet"  method="post" >
                <font>Usuario: </font> <input type="text" name="usuario" >
                <font>Contraseña: </font><input type="password" name="contrasena" >
                <br>
                <input type="submit" value="Iniciar Sesión" name="IniciarSesion">
                <b>${mensaje}</b>
            </form>       
        </div>
    </body>
</html>

