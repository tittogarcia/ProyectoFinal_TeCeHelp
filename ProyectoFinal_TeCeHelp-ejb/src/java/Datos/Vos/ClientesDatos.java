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
public class ClientesDatos {

    private int Identificacion, Telefono, Ciudad;
    private String NombreEmpresa, NombreContacto, Direccion, Correo, Url, CiudadNombre;

    public ClientesDatos() {
    }

    public ClientesDatos(int Identificacion, int Telefono, int Ciudad, String NombreEmpresa, String NombreContacto, String Direccion, String Correo, String Url) {
        this.Identificacion = Identificacion;
        this.Telefono = Telefono;
        this.Ciudad = Ciudad;
        this.NombreEmpresa = NombreEmpresa;
        this.NombreContacto = NombreContacto;
        this.Direccion = Direccion;
        this.Correo = Correo;
        this.Url = Url;
    }

    public ClientesDatos(int Identificacion, int Telefono, String NombreEmpresa, String NombreContacto, String Direccion, String Correo, String CiudadNombre) {
        this.Identificacion = Identificacion;
        this.Telefono = Telefono;
        this.NombreEmpresa = NombreEmpresa;
        this.NombreContacto = NombreContacto;
        this.Direccion = Direccion;
        this.Correo = Correo;
        this.CiudadNombre = CiudadNombre;
    }

    public String getCiudadNombre() {
        return CiudadNombre;
    }

    public void setCiudadNombre(String CiudadNombre) {
        this.CiudadNombre = CiudadNombre;
    }

    public int getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(int Identificacion) {
        this.Identificacion = Identificacion;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public int getCiudad() {
        return Ciudad;
    }

    public void setCiudad(int Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    public void setNombreEmpresa(String NombreEmpresa) {
        this.NombreEmpresa = NombreEmpresa;
    }

    public String getNombreContacto() {
        return NombreContacto;
    }

    public void setNombreContacto(String NombreContacto) {
        this.NombreContacto = NombreContacto;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

}
