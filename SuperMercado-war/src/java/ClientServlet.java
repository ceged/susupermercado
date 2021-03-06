/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Session.SessionAgentLivraisonLocal;
import Session.SessionClientLocal;
import Session.SessionPersonneLocal;
import entités.gestionArticle.Achat;
import entités.gestionArticle.LigneAchat;
import entités.gestionArticle.ReferentielArticle;
import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Personne;
import entités.gestionVenteEnLigne.AchatEnLigne;
import entités.gestionVenteEnLigne.Client;
import entités.gestionVenteEnLigne.Creneau;
import entités.gestionVenteEnLigne.ModeLivraison;
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
 * @author Sophia
 */
@WebServlet(urlPatterns = {"/ClientServlet"})
public class ClientServlet extends HttpServlet {

    @EJB
    private SessionAgentLivraisonLocal sessionAgentLivraison1;

    @EJB
    private SessionAgentLivraisonLocal sessionAgentLivraison;

    @EJB
    private SessionPersonneLocal sessionPersonne;

    @EJB
    private SessionClientLocal sessionClient;

    
    
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
        String jspChoix ="/Accueil.jsp";
        String act=request.getParameter("action");
        String act2=request.getParameter("action2");
        /*if ((act == null)||(act.equals("null")))
            {
            jspChoix="/Accueil.jsp";
            }
        */
        if(act!=null){
        if (act.equals("insererClient"))
        {
            String message = doActionInsererClient(request,response);
            if(message.equals("login existe déjà"))
            {jspChoix="/GestionVentesEnLigneJSP/CreerCompteClient.jsp";}
            else
            {jspChoix="/MenuClient.jsp";}
        }
        
        else if (act.equals("transferListeMagasin")) /// pour le choix des magasins par le client au debut
        {
            HttpSession sess=request.getSession(true);
            List<Magasin> listeMagasin = sessionPersonne.ConsultationMagasins();
            sess.setAttribute("listeMagasin",listeMagasin);
            jspChoix="/GestionVentesEnLigneJSP/ChoixMagasin.jsp";
        }
        else if (act.equals("transferArticlesParMagasin")) /// 
        {
            //création de session
            HttpSession sess=request.getSession(true);
            //recuperation de paramètres 
            String idClientString = request.getParameter("idClient");
            String nomMagasin = request.getParameter("magasin");
            //Recuperation du client connecté 
            Personne p = sessionPersonne.RechercherPersonneParId(idClientString);
            Client c = (Client) p;
            //Recuperation du magasin choisi
            Magasin magasinChoisi = sessionPersonne.RechercherMagasinParNom(nomMagasin);
            //Recuperation de la liste d'article du magasin choisi 
            List<ReferentielArticle> listeArticle = sessionPersonne.ConsultationArticlesParMagasin(nomMagasin);
            //Creation de l'achat 
            //verification si achat en cours , si non il cree, si oui il ouvre l'achat en cours
            AchatEnLigne achatclientencours = sessionClient.RechercherAchatEnCours(idClientString); //Achat existant créé avant
            AchatEnLigne achatEnCours; //nouveau achat 
            if(achatclientencours==null) // si pas d'achat en cours pour le client
            {           
            achatEnCours = sessionClient.CreationAchatEnLigne(idClientString); //creer un achat
            }
            else //si achat en cours existe 
            {
                List <LigneAchat> la = achatclientencours.getListeLigneAchats();
                if(la.isEmpty())
                {
                achatEnCours = achatclientencours; //passer en attribut l'achat trouvé
                }
                else
                {
                    Magasin magasinPanierTrouve =  la.get(0).getLotArticle().getArticle().getRayon().getSecteur().getMagasin();
                    if(magasinPanierTrouve==magasinChoisi)
                    {
                        achatEnCours = achatclientencours;
                    }
                    else 
                    {
                        sessionClient.ViderPanier(la);
                        achatEnCours=achatclientencours;
                    }
                }
            }
            sess.setAttribute("client", c);
            sess.setAttribute("achatEnCours", achatEnCours);
            sess.setAttribute("listeArticle",listeArticle);
            sess.setAttribute("magasinChoisi",magasinChoisi);
            
            jspChoix="/GestionVentesEnLigneJSP/AfficherListeArticles.jsp";
        }
        else if(act.equals("insererLignePanier")){
            doActioninsererLignePanier(request,response);
            /*String idAchat= request.getParameter("idAchat");
            AchatEnLigne c=sessionClient.RechercheAchatParId(idAchat);
            HttpSession sess=request.getSession(true);*/
          //sess.setAttribute("listeLigneCommande",listeLigneCommande);
            jspChoix="/GestionVentesEnLigneJSP/AfficherListeArticles.jsp";
        }
        else if(act.equals("passageDateChoisiClient")){
            String nomMagasin=request.getParameter("nomMagasin");
            Magasin m=sessionAgentLivraison.ChercherMagasinParNom(nomMagasin);
            List<Creneau>liste=sessionAgentLivraison.ListeCreneauDispoParMagasin(m);
            HttpSession sess=request.getSession(true);
            sess.setAttribute("liste",liste);
            jspChoix="/GestionLivraisonJSP/AfficherCreneauDispoClient.jsp";
        }
        else if(act.equals("SupprimerLigneAchat")){
            doActioninsererSupprimerLigneAchat(request,response);
            String idLigneAchat= request.getParameter("ligneAchatId");
            HttpSession sess=request.getSession(true);
            String idAchatEnCours = request.getParameter("idAchat");
            List<LigneAchat> listeLignesPanier = sessionClient.GetLignesPanier(idAchatEnCours);
            sess.setAttribute("listeLignesPanier", listeLignesPanier);
            jspChoix="/GestionVentesEnLigneJSP/AfficherPanierEnCours.jsp";
        }
        else if(act.equals("passageDateCreneau")){
            String date=request.getParameter("date");
            String nomMagasin= request.getParameter("nomMagasin");
            Magasin m=sessionAgentLivraison.ChercherMagasinParNom(nomMagasin);
            List<Creneau> liste;
            if(date.equalsIgnoreCase("")){
                liste=sessionAgentLivraison.ListeCreneauDispoParMagasin(m);
            }
            else{
                Date d=Date.valueOf(date);    
                liste=sessionAgentLivraison.ListeCreneauDispoParMagasinParDate(m, d);
            }
            HttpSession sess=request.getSession(true);
            sess.setAttribute("liste",liste);
            jspChoix="/GestionLivraisonJSP/AfficherCreneauDispoClient.jsp"; 
        }
        else if(act.equals("dateRetraitMagasin")){
            doActionDateRetraitMagasin(request,response);
            jspChoix="/GestionVentesEnLigneJSP/ChoixMagasin.jsp";
        }
        
        else if(act.equals("selectionModeLivraison")){
            doActioninsererChoixModeLivraison(request,response); 
            String modeLivraison= request.getParameter("modeLivraison");
            if(modeLivraison.equals("retraitMagasin")){
                String nomMag= request.getParameter("nomMag");
                String idAchat= request.getParameter("idAchat");
                Magasin magasinChoisi=sessionAgentLivraison.ChercherMagasinParNom(nomMag);
                Achat achat=sessionClient.RechercheAchatParId(idAchat);
                HttpSession sess=request.getSession(true);
                sess.setAttribute("achat",achat);
                sess.setAttribute("magasinChoisi",magasinChoisi);
            jspChoix="/GestionVentesEnLigneJSP/InfoRetraitMagasin.jsp"; 
            }
            else{
                String nomMagasin= request.getParameter("nomMag");
                Magasin m=sessionAgentLivraison.ChercherMagasinParNom(nomMagasin);
            List<Creneau> liste= sessionAgentLivraison.ListeCreneauDispoParMagasin(m);
            HttpSession sess=request.getSession(true);
            sess.setAttribute("liste",liste);
                jspChoix="/GestionLivraisonJSP/AfficherCreneauDispoClient.jsp"; 
            }
        }

        else if (act.equals("ChoisiCreneau")){
            doActionChoixCreneau(request,response);
            jspChoix="/GestionVentesEnLigneJSP/ChoixMagasin.jsp";
        }

        else if(act.equals("validerPanier")){
            String idAchat= request.getParameter("idAchat");
            String message = sessionClient.ValidationAchat(idAchat);
            request.setAttribute( "message", message );
            if("Panier Validé".equals(message)){
            Achat achat=sessionClient.RechercheAchatParId(idAchat);
            HttpSession sess=request.getSession(true);
            sess.setAttribute("achat", achat);
            jspChoix="/GestionVentesEnLigneJSP/ChoixModeLivraison.jsp";
            }
            else
            {
                jspChoix="/GestionVentesEnLigneJSP/AfficherPanierEnCours.jsp";
            }
            
        }
        else if(act.equals("annulerInsertionLigne")){
            jspChoix="/GestionVentesEnLigneJSP/AfficherListeArticles.jsp";
        }
        }
        else if (act2.equals("consulterVotrePanier"))
        {
            
            HttpSession sess=request.getSession(true);
            String idAchatEnCours = request.getParameter("idAchat");
            List<LigneAchat> listeLignesPanier = sessionClient.GetLignesPanier(idAchatEnCours);
            sess.setAttribute("listeLignesPanier", listeLignesPanier);
            jspChoix="/GestionVentesEnLigneJSP/AfficherPanierEnCours.jsp";
            
        }
        else 
        {
            jspChoix="/Accueil.jsp";
        }

