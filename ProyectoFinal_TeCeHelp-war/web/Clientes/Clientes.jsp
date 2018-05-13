<%-- 
    Document   : Clientes
    Created on : 27-abr-2018, 16:02:49
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clientes</title>
    </head>
    <body>
        <form name='producto' action="../ClienteServlet"  method="post">

            <table width="351" border="0">

                <tr><td colspan="2"><div align="center">Registro de Clientes de WorldCad</div></td></tr>
                <tr><td width="150">Identificación</td><td><input name="id" type="int" value="" required /></td>	
                <tr><td width="150">Nombre de la Empresa</td><td><input name="nombreempre" type="text" value=""  /></td>	
                <tr><td width="150">Nombre del Cliente</td><td><input name="nombrecli" type="text" value=""  /></td>	
                <tr><td width="150">Dirección</td><td><input name="direccion" type="text" value=""  /></td>	
                <tr><td width="150">E-mail</td><td><input name="correo" type="text" value=""  /></td>	
                <tr><td width="150">Url</td><td><input name="url" type="text" value=""  /></td>	
                <tr><td width="150">Telefono</td><td><input name="telefono" type="number" value="0"  /></td>
                <tr><td width="150">Ciudad</td><td><select name="ciudad">
                            <option value="1">Bogotá</option>
                            <option value="2">Barranquilla</option>
                            <option value="3">Cartagena</option>
                            <option value="4">Medellin</option>
                            <option value="5">Cali</option>
                        </select></td>			

                <tr><td width="150">¿Que quiere hacer?</td><td><select name="opcion">
                            <option value="registrar">Registrar</option>
                            <option value="consultar">Consultar</option>
                            <option value="modificar">Modificar</option>
                            <option value="eliminar">Eliminar</option>
                        </select></td>
                <tr><td colspan="2">			
                        <input type="submit" value="enviar">   
                    </td></tr>

            </table>
            <p>${mensajeCliente}</p>
        </form>
    </body>
</html>

