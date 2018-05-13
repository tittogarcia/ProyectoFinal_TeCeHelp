<%-- 
    Document   : ClienteMensajes
    Created on : 27-abr-2018, 16:05:28
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensajes Clientes</title>
    </head>
    <body>
        <table>
            <tr>
                <th><h2>Los Datos del Cliente son: </h2></th>
            </tr>
            <tr>
                <td>Identificación: </td>
                <td>${IdentificaciónCliente}</td>
            </tr>
            <tr>
                <td>Nombre de la Empresa: </td>
                <td>${NombreEmpresaCliente}</td>
            </tr>
            <tr>
                <td>Nombre del Contacto </td>
                <td>${NombreCliente}</td>
            </tr>
            <tr>
                <td>Dirección: </td>
                <td>${DireccionCliente}</td>
            </tr>
            <tr>
                <td>E-Mail: </td>
                <td>${CorreoCliente}</td>
            </tr>
            <tr>
                <td>Url: </td>
                <td>${UrlCliente}</td>
            </tr>
            <tr>
                <td>Telefono: </td>
                <td>${TelefonoCliente}</td>
            </tr>
            <tr>
                <td>Ciudad: </td>
                <td>${CiudadCliente}</td>
            </tr>
        </table>
    </body>
</html>
   