        RequestDispatcher Rd;
        Rd= getServletContext().getRequestDispatcher(jspChoix);
        Rd.forward(request,response);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClientServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClientServlet at " + request.getContextPath() + "</h1>");
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
protected String doActionInsererClient(HttpServletRequest request, HttpServletResponse response)
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
    if ( nomPersonne.trim().isEmpty()||prenomPersonne.trim().isEmpty()||loginPersonne.trim().isEmpty()||mdpPersonne.trim().isEmpty()||sexePersonne.isEmpty()||dobPersonne.isEmpty()||adressePersonne.isEmpty()||codePostalPersonne.isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionVentesEnLigneJSP/CreerCompteClient.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un compte";
} else
    {
        Date dob=Date.valueOf(dobPersonne);
        message = sessionClient.CreationCompteClient(nomPersonne, prenomPersonne, loginPersonne, mdpPersonne, sexePersonne, dob, adressePersonne, codePostalPersonne);
        Client client=sessionClient.ChercherClientParLoginMdp(loginPersonne, mdpPersonne);
        HttpSession sess=request.getSession(true);
        sess.setAttribute("client",client);
    }
   
    request.setAttribute( "message", message );
    return message;
}

        protected void doActionDateRetraitMagasin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String idAchat= request.getParameter("idAchat");
            String date= request.getParameter("date");
            String IdMag= request.getParameter("IdMag");
            Date dateRecup=Date.valueOf(date);
            String message;
        sessionClient.CreerRetraitMagasin(idAchat, dateRecup, IdMag);
        message="Achat et retrait magasin validé";
        request.setAttribute( "message", message );
}
        

