<%-- 
    Document   : CreerFournisseur
    Created on : 14 mars 2018, 11:59:16
    Author     : Sophia
--%>

<%@page import="entités.gestionArticle.ReferentielArticle"%>
<a href="CreerLigneCommande.jsp"></a>
<%@page import="entités.gestionCommande.Commande"%>
<%@page import="entités.gestionCommande.Fournisseur"%>
<%@page import="entités.gestionMagasin.ChefRayon"%>
<%@page import="entités.gestionMagasin.Rayon"%>
<%@page import="java.util.List"%>
<%@page import="entités.gestionMagasin.DirecteurMagasin"%>
<%@page import="entités.gestionMagasin.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Commande.css" type="text/css">
        <jsp:useBean id="chefRayonConnecte" scope="session" class="ChefRayon"></jsp:useBean>
        <jsp:useBean id="commande" scope="session" class="Commande"></jsp:useBean>
        <title>JSP Page</title>
    <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>
    <%@ include file="/include/sidebar.jsp" %>
    <body>
    <% List<ReferentielArticle> liste= commande.getFournisseur().getListeReferentielArticles(); %>
         <h1>Formulaire de ligne commande</h1>
        <center> 
            <form method="get" action="/SuperMercado-war/ChefRayonServlet">
        <fieldset>
        <legend>Informations ligne commande (majuscules et accents interdits)</legend>
        <label for="article">Article du fournisseur<span class="requis">*</span></label>
        <SELECT name="article" size="1">
            <%
            for(ReferentielArticle r: liste){ %>
            <OPTION value="<%=r.getCodeBarre()%>"> <%=r.getLibelleArticle()%>
                <%}%>
        </SELECT>
        <br />
        <label for="quantite"> Quantité <span class="requis">*</span></label>
        <input type="number" name="quantite" value="" size="20" maxlength="20" />
        <br />
        <label for="prix"> Prix Unitaire <span class="requis">*</span></label>
        <input type="number" step="0.01" name="prix" value="" size="20" maxlength="20" />
        <br />
        <input type="hidden" name="commandeId" value="<%=commande.getId()%>">
        <input type="hidden" name="action" value="insererLigneCommande">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
        </center> 
     <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
