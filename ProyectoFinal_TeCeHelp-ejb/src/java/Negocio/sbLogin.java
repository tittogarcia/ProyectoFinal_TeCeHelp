/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.Daos.LoginDAO;
import Datos.Vos.UsuarioLogin;
import javax.ejb.Stateless;

/**
 *
 * @author TITTO
 */
@Stateless
public class sbLogin implements sbLoginLocal {

    public UsuarioLogin autenticacion(String Usuario, String Contrasena) {
        
        UsuarioLogin datosUsuario = new UsuarioLogin();
        datosUsuario= LoginDAO.getConsultar(new UsuarioLogin(Usuario, Contrasena));
        
        return datosUsuario;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
