/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import Beans.paciente;
import Dao.busquedas;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**

/**
 *
 * @author Brisa Marin
 */
public class ValidarPaciente1 extends HttpServlet {
   
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

        String usu=null;
        String pass=null;
        paciente paci;
        busquedas buscar=new busquedas();
        if (request.getParameter("usuario")!=null) {
            usu=request.getParameter("usuario");
        }
        if (request.getParameter("clave")!=null) {
            pass=request.getParameter("clave");
        }
        paci=buscar.logeoPaciente(usu, pass);
        if (paci!=null) {
            HttpSession sesion=request.getSession();
            sesion.setAttribute("codigo", paci.getCodigo());
            sesion.setAttribute("apellidop", paci.getApepaterno());
            sesion.setAttribute("apellidom",paci.getApematerno());
            sesion.setAttribute("nombre",paci.getNombres());
            sesion.setAttribute("fechanac",paci.getFechanac());
            sesion.setAttribute("fechareg",paci.getFecharegistro());
            sesion.setAttribute("lugarnac",paci.getLugarnac());
            sesion.setAttribute("fechanac",paci.getFechanac());
            sesion.setAttribute("sexo",paci.getSexo());
            sesion.setAttribute("estado",paci.getEstadocivil());
            sesion.setAttribute("direccion",paci.getDireccion());
            sesion.setAttribute("telefono",paci.getTelefono());
            sesion.setAttribute("usuario",paci.getUsuario());
            sesion.setAttribute("clave",paci.getClave());
            sesion.setAttribute("foto",paci.getFoto());
            sesion.setAttribute("observacion",paci.getObservacion());
            sesion.setAttribute("email",paci.getEmail());
        response.sendRedirect("Modifica01.jsp");
        }
        else {
            response.sendRedirect("Registro01.jsp?msg=falso");


        }


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