protected void doActioninsererChoixModeLivraison(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String idAchat= request.getParameter("idAchat");
            String modeLivraison= request.getParameter("modeLivraison");
    String message;
    if ( modeLivraison.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionVentesEnLigneJSP/ChoixModeLivraison.jsp\">Cliquez ici</a> pour accéder choix de livraison.";
    request.setAttribute( "message", message );
    } else
    {
    Achat a=sessionClient.RechercheAchatParId(idAchat);
    if(modeLivraison.equals("retraitMagasin")){
        sessionClient.AjouterChoixModeLivraison(a, ModeLivraison.magasin);
    }
    else{
        sessionClient.AjouterChoixModeLivraison(a, ModeLivraison.domicile);
    }
    
}

}

        protected void doActionChoixCreneau(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String idAchat= request.getParameter("achatLigne");
            String idCreneau= request.getParameter("idCreneau");
            String adresse= request.getParameter("adresse");
            String cp= request.getParameter("codePostal");
            String ville= request.getParameter("ville");
    String message;
    if ( idCreneau.trim().isEmpty()||adresse.trim().isEmpty()||cp.trim().isEmpty()||ville.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionLivraisonJSP/AfficherCreneauDispoClient.jsp\">Cliquez ici</a> pour accéder choix de créneau.";
} else
    {
        sessionClient.CreerLivraisonDomicile(idAchat, adresse, cp, ville, idCreneau);
        message="Achat et livraison validé";
    
    }
    request.setAttribute( "message", message );
}


protected void doActioninsererLignePanier(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String quantite= request.getParameter( "quantite" );
    String idArticle= request.getParameter( "article" );
   // String client = request.getParameter("idClient");
    String achat = request.getParameter("idAchat");
    
    String message;
    if ( quantite.trim().isEmpty()&&idArticle.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionVentesEnLigneJSP/AfficherListeArticles.jsp\">Cliquez ici</a> pour accéder au formulaire d'ajout un article.";
} else
{
    message = sessionClient.creationLignePanier(quantite, idArticle, achat);
}
   
request.setAttribute( "message", message );
}

protected void doActioninsererSupprimerLigneAchat(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    String idLigne = request.getParameter("ligneAchatId");
    String message;
    
    if ( idLigne.trim().isEmpty()){
    message = "Erreur pas de ligne récup de la jsp " + "<br /> <a href=\"GestionVentesEnLigneJSP/AfficherPanierEnCours.jsp\">Cliquez ici</a>";
} else
{
    
    sessionClient.SuppressionLigneAchat(idLigne);
    message="Article Supprimé";
}
   
request.setAttribute( "message", message );
}
}
