/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.busquedas;
import Beans.especialista;
/**
 *
 * @author CarlosM
 */
public class MostrarEspecialista1 extends HttpServlet {
   
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

        String dato=request.getParameter("cboespecialidad");
        String apellido=request.getParameter("txtapellido");
        String ape="%" + apellido + "%";

         if (dato != null) {
             String filtro=dato;
             especialista espe = null;
             busquedas buscador = new busquedas();
            espe = buscador.buscaEspecialistaEspecialidad(filtro);
             try{
            if (espe.getCodigo() != null) {
                response.sendRedirect("Reserva02.jsp?filtro=" + filtro + "&especialidad=" + espe.getEspecialidad());
            }
            else
            {
                response.sendRedirect("Reserva01.jsp?resp=1");
             }
             }catch(NullPointerException e){
               response.sendRedirect("Reserva01.jsp?resp=1");
             }

         }else{
         String filtro=ape;
         especialista espe = null;
            busquedas buscador = new busquedas();
            espe = buscador.buscaEspecialistaEspecialidad(filtro);

                       try{
            if (espe.getCodigo() != null) {
                response.sendRedirect("Reserva02.jsp?filtro=" + filtro + "&especialidad=" + espe.getEspecialidad() + "&codigo=" + espe.getCodigo() + "&apellidos=" + espe.getApellidos() + "&nombre=" + espe.getNombre() + "&dni=" + espe.getDni() + "&telefono=" + espe.getTelefono() + "&direccion=" + espe.getDireccion() + "&especialidad=" + espe.getEspecialidad() + "&horario=" + espe.getTurno());
            }
            else
            {
                response.sendRedirect("Reserva01.jsp?resp=1");
             }
             }catch(NullPointerException e){
               response.sendRedirect("Reserva01.jsp?resp=1");
             }
            }
         

        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MostrarEspecialista</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MostrarEspecialista at " + request.getContextPath () + "</h1>");
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
