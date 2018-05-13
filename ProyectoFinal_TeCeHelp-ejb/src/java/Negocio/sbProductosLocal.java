/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.Vos.ProductosDatos;
import javax.ejb.Local;

/**
 *
 * @author TITTO
 */
@Local
public interface sbProductosLocal {

    public int crearProducto(ProductosDatos productosDatos);

    public ProductosDatos Consultar(ProductosDatos productosDatos);

    public int modificarProducto(ProductosDatos productosDatos);

    public int eliminarProducto(ProductosDatos productosDatos);
    
}
