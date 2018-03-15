/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Session.SessionChefDeRayonLocal;
import entités.gestionArticle.SousCategorie;
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

/**
 *
 * @author Soldat
 */
@WebServlet(urlPatterns = {"/ChefRayonServlet"})
public class ChefRayonServlet extends HttpServlet {

    @EJB
    private SessionChefDeRayonLocal sessionChefDeRayon;

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
        String jspChoix ="/MenuChefdeRayon.jsp";
        String act=request.getParameter("action");
        if ((act == null)||(act.equals("null")))
            {
            jspChoix="/MenuChefdeRayon.jsp";
            }
        else if (act.equals("creerArticle"))
        {
            List<SousCategorie> listeSousCategorie = sessionChefDeRayon.ListerSousCategorie();
            HttpSession sess=request.getSession(true);
            sess.setAttribute("listeSousCategorie",listeSousCategorie); 
            jspChoix="/GestionArticleJSP/CreerArticle.jsp";
        }
        else if (act.equals("insererReferentielArticle")){
            doActionInserReferentielArticle(request,response);
            jspChoix="/MenuChefdeRayon.jsp";
        }
        
        RequestDispatcher Rd;
        Rd= getServletContext().getRequestDispatcher(jspChoix);
        Rd.forward(request,response);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChefRayonServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChefRayonServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    protected void doActionInserReferentielArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String libelleArticleCree= request.getParameter( "libelleArticle" );
    String magasinCree= request.getParameter( "magasin" );
    String rayonCree= request.getParameter( "rayon" );
    String marqueCree= request.getParameter( "marque" );
    String prixCree= request.getParameter( "prix" );
    String souscateogireCree= request.getParameter( "souscategorie" );
    String message;
    if ( libelleArticleCree.trim().isEmpty()&&magasinCree.trim().isEmpty()&&marqueCree.trim().isEmpty()&&prixCree.trim().isEmpty()&&souscateogireCree.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionArticle/CreerArticle.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un article.";
} else
{
    Float prixVente=Float.parseFloat(prixCree);
    message=sessionChefDeRayon.CreerReferentielArticle(libelleArticleCree, magasinCree, rayonCree, marqueCree, prixVente, souscateogireCree);
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
