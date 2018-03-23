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
import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
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
        
        String jspChoix ="/MenuAgentCaisse.jsp";
        String act=request.getParameter("action");
        if ((act == null)||(act.equals("null")))
            {
            jspChoix="/MenuAgentCaisse.jsp";
            }
        
        else if (act.equals("passageInfoCreerAchatCaisse"))
        {
            String message=null;
            String idAgent=request.getParameter("idAgent");
            AchatCaisse a=sessionEmployeCaisse.CreerAchatCaisse(idAgent);
            if(a!=null){
                HttpSession sess=request.getSession(true);
            List<LigneAchat> liste=sessionEmployeCaisse.ChercherLigneAchatParAchat(a);
            sess.setAttribute("liste",liste); 
            sess.setAttribute("achatCaisse",a); 
            jspChoix="/GestionArticleJSP/CreerAchatCaisse.jsp";
                
            }
            else{

            HttpSession sess=request.getSession(true);
            List<LigneAchat> liste=null;
            sess.setAttribute("listeRayon",liste); 
            jspChoix="/GestionMagasinJSP/CreerAgentRayon.jsp";

                message="vous n'êtes pas affecté à une caisse";

            }
        }
        else if (act.equals("insererLigneAchat")){
            doActioninsererLigneAchat(request,response);
            String idAchat=request.getParameter("idAchat");
            AchatCaisse a=sessionEmployeCaisse.ChercherAchatCaisseParId(idAchat);
            HttpSession sess=request.getSession(true);
            List<LigneAchat> liste=sessionEmployeCaisse.ChercherLigneAchatParAchat(a);
            sess.setAttribute("liste",liste); 
            jspChoix="/GestionArticleJSP/CreerAchatCaisse.jsp";
        }
        
        RequestDispatcher Rd;
        Rd= getServletContext().getRequestDispatcher(jspChoix);
        Rd.forward(request,response);
        
        
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

    protected void doActioninsererLigneAchat(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

            String IDLot=request.getParameter("idLotArticle");
            String IDAchat=request.getParameter("idAchat");
            String message;
            Long idLot=Long.parseLong(IDLot);
            Long idAchat=Long.parseLong(IDAchat);
            message=sessionEmployeCaisse.CreerLigneAchat(idLot, 1, idAchat);
     
   
request.setAttribute( "message", message );
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
