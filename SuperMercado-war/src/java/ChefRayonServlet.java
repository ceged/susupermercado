/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Session.SessionChefDeRayonLocal;
import entités.gestionArticle.ReferentielArticle;
import entités.gestionArticle.SousCategorie;
import entités.gestionCommande.Commande;
import entités.gestionCommande.Fournisseur;
import entités.gestionCommande.LigneCommande;
import entités.gestionMagasin.ChefRayon;
import entités.gestionMagasin.DirecteurMagasin;
import entités.gestionMagasin.Secteur;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
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
        else if (act.equals("passageListeSousCategorie"))
        {
            HttpSession sess=request.getSession(true);
            List<SousCategorie> listeSousCategorie = sessionChefDeRayon.ListerSousCategorie();
            List<Fournisseur> listeFournisseur=sessionChefDeRayon.ListerFournisseur();
            sess.setAttribute("listeFournisseur",listeFournisseur);
            sess.setAttribute("listeSousCategorie",listeSousCategorie); 
            jspChoix="/GestionArticleJSP/CreerArticle.jsp";
        }
        else if (act.equals("passageInfospourModifierPrix"))
        {
            String chefRayonCherche= request.getParameter( "chefRayon" );
            ChefRayon c=sessionChefDeRayon.ChercherChefRayonParId(chefRayonCherche);
            HttpSession sess=request.getSession(true);
            List<ReferentielArticle> listeReferentielArticleModifier = sessionChefDeRayon.ConsulterListeArticleParChefRayon(c);
            sess.setAttribute("listeReferentielArticleModifier",listeReferentielArticleModifier);
            if(listeReferentielArticleModifier==null){
                String message="aucun article existant";
                request.setAttribute( "message", message );
                jspChoix="/MenuChefdeRayon.jsp";
            }else{
                jspChoix="/GestionArticleJSP/ModifierPrixArticle.jsp";
            }
        }
        else if(act.equals("passageInfosCreerBonCommande")){
            HttpSession sess=request.getSession(true);
            List<Fournisseur> listeFournisseur=sessionChefDeRayon.ListerFournisseur();
            sess.setAttribute("listeFournisseur",listeFournisseur);
            jspChoix="/GestionCommandeJSP/CreerBonCommande.jsp";
        }
        else if(act.equals("passageModifListeBonCommande")){
            HttpSession sess=request.getSession(true);
            String idChef=request.getParameter("chefRayon");
            String statut=request.getParameter("statut");
            List<Commande> liste= sessionChefDeRayon.RecherListeCommandeParChefRayon(idChef);
            if(statut.equalsIgnoreCase("aucun")){
                liste=sessionChefDeRayon.RecherListeCommandeParChefRayon(idChef);
            }
            else{
                liste=sessionChefDeRayon.RechercherListeCommandeParStatutParChefRayon(statut, idChef);
            }
            sess.setAttribute("liste", liste);
            jspChoix="/GestionCommandeJSP/AfficherListeCommande.jsp";
        }
        else if (act.equals("passageInfospourSupprimerArticle"))
        {
            String chefRayonCherche= request.getParameter( "chefRayon" );
            ChefRayon c=sessionChefDeRayon.ChercherChefRayonParId(chefRayonCherche);
            HttpSession sess=request.getSession(true);
            List<ReferentielArticle> listeReferentielArticle = sessionChefDeRayon.ConsulterListeArticleParChefRayon(c);
            sess.setAttribute("listeReferentielArticle",listeReferentielArticle);
            if(listeReferentielArticle==null){
                String message="aucun article existant";
                request.setAttribute( "message", message );
                jspChoix="/MenuChefdeRayon.jsp";
            }
            else{
                jspChoix="/GestionArticleJSP/SupprimerArticle.jsp";
            }
        }
        else if(act.equals("modifierPrixArticle"))
        {
            doActionModifierPrixArticle(request,response);
            jspChoix="/MenuChefdeRayon.jsp";
        }
        else if(act.equals("passageInfosListeBonCommande")){
            String idChef=request.getParameter("chefRayon");
            List<Commande>liste=sessionChefDeRayon.RecherListeCommandeParChefRayon(idChef);
            HttpSession sess=request.getSession(true);
            sess.setAttribute("liste",liste);
            jspChoix="/GestionCommandeJSP/AfficherListeCommande.jsp";
        }
        else if(act.equals("afficherBonCommande")){
            String idCommande= request.getParameter( "commandeId" );
            Long id=Long.parseLong(idCommande);
            Commande c=sessionChefDeRayon.RechercherCommandeParId(id);
            HttpSession sess=request.getSession(true);
            List<LigneCommande> listeLigneCommande=sessionChefDeRayon.RechercherListLigneCommandeParCommande(c);
            sess.setAttribute("commande",c);
            sess.setAttribute("listeLigneCommande",listeLigneCommande);
            jspChoix="/GestionCommandeJSP/AfficherCommandeEnCours.jsp";
        }
        else if(act.equals("insererLigneCommande")){
            doActioninsererLigneCommande(request,response);
            String idCommande= request.getParameter( "commandeId" );
            Long id=Long.parseLong(idCommande);
            Commande c=sessionChefDeRayon.RechercherCommandeParId(id);
            HttpSession sess=request.getSession(true);
            List<LigneCommande> listeLigneCommande=sessionChefDeRayon.RechercherListLigneCommandeParCommande(c);
            sess.setAttribute("listeLigneCommande",listeLigneCommande);
            jspChoix="/GestionCommandeJSP/AfficherCommandeEnCours.jsp";
        }
        else if(act.equals("SupprimerLigneAchat")){
            doActionsupprimerLigneCommande(request,response);
            String idCommande= request.getParameter( "commandeId" );
            Long id=Long.parseLong(idCommande);
            Commande c=sessionChefDeRayon.RechercherCommandeParId(id);
            HttpSession sess=request.getSession(true);
            List<LigneCommande> listeLigneCommande=sessionChefDeRayon.RechercherListLigneCommandeParCommande(c);
            sess.setAttribute("listeLigneCommande",listeLigneCommande);
            jspChoix="/GestionCommandeJSP/AfficherCommandeEnCours.jsp";
            
        }
        else if(act.equals("validerBonCommande")){
            String idCommande= request.getParameter( "commandeId" );
            Long id=Long.parseLong(idCommande);
            Commande c=sessionChefDeRayon.RechercherCommandeParId(id);
            sessionChefDeRayon.ValiderBonCommande(c);
            String message="Bon de commande validé";
            request.setAttribute("message", message);
            jspChoix="/MenuChefdeRayon.jsp";
        }
        else if(act.equals("insererBonCommande"))
        {
            doActioninsererBonCommande(request,response);
            jspChoix="/GestionCommandeJSP/AfficherCommandeEnCours.jsp";
            Commande commande = sessionChefDeRayon.ChercherDernierCommande();
            List<LigneCommande> listeLigneCommande=sessionChefDeRayon.RechercherListLigneCommandeParCommande(commande);
            HttpSession sess=request.getSession(true);
            sess.setAttribute("commande",commande);
            sess.setAttribute("listeLigneCommande",listeLigneCommande);
        }
        else if (act.equals("insererReferentielArticle")){
            doActionInserReferentielArticle(request,response);
            jspChoix="/MenuChefdeRayon.jsp";
        }
        else if(act.equals("SupprimerArticle")){
            doActionSupprimerArticle(request,response);
            jspChoix="/MenuChefdeRayon.jsp";
        }
        else if(act.equals("insererFournisseur")){
            doActioninsererFournisseur(request,response);
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
    List<Fournisseur>listeFournisseurRecuperer=sessionChefDeRayon.ListerFournisseur();
    List<Fournisseur>listeFournisseurAssocie= new ArrayList();
    int j=0;
    for(Fournisseur f:listeFournisseurRecuperer){
        j++;
        String h=String.valueOf(j);
            if(request.getParameter(h)!=null){
            Long h2=Long.valueOf(request.getParameter (h));
            Fournisseur f2=sessionChefDeRayon.ChercherFournisseurParId(h2);
            listeFournisseurAssocie.add(f2);
            }
    }
    String message;
    if ( libelleArticleCree.trim().isEmpty()&&magasinCree.trim().isEmpty()&&marqueCree.trim().isEmpty()&&prixCree.trim().isEmpty()&&souscateogireCree.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionArticle/CreerArticle.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un article.";
} else
{
    Float prixVente=Float.parseFloat(prixCree);
    message=sessionChefDeRayon.CreerReferentielArticle(libelleArticleCree, magasinCree, rayonCree, marqueCree, prixVente, souscateogireCree,listeFournisseurAssocie);
}
   
request.setAttribute( "message", message );
}   
    
    protected void doActionsupprimerLigneCommande(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String idLigne= request.getParameter( "ligneId" );
    String message;
    if (idLigne.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionCommande/CreerLigneCommande.jsp\">Cliquez ici</a> pour accéder au formulaire d'ajout un article.";
} else
{
    Long id=Long.parseLong(idLigne);
    LigneCommande l=sessionChefDeRayon.ChercherLigneCommandeParId(id);
    sessionChefDeRayon.SupprimerLigneCommande(l);
    message="Article supprimé";
}
   
request.setAttribute( "message", message );
}
            
            protected void doActioninsererLigneCommande(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String quantite= request.getParameter( "quantite" );
    String prix= request.getParameter( "prix" );
    String commandeId= request.getParameter( "commandeId" );
    String articleId= request.getParameter( "article" );
    String message;
    if ( quantite.trim().isEmpty()&&prix.trim().isEmpty()&&articleId.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionCommande/CreerLigneCommande.jsp\">Cliquez ici</a> pour accéder au formulaire d'ajout un article.";
} else
{
    Float prixAchat=Float.parseFloat(prix);
    Long id=Long.parseLong(commandeId);
    Long idArticle=Long.parseLong(articleId);
    int q=Integer.parseInt(quantite);
    sessionChefDeRayon.CreerLigneBonCommande(idArticle, id, prixAchat, q);
    message="Article ajouté";
}
   
request.setAttribute( "message", message );
}   

    protected void doActionModifierPrixArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String libelleArticleCree= request.getParameter( "libelleArticle" );
    String magasinCree= request.getParameter( "magasin" );
    String rayonCree= request.getParameter( "rayon" );
    String newPrix= request.getParameter( "newprix" );
    String message;
    if ( libelleArticleCree.trim().isEmpty()&&magasinCree.trim().isEmpty()&&newPrix.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionArticle/ModifierPrixArticle.jsp\">Cliquez ici</a> pour accéder au formulaire de modification de prix.";
} else
{
    Float prixVente=Float.parseFloat(newPrix);
    message=sessionChefDeRayon.ModifierPrixReferentielArticle(libelleArticleCree, rayonCree, magasinCree, prixVente);
}
   
