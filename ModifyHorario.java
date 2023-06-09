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
import Beans.horario;
/**
 *
 * @author CarlosM
 */
public class ModifyHorario extends HttpServlet {
   
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

        String codigo=request.getParameter("txtcodigo");
        String nombre=request.getParameter("txtnombre");
        String horae=request.getParameter("txthorae");
        String horas=request.getParameter("txthoras");
        String busca = request.getParameter("buscar");
        String modifica = request.getParameter("modificar");
        String grabar = request.getParameter("grabar");
        String eliminar = request.getParameter("eliminar");

        insertar InsertarHorario=new insertar();
        borrar elimina=new borrar();

        if(grabar != null){
         boolean result = InsertarHorario.inserthorario(nombre, horae, horas);
        if (result)
        {
        response.sendRedirect("Man_Horario.jsp?msg=Ok");
        }
        else
        {
        response.sendRedirect("Man_Horario.jsp?msg=No se Pudieron Grabar Los Datos");
        }

        }

        if (eliminar != null){
        if(codigo!=null ){
            boolean resultado1=elimina.eliminarHorario(codigo);
        if (resultado1){response.sendRedirect("Man_Horario.jsp?resp=5");}
        else{response.sendRedirect("Man_Horario.jsp?resp=6");}
        }
        }


       if (modifica != null) {
       if (codigo != null && nombre != null) {
           if(horae!=null && horas!=null ){
           modificar modify=new modificar();
        boolean result =modify.modificaHorario(codigo, nombre, horae, horas);
        if (result)
        {
        response.sendRedirect("Man_Horario.jsp?resp=1");
        }
        else
        {
        response.sendRedirect("Man_Horario.jsp?resp=2");
        }
                }
            }
       }

       if (busca != null) {
            horario hora = null;
            busquedas buscador = new busquedas();
            hora = buscador.buscaHorario(codigo);
            try{
            if (hora.getIdhorario() != null) {
                response.sendRedirect("Man_Horario.jsp?resp=3&codigo=" + hora.getIdhorario() + "&turno=" + hora.getTurno() + "&horae=" + hora.getHorae() + "&horas=" + hora.getHoras() );
            }
            else
            {
                response.sendRedirect("Man_Horario.jsp?resp=4");
             }
            }catch(NullPointerException e){
               response.sendRedirect("Man_Horario.jsp?resp=4");
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


 
