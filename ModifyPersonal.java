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
import Beans.personal;


/**
 *
 * @author CarlosM
 */
public class ModifyPersonal extends HttpServlet {
   
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
        insertar insert=new insertar();
        borrar elimina=new borrar();

        String codigo=request.getParameter("txtcodigo");
        String apellidos=request.getParameter("txtapellidos");
        String nombres=request.getParameter("txtnombre");
        String dni=request.getParameter("txtdni");
        String fechanac=request.getParameter("txtfechanac");
        String telefono=request.getParameter("txttelefono");
        String direccion=request.getParameter("txtdireccion");
        String fechareg=request.getParameter("txtfechareg");
        String cargo=request.getParameter("cbocargo");
        String horario=request.getParameter("cboturno");
        String busca=request.getParameter("buscar");
        String modifica=request.getParameter("modificar");
        String grabar=request.getParameter("grabar");
        String eliminar=request.getParameter("eliminar");
        String filtro = request.getParameter("filtro");

        System.out.println(codigo);
        System.out.println(apellidos);
        System.out.println(nombres);
        System.out.println(dni);
        System.out.println(fechanac);
        System.out.println(telefono);
        System.out.println(direccion);
        System.out.println(fechareg);
        System.out.println(cargo);
        System.out.println(horario);

        if (grabar != null) {
         if(apellidos!=null && nombres!=null && telefono!=null ){
        boolean resultado=insert.insertpersonal(apellidos, nombres, dni, fechanac, telefono, direccion, fechareg, cargo, horario);
        if (resultado){response.sendRedirect("Man_Personal.jsp?msg=ok");}
        else{response.sendRedirect("Man_Personal.jsp?msg=falso");}
        }else{response.sendRedirect("Man_Personal.jsp?msg=nulo");}
        }
        
        if (eliminar != null){
        if(codigo!=null ){
            boolean resultado1=elimina.eliminarPersonal(codigo);
        if (resultado1){response.sendRedirect("Man_Personal.jsp?resp=5");}
        else{response.sendRedirect("Man_Personal.jsp?resp=6");}
        }
        }

       if (modifica != null) {
       if (codigo != null && apellidos != null) {
           if(nombres!=null && dni!=null && fechanac!=null ){
            boolean resultado=modify.modificaPersonal(codigo, apellidos, nombres, dni, fechanac, telefono, direccion, fechareg, cargo, horario);
        if (resultado){response.sendRedirect("Man_Personal.jsp?resp=1");}
        else{response.sendRedirect("Man_Personal.jsp?resp=2");}
        }else{response.sendRedirect("Man_Personal.jsp?msg=nulo");}

       }
       }

         if (busca != null) {
            personal per = null;
            busquedas buscador = new busquedas();
            per = buscador.buscaPersonal(codigo);
            try{
            if (per.getCodigo() != null) {
                response.sendRedirect("Man_Personal.jsp?resp=3&codigo=" + per.getCodigo() + "&apellidos=" + per.getApellidos() + "&nombres=" + per.getNombres() + "&dni=" + per.getDni() + "&fechanac=" + per.getFechanac() + "&telefono=" + per.getTelefono() + "&fechareg=" + per.getFechareg() + "&direccion=" + per.getDireccion() + "&cargo=" + per.getIdcargo() + "&horario=" + per.getIdhorario());
            }
            else
            {
                response.sendRedirect("Man_Personal.jsp?resp=4");
             }
            }catch(NullPointerException e){
               response.sendRedirect("Man_Paciente.jsp?resp=4");
             }
            }

        if (filtro != null) {
            personal per = null;
            busquedas buscador = new busquedas();
            per = buscador.buscaPersonal(filtro);
            try{
            if (per.getCodigo() != null) {
                response.sendRedirect("Man_Personal.jsp?resp=3&codigo=" + per.getCodigo() + "&apellidos=" + per.getApellidos() + "&nombres=" + per.getNombres() + "&dni=" + per.getDni() + "&fechanac=" + per.getFechanac() + "&telefono=" + per.getTelefono() + "&fechareg=" + per.getFechareg() + "&direccion=" + per.getDireccion() + "&cargo=" + per.getIdcargo() + "&horario=" + per.getIdhorario());
            }
            else
            {
                response.sendRedirect("Man_Personal.jsp?resp=4");
             }
            }catch(NullPointerException e){
               response.sendRedirect("Man_Paciente.jsp?resp=4");
             }
            }

  try {

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
