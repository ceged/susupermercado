

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Session.SessionAdminLocal;
import Session.SessionChefDeRayonLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            i=sessionAdmin.SeConnecter(login, mp);
            if(i==1){
                jspChoix="/MenuAdmin.jsp";
                    }
            else if(i==2){
                jspChoix="/MenuChefdeRayon.jsp";
            }
            }
        else if (act.equals("insererMagasin"))
        {
            doActionInsererMagasin(request,response);
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
