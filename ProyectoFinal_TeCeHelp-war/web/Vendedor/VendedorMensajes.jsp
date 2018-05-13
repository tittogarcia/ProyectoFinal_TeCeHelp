<%-- 
    Document   : VendedorMensajes
    Created on : 27-abr-2018, 15:40:00
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensajes Vendedor</title>
    </head>
    <body>
        <table>
            <tr>
                <th><h2>Los Datos del Vendedor son: </h2></th>
            </tr>
            <tr>
                <td>Nombre: </td>
                <td>${NombreVendedor}</td>
            </tr>
            <tr>
                <td>Identificacion: </td>
                <td>${IdentificacionVendedor}</td>
            </tr>
            <tr>
                <td>Correo: </td>
                <td>${CorreoVendedor}</td>
            </tr>
            <tr>
                <td>Ciudad: </td>
                <td>${CiudadVendedor}</td>
            </tr>
        </table>
    </body>
</html>

