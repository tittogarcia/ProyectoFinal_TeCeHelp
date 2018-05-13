/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Daos;

import Datos.Vos.VendedoresDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ESTACION
 */
public class VendedorDAO {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static Connection conn = null;
    private static VendedoresDatos vendedor;

    private static final String sql_Insert = "INSERT INTO vendedores (Nombre,Identificacion,Correo,Ciudad_id) VALUES(?, ?, ?, ?)";
    private static final String sql_consultar = "SELECT NOMBRE, IDENTIFICACION, CORREO, CIUDAD FROM vendedores, ciudades WHERE  identificacion=? and (vendedores.CIUDAD_ID=ciudades.CIUDAD_ID)";
    private static final String sql_Modificar = "UPDATE vendedores SET NOMBRE=?, CORREO=?, CIUDAD_ID=? WHERE IDENTIFICACION=?";
    private static final String sql_Eliminar = "DELETE FROM vendedores WHERE IDENTIFICACION=?";

    public static int crearVendedor(VendedoresDatos vendedor) throws ClassNotFoundException {
        int exito = 0;
        try {
            conn = ConexionDAO.crearConexion();
            ps = conn.prepareStatement(sql_Insert);
            ps.setString(1, vendedor.getNombre());
            ps.setInt(2, vendedor.getIdentificacion());
            ps.setString(3, vendedor.getCorreo());
            ps.setInt(4, vendedor.getCiudad());
            exito = ps.executeUpdate();
            return exito;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionDAO.cerrarConexion(conn, ps);
        }

        return exito;
    }

    public static VendedoresDatos Consultar(VendedoresDatos vendedores) {
        vendedor = new VendedoresDatos();
        try {
            conn = ConexionDAO.crearConexion();
            ps = conn.prepareStatement(sql_consultar);
            ps.setInt(1, vendedores.getIdentificacion());
            rs = ps.executeQuery();

            while (rs.next()) {
                vendedor.setNombre(rs.getString("Nombre"));
                vendedor.setIdentificacion(rs.getInt("Identificacion"));
                vendedor.setCorreo(rs.getString("Correo"));
                vendedor.setCiudadNombre(rs.getString("Ciudad"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionDAO.cerrarConexion(conn, ps);
        }
        return vendedor;
    }

    public static int modificarVendedor(VendedoresDatos vendedor) throws ClassNotFoundException {
        int exito = 0;
        try {
            conn = ConexionDAO.crearConexion();
            ps = conn.prepareStatement(sql_Modificar);
            ps.setString(1, vendedor.getNombre());
            ps.setString(2, vendedor.getCorreo());
            ps.setInt(3, vendedor.getCiudad());
            ps.setInt(4, vendedor.getIdentificacion());
            exito = ps.executeUpdate();
            return exito;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionDAO.cerrarConexion(conn, ps);
        }

        return exito;
    }

    public static int eliminarVendedor(VendedoresDatos vendedor) throws ClassNotFoundException {
        int exito = 0;
        try {
            conn = ConexionDAO.crearConexion();
            ps = conn.prepareStatement(sql_Eliminar);
            ps.setInt(1, vendedor.getIdentificacion());
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
