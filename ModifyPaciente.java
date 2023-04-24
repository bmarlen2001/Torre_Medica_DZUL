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
import Beans.paciente;
/**
 *
 * @author CarlosM
 */
public class ModifyPaciente extends HttpServlet {
   
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
        String apepaterno=request.getParameter("txtapepaterno");
        String apematerno=request.getParameter("txtapematerno");
        String nombre=request.getParameter("txtnombre");
        String fechanac=request.getParameter("txtfechanac");
        String lugarnac=request.getParameter("txtlugarnac");
        String sexo=request.getParameter("txtsexo");
        String estado=request.getParameter("txtestado");
        String direccion=request.getParameter("txtdireccion");
        String telefono=request.getParameter("txttelf");
        String fehareg=request.getParameter("txtfechareg");
        String observacion=request.getParameter("txtobservacion");
        String foto=request.getParameter("txtfoto");
        String email=request.getParameter("txtemail");
        String user=request.getParameter("txtusuario");
        String clave=request.getParameter("txtclave");
        String busca = request.getParameter("buscar");
        String modifica = request.getParameter("modificar");
        String mod = request.getParameter("mod");
        String grabar = request.getParameter("grabar");
        String eliminar = request.getParameter("eliminar");

        System.out.println(apepaterno);
        System.out.println(apematerno);
        System.out.println(nombre);
        System.out.println(fechanac);
        System.out.println(lugarnac);
        System.out.println(sexo);
        System.out.println(estado);
        System.out.println(direccion);
        System.out.println(telefono);
        System.out.println(fehareg);
        System.out.println(observacion);
        System.out.println(foto);
        System.out.println(email);
        System.out.println(user);
        System.out.println(clave);


        if(grabar != null){
         if(apepaterno!=null && direccion!=null && telefono!=null ){
            boolean resultado=insert.insertpaciente(apepaterno, apematerno, nombre, fechanac, lugarnac, sexo, estado, direccion, telefono, fehareg, observacion, email, foto, user, clave);
        if (resultado){response.sendRedirect("Man_Paciente.jsp?msg=Ok");}
        else{response.sendRedirect("Man_Paciente.jsp?msg=falso");}
        }else{response.sendRedirect("Man_Paciente.jsp?msg=nulo");}
        }

        if(eliminar != null){
        if(codigo!=null ){
            boolean resultado1=elimina.eliminarPaciente(codigo);
        if (resultado1){response.sendRedirect("Man_Paciente.jsp?resp=5");}
        else{response.sendRedirect("Man_Paciente.jsp?resp=5");}
        }
        }

       if (modifica != null) {
       if (codigo != null && apepaterno != null) {
           if(apematerno!=null && fechanac!=null && lugarnac!=null ){
            boolean resultado=modify.modificaPaciente1(codigo, apepaterno, apematerno, nombre, fechanac, lugarnac, sexo, estado, direccion, telefono, fehareg, observacion, email, foto, user, clave);
       if (resultado){response.sendRedirect("Man_Paciente.jsp?resp=1");}
        else{response.sendRedirect("Man_Paciente.jsp?resp=2");}
        }else{response.sendRedirect("Man_Paciente.jsp?msg=nulo");}
                }
            }
  if (mod != null) {
       if (codigo != null && apepaterno != null) {
           if(apematerno!=null && fechanac!=null && lugarnac!=null ){
            boolean resultado=modify.modificaPaciente(codigo, apepaterno, apematerno, nombre, fechanac, lugarnac, sexo, estado, direccion, telefono, fehareg, observacion, email, foto);
       if (resultado){response.sendRedirect("Modifica02.jsp?resp=1");}
        else{response.sendRedirect("Modifica02.jsp?resp=2");}
        }else{response.sendRedirect("Modifica02.jsp?msg=nulo");}
                }
            }




         if (busca != null) {
            paciente pac = null;
            busquedas buscador = new busquedas();
            try{
            pac = buscador.buscaPaciente(codigo);
            if (pac.getCodigo() != null) {
                response.sendRedirect("Man_Paciente.jsp?resp=3&codigo=" + pac.getCodigo() + "&apepat=" + pac.getApepaterno() + "&email=" + pac.getEmail() + "&user=" + pac.getUsuario() + "&clave=" + pac.getClave() + "&apemat=" + pac.getApematerno() + "&nombres=" + pac.getNombres() + "&fechanac=" + pac.getFechanac() + "&lugarnac=" + pac.getLugarnac() + "&sexo=" + pac.getSexo() + "&estado=" + pac.getEstadocivil() + "&direccion=" + pac.getDireccion() + "&telefono=" + pac.getTelefono() + "&imagen=" + pac.getFoto() + "&fechareg=" + pac.getFecharegistro() + "&observacion=" + pac.getObservacion());
            }
            else
            {
                response.sendRedirect("Man_Paciente.jsp?resp=4");
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
