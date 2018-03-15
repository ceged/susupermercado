/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Session.SessionAdminLocal;
import entités.gestionArticle.Categorie;
import entités.gestionArticle.ReferentielArticle;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author CGAILLOTDREVON
 */
public class Admin extends HttpServlet {

    @EJB
    private SessionAdminLocal sessionAdmin;
    
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
        String jspChoix ="/MenuAdmin.jsp";
        String act=request.getParameter("action");
        
         if ((act == null)||(act.equals("null")))
            {
            jspChoix="/MenuAdmin.jsp";
            }
        
    else if (act.equals("insererMagasin"))
        {
            doActionInsererMagasin(request,response);
            jspChoix="/MenuAdmin.jsp";
        }
        else if (act.equals("insererDirecteur"))
        {
            doActionInsererDirecteur(request,response);
            jspChoix="/MenuAdmin.jsp";
        }  
       
        else if (act.equals("insererCategorie"))
        {
            doActionInsererCategorie(request,response);
            jspChoix="/MenuAdmin.jsp";
        }
        else if (act.equals("TransfererListeCategorie"))
        {
            HttpSession sess=request.getSession(true);
            List<Categorie> listeCategorie = sessionAdmin.ListerCategorie();
            sess.setAttribute("listeCategorie",listeCategorie); 
            jspChoix="/GestionArticleJSP/CreerSousCategorie.jsp";
            
        } 
        else if (act.equals("insererSousCategorie"))
        {
            doActionInsererSousCategorie(request,response);
            jspChoix="/MenuAdmin.jsp";
        }
         
        else if (act.equals("TransfererListeRefArticle"))
        {
            HttpSession sess=request.getSession(true);
            List<ReferentielArticle> listeRefArticle = sessionAdmin.ListerReferentielArticle();
            sess.setAttribute("listeRefArticle",listeRefArticle); 
            jspChoix="/GestionArticleJSP/CreerSousCategorie.jsp";
            
        } 
         
        
        
         
         
     RequestDispatcher Rd;
        Rd= getServletContext().getRequestDispatcher(jspChoix);
        Rd.forward(request,response);
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Admin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Admin at " + request.getContextPath() + "</h1>");
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
    
 protected void doActionInsererDirecteur(HttpServletRequest request, HttpServletResponse response)
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
    message=sessionAdmin.CreerDirecteur(nomPersonne, prenomPersonne,loginPersonne,mdpPersonne,sexePersonne,dob,adressePersonne, codePostalPersonne, magasinPersonne);
    
}
   
request.setAttribute( "message", message );
}
 
protected void doActionInsererCategorie(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String libelle= request.getParameter( "libelleCategorie" );
    String message;
    if ( libelle.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionMagasin/CreerMagasin.jsp\">Cliquez ici</a> pour accéder au formulaire de création magasin.";
} else
{
    sessionAdmin.CreerCategorie(libelle);
    message = "Categorie crée";
}
   
request.setAttribute( "message", message );
}

protected void doActionInsererSousCategorie(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String libelleCategorie= request.getParameter( "libelleCategorie" );
    String libelleSousCategorie= request.getParameter( "libelleSousCategorie" );
    String message;
    if ( libelleCategorie.trim().isEmpty()&&libelleSousCategorie.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionMagasin/CreerMagasin.jsp\">Cliquez ici</a> pour accéder au formulaire de création magasin.";
} else
{
    message =sessionAdmin.CreerSousCategorie(libelleSousCategorie, libelleCategorie);

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
