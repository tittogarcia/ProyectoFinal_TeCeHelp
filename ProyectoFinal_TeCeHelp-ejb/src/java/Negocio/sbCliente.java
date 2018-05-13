/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.Daos.ClienteDAO;
import Datos.Vos.ClientesDatos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author TITTO
 */
@Stateless
public class sbCliente implements sbClienteLocal {

    @Override
    public int crearCliente(ClientesDatos clientesDatos) {
       
       int resultado=0;
        try {
            resultado = ClienteDAO.crearCliente(clientesDatos);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sbCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return resultado;
    }

    @Override
    public ClientesDatos Consultar(ClientesDatos clientesDatos) {
     
       ClientesDatos cliente = ClienteDAO.Consultar(clientesDatos);
        
        return cliente;
     
    }

    @Override
    public int modificarCliente(ClientesDatos clientesDatos) {
         int resultado=0;
        try {
            resultado = ClienteDAO.modificarCliente(clientesDatos);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sbCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return resultado;
    }

    @Override
    public int eliminarCliente(ClientesDatos clientesDatos) {
           int resultado=0;
        try {
            resultado = ClienteDAO.eliminarCliente(clientesDatos);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sbCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return resultado;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


}
