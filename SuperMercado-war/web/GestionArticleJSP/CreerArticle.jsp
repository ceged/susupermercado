<%-- 
    Document   : CreerArticle
    Created on : 12 mars 2018, 09:47:40
    Author     : PC Tim
--%>
<% 
        
    if (session.getAttribute("chefRayonConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>


<%@page import="entités.gestionCommande.Fournisseur"%>
<%@page import="java.util.List"%>
<%@page import="entités.gestionArticle.SousCategorie"%>
<%@page import="entités.gestionMagasin.ChefRayon"%>
<%@page import="entités.gestionMagasin.Personne"%>
<%@page import="Session.SessionChefDeRayon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="chefRayonConnecte" scope="session" class="ChefRayon"></jsp:useBean>
        <jsp:useBean id="listeSousCategorie" scope="session" class="List<SousCategorie>"></jsp:useBean>
        <jsp:useBean id="listeFournisseur" scope="session" class="List<Fournisseur>"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
        <% ChefRayon c= chefRayonConnecte;
    List<SousCategorie> listeSousCategorie2 =listeSousCategorie;{%>
<tr> <td Width=15%>Bienvenue <%=c.getNom()%></td>
</tr><%}%>
        <h1>Formulaire de création d'article</h1>
        <form method="get" action="/SuperMercado-war/ChefRayonServlet">
        <fieldset>
        <legend>Informations Produit (majuscules et accents interdits)</legend>
        <label for="libelleArticle">Libéllé article <span class="requis">*</span></label>
        <input type="text" name="libelleArticle" value="" size="20" maxlength="20" required />
        <br />
        <input type="hidden" name="rayon" value="<%=c.getRayon().getId() %>" size="20" maxlength="20" />
        <input type="hidden" name="magasin" value=<%=c.getRayon().getSecteur().getMagasin().getNomMagasin() %> size="20" maxlength="20" />
        <label for="marque">Marque <span class="requis">*</span></label>
        <input type="text" name="marque" value="" size="20" maxlength="20" required />
        <br />
        <label for="prix">Prix de vente <span class="requis">*</span></label>
        <input type="number" step="0.01" name="prix" value="" size="20" maxlength="20" required/>
        <br />
        <label for="souscategorie">Sous catégorie <span class="requis">*</span></label>
        <SELECT name="souscategorie" size="1">
            <%
            for(SousCategorie s: listeSousCategorie2){ %>
            <OPTION><%=s.getLibelleSousCategorie()%>
                <%}%>
        </SELECT>
        <br />
        <A HREF="GestionCommandeJSP/CreerFournisseur.jsp">
        Créer un fournisseur</A><br/><br/>
        <br />
        <label for="listeFournisseur">Liste de fournisseur<span class="requis">*</span></label><br />
        <%
            int i=0;
            for(Fournisseur f: listeFournisseur){ i++;%>
            <input type="checkbox" name=<%=i%> value=<%=f.getId()%> size="20" required/><%=f.getNom()%>
                <%}%>
        <br />
        <input type="hidden" name="action" value="insererReferentielArticle">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
    </body>
</html>
