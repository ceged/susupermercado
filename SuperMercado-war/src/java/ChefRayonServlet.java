/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Session.SessionChefDeRayonLocal;
import entités.gestionArticle.ReferentielArticle;
import entités.gestionArticle.SousCategorie;
import entités.gestionCommande.Fournisseur;
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
    
    protected void doActionSupprimerArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String libelleArticleCree= request.getParameter( "libelleArticle" );
    String magasinCree= request.getParameter( "magasin" );
    String rayonCree= request.getParameter( "rayon" );
    String message;
    if ( libelleArticleCree.trim().isEmpty()&&magasinCree.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionArticle/ModifierPrixArticle.jsp\">Cliquez ici</a> pour accéder au formulaire de modification de prix.";
} else
{
    message=sessionChefDeRayon.SupprimerReferentielArticle(libelleArticleCree, rayonCree, magasinCree);
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
