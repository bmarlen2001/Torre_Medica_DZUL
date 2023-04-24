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
import Dao.busquedas;
import Beans.especialista;

/**
 *
 * @author CarlosM
 */
public class ModifyEspecialista extends HttpServlet {
   
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
        modificar modify=new modificar();
        borrar elimina=new borrar();
        insertar insert=new insertar();
        String codigo=request.getParameter("txtcodigo");
        String apellidos=request.getParameter("txtapellidos");
        String nombre=request.getParameter("txtnombre");
        String dni=request.getParameter("txtdni");
        String telefono=request.getParameter("txttelf");
        String direccion=request.getParameter("txtdireccion");
        String especialidad=request.getParameter("cboespecialidad");
        String turno=request.getParameter("cboturno");
        String busca = request.getParameter("buscar");
        String modifica = request.getParameter("modificar");
        String graba = request.getParameter("grabar");
        String eliminar = request.getParameter("eliminar");
        String filtro = request.getParameter("filtro");

        System.out.println(codigo);
        System.out.println(apellidos);
        System.out.println(nombre);
        System.out.println(dni);
        System.out.println(telefono);
        System.out.println(direccion);
        System.out.println(especialidad);
        System.out.println(turno);


        if(graba != null){
            if(apellidos!=null && nombre!=null && dni!=null ){
            boolean resultado=insert.insertespecialista(apellidos, nombre, dni, telefono, direccion, especialidad, turno);
        if (resultado){response.sendRedirect("Man_Especialista.jsp?msg=ok");}
        else{response.sendRedirect("Man_Especialista.jsp?msg=falso");}
        }else{response.sendRedirect("Man_Especialista.jsp?msg=nulo");}
        }

        if(eliminar != null){
         if(codigo!=null ){
            boolean resultado1=elimina.eliminarEspecialista(codigo);
        if (resultado1){response.sendRedirect("Man_Especialista.jsp?resp=5");}
        else{response.sendRedirect("Man_Especialista.jsp?resp=6");}
        }
        }

       if (modifica != null) {
       if (codigo != null && nombre != null) {
           if(apellidos!=null && nombre!=null && dni!=null ){
            boolean resultado=modify.modificaEspecialista(codigo, apellidos, nombre, dni, telefono, direccion, especialidad, turno);
        if (resultado){response.sendRedirect("Man_Especialista.jsp?resp=1");}
        else{response.sendRedirect("Man_Especialista.jsp?resp=2");}
        }else{response.sendRedirect("Man_Especialista.jsp?msg=nulo");}

                }
            }

         if (busca != null) {
            especialista espe = null;
            busquedas buscador = new busquedas();
            espe = buscador.buscaEspecialista(codigo);
            try{
            if (espe.getCodigo() != null) {
                response.sendRedirect("Man_Especialista.jsp?resp=3&codigo=" + espe.getCodigo() + "&apellidos=" + espe.getApellidos() + "&nombre=" + espe.getNombre() + "&dni=" + espe.getDni() + "&telefono=" + espe.getTelefono() + "&direccion=" + espe.getDireccion() + "&especialidad=" + espe.getEspecialidad() + "&horario=" + espe.getTurno());
            }
            else
            {
                response.sendRedirect("Man_Especialista.jsp?resp=4");
             }
             }catch(NullPointerException e){
               response.sendRedirect("Man_Especialista.jsp?resp=4");
             }
            }


            if (filtro != null) {
            especialista espe = null;
            busquedas buscador = new busquedas();
            espe = buscador.buscaEspecialista(filtro);
            try{
            if (espe.getCodigo() != null) {
                response.sendRedirect("Man_Especialista.jsp?resp=3&codigo=" + espe.getCodigo() + "&apellidos=" + espe.getApellidos() + "&nombre=" + espe.getNombre() + "&dni=" + espe.getDni() + "&telefono=" + espe.getTelefono() + "&direccion=" + espe.getDireccion() + "&especialidad=" + espe.getEspecialidad() + "&horario=" + espe.getTurno());
            }
            else
            {
                response.sendRedirect("Man_Especialista.jsp?resp=4");
             }
             }catch(NullPointerException e){
               response.sendRedirect("Man_Especialista.jsp?resp=4");
             }
            }





        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet insertpaciente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet insertpaciente at " + request.getContextPath () + "</h1>");
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
