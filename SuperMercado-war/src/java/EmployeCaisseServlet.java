/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Session.SessionEmployeCaisseLocal;
import entités.gestionArticle.AchatCaisse;
import entités.gestionArticle.LigneAchat;
import entités.gestionMagasin.AgentCaisse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.management.Agent;

/**
 *
 * @author CGAILLOTDREVON
 */
@WebServlet(urlPatterns = {"/EmployeCaisseServlet"})
public class EmployeCaisseServlet extends HttpServlet {

    @EJB
    private SessionEmployeCaisseLocal sessionEmployeCaisse;

    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String jspChoix ="/Accueil.jsp";
        String act=request.getParameter("action");
        if ((act == null)||(act.equals("null")))
            {
            jspChoix="/Accueil.jsp";
            }
        
        else if (act.equals("passageInfoCreerAchatCaisse"))
        {
            String message=null;
            String idAgent=request.getParameter("idAgent");
            AchatCaisse a=sessionEmployeCaisse.CreerAchatCaisse(idAgent);
            if(a==null){
                message="vous n'êtes pas affecté à une caisse";
            }
            else{
            HttpSession sess=request.getSession(true);
            List<LigneAchat> liste=
            sess.setAttribute("listeRayon",liste); 
            jspChoix="/GestionMagasinJSP/CreerAgentRayon.jsp";
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmployeCaisseServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmployeCaisseServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
