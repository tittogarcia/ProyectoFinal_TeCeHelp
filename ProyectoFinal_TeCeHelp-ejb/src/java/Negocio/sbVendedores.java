/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.Daos.VendedorDAO;
import Datos.Vos.VendedoresDatos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author TITTO
 */
@Stateless
public class sbVendedores implements sbVendedoresLocal {

    @Override
    public int eliminarVendedor(VendedoresDatos vendedoresDatos) {
          int resultado=0;
        try {
            resultado = VendedorDAO.eliminarVendedor(vendedoresDatos);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sbCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return resultado;   
    
    }

    @Override
    public int modificarVendedor(VendedoresDatos vendedoresDatos) {
              int resultado=0;
        try {
            resultado = VendedorDAO.modificarVendedor(vendedoresDatos);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sbCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return resultado;
    }

    @Override
    public VendedoresDatos Consultar(VendedoresDatos vendedoresDatos) {
        VendedoresDatos cliente = VendedorDAO.Consultar(vendedoresDatos);
        
        return cliente;
    }

    @Override
    public int crearVendedor(VendedoresDatos vendedoresDatos) {
           int resultado=0;
        
        try {
            resultado = VendedorDAO.crearVendedor(vendedoresDatos);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sbCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return resultado; 
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
