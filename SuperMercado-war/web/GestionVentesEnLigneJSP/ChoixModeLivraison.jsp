<%-- 
    Document   : ChoixModeLivraison
    Created on : 23 mars 2018, 16:51:35
    Author     : Soldat
--%>
<%@page import="entités.gestionMagasin.Magasin"%>
<%@page import="entités.gestionArticle.Achat"%>
<% 
        
    if (session.getAttribute("client") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>

<%@page import="entités.gestionVenteEnLigne.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="magasinChoisi" scope="session" class="Magasin"></jsp:useBean>
        <jsp:useBean id="client" scope="session" class="Client"></jsp:useBean>
        <jsp:useBean id="achat" scope="session" class="Achat"></jsp:useBean>
        <title>Choix mode de livraison</title>
    </head>
    <body>
        <h1>Choix mode de livraison</h1>
        <form method="get" action="/SuperMercado-war/ClientServlet">
        <label for="retraitMagasin">Retrait en magasin <span class="requis">*</span></label>
        <input type="radio" name="retraitMagasin" value="" size="20" maxlength="20" />
        <br />
        <label for="livraisonDomicile">Livraison à domicile <span class="requis">*</span></label>
        <input type="radio" name="livraisonDomicile" value="" size="20" maxlength="20" />
        <br />
        <input type="hidden" name="action" value="selectionModeLivraison">
        <input type="hidden" name="nomMag" value="<%=magasinChoisi.getNomMagasin()%>">
        <input type="hidden" name="idAchat" value="<%=achat.getId()%>">
        <input type="submit" value="Valider" />
        </form>
    </body>
</html>
