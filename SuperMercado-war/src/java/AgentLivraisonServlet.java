/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Session.SessionAgentLivraisonLocal;
import Session.SessionDirecteurMagasinLocal;
import Session.SessionFournisseurLocal;
import static com.sun.xml.bind.util.CalendarConv.formatter;
import entités.gestionLivraison.AgentLivraison;
import entités.gestionLivraison.LigneLivraison;
import entités.gestionLivraison.Livraison;
import entités.gestionMagasin.Magasin;
import entités.gestionVenteEnLigne.Creneau;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Soldat
 */
@WebServlet(urlPatterns = {"/AgentLivraisonServlet"})
public class AgentLivraisonServlet extends HttpServlet {

    @EJB
    private SessionDirecteurMagasinLocal sessionDirecteurMagasin;

    @EJB
    private SessionFournisseurLocal sessionFournisseur;

    @EJB
    private SessionAgentLivraisonLocal sessionAgentLivraison;

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
        String jspChoix ="/MenuAgentLivraison.jsp";
        String act=request.getParameter("action");
        if ((act == null)||(act.equals("null")))
            {
            jspChoix="/MenuAgentLivraison.jsp";
            }
        else if(act.equals("passageInfosListeReceptionLivraison")){
            String idagentLivraison=request.getParameter("agentLivraison");
            AgentLivraison a=sessionAgentLivraison.ChercherAgentLivraisonParId(idagentLivraison);
            List<Livraison> liste=sessionAgentLivraison.ChercherListeLivraisonParAgent(a);
             HttpSession sess=request.getSession(true);
                sess.setAttribute("liste",liste);
                jspChoix="/GestionLivraisonJSP/AfficherListeLivraison.jsp";
        }
        else if(act.equals("afficherLivraisonAgent")){
             String idLivraison=request.getParameter("livraisonId");
             Livraison l=sessionFournisseur.ChercherLivraisonParId(idLivraison);
             List<LigneLivraison> liste=sessionFournisseur.ChercherListeLigneLivraisonParLivraison(l);
            HttpSession sess=request.getSession(true);
            sess.setAttribute("livraison",l);
            sess.setAttribute("liste",liste);
            jspChoix="/GestionLivraisonJSP/AfficherLivraison.jsp"; 
        }
        else if(act.equals("ValiderLigneLivraison")){
            DoActionValiderLigneLivraison(request,response);
            String livraisonId=request.getParameter("livraisonId");
            Livraison livraison = sessionFournisseur.ChercherLivraisonParId(livraisonId);
            List<LigneLivraison> liste=sessionFournisseur.ChercherListeLigneLivraisonParLivraison(livraison);
            HttpSession sess=request.getSession(true);
            sess.setAttribute("livraison",livraison);
            sess.setAttribute("liste",liste);
                jspChoix="/GestionLivraisonJSP/AfficherLivraison.jsp";
        }
        else if(act.equals("ValiderLivraison")){
            DoActionValiderLivraison(request,response);
            String agentLivraisonId=request.getParameter("agentLivraisonId");
            AgentLivraison a=sessionAgentLivraison.ChercherAgentLivraisonParId(agentLivraisonId);
            List<Livraison> liste=sessionAgentLivraison.ChercherListeLivraisonParAgent(a);
            HttpSession sess=request.getSession(true);
            sess.setAttribute("liste",liste);
            jspChoix="/GestionLivraisonJSP/AfficherListeLivraison.jsp";
        }
        else if (act.equals("insererCreneau")){
            DoActionInsererCreneau(request,response);
            jspChoix="/MenuAgentLivraison.jsp";
        }
        else if(act.equals("passageDateChoisi")){
            String agentLivraisonId=request.getParameter("idAgent");
            String date=request.getParameter("date");
            List<Creneau> liste;
            AgentLivraison a=sessionAgentLivraison.ChercherAgentLivraisonParId(agentLivraisonId);
            if(date.equalsIgnoreCase("")){
                liste=sessionAgentLivraison.ListeCreneauDispoParMagasin(a.getMagasin());
            }
            else{
                Date d=Date.valueOf(date);    
                liste=sessionAgentLivraison.ListeCreneauDispoParMagasinParDate(a.getMagasin(), d);
            }
            HttpSession sess=request.getSession(true);
            sess.setAttribute("liste",liste);
            jspChoix="/GestionLivraisonJSP/AfficherCreneauDispo.jsp";
        }
        else if(act.equals("passageInfosCreneauDispo")){
            String agentLivraisonId=request.getParameter("agentLivraison");
            AgentLivraison a=sessionAgentLivraison.ChercherAgentLivraisonParId(agentLivraisonId);
            List<Creneau>liste=sessionAgentLivraison.ListeCreneauDispoParMagasin(a.getMagasin());
            HttpSession sess=request.getSession(true);
            sess.setAttribute("liste",liste);
            jspChoix="/GestionLivraisonJSP/AfficherCreneauDispo.jsp";
        }
        
       
        
