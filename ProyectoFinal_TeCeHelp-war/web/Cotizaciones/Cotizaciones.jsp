<%-- 
    Document   : Cotizaciones
    Created on : 27-abr-2018, 15:59:54
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cotizaciones</title>
        <link rel="stylesheet" href="../css/Style_Cotizaciones.css" type="text/css">
    </head>
    <body>

        <section id="cabecera_cotiza" >
            <form name="Crear_Cotiza">

                <div id="cabecera_izq">
                    <label>Cliente: </label>
                    <select name="lista_cliente">
                        <option value="Seleccione...">Seleccione...</option>
                        <?php  while ($clientes = mysql_fetch_array($querycli)) { ?>												
                        <option value="<?php echo $clientes['clientes_id']?>"><?php echo $clientes['nombre_empresa'] ?></option>

                        <?php   }
                        ?>
                        <option value="pablo">pablo</option>
                    </select>
                    <br />
                    <label>Vendedor: </label>
                    <input list="lista_vendedor" name="lista_vendedor" />
                    <datalist id="lista_vendedor">
                        <option label="Iron Man" value="Iron Man">
                    </datalist>
                    <br />
                    <label>Descripción: </label>
                    <textarea name="textarea" rows="5" cols="30"></textarea>
                </div>
                <div id="cabecera_der">
                    <label>Número de Cotización: </label>
                    <input type="number"  name="num_cotiza" id="num_cotiza" />
                    <output name="num_cotiza" id="num_cotiza"></output>
                    <br />
                    <label>Porcentaje de Cierre: </label>
                    <input type="number" name="percentaje_cierre" id="percentaje_cierre" placeholder="100%" min="0"  max="100"/>
                    <br />
                    <label>Fecha Estimada de Cierre: </label>
                    <input type="date" name="percentaje_cierre" id="percentaje_cierre" />
                </div>
            </form>
        </section>

        <section id="seleccionar_producto">
            <form name="buscar_producto">

                <label>Número de Parte </label>
                <input type="text" name="num_parte" id="num_parte"/>

                <input type="submit" name="Buscar_Producto" id="Buscar_Producto" value="Buscar Producto"/>
                <br />

                <label>Número de Parte: </label>
                <input type="text" name="num_parte2" id="num_parte2"/>

                <label>Producto: </label>
                <input type="text" name="Producto" id="Producto"/>

                <label>Precio de Venta: </label>
                <input type="text" name="precio_venta" id="precio_venta"/>

                <label>Cantidad: </label>
                <input type="text" name="cantidad" id="cantidad"/>
                <input type="submit" name="Agregar" id="Agregar" value="Agregar"/>
            </form>
        </section>

        <section id="detalle_cotiza">
            <div id="detalle_co">
                <table border="1" align="center">
                    <tr>
                        <th>Cantidad</th>
                        <th>Producto</th>
                        <th>Precio Unitario</th>
                        <th>Precio Total</th>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                </table>
            </div>
            <div id="valores">
                <label>Subtotal: </label>
                <input type="number" name="subtotal" id="subtotal" form="Crear_Cotiza"/>
                <br />
                <label>IVA: </label>
                <input type="number" name="iva" id="iva" form="Crear_Cotiza"/>
                <br />
                <label>Total: </label>
                <input type="number" name="total" id="total" form="Crear_Cotiza"/>
                <br />

                <input type="submit" name="Crear" id="Crear" value="Crear"/>

                <input type="submit" name="Modificar" id="Modificar" value="Modificar"/>

                <input type="submit" name="Consultar" id="Consultar" value="Consultar"/>
            </div>
        </section>
    </body>
</html>

