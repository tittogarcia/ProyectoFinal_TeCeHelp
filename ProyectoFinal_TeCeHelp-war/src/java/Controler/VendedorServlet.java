/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;


import Datos.Daos.VendedorDAO;
import Datos.Vos.VendedoresDatos;
import Negocio.sbVendedores;
import Negocio.sbVendedoresLocal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
@WebServlet(name = "VendedorServlet", urlPatterns = {"/VendedorServlet"})
public class VendedorServlet extends HttpServlet {
@EJB

sbVendedoresLocal CL;
        
    String Nombre, Correo, BVendedor, ciudadNombre;
    int Identificacion, Ciudad;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");

        Nombre = request.getParameter("nombre");
        Identificacion = Integer.parseInt(request.getParameter("identificacion"));
        Correo = request.getParameter("correo");
        Ciudad = Integer.parseInt(request.getParameter("ciudad"));

        BVendedor = request.getParameter("BVendedor");

        if (BVendedor.equalsIgnoreCase("Registrar")) {
            registrarVendedor(request, response);
        } else if (BVendedor.equalsIgnoreCase("Consultar")) {
            ConsultarVendedor(request, response);
        } else if (BVendedor.equalsIgnoreCase("Modificar")) {
            modificarVendedor(request, response);
        } else if (BVendedor.equalsIgnoreCase("Eliminar")) {
            eliminarVendedor(request, response);
        }

    }

    private void registrarVendedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {

        if (CL.crearVendedor(new VendedoresDatos(Nombre, Correo, Ciudad, Identificacion)) == 1) {
            request.getSession().setAttribute("mensajeVendedor", new String("Vendedor " + Nombre + " registrado correctamente"));
            response.sendRedirect("Vendedor/Vendedor.jsp");
        } else {
            request.getSession().setAttribute("mensajeVendedor", new String("Vendedor con Identificación " + Identificacion + " ya existe"));
            response.sendRedirect("Vendedor/Vendedor.jsp");
        }
    }

    private void ConsultarVendedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VendedoresDatos ElVendedor = CL.Consultar(new VendedoresDatos(Nombre, Correo, ciudadNombre, Identificacion));

        if (ElVendedor.getNombre() != null) {
            request.getSession().setAttribute("NombreVendedor", new String(ElVendedor.getNombre()));
            System.out.println(ElVendedor.getNombre());
            request.getSession().setAttribute("IdentificacionVendedor", new String(Integer.toString(ElVendedor.getIdentificacion())));
            System.out.println(ElVendedor.getIdentificacion());
            request.getSession().setAttribute("CorreoVendedor", new String(ElVendedor.getCorreo()));
            System.out.println(ElVendedor.getCorreo());
            request.getSession().setAttribute("CiudadVendedor", new String(ElVendedor.getCiudadNombre()));
            System.out.println(ElVendedor.getCiudad());
            response.sendRedirect("Vendedor/VendedorMensajes.jsp");

        } else {
            request.getSession().setAttribute("mensajeVendedor", new String("Vendedor no Registrado en el sistema"));
            response.sendRedirect("Vendedor/Vendedor.jsp");

        }

    }

    private void modificarVendedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {

        if (CL.modificarVendedor(new VendedoresDatos(Nombre, Correo, Ciudad, Identificacion)) == 1) {
            request.getSession().setAttribute("mensajeVendedor", new String("Fue modificado el vendedor " + Nombre));
            response.sendRedirect("Vendedor/Vendedor.jsp");
        } else {
            request.getSession().setAttribute("mensajeVendedor", new String("Vendedor con identificación " + Identificacion + " no existe"));
            response.sendRedirect("Vendedor/Vendedor.jsp");
        }
    }

    private void eliminarVendedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {

         VendedoresDatos ElVendedor = CL.Consultar(new VendedoresDatos(Nombre, Correo, ciudadNombre, Identificacion));
        
         String CNombre= ElVendedor.getNombre();
         int CId = ElVendedor.getIdentificacion();
         
        if (CL.eliminarVendedor(new VendedoresDatos(Nombre, Correo, Ciudad, Identificacion)) == 1) {
                        
            request.getSession().setAttribute("mensajeVendedor", new String("Fue eliminado el vendedor " + CNombre + " Con Identificación "+CId));
            response.sendRedirect("Vendedor/Vendedor.jsp");
        } else {
            request.getSession().setAttribute("mensajeVendedor", new String("Vendedor con identificación " + Identificacion + " no existe"));
            response.sendRedirect("Vendedor/Vendedor.jsp");
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
            Logger.getLogger(VendedorServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(VendedorServlet.class.getName()).log(Level.SEVERE, null, ex);
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
