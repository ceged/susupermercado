<%-- 
    Document   : ModifierPrixArticle
    Created on : 15 mars 2018, 12:03:08
    Author     : Soldat
--%>
<% 
        
    if (session.getAttribute("chefRayonConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>



<%@page import="java.util.List"%>
<%@page import="entités.gestionArticle.ReferentielArticle"%>
<%@page import="entités.gestionMagasin.ChefRayon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="chefRayonConnecte" scope="session" class="ChefRayon"></jsp:useBean>
        <jsp:useBean id="listeReferentielArticleModifier" scope="session" class="List<ReferentielArticle>"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
        <% ChefRayon c= chefRayonConnecte;
        List<ReferentielArticle> liste=listeReferentielArticleModifier;{%>
<tr> <td Width=15%>Bienvenue <%=c.getNom()%></td>
</tr><%}%>
        <h1>Formulaire de création d'article</h1>
        <form method="get" action="/SuperMercado-war/ChefRayonServlet">
        <fieldset>
        <legend>Informations Article (majuscules et accents interdits)</legend>
        <br />
        <input type="hidden" name="rayon" value=<%=c.getRayon().getLibelleRayon() %> size="20" maxlength="20" />
        <input type="hidden" name="magasin" value=<%=c.getRayon().getSecteur().getMagasin().getNomMagasin() %> size="20" maxlength="20" />
        <label for="libelleArticle">Article <span class="requis">*</span></label>
        <SELECT name="libelleArticle" size="1">
            <%
            for(ReferentielArticle r: liste){ %>
            <OPTION><%=r.getLibelleArticle()%>
                <%}%>
        </SELECT>
        <br />
        <label for="newprix">Nouveau prix <span class="requis">*</span></label>
        <input type="number" step="0.01" name="newprix" value="" size="20" maxlength="20" required/>
        <br />
        <input type="hidden" name="action" value="modifierPrixArticle">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
</html>
