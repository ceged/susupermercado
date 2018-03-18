<%-- 
    Document   : SupprimerArticle
    Created on : 15 mars 2018, 14:05:22
    Author     : Soldat
--%>

<%@page import="entités.gestionArticle.ReferentielArticle"%>
<%@page import="java.util.List"%>
<%@page import="entités.gestionMagasin.ChefRayon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="chefRayonConnecte" scope="session" class="ChefRayon"></jsp:useBean>
        <jsp:useBean id="listeReferentielArticle" scope="session" class="List<ReferentielArticle>"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
        <% ChefRayon c= chefRayonConnecte;
        List<ReferentielArticle> liste=listeReferentielArticle;{%>
<tr> <td Width=15%>Bienvenue <%=c.getNom()%></td>
</tr><%}%>
        <h1>Formulaire de suppresion d'article</h1>
        <form method="get" action="/SuperMercado-war/ChefRayonServlet">
        <fieldset>
        <legend>Choisir l'article à supprimer</legend>
        <br />
        <input type="hidden" name="rayon" value=<%=c.getRayon().getLibelleRayon() %> size="20" maxlength="20" />
        <input type="hidden" name="magasin" value=<%=c.getRayon().getSecteur().getMagasin().getNomMagasin() %> size="20" maxlength="20" />
        <label for="libelleArticle">Article <span class="requis">*</span></label>
        <SELECT name="libelleArticle" size="1">
            <%
            for(ReferentielArticle r: liste){ %>
            <OPTION value="<%=r.getCodeBarre()%>"><%=r.getLibelleArticle()%>
                <%}%>
        </SELECT>
        <br />
        <input type="hidden" name="action" value="SupprimerArticle">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
</html>
