/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.Vos.UsuarioLogin;
import javax.ejb.Local;

/**
 *
 * @author TITTO
 */
@Local
public interface sbLoginLocal {

    public UsuarioLogin autenticacion(String Usuario, String Contrasena);
    
}
