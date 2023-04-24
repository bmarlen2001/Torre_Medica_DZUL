/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Beans.usuario;
import Dao.busquedas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Brisa Marin
 */
public class validar extends HttpServlet {
      
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Date date = new Date();
        String hoy=String.valueOf(date);
        
        String usuario=null;
        String clave=null;
        usuario user;
        busquedas buscando=new busquedas();
        if (request.getParameter("usuario")!=null) {
            usuario=request.getParameter("usuario");
        }
        if (request.getParameter("clave")!=null) {
            clave=request.getParameter("clave");
        }
        user=buscando.logeo(usuario, clave);
        if (user!=null) {
            HttpSession sesion=request.getSession();
            sesion.setAttribute("nombre", user.getNombre());
            sesion.setAttribute("apellido", user.getApellido());
            sesion.setAttribute("cargo",user.getCargo());
            sesion.setAttribute("foto",user.getFoto());
            response.sendRedirect("Perfil_Admin.jsp");
        }
        else {
            String error="!Ingreso Datos Erroneos!";
            response.sendRedirect("Intranet.jsp?error="+error);


        }

       System.out.println(date + "------------------------------------------");
        /* fin de captura de datos */
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet validar</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet validar at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
