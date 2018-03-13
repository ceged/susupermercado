/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Session.SessionDirecteurMagasinLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        else if (act.equals("insererRayon"))
        {
            doActionInsererRayon(request,response);
            jspChoix="/MenuDirecteur.jsp";
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
    sessionDirecteurMagasin.CreerSecteur(libelleSecteur, magasinSecteur);
    message = "Secteur créé";
}
   
request.setAttribute( "message", message );
}
    protected void doActionInsererRayon(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String libelleSecteur= request.getParameter( "libelleRayon" );
    String magasinSecteur= request.getParameter( "Secteur" );
    String ChefRayon= request.getParameter( "ChefRayon" );
    String message;
    if ( libelleSecteur.trim().isEmpty()&&magasinSecteur.trim().isEmpty()&&ChefRayon.trim().isEmpty()){
    message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. " + "<br /> <a href=\"GestionMagasin/CreerRayon.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un rayon.";
} else
{
    sessionDirecteurMagasin.CreerRayon(libelleSecteur, magasinSecteur,ChefRayon);
    message = "Rayon créé";
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