<%-- 
    Document   : InfoRetraitMagasin
    Created on : 23 mars 2018, 18:51:53
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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="magasinChoisi" scope="session" class="Magasin"></jsp:useBean>
        <jsp:useBean id="achat" scope="session" class="Achat"></jsp:useBean>
        <title>Informations Retrait Magasin</title>
    </head>
    <body>
        <h1>Choisir date de retrait</h1>
        <form method="get" action="/SuperMercado-war/ClientServlet">
        <label for="date">Date <span class="requis">*</span></label>
        <input type="date" name="date" value="livraisonDomicile" min="<%=achat.getDateAchat()%>" size="20" maxlength="20" required="" />
        <br />
        <input type="hidden" name="action" value="dateRetraitMagasin">
        <input type="hidden" name="IdMag" value="<%=magasinChoisi.getId() %>">
        <input type="hidden" name="idAchat" value="<%=achat.getId()%>">
        <input type="submit" value="Valider" />
        </form>
    </body>
</html>