        RequestDispatcher Rd;
        Rd= getServletContext().getRequestDispatcher(jspChoix);
        Rd.forward(request,response);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgentLivraisonServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgentLivraisonServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
     
    
    protected void DoActionValiderLigneLivraison(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String ligneLivraisonId=request.getParameter("ligneId");
        String quantiteLivrer=request.getParameter("quantiteLivrer");
        String quantiteReceptionner=request.getParameter("quantiteReceptionner");
        String garantie=request.getParameter("garantie");
        String taille=request.getParameter("taille");
        String datePeremption=request.getParameter("datePeremption");
        String couleur=request.getParameter("couleur");
        String message=null;
        String statut=null;
    if (quantiteLivrer.trim().isEmpty()&& quantiteReceptionner.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionCommande/AfficherLivraison.jsp\">Cliquez ici</a> pour accéder au formulaire de gestion livraison.";
} else{    
        
        
    int qtLivrer=Integer.valueOf(quantiteLivrer);
    int qtReceptionner=Integer.valueOf(quantiteReceptionner);
    LigneLivraison l=sessionFournisseur.ChercherLigneLivraisonParId(ligneLivraisonId);
    if(l.getQuantiteFournisseur()!=qtLivrer){
        statut="reclamationLivraison";
    }
    else if(l.getQuantiteFournisseur()!=qtReceptionner){
        statut="reclamationQualite";
    }
    else if(l.getQuantiteFournisseur()==qtReceptionner){
        statut="receptionner";
    }  
    sessionFournisseur.ModifierStatutLigneLivraison(l, statut);
    sessionAgentLivraison.ModifierQuantiteLigneLivraison(ligneLivraisonId, qtReceptionner, qtLivrer);
    if(datePeremption.equalsIgnoreCase("")){
        if(taille.equalsIgnoreCase("")){
            if(garantie.equalsIgnoreCase("")){
                 sessionAgentLivraison.CreerLotArticle(l.getLigneCommande().getArticle().getCodeBarre(),qtReceptionner,l);
                 message="Lot article créé";
            }
            else{
                int garantieDuree=Integer.valueOf(garantie);
                sessionAgentLivraison.CreerLotArticleElectromenager(qtReceptionner, l.getLigneCommande().getArticle().getCodeBarre(),garantieDuree,l);
                message="Lot Electroménager créé";
            }
        }
        else{
            sessionAgentLivraison.CreerLotArticleVetement(qtReceptionner, l.getLigneCommande().getArticle().getCodeBarre(), taille, couleur,l);
            message="Lot vêtement créé";
        }
    }
    else{
        Date dPeremption=Date.valueOf(datePeremption);
        sessionAgentLivraison.CreerLotArticleFrais(qtReceptionner, l.getLigneCommande().getArticle().getCodeBarre(), dPeremption,l);
        message="Lot produit frais créé";
    }

       request.setAttribute( "message", message ); 
}
    }
    protected void DoActionValiderLivraison(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
String livraisonId=request.getParameter("livraisonId");
            String statut=request.getParameter("statut");
            String dateLivraisonEffective=request.getParameter("date");
            String message;
            if (dateLivraisonEffective.trim().isEmpty()&&statut.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionCommande/AfficherLivraison.jsp\">Cliquez ici</a> pour accéder au formulaire de gestion livraison.";
} else
{
    Date d=Date.valueOf(dateLivraisonEffective); 
    sessionAgentLivraison.ModifierDateLivraisonEffectiveParLivraison(livraisonId, d);
    sessionFournisseur.ModifierStatutLivraison(livraisonId, statut);
    message="Livraison valider par agent";
}             
request.setAttribute( "message", message );
}

    protected void DoActionInsererCreneau(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String heureDebut=request.getParameter("heureDebut");
            String date=request.getParameter("date");
            String heureFin=request.getParameter("heureFin");
            String agentId=request.getParameter("agentId");
            String message;
            if (heureDebut.trim().isEmpty()&&heureFin.trim().isEmpty()&&date.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionLivraisonJSP/CreerCreneau.jsp\">Cliquez ici</a> pour accéder au formulaire de création de créneau.";
} else
{
    Date d=Date.valueOf(date);
    LocalTime dDebut= LocalTime.parse(heureDebut);
    LocalTime dFin= LocalTime.parse(heureFin);
    Time Fin=Time.valueOf(dFin);
    Time Debut=Time.valueOf(dDebut);
    sessionAgentLivraison.CreerCreneau(Debut, Fin,d, agentId);
    message="Créneau créé";
}             
request.setAttribute( "message", message );
}
    
    

protected void DoActionExclureLigneLivraison(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String ligneLivraisonId=request.getParameter("ligneId");
        String statut="reclamationCommande";
    LigneLivraison l=sessionFournisseur.ChercherLigneLivraisonParId(ligneLivraisonId);
    sessionFournisseur.ModifierStatutLigneLivraison(l, statut);
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
