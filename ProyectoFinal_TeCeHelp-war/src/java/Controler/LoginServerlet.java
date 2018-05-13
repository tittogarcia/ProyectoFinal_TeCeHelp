/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;


import Datos.Daos.LoginDAO;
import Datos.Vos.UsuarioLogin;
import Negocio.sbLoginLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "LoginServerlet", urlPatterns = {"/LoginServerlet"})
public class LoginServerlet extends HttpServlet {
    @EJB
    sbLoginLocal log;
    String Usuario, Contrasena;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Usuario = request.getParameter("usuario");
        Contrasena = request.getParameter("contrasena");
        login(request, response);

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //UsuarioLogin miUsuario = LoginDAO.getConsultar(new UsuarioLogin(Usuario, Contrasena));
        UsuarioLogin miUsuario = log.autenticacion(Usuario, Contrasena);
        
        if (miUsuario.getUsuario() != null && miUsuario.getContrasena() != null) {
          //  request.setAttribute("miusuario", miUsuario);
           // request.getRequestDispatcher("Menu.jsp").forward(request, response);
            response.sendRedirect("Menu.jsp");

        } else {
            request.getSession().setAttribute("mensaje", new String("Usuario no Registrado"));
            response.sendRedirect("Inicio/Inicio.jsp");

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
        processRequest(request, response);
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
        processRequest(request, response);
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
