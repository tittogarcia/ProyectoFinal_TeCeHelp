<%-- 
    Document   : Producto
    Created on : 27-abr-2018, 15:43:33
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gesión Productos</title>
        <link rel="stylesheet" href="../css/Style_Formularios.css" type="text/css">
    </head>
    <body>
        <div class="container">  
            <form id="contact" action="../ProductoServlet" method="post">
                <h3>Formulario ingreso de productos</h3>
                <fieldset>
                    <input placeholder="Serial" type="text" tabindex="1" required autofocus name="NombreParte">
                </fieldset>
                <fieldset>
                    <input placeholder="Producto" type="text" tabindex="1" required autofocus name="NombreProducto">
                </fieldset>
                <fieldset>
                    <input placeholder="Cantidad" type="number" tabindex="2" required name="Cantidad">
                </fieldset>
                <fieldset>
                    <input placeholder="PrecioVenta" type="number" tabindex="2" required name="PrecioVenta">
                </fieldset>
                <fieldset>
                    <button name="BProducto" type="submit" id="Registrar" value="Registrar">Registrar</button>
                </fieldset>
                <fieldset>
                    <button name="BProducto" type="submit" id="Consultar" value="Consultar">Consultar</button>
                </fieldset>
            </form>
        </div>
        <%-- <form name='producto' action="../ProductoServlet"  method="post">

            <table width="455" border="0">
                <tr><td colspan="10"><div align="center">Gestion de Productos</div></td></tr>
                <tr>
                    <td width="244">Nombre de parte</td>
                    <td width="1">&nbsp;</td>
                    <td width="1">&nbsp;</td>
                    <td width="191"><input name="NombreParte" type="text" value="" required /></td>


                </tr>
                <tr>
                    <td width="244">Nombre del Producto</td>
                    <td width="1">&nbsp;</td>
                    <td width="1">&nbsp;</td>
                    <td width="191"><input name="NombreProducto" type="text" value="" /></td>


                </tr>
                <tr>
                    <td width="244">Cantidad</td>
                    <td width="1">&nbsp;</td>
                    <td width="1">&nbsp;</td>
                    <td width="191"><input name="Cantidad" type="number" value="0" /></td>


                </tr>

                <tr>
                    <td width="244">Precio Venta</td>
                    <td width="1">&nbsp;</td>
                    <td width="1">&nbsp;</td>
                    <td width="191"><input name="PrecioVenta" type="text" value="0" /></td>


                </tr>

                </tr>

                <tr>
                    <td width="300">
                        <input type="submit" value="Registrar" name="BProducto">  
                        <input type="submit" value="Modificar" name="BProducto">  
                        <input type="submit" value="Consultar" name="BProducto">
                        <input type="submit" value="Eliminar" name="BProducto">
                    </td>
                    <td width="1">&nbsp;</td>
                    <td width="1">&nbsp;</td>
                    <td width="191"></td>


                </tr>

            </table>

        </form> --%>
        <!--este "mensaje" hace referencia al que aparecerá en el momento que un vendedor sea registrado -->
        <p>${mensajeProducto}</p>
    </body>
</html>

