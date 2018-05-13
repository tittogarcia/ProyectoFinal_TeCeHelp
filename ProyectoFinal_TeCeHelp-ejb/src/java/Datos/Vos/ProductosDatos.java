/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Vos;

/**
 *
 * @author Andres
 */
public class ProductosDatos {    
    
    private String NombreParte, NombreProducto;
    private int Cantidad;
    private float Precio;

    public ProductosDatos() {
    }

    public ProductosDatos(String NombreParte, String NombreProducto, int Cantidad, float Precio) {
        this.NombreParte = NombreParte;
        this.NombreProducto = NombreProducto;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
    }

    public String getNombreParte() {
        return NombreParte;
    }

    public void setNombreParte(String NombreParte) {
        this.NombreParte = NombreParte;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }
    
    
    
}
