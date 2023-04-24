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
import Beans.especialidad;
/**
 *
 * @author CarlosM
 */
public class ModifyEspecialidad extends HttpServlet {
   
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
        String busca = request.getParameter("buscar");
        String modifica = request.getParameter("modificar");
        String grabar = request.getParameter("grabar");
        String eliminar = request.getParameter("eliminar");

        insertar InsertarServivio=new insertar();
        borrar elimina=new borrar();
        
        if(eliminar != null){
        if(codigo!=null ){
            boolean resultado1=elimina.eliminarEspecialidad(codigo);
        if (resultado1){response.sendRedirect("Man_Especialidad.jsp?resp=5");}
        else{response.sendRedirect("Man_Especialidad.jsp?resp=6");}
        }
         }

        if(grabar != null){
         boolean result = InsertarServivio.insertespecialidad(nombre);
        if (result)
        {
        response.sendRedirect("Man_Especialidad.jsp?msg=Ok");
        }
        else
        {
        response.sendRedirect("Man_Especialidad.jsp?msg=No");
        }

        }

        if (modifica != null) {
            if (codigo != null && nombre != null) {
                 modificar modify=new modificar();
                  boolean result =modify.modificaEspecialidad(codigo, nombre);
                    if (result)
                            {
                            response.sendRedirect("Man_Especialidad.jsp?&resp=1");
                            }
                    else
                            {
                    response.sendRedirect("Man_Especialidad.jsp?resp=2");
                    }
                }
            }

         if (busca != null) {
            especialidad esp = null;
            busquedas buscador = new busquedas();
            esp = buscador.buscaEspecialidad(codigo);
            try{
            if (esp.getIdespecialidad() != null) {
                response.sendRedirect("Man_Especialidad.jsp?resp=3&codigo=" + esp.getIdespecialidad() + "&nombre=" + esp.getNombre());
            }
            else
            {
                response.sendRedirect("Man_Especialidad.jsp?resp=4");
             }
            }catch(NullPointerException e){
               response.sendRedirect("Man_Especialidad.jsp?resp=4");
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
