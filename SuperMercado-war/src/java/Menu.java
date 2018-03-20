


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Session.SessionAdminLocal;
import Session.SessionChefDeRayonLocal;
import Session.SessionPersonneLocal;
import entités.gestionCommande.Fournisseur;
import entités.gestionMagasin.AgentCaisse;
import entités.gestionMagasin.ChefRayon;
import entités.gestionMagasin.DirecteurMagasin;
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
    private SessionPersonneLocal sessionPersonne;

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
        // sessionAdmin.CreerPersonneAdmin();
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
            i=sessionAdmin.SeConnecter(login, mp);
            HttpSession sess=request.getSession(true);
            if (i==0){
                String message="Identifiants incorrects";
                request.setAttribute( "message", message );
                jspChoix="/Accueil.jsp";
            }
            if(i==1){
                Personne personneConnecte =sessionAdmin.PersonneConnecte(login, mp);
                jspChoix="/MenuAdmin.jsp";
                sess.setAttribute("personneConnecte",personneConnecte);
                    }
            else if(i==2){
                Personne personneConnecte =sessionAdmin.PersonneConnecte(login, mp);
                ChefRayon chefRayonConnecte = (ChefRayon)personneConnecte;
                sess.setAttribute("chefRayonConnecte",chefRayonConnecte);
                jspChoix="/MenuChefdeRayon.jsp";
            }
            else if(i==3){
                Personne personneConnecte =sessionAdmin.PersonneConnecte(login, mp);
                DirecteurMagasin directeurConnecte = (DirecteurMagasin)personneConnecte;
                sess.setAttribute("directeurConnecte",directeurConnecte);
                jspChoix="/MenuDirecteur.jsp";
            }
            else if(i==4){
                Personne personneConnecte =sessionAdmin.PersonneConnecte(login, mp);
                AgentCaisse agentCaisse = (AgentCaisse)personneConnecte;
                sess.setAttribute("agentCaisse",agentCaisse);
                jspChoix="/MenuAgentCaisse.jsp";
            }
            else if(i==6){
                Personne personneConnecte =sessionAdmin.PersonneConnecte(login, mp);
                Fournisseur fournisseurConnecte = (Fournisseur)personneConnecte;
                sess.setAttribute("fournisseurConnecte",fournisseurConnecte);
                jspChoix="/MenuFournisseur.jsp";
            }
          }
        
        else if (act.equals("CasterEnPersonne"))
        {
            String personneCherche= request.getParameter( "idPersonneSession");
            Personne p = sessionPersonne.RechercherPersonneParId(personneCherche);
            HttpSession sess=request.getSession(false);
            sess.setAttribute("personneConnecte",p);
        
            jspChoix="/GestionMagasinJSP/ModifierMdp.jsp";
        }
        else if (act.equals("modifierMdp"))
        {
            doActionModifierMdp(request,response);
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
            out.println("<title>Servlet Menu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Menu at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
      protected void doActionModifierMdp (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
    String ancienMdp = request.getParameter("ancienMdp");
    String nouveauMdp = request.getParameter("nouveauMdp");
    String idPersonne = request.getParameter("id");
    
    String message;
    if(!(ancienMdp.trim().isEmpty() && nouveauMdp.trim().isEmpty()))
    {
        sessionPersonne.ModificationMdp(ancienMdp, nouveauMdp, idPersonne);
        message = "Votre mot de passe a été modifié avec succès";
        request.setAttribute("message", message);
    } 
    else
    {
        message = "Les champs ancien mot de passe et nouveau mot de passe sont obligatoires";
        request.setAttribute("message", message);
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

}
