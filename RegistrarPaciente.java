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

/**
 *
 * @author Brisa Marin
 */
public class RegistrarPaciente extends HttpServlet {
   
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

        String apepaterno=request.getParameter("txtapepaterno");
        String apematerno=request.getParameter("txtapematerno");
        String nombre=request.getParameter("txtnombre");
        String fechanac=request.getParameter("txtfechanac");
        String lugarnac=request.getParameter("txtlugarnac");
        String sexo=request.getParameter("txtsexo");
        String estado=request.getParameter("txtestado");
        String direccion=request.getParameter("txtdireccion");
        String telefono=request.getParameter("txttelf");
        String foto=request.getParameter("txtfoto");
        String email=request.getParameter("txtemail");

        response.sendRedirect("Registro03.jsp?apepat="+apepaterno+"&foto="+foto+"&email="+email+"&apematerno="+apematerno+"&nombre="+nombre+"&fechanac="+fechanac+"&lugarnac="+lugarnac+"&sexo="+sexo+"&estado="+estado+"&direccion="+direccion+"&telefono="+telefono+"");

        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrarPaciente</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarPaciente at " + request.getContextPath () + "</h1>");
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
