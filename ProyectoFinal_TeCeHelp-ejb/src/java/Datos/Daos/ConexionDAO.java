/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexionDAO {
    private static String url="jdbc:mysql://localhost:3306/worldcad";
    private static String usuario="root";
    private static String clave="root";
    private static Connection conn=null;
            
    public static Connection crearConexion() throws ClassNotFoundException{
           
          try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,usuario,clave);
            System.out.println("Conexion exitosa");
       }catch (SQLException e) {
            System.out.println("Error en la conexión:" + e.toString());
            
        }
       return conn;
    }
    
    public static void cerrarConexion(Connection conn, PreparedStatement ps){
       if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
        
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
            }
        }
        
    }
}

/*class conectar{
    public static void main(String[] arg) throws ClassNotFoundException{
       ConexionDAO.crearConexion();
       
        
    }

}*/
