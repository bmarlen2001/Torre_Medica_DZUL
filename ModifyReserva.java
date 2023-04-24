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

import Dao.*;
import Beans.reserva;
/**
 *
 * @author CarlosM
 */
public class ModifyReserva extends HttpServlet {
   
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

        insertar RegisReser=new insertar();
        borrar elimina=new borrar();
        modificar modify =new modificar();


        String codigo=request.getParameter("txtcodigo");
        String fecha=request.getParameter("txtfecha");
        String hora=request.getParameter("reloj");
        String IdPac=request.getParameter("txtpaciente");
        String IdSer=request.getParameter("cboservicio");
        String IdEsp=request.getParameter("cboespecialista");
        String des=request.getParameter("txtdescripcion");
   
        String busca=request.getParameter("buscar");
        String modifica=request.getParameter("modificar");
        String grabar=request.getParameter("grabar");
        String eliminar=request.getParameter("eliminar");

        System.out.println(codigo);
        System.out.println(fecha);
        System.out.println(hora);
        System.out.println(IdPac);
        System.out.println(IdSer);
        System.out.println(IdEsp);
        System.out.println(des);

        

        if (grabar != null){
        boolean result = RegisReser.inserReser(fecha, hora, IdPac, IdSer, IdEsp, des);
        if (result)
        {
        response.sendRedirect("Man_Reserva.jsp?msg=Ok");
        }
        else
        {
        response.sendRedirect("Man_Reserva.jsp?msg=No");
        }
        }

       if (modifica != null) {
       if (codigo != null && fecha != null) {
           if(hora!=null){
       boolean result = modify.modificaReserva(codigo, fecha, hora, IdPac, IdSer, IdEsp, des, des);
        if (result)
        {
        response.sendRedirect("Man_Reserva.jsp?resp=1");
        }
        else
        {
        response.sendRedirect("Man_Reserva.jsp?resp=2");
        }
        }
        }
        }

        if(eliminar != null){
        if(codigo != null ){
        boolean resultado1=elimina.eliminarReserva(codigo);
        if (resultado1){response.sendRedirect("Man_Reserva.jsp?resp=5");}
        else{response.sendRedirect("Man_Reserva.jsp?resp=6");}
        }
        }

         if (busca != null) {
            reserva res = null;
            busquedas buscador = new busquedas();
            res = buscador.buscaReserva(codigo);
            try{
            if (res.getNumero() != null) {
                response.sendRedirect("Man_Reserva.jsp?resp=3&codigo=" + res.getNumero() + "&fecha=" + res.getFecha() + "&hora=" + res.getHora() + "&paciente=" + res.getPaciente() + "&servicio=" + res.getServicio() + "&especialista=" + res.getEspecialista() + "&descripcion=" + res.getDescripcion());

            }
            else
            {
                response.sendRedirect("Man_Reserva.jsp?resp=4");
             }
             }catch(NullPointerException e){
               response.sendRedirect("Man_Reserva.jsp?resp=4");
             }
            }

           try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Reserva</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Reserva at " + request.getContextPath () + "</h1>");
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
