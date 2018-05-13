/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Daos;

import Datos.Vos.UsuarioLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Andres
 */
public class LoginDAO {

    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static Connection conn = null;
    private static UsuarioLogin usuario;

    private static final String sql_SelectLogin = "SELECT * FROM login WHERE usuario = ? and contrasena = ?";

    public static UsuarioLogin getConsultar(UsuarioLogin usuariotest) {
        usuario = new UsuarioLogin();
        try {
            conn = ConexionDAO.crearConexion();
            ps = conn.prepareStatement(sql_SelectLogin);
            ps.setString(1, usuariotest.getUsuario());
            ps.setString(2, usuariotest.getContrasena());
            rs = ps.executeQuery();

            while (rs.next()) {
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setContrasena(rs.getString("contrasena"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConexionDAO.cerrarConexion(conn, ps);
        }
        return usuario;
    }

}
