/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Session.SessionChefDeRayonLocal;
import Session.SessionFournisseurLocal;
import entités.gestionCommande.Commande;
import entités.gestionCommande.Fournisseur;
import entités.gestionCommande.LigneCommande;
import entités.gestionLivraison.LigneLivraison;
import entités.gestionLivraison.Livraison;
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
@WebServlet(urlPatterns = {"/FournisseurServlet"})
public class FournisseurServlet extends HttpServlet {

    @EJB
    private SessionChefDeRayonLocal sessionChefDeRayon;

    @EJB
    private SessionFournisseurLocal sessionFournisseur;

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
        String jspChoix ="/MenuFournisseur.jsp";
        String act=request.getParameter("action");
        if((act == null)||(act.equals("null")))
            {
            jspChoix="/MenuFournisseur.jsp";
            }
        else if (act.equals("passageInfosListeCommande"))
        {
            String idFournisseur=request.getParameter("fournisseur");
            List<Livraison> liste=sessionFournisseur.ChercherListeLivraisonParFournisseur(idFournisseur);
            HttpSession sess=request.getSession(true);
            sess.setAttribute("liste",liste);
            jspChoix="/GestionCommandeJSP/AfficherListeCommandeFournisseur.jsp";
        }
        else if (act.equals("ChoisirDateLivraison")){
            String idFournisseur=request.getParameter("fournisseurId");
            String date1=request.getParameter("date1");
            String date2=request.getParameter("date2");
            if(date1.isEmpty()&&date2.isEmpty()){
                List<Livraison> liste=sessionFournisseur.ChercherListeLivraisonParFournisseur(idFournisseur);
                HttpSession sess=request.getSession(true);
                sess.setAttribute("liste",liste);
               jspChoix="/GestionCommandeJSP/AfficherListeCommandeFournisseur.jsp"; 
            }
            else{
            Date d1=Date.valueOf(date1);
            Date d2=Date.valueOf(date2);
            Fournisseur f= sessionFournisseur.ChercherFournisseurParId(idFournisseur);
            List<Livraison> liste= sessionFournisseur.ChercherListeLivraisonParFournisseurEntreDate(f, d1, d2);
            HttpSession sess=request.getSession(true);
            sess.setAttribute("liste",liste);
            jspChoix="/GestionCommandeJSP/AfficherListeCommandeFournisseur.jsp";
            }
            
        }
        else if (act.equals("afficherCommandeFournisseur")){
            String idLivraison=request.getParameter("livraisonId");
            Livraison livraison=sessionFournisseur.ChercherLivraisonParId(idLivraison);
            List<LigneLivraison> liste=sessionFournisseur.ChercherListeLigneLivraisonParLivraison(livraison);
            HttpSession sess=request.getSession(true);
            sess.setAttribute("livraison",livraison);
            sess.setAttribute("liste",liste);
            jspChoix="/GestionCommandeJSP/AfficherCommandeFournisseur.jsp"; 
        }
        else if(act.equals("ValiderLigneLivraison")){
               String idLigneLivraison=request.getParameter("ligneId");
               String livraisonId=request.getParameter("livraisonId");
               LigneLivraison l = sessionFournisseur.ChercherLigneLivraisonParId(idLigneLivraison);
               Livraison livraison = sessionFournisseur.ChercherLivraisonParId(livraisonId);
               String statut="valider";
               sessionFournisseur.ModifierStatutLigneLivraison(l, statut);
               List<LigneLivraison> liste=sessionFournisseur.ChercherListeLigneLivraisonParLivraison(livraison);
               HttpSession sess=request.getSession(true);
                sess.setAttribute("livraison",livraison);
                sess.setAttribute("liste",liste);
                jspChoix="/GestionCommandeJSP/AfficherCommandeFournisseur.jsp";
            }
        else if(act.equals("ExclureLigneLivraison")){
               String idLigneLivraison=request.getParameter("ligneId");
               String livraisonId=request.getParameter("livraisonId");
               LigneLivraison l = sessionFournisseur.ChercherLigneLivraisonParId(idLigneLivraison);
               Livraison livraison = sessionFournisseur.ChercherLivraisonParId(livraisonId);
               String statut="nonlivrer";
               sessionFournisseur.ModifierStatutLigneLivraison(l, statut);
               List<LigneLivraison> liste=sessionFournisseur.ChercherListeLigneLivraisonParLivraison(livraison);
               HttpSession sess=request.getSession(true);
                sess.setAttribute("livraison",livraison);
                sess.setAttribute("liste",liste);
                jspChoix="/GestionCommandeJSP/AfficherCommandeFournisseur.jsp";
            }
        else if(act.equals("ValiderLivraison")){
            doActionValiderLivraison(request,response);
            String idFournisseur=request.getParameter("fournisseurId");
            List<Livraison> liste=sessionFournisseur.ChercherListeLivraisonParFournisseur(idFournisseur);
            HttpSession sess=request.getSession(true);
            sess.setAttribute("liste",liste);
            jspChoix="/GestionCommandeJSP/AfficherListeCommandeFournisseur.jsp";
            
        }
        RequestDispatcher Rd;
        Rd= getServletContext().getRequestDispatcher(jspChoix);
        Rd.forward(request,response);
            
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FournisseurServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FournisseurServlet at " + request.getContextPath() + "</h1>");
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

    protected void doActionValiderLivraison(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String livraisonId=request.getParameter("livraisonId");
            String statut=request.getParameter("statut");
            String idFournisseur=request.getParameter("fournisseurId");
            String dateLivraisonPrevue=request.getParameter("date");
            String message;
            if (dateLivraisonPrevue.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionCommande/AfficherCommandeFournisseur.jsp\">Cliquez ici</a> pour accéder au formulaire de gestion commande fournisseur.";
} else
{
    Date d=Date.valueOf(dateLivraisonPrevue); 
    sessionFournisseur.ModifierDateLivraisonPrevuParLivraison(livraisonId, d);
    sessionFournisseur.ModifierStatutLivraison(livraisonId, statut);
    message="Commande valider par fournisseur";
}       
   
request.setAttribute( "message", message );
}
    
}
