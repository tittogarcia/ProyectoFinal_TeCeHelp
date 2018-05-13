/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.Vos.VendedoresDatos;
import javax.ejb.Local;

/**
 *
 * @author TITTO
 */
@Local
public interface sbVendedoresLocal {

    public int eliminarVendedor(VendedoresDatos vendedoresDatos);

    public int modificarVendedor(VendedoresDatos vendedoresDatos);

    public VendedoresDatos Consultar(VendedoresDatos vendedoresDatos);

    public int crearVendedor(VendedoresDatos vendedoresDatos);
    
}
