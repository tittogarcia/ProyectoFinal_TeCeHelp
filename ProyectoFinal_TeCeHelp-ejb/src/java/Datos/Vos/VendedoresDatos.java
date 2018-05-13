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
public class VendedoresDatos {

    private String Nombre, Correo, ciudadNombre;
    private int ciudad, identificacion;

    public VendedoresDatos() {
    }

    public VendedoresDatos(String Nombre, String Correo, int ciudad, int identificacion) {
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.ciudad = ciudad;
        this.identificacion = identificacion;
    }

    public VendedoresDatos(String Nombre, String Correo, String ciudadNombre, int identificacion) {
        this.Nombre = Nombre;
        this.Correo = Correo;
        this.ciudadNombre = ciudadNombre;
        this.identificacion = identificacion;
    }

    public String getCiudadNombre() {
        return ciudadNombre;
    }

    public void setCiudadNombre(String ciudadNombre) {
        this.ciudadNombre = ciudadNombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getCiudad() {
        return ciudad;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

}
