<%-- 
    Document   : ProductoMensajes
    Created on : 27-abr-2018, 15:44:17
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensajes Producto</title>
    </head>
    <body>
        <table>
            <tr>
                <th><h2>Los Datos del Producto son: </h2></th>
            </tr>
            <tr>
                <td>Nombre Parte: </td>
                <td>${NombreParte}</td>
            </tr>
            <tr>
                <td>Nombre Producto: </td>
                <td>${NombreProducto}</td>
            </tr>
            <tr>
                <td>Cantidad Producto: </td>
                <td>${CantidadProducto}</td>
            </tr>
            <tr>
                <td>Precio Venta: </td>
                <td>${PrecioVenta}</td>
            </tr>
        </table>
    </body>
</html>
