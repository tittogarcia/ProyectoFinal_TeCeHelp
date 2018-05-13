/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.Vos.ClientesDatos;
import javax.ejb.Local;

/**
 *
 * @author TITTO
 */
@Local
public interface sbClienteLocal {

    

    public ClientesDatos Consultar(ClientesDatos clientesDatos);

    public int modificarCliente(ClientesDatos clientesDatos);

    public int eliminarCliente(ClientesDatos clientesDatos);

    public int crearCliente(ClientesDatos clientesDatos);

    
}
