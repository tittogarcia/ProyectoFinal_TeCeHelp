/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.Daos.ClienteDAO;
import Datos.Daos.ProductosDAO;
import Datos.Vos.ProductosDatos;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author TITTO
 */
@Stateless
public class sbProductos implements sbProductosLocal {

    @Override
    public int crearProducto(ProductosDatos productosDatos) {
        
        int resultado=0;
        try {
            resultado = ProductosDAO.crearProducto(productosDatos);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sbProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
}
    @Override
    public ProductosDatos Consultar(ProductosDatos productosDatos) {
        
        ProductosDatos productos = ProductosDAO.Consultar(productosDatos);
        
        return productos;
    }

    @Override
    public int modificarProducto(ProductosDatos productosDatos) {
              int resultado=0;
        try {
            resultado = ProductosDAO.modificarProducto(productosDatos);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sbProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;  
    }

    @Override
    public int eliminarProducto(ProductosDatos productosDatos) {
                int resultado=0;
        try {
            resultado = ProductosDAO.eliminarProducto(productosDatos);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sbProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
