/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Daos;

import Datos.Vos.ProductosDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Andres
 */
public class ProductosDAO {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static Connection conn = null;
    private static ProductosDatos producto;

    private static final String sql_Insert = "INSERT INTO productos (numero_parte,nombre,cantidad,precio_venta) VALUES(?, ?, ?, ?)";
    private static final String sql_consultar = "SELECT numero_parte, nombre, cantidad, precio_venta FROM productos WHERE  numero_parte=?";
    private static final String sql_Modificar = "UPDATE productos SET nombre=?, cantidad=?, precio_venta=? WHERE numero_parte=?";
    private static final String sql_Eliminar = "DELETE FROM productos WHERE numero_parte=?";

    public static int crearProducto(ProductosDatos producto) throws ClassNotFoundException {
        int exito = 0;
        try {
            conn = ConexionDAO.crearConexion();
            ps = conn.prepareStatement(sql_Insert);
            ps.setString(1, producto.getNombreParte());
            ps.setString(2, producto.getNombreProducto());
            ps.setInt(3, producto.getCantidad());
            ps.setFloat(4, producto.getPrecio());
            exito = ps.executeUpdate();
            return exito;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionDAO.cerrarConexion(conn, ps);
        }

        return exito;
    }

    public static ProductosDatos Consultar(ProductosDatos productos) {
        producto = new ProductosDatos();
        try {
            conn = ConexionDAO.crearConexion();
            ps = conn.prepareStatement(sql_consultar);
            ps.setString(1, productos.getNombreParte());
            rs = ps.executeQuery();

            while (rs.next()) {
                producto.setNombreParte(rs.getString("numero_parte"));
                producto.setNombreProducto(rs.getString("nombre"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setPrecio(rs.getFloat("precio_venta"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionDAO.cerrarConexion(conn, ps);
        }
        return producto;
    }

    public static int modificarProducto(ProductosDatos producto) throws ClassNotFoundException {
        int exito = 0;
        try {
            conn = ConexionDAO.crearConexion();
            ps = conn.prepareStatement(sql_Modificar);
            ps.setString(1, producto.getNombreProducto());
            ps.setInt(2, producto.getCantidad());
            ps.setFloat(3, producto.getPrecio());
            ps.setString(4, producto.getNombreParte());
            exito = ps.executeUpdate();
            return exito;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionDAO.cerrarConexion(conn, ps);
        }

        return exito;
    }

    public static int eliminarProducto(ProductosDatos producto) throws ClassNotFoundException {
        int exito = 0;
        try {
            conn = ConexionDAO.crearConexion();
            ps = conn.prepareStatement(sql_Eliminar);
            ps.setString(1, producto.getNombreParte());
            exito = ps.executeUpdate();
            return exito;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionDAO.cerrarConexion(conn, ps);
        }

        return exito;
    }

}
