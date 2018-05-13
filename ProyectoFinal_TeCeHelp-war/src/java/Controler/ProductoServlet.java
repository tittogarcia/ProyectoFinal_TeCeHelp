/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;


import Datos.Daos.ProductosDAO;
import Datos.Vos.ProductosDatos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres
 */
@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

    String NombreParte, NombreProducto, BProducto;
    int Cantidad;
    float Precio;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        NombreParte = request.getParameter("NombreParte");
        NombreProducto = request.getParameter("NombreProducto");
        Cantidad = Integer.parseInt(request.getParameter("Cantidad"));
        Precio = Float.parseFloat(request.getParameter("PrecioVenta"));

        BProducto = request.getParameter("BProducto");

        if (BProducto.equalsIgnoreCase("Registrar")) {
            registrarProducto(request, response);
        } else if (BProducto.equalsIgnoreCase("Consultar")) {
            ConsultarProducto(request, response);
        } else if (BProducto.equalsIgnoreCase("Modificar")) {
            modificarProducto(request, response);
        } else if (BProducto.equalsIgnoreCase("Eliminar")) {
            eliminarProducto(request, response);
        }

    }

    private void registrarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {

        if (ProductosDAO.crearProducto(new ProductosDatos(NombreParte, NombreProducto, Cantidad, Precio)) == 1) {
            request.getSession().setAttribute("mensajeProducto", new String("Producto " + NombreProducto + " registrado correctamente"));
            response.sendRedirect("Producto/Producto.jsp");
        } else {
            request.getSession().setAttribute("mensajeProducto", new String("Producto con Nombre de Parte " + NombreParte + " ya existe"));
            response.sendRedirect("Producto/Producto.jsp");
        }
    }

    private void ConsultarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductosDatos ElProducto = ProductosDAO.Consultar(new ProductosDatos(NombreParte, NombreProducto, Cantidad, Precio));

        if (ElProducto.getNombreParte() != null) {
            request.getSession().setAttribute("NombreParte", new String(ElProducto.getNombreParte()));
            request.getSession().setAttribute("NombreProducto", new String(ElProducto.getNombreProducto()));
            request.getSession().setAttribute("CantidadProducto", new String(Integer.toString(ElProducto.getCantidad())));
            request.getSession().setAttribute("PrecioVenta", new String(Float.toString(ElProducto.getPrecio())));
            response.sendRedirect("Producto/ProductoMensajes.jsp");

        } else {
            request.getSession().setAttribute("mensajeProducto", new String("Producto no Registrado en el sistema"));
            response.sendRedirect("Producto/Producto.jsp");

        }

    }

    private void modificarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {

        if (ProductosDAO.modificarProducto(new ProductosDatos(NombreParte, NombreProducto, Cantidad, Precio)) == 1) {
            request.getSession().setAttribute("mensajeProducto", new String("Fue modificado el producto " + NombreProducto+ " que tiene nombre de parte "+NombreParte));
            response.sendRedirect("Producto/Producto.jsp");
        } else {
            request.getSession().setAttribute("mensajeProducto", new String("Producto con Nombre de parte " + NombreParte + " no existe"));
            response.sendRedirect("Producto/Producto.jsp");
        }
    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {

        ProductosDatos ElProducto = ProductosDAO.Consultar(new ProductosDatos(NombreParte, NombreProducto, Cantidad, Precio));

        String CNombreProducto = ElProducto.getNombreProducto(), CNombreParte = ElProducto.getNombreParte();

        if (ProductosDAO.eliminarProducto(new ProductosDatos(NombreParte, NombreProducto, Cantidad, Precio)) == 1) {

            request.getSession().setAttribute("mensajeProducto", new String("Fue Eliminado Nombre de Producto " + CNombreProducto)+" y nombre de parte "+NombreParte);
            response.sendRedirect("Producto/Producto.jsp");
        } else {
            request.getSession().setAttribute("mensajeProducto", new String("Producto con Nombre de parte " + CNombreParte + " no existe"));
            response.sendRedirect("Producto/Producto.jsp");
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
            Logger.getLogger(ProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProductoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
