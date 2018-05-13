/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Daos;

import Datos.Vos.ClientesDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Andres
 */
public class ClienteDAO {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static Connection conn = null;
    private static ClientesDatos Cliente;

    private static final String sql_Insert = "insert into clientes(IDENTIFICACION,NOMBRE_EMPRESA,NOMBRE_CONTACTO,DIRECCION,CORREO,URL,TELEFONO,CIUDAD_ID) values(?,?,?,?,?,?,?,?)";
    private static final String sql_consultar = "Select IDENTIFICACION,NOMBRE_EMPRESA,NOMBRE_CONTACTO,DIRECCION,CORREO,URL,TELEFONO,CIUDAD FROM clientes, ciudades WHERE  identificacion=? and (clientes.CIUDAD_ID=ciudades.CIUDAD_ID)";
    private static final String sql_Modificar = "UPDATE clientes SET NOMBRE_EMPRESA=?,NOMBRE_CONTACTO=?,DIRECCION=?,CORREO=?,URL=?,TELEFONO=?,CIUDAD_ID=? where IDENTIFICACION=?";
    private static final String sql_Eliminar = "delete from clientes where IDENTIFICACION=?";

    public static int crearCliente(ClientesDatos cliente) throws ClassNotFoundException {
        int exito = 0;
        try {
            conn = ConexionDAO.crearConexion();
            ps = conn.prepareStatement(sql_Insert);

            ps.setInt(1, cliente.getIdentificacion());
            ps.setString(2, cliente.getNombreEmpresa());
            ps.setString(3, cliente.getNombreContacto());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getCorreo());
            ps.setString(6, cliente.getUrl());
            ps.setInt(7, cliente.getTelefono());
            ps.setInt(8, cliente.getCiudad());

            exito = ps.executeUpdate();
            return exito;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionDAO.cerrarConexion(conn, ps);
        }

        return exito;
    }

    public static ClientesDatos Consultar(ClientesDatos clientes) {
        Cliente = new ClientesDatos();
        try {
            conn = ConexionDAO.crearConexion();
            ps = conn.prepareStatement(sql_consultar);
            ps.setInt(1, clientes.getIdentificacion());
            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente.setIdentificacion(rs.getInt("IDENTIFICACION"));
                Cliente.setNombreEmpresa(rs.getString("NOMBRE_EMPRESA"));
                Cliente.setNombreContacto(rs.getString("NOMBRE_CONTACTO"));
                Cliente.setDireccion(rs.getString("DIRECCION"));
                Cliente.setCorreo(rs.getString("CORREO"));
                Cliente.setUrl(rs.getString("URL"));
                Cliente.setTelefono(rs.getInt("TELEFONO"));
                Cliente.setCiudadNombre(rs.getString("CIUDAD"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionDAO.cerrarConexion(conn, ps);
        }
        return Cliente;
    }

    public static int modificarCliente(ClientesDatos Cliente) throws ClassNotFoundException {
        int exito = 0;
        try {
            conn = ConexionDAO.crearConexion();
            ps = conn.prepareStatement(sql_Modificar);

            ps.setString(1, Cliente.getNombreEmpresa());
            ps.setString(2, Cliente.getNombreContacto());
            ps.setString(3, Cliente.getDireccion());
            ps.setString(4, Cliente.getCorreo());
            ps.setString(5, Cliente.getUrl());
            ps.setInt(6, Cliente.getTelefono());
            ps.setInt(7, Cliente.getCiudad());
            ps.setInt(8, Cliente.getIdentificacion());

            exito = ps.executeUpdate();
            return exito;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionDAO.cerrarConexion(conn, ps);
        }

        return exito;
    }

    public static int eliminarCliente(ClientesDatos Cliente) throws ClassNotFoundException {
        int exito = 0;
        try {
            conn = ConexionDAO.crearConexion();
            ps = conn.prepareStatement(sql_Eliminar);
            ps.setInt(1, Cliente.getIdentificacion());
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