request.setAttribute( "message", message );
}   
    
    protected void doActioninsererBonCommande(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String fournisseur= request.getParameter( "fournisseur" );
    String date= request.getParameter( "date" );
    String idChef= request.getParameter( "chefRayon" );
    String message;
    if ( fournisseur.trim().isEmpty()&&date.trim().isEmpty()&&idChef.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionCommandeJSP/CreerBonCommande.jsp\">Cliquez ici</a> pour accéder au formulaire de création bon de commande.";
} else
{
    Date date2=Date.valueOf(date);
    message = sessionChefDeRayon.CreerBonCommande(idChef, date2, fournisseur);
}
   
request.setAttribute( "message", message );
}   
    protected void doActionSupprimerArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String idArticle= request.getParameter( "libelleArticle" );
    String magasinCree= request.getParameter( "magasin" );
    String rayonCree= request.getParameter( "rayon" );
    String message;
    if ( idArticle.trim().isEmpty()&&magasinCree.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionArticle/ModifierPrixArticle.jsp\">Cliquez ici</a> pour accéder au formulaire de modification de prix.";
} else
{
    Long ArticleId=Long.parseLong(idArticle);
    message=sessionChefDeRayon.SupprimerReferentielArticle(ArticleId, rayonCree, magasinCree);
}
   
request.setAttribute( "message", message );
}   
    
protected void doActioninsererFournisseur(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String nomPersonne= request.getParameter( "nom" );
    String prenomPersonne= request.getParameter( "prenom" );
    String loginPersonne= request.getParameter( "login" );
    String mdpPersonne= request.getParameter( "mdp" );
    String sexePersonne= request.getParameter( "sexe" );
    String dobPersonne= request.getParameter( "dob" );
    String adressePersonne= request.getParameter( "adresse" );
    String codePostalPersonne= request.getParameter( "codePostal" );
    String message;
    if ( nomPersonne.trim().isEmpty()&&prenomPersonne.trim().isEmpty()&&loginPersonne.trim().isEmpty()&&mdpPersonne.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionCommande/CreerFournisseur.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un fournisseur.";
} else
{
    Date dob=Date.valueOf(dobPersonne);
    message=sessionChefDeRayon.CreerFournisseur(nomPersonne, prenomPersonne, loginPersonne, mdpPersonne, sexePersonne, dob, adressePersonne, codePostalPersonne);
    
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
