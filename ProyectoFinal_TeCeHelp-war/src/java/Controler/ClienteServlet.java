/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Datos.Daos.ClienteDAO;
import Datos.Vos.ClientesDatos;
import Negocio.sbClienteLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    @EJB
    sbClienteLocal cl;
    private int Identificacion, Telefono, Ciudad;
    private String NombreEmpresa, NombreContacto, Direccion, Correo, Url, CiudadNombre, BCliente;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        Identificacion = Integer.parseInt(request.getParameter("id"));
        NombreEmpresa = request.getParameter("nombreempre");
        NombreContacto = request.getParameter("nombrecli");
        Direccion = request.getParameter("direccion");
        Correo = request.getParameter("correo");
        Url = request.getParameter("url");
        Telefono = Integer.parseInt(request.getParameter("telefono"));
        Ciudad = Integer.parseInt(request.getParameter("ciudad"));

        BCliente = request.getParameter("opcion");

        if (BCliente.equalsIgnoreCase("registrar")) {
            crearCliente(request, response);
        } else if (BCliente.equalsIgnoreCase("consultar")) {
            consultarCliente(request, response);
        } else if (BCliente.equalsIgnoreCase("modificar")) {
            modificarCliente(request, response);
        } else if (BCliente.equalsIgnoreCase("eliminar")) {
            eliminarCliente(request, response);
        }

    }

    private void crearCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        if (cl.crearCliente(new ClientesDatos(Identificacion, Telefono, Ciudad, NombreEmpresa, NombreContacto, Direccion, Correo, Url)) == 1) {
            request.getSession().setAttribute("mensajeCliente", new String("Cliente con identificación " + Identificacion + " registrado correctamente"));
            response.sendRedirect("Clientes/Clientes.jsp");
        } else {
            request.getSession().setAttribute("mensajeCliente", new String("Cliente con identificación " + Identificacion + " ya existe"));
            response.sendRedirect("Clientes/Clientes.jsp");
        }
    }

    private void consultarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientesDatos ElCliente = cl.Consultar(new ClientesDatos(Identificacion, Telefono, NombreEmpresa, NombreContacto, Direccion, Correo, CiudadNombre));

        if (ElCliente.getNombreContacto() != null) {
            request.getSession().setAttribute("IdentificaciónCliente", new String(Integer.toString(ElCliente.getIdentificacion())));
            request.getSession().setAttribute("NombreEmpresaCliente", new String(ElCliente.getNombreEmpresa()));
            request.getSession().setAttribute("NombreCliente", new String(ElCliente.getNombreContacto()));
            request.getSession().setAttribute("DireccionCliente", new String(ElCliente.getDireccion()));
            request.getSession().setAttribute("CorreoCliente", new String(ElCliente.getCorreo()));
            request.getSession().setAttribute("UrlCliente", new String(ElCliente.getUrl()));
            request.getSession().setAttribute("TelefonoCliente", new String(Integer.toString(ElCliente.getTelefono())));
            request.getSession().setAttribute("CiudadCliente", new String(ElCliente.getCiudadNombre()));

            response.sendRedirect("Clientes/ClienteMensajes.jsp");

        } else {
            request.getSession().setAttribute("mensajeCliente", new String("Cliente no Registrado en el sistema"));
            response.sendRedirect("Clientes/Clientes.jsp");

        }

    }

    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {

        if (cl.modificarCliente(new ClientesDatos(Identificacion, Telefono, Ciudad, NombreEmpresa, NombreContacto, Direccion, Correo, Url)) == 1) {
            request.getSession().setAttribute("mensajeCliente", new String("Fue modificado el cliente con identificación " + Identificacion));
            response.sendRedirect("Clientes/Clientes.jsp");
        } else {
            request.getSession().setAttribute("mensajeCliente", new String("Producto con identificación " + Identificacion + " no existe"));
            response.sendRedirect("Clientes/Clientes.jsp");
        }
    }

    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {

        ClientesDatos ElCliente = cl.Consultar(new ClientesDatos(Identificacion, Telefono, NombreEmpresa, NombreContacto, Direccion, Correo, CiudadNombre));

        int CIdentificación = ElCliente.getIdentificacion();

        if (cl.eliminarCliente(new ClientesDatos(Identificacion, Telefono, Ciudad, NombreEmpresa, NombreContacto, Direccion, Correo, Url)) == 1) {

            request.getSession().setAttribute("mensajeCliente", new String("Fue Eliminado cliente con identificación " + CIdentificación));
            response.sendRedirect("Clientes/Clientes.jsp");
        } else {
            request.getSession().setAttribute("mensajeCliente", new String("Cliente con identificación " + Identificacion + " no existe"));
            response.sendRedirect("Clientes/Clientes.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
