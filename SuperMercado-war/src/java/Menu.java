

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Session.SessionAdminLocal;
import Session.SessionChefDeRayonLocal;
import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Personne;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tangu_000
 */
public class Menu extends HttpServlet {

    @EJB
    private SessionAdminLocal sessionAdmin;

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

        String jspChoix ="/Accueil.jsp";
        String act=request.getParameter("action");
        if ((act == null)||(act.equals("null")))
            {
            jspChoix="/Accueil.jsp";
            }
        //Méthode de connexion
        else if (act.equals("connexionUser"))
            {
            int i=0;
            String login = request.getParameter("loginUser");
            String mp = request.getParameter("mdpUser");
            Personne personneConnecte =sessionAdmin.PersonneConnecte(login, mp);
            i=sessionAdmin.SeConnecter(login, mp);
            if(i==1){
                jspChoix="/MenuAdmin.jsp";
                    }
            else if(i==2){
                jspChoix="/MenuChefdeRayon.jsp";
            }
            else if(i==3){
                jspChoix="/MenuDirecteur.jsp";
            }
            HttpSession sess=request.getSession(true);
            sess.setAttribute("personneConnecte",personneConnecte);
            }
        else if (act.equals("insererMagasin"))
        {
            doActionInsererMagasin(request,response);
            jspChoix="/MenuAdmin.jsp";
        }
        else if (act.equals("insererDirecteur"))
        {
            doActionInserDirecteur(request,response);
            jspChoix="/MenuAdmin.jsp";
        }
        
        else if (act.equals("supprimerMagasin"))
        {
            doActionSupprimerMagasin(request,response);
            jspChoix="/MenuAdmin.jsp";
        }
        
        RequestDispatcher Rd;
        Rd= getServletContext().getRequestDispatcher(jspChoix);
        Rd.forward(request,response);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Menu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Menu at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    protected void doActionInsererMagasin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String libelle= request.getParameter( "libelleMagasin" );
    String adresseMagasin= request.getParameter( "adresse" );
    String codePostalMagasin= request.getParameter( "codePostal" );
    String message;
    if ( libelle.trim().isEmpty()&&adresseMagasin.trim().isEmpty()&&codePostalMagasin.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionMagasin/CreerMagasin.jsp\">Cliquez ici</a> pour accéder au formulaire de création magasin.";
} else
{
    sessionAdmin.CreerMagasin(libelle, adresseMagasin, codePostalMagasin);
    message = "Magasin crée";
}
   
request.setAttribute( "message", message );
}
    
 protected void doActionInserDirecteur(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String nomPersonne= request.getParameter( "nom" );
    String prenomPersonne= request.getParameter( "prenom" );
    String loginPersonne= request.getParameter( "login" );
    String mdpPersonne= request.getParameter( "mdp" );
    String sexePersonne= request.getParameter( "sexe" );
    String dobPersonne= request.getParameter( "dob" );
    String adressePersonne= request.getParameter( "adresse" );
    String codePostalPersonne= request.getParameter( "codePostal" );
    String magasinPersonne= request.getParameter( "magasin" );
    String message;
    if ( nomPersonne.trim().isEmpty()&&prenomPersonne.trim().isEmpty()&&loginPersonne.trim().isEmpty()&&mdpPersonne.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionMagasin/CreerDirecteur.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un directeur.";
} else
{
    Date dob=Date.valueOf(dobPersonne);
    sessionAdmin.CreerDirecteur(nomPersonne, prenomPersonne,loginPersonne,mdpPersonne,sexePersonne,dob,adressePersonne, codePostalPersonne, magasinPersonne);
    message = "Directeur crée";
}
   
request.setAttribute( "message", message );
}   
 
 protected void doActionSupprimerMagasin(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{
     
                    Magasin Magasin=null;
                    String magasinasupprimer= request.getParameter ("libelleMagasin");
                   
                    
                    String message;
                    if ( magasinasupprimer.trim().isEmpty())
                    {
                        
                        
                        message = "Vueillez remplir l'ensemble des champs obligatoires"+"<br /> <a href=\"GestionMagasin/SupprimerMagasin.jsp\">Cliquez ici</a> pour accéder au formulaire de suppression Magasin .";
                    }
                    else
                    {  
                        sessionAdmin.SupprimerMagasin(magasinasupprimer,Magasin);
                        
                        message= "Magasin supprimé";
                    }
                    request.setAttribute ("message", message);
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
