<%@page import="entités.gestionArticle.ReferentielArticle"%>
<%@page import="java.util.List"%>

<%-- 
    Document   : CreerPromotion
    Created on : 15 mars 2018, 10:47:16
    Author     : CGAILLOTDREVON
--%>
<% 
        
    if (session.getAttribute("personneConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="listeRefArticle" scope="session" class="List<ReferentielArticle>"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
        
       <h1>Créer une Promotion</h1>
        
        <form method="get" action="/SuperMercado-war/Admin">
        <fieldset>
        
        <label for="dob">Date de début de la promotion <span class="requis">*</span></label>
        <input type="date" name="dateDeb" value="" size="20" maxlength="20" />
        <br />    
        
        <label for="dob">Date de fin de la promotion <span class="requis">*</span></label>
        <input type="date" name="dateFin" value="" size="20" maxlength="20" />
        <br />  
        
        <label for="prixPromo">Prix de la promotion <span class="requis">*</span></label>
        <input type="number" name="prixPromo" min="0" step="0.01" />
        <br />
            
        <label for="libelle"> Libellé Article <span class="requis">*</span></label>
        <SELECT name="libelle" size="1">
            <%
            for(ReferentielArticle a: listeRefArticle){ %>
            <OPTION><%=a.getLibelleArticle()%>
                <%}%>
        </SELECT>
        
        <input type="hidden" name="action" value="insererPromotion">
        
        
        </fieldset>
        
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form> 
    </body>
</html>
