<%-- 
    Document   : Vendedor
    Created on : 27-abr-2018, 15:38:41
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name='vendedores' action="../VendedorServlet"  method="post">
            <table width="387" border="0">
                <tr>
                    <td width="83" height="37">Nombre:</td>
                    <td colspan="3"><label for="nombre"></label>
                        <input type="text" name="nombre" id="nombre" size="35" requered/></td>

                </tr>
                <tr>
                    <td height="32">Identificacion:</td>
                    <td colspan="3"><input type="text" name="identificacion" id="identificacion" size="35" requered/></td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td height="42">Correo:</td>
                    <td colspan="3"><input type="text" name="correo" id="correo" size="35" requered /></td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td height="41">Sucursal:</td>
                    <td colspan="3">


                        <select id="ciudad" name= "ciudad">
                            <option value="1">Bogotá</option>
                            <option value="2">Barranquilla</option>
                            <option value="3">Cartagena</option>
                            <option value="4">Medellin</option>
                            <option value="5">Cali</option>

                        </select>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td height="37"><input type="submit" name="BVendedor" id="Registrar" value="Registrar" /></td>
                    <td width="76"><input type="submit" name="BVendedor" id="Consultar" value="Consultar" /></td>
                    <td width="77"><input type="submit" name="BVendedor" id="Modificar" value="Modificar" /></td>
                    <td width="68"><input type="submit" name="BVendedor" id="Eliminar" value="Eliminar" /></td>
                    <td>&nbsp;</td>
                </tr>
            </table>
            <!--este "mensaje" hace referencia al que aparecerá en el momento que un vendedor sea registrado -->
            <p>${mensajeVendedor}</p>
        </form>
    </body>
</html>

