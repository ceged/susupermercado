    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Session.SessionDirecteurMagasinLocal;
import entités.gestionMagasin.DirecteurMagasin;
import entités.gestionArticle.SousCategorie;
import entités.gestionMagasin.Caisse;
import entités.gestionMagasin.DirecteurMagasin;
import entités.gestionMagasin.Rayon;
import entités.gestionMagasin.Secteur;
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
@WebServlet(urlPatterns = {"/DirecteurServlet"})
public class DirecteurServlet extends HttpServlet {

    @EJB
    private SessionDirecteurMagasinLocal sessionDirecteurMagasin;

    
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
        if ((act == null)||(act.equals("null")))
            {
            jspChoix="/Accueil.jsp";
            }
        else if (act.equals("insererSecteur"))
        {
            doActionInsererSecteur(request,response);
            jspChoix="/MenuDirecteur.jsp";
        }

        else if (act.equals("insererChefRayon"))
        {
            doActionInsererChefRayon(request,response);
            jspChoix="/MenuDirecteur.jsp";
        }
        else if (act.equals("InsererAgentCaisse"))
        {
            doActionInsererAgentCaisse(request,response);
            jspChoix="/MenuDirecteur.jsp";
        }
        else if (act.equals("transferListeRayon"))
        {
            String directeurCherche= request.getParameter( "directeur" );
            DirecteurMagasin d= sessionDirecteurMagasin.ChercherDirecteurParId(directeurCherche);
            HttpSession sess=request.getSession(true);
            List<Rayon> listeRayon = sessionDirecteurMagasin.ConsultationListeRayonsParMagasin(d.getMagasin().getNomMagasin());
            sess.setAttribute("listeRayon",listeRayon); 
            jspChoix="/GestionMagasinJSP/CreerChefRayon.jsp";
        }

        else if (act.equals("insererRayon"))
        {
            doActionInsererRayon(request,response);
            jspChoix="/MenuDirecteur.jsp";
        }
        else if (act.equals("transferListeSecteur"))
        {
            String directeurCherche= request.getParameter( "directeur" );
            DirecteurMagasin d= sessionDirecteurMagasin.ChercherDirecteurParId(directeurCherche);
            HttpSession sess=request.getSession(true);
            List<Secteur> listeSecteur = sessionDirecteurMagasin.ListerSecteur(d);
            sess.setAttribute("listeSecteur",listeSecteur); 
            jspChoix="/GestionMagasinJSP/CreerRayon.jsp";
        }
        else if (act.equals("insererCaisse"))
        {
            doActionInsererCaisse(request,response);
            jspChoix="/MenuDirecteur.jsp";
        }
        else if (act.equals("transferListeCaisse"))//utiliser dans creation d'affectation
        {
            String directeurCherche= request.getParameter( "directeur" );
            DirecteurMagasin d= sessionDirecteurMagasin.ChercherDirecteurParId(directeurCherche);
            HttpSession sess=request.getSession(true);
            List<Caisse> listeCaisse = sessionDirecteurMagasin.ConsultationCaisseParMagasin(d.getMagasin().getNomMagasin());
            sess.setAttribute("listeCaisse",listeCaisse); 
            jspChoix="/GestionMagasinJSP/CreerAgentCaisse.jsp";
        }
        
        RequestDispatcher Rd;
        Rd= getServletContext().getRequestDispatcher(jspChoix);
        Rd.forward(request,response);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DirecteurServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DirecteurServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    protected void doActionInsererSecteur(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String libelleSecteur= request.getParameter( "libelleSecteur" );
    String magasinSecteur= request.getParameter( "magasinSecteur" );
    String message;
    if ( libelleSecteur.trim().isEmpty()&&magasinSecteur.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionMagasin/CreerMagasin.jsp\">Cliquez ici</a> pour accéder au formulaire de création magasin.";
} else
{
    message = sessionDirecteurMagasin.CreerSecteur(libelleSecteur, magasinSecteur);
    
}
   
request.setAttribute( "message", message );
}

protected void doActionInsererChefRayon(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
String nomPersonne= request.getParameter( "nom" );
    String prenomPersonne= request.getParameter( "prenom" );
    String loginPersonne= request.getParameter( "login" );
    String mdpPersonne= request.getParameter( "mdp" );
    String sexePersonne= request.getParameter( "sexe" );
    String dobPersonne= request.getParameter( "dob" );
    String adressePersonne= request.getParameter( "adresse" );
    String codePostalPersonne= request.getParameter( "codePostal" );
    String rayon= request.getParameter( "libelleRayon" );
    String magasin = request.getParameter("magasin");

    String message;
    if ( nomPersonne.trim().isEmpty()&&prenomPersonne.trim().isEmpty()&&loginPersonne.trim().isEmpty()&&mdpPersonne.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionMagasin/CreerChefRayonJSP.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un chef de rayon";
} else
    {
        Date dob=Date.valueOf(dobPersonne);
        message = sessionDirecteurMagasin.CreerChefRayon(nomPersonne, prenomPersonne,loginPersonne, mdpPersonne, sexePersonne, dob, adressePersonne, codePostalPersonne, rayon, magasin);
    }
   
        request.setAttribute( "message", message );
}

    protected void doActionInsererRayon(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String libellesecteurCherche= request.getParameter( "libellesecteur" );
    String rayon= request.getParameter( "libelleRayon" );
    String message;
    if ( libellesecteurCherche.trim().isEmpty()&&rayon.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionMagasin/CreerRayon.jsp\">Cliquez ici</a> pour accéder au formulaire de création de rayon.";
} else
{
    
    message = sessionDirecteurMagasin.CreerRayon(libellesecteurCherche, rayon);

}
   
request.setAttribute( "message", message );
}
    protected void doActionInsererCaisse (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String libelleMagasinCherche= request.getParameter( "magasinCaisse" );
    String caisse= request.getParameter( "id" );
    Long Idcaisse = Long.valueOf(caisse);
                    String message;
 
    if ( libelleMagasinCherche.trim().isEmpty()&&caisse.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionMagasin/CreerMagasin.jsp\">Cliquez ici</a> pour accéder au formulaire de création de caisse.";
} else
{
    
    message = sessionDirecteurMagasin.CreerCaisse(Idcaisse,libelleMagasinCherche);

}
   
request.setAttribute( "message", message );
}

protected void doActionInsererAgentCaisse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
String nomPersonne= request.getParameter( "nom" );
    String prenomPersonne= request.getParameter( "prenom" );
    String loginPersonne= request.getParameter( "login" );
    String mdpPersonne= request.getParameter( "mdp" );
    String sexePersonne= request.getParameter( "sexe" );
    String dobPersonne= request.getParameter( "dob" );
    String adressePersonne= request.getParameter( "adresse" );
    String codePostalPersonne= request.getParameter( "codePostal" );
    String magasin = request.getParameter("magasin");


    String message;
    if ( nomPersonne.trim().isEmpty()&&prenomPersonne.trim().isEmpty()&&loginPersonne.trim().isEmpty()&&mdpPersonne.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionMagasin/CreerChefRayonJSP.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un chef de rayon";
} else
    {
        Date dob=Date.valueOf(dobPersonne);
        message = sessionDirecteurMagasin.CreerAgentCaisse(nomPersonne, prenomPersonne, loginPersonne, mdpPersonne, dob, sexePersonne,adressePersonne, codePostalPersonne, magasin);
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
