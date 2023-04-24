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
import Dao.insertar;
import Dao.busquedas;
import Beans.prereserva;

/**
 *
 * @author Brisa Marin
 */
public class PreReserva1 extends HttpServlet {
   
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

        insertar insert=new insertar();
        String paciente =request.getParameter("txtcodigo");
        String servicio=request.getParameter("cboservicio");

 
         if(paciente!=null && servicio!=null){
            boolean resultado=insert.insertPreReserva1(paciente, servicio);
        if (resultado){
            prereserva pre = null;
            busquedas buscador = new busquedas();
            try{
            pre = buscador.buscaPreReserva(paciente, servicio);
            if (pre.getPaciente() != null) {
                response.sendRedirect("Reserva06.jsp?paciente=" + pre.getPaciente() + "&especialista=" +pre.getEspecialista() + "&especialidad=" + pre.getEspecialidad() + "&fecha=" + pre.getFecha() + "&hora=" + pre.getHora() + "&servicio=" + pre.getServicio() + "&precio=" + pre.getPrecio());
            }
            else
            {
                response.sendRedirect("Reserva05.jsp?resp=4");
             }
             }catch(NullPointerException e){
               response.sendRedirect("Reserva05.jsp?resp=4");
             }

        }
        else{response.sendRedirect("Reserva05.jsp?msg=falso");}
        }else{response.sendRedirect("Reserva05.jsp?msg=nulo");}
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


