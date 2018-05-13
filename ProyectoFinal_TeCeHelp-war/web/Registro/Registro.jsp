<%-- 
    Document   : Registro
    Created on : 27-abr-2018, 15:40:52
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <form action="registro.php" method="post">

            <table width="351" border="0">

                <tr><td colspan="2"><div align="center">Registro a WorldCad</div></td></tr>
                <tr><td width="150">Nombres Completos</td><td><input name="nombres" type="text" value="" required /></td>
                <tr><td width="150">Apellidos Completos</td><td><input name="apellidos" type="text" value="" required /></td>	
                <tr><td width="150">Identificación</td><td><input name="id" type="int" value="" required /></td>	
                <tr><td width="150">Usuario</td><td><input name="usuario" type="text" value="" required /></td>	
                <tr><td width="150">Contraseña</td><td><input name="contrasena" type="password" value="" required /></td>		
                <tr><td colspan="2"><input type="submit" value="Registrar"></td></tr>

            </table>

        </form>    
    </body>
</html>

