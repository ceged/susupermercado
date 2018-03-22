<%-- 
    Document   : CreerFournisseur
    Created on : 14 mars 2018, 11:59:16
    Author     : Sophia
--%>
<% 
        
    if (session.getAttribute("chefRayonConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>


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
        <jsp:useBean id="chefRayonConnecte" scope="session" class="ChefRayon"></jsp:useBean>
        <jsp:useBean id="listeFournisseur" scope="session" class="List<Fournisseur>"></jsp:useBean>
        <link rel="stylesheet" href="test.css" type="test/css">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Formulaire de bon de commande</h1>
        <form method="get" action="/SuperMercado-war/ChefRayonServlet">
        <fieldset>
        <legend>Informations bon de commande (majuscules et accents interdits)</legend>
        <label for="fournisseur">Fournisseur <span class="requis">*</span></label>
        <SELECT name="fournisseur" size="1">
            <%
            for(Fournisseur f: listeFournisseur){ %>
            <OPTION> <%=f.getNom()%>
                <%}%>
        </SELECT>
        <br />
        <label for="date"> Date <span class="requis">*</span></label>
        <input type="date" name="date" value="" size="20" maxlength="20" />
        <br />
        <input type="hidden" name="chefRayon" value="<%=chefRayonConnecte.getId()%>">
        <input type="hidden" name="action" value="insererBonCommande">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
    </body>
</html>
        
