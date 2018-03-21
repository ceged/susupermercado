/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Session.SessionAgentRayonLocal;
import entités.gestionArticle.Casse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Soldat
 */
@WebServlet(urlPatterns = {"/AgentRayonServlet"})
public class AgentRayonServlet extends HttpServlet {

    @EJB
    private SessionAgentRayonLocal sessionAgentRayon;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String jspChoix ="/MenuAgentRayon.jsp";
        String act=request.getParameter("action");
        if ((act == null)||(act.equals("null")))
            {
            jspChoix="/MenuAgentRayon.jsp";
            }
        else if(act.equals("insererCasse")){
            DoActionInsererCasse(request,response);
            jspChoix="/MenuAgentRayon.jsp";
        }
        else if (act.equals("passageListeCasseRayon")){
            String idAgent=request.getParameter("idAgent");
            List<Casse> liste=sessionAgentRayon.ChercherListeCasseParRayon(idAgent);
            HttpSession sess=request.getSession(true);
            sess.setAttribute("liste",liste);
            jspChoix="/GestionArticleJSP/AfficherListeCasseParRayon.jsp";
        }
            
        RequestDispatcher Rd;
        Rd= getServletContext().getRequestDispatcher(jspChoix);
        Rd.forward(request,response);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgentRayonServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgentRayonServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    protected void DoActionInsererCasse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
String idLotArticle=request.getParameter("idLotArticle");
            String quantite=request.getParameter("quantite");
            String motif=request.getParameter("motif");
            String idAgent=request.getParameter("idAgent");
            String message;
            if (quantite.trim().isEmpty()&&motif.trim().isEmpty()&&idLotArticle.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionArticleJSP/CreerCasse.jsp\">Cliquez ici</a> pour accéder au formulaire de création casse.";
} else
{
    Date d=new Date();
    int qte=Integer.valueOf(quantite);
    message=sessionAgentRayon.AjouterCasse(idAgent, d, idLotArticle, motif, qte);;
    
    
}             
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
