<%-- 
    Document   : MenuAdmin
    Created on : 13 mars 2018, 10:31:11
    Author     : Soldat
--%>
<% 
        
    if (session.getAttribute("personneConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>


<%@page import="java.io.IOException"%>
<%@page import="entités.gestionMagasin.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="personneConnecte" scope="session" class="Personne"></jsp:useBean>
<link rel="stylesheet" href="text.css" type="text/css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>
    </head>
    <body>
            
        <h1>Bienvenue sur le menu Admin !</h1>
        <A HREF="GestionMagasinJSP/CreerMagasin.jsp">
        Créer un magasin</A><br/><br/>
        <A HREF="Admin?action=TransfererListeMagasinPourAjoutDirecteur">
        Créer un directeur</A><br/><br/>
        <A HREF="GestionArticleJSP/CreerCategorie.jsp">
        Créer une Catégorie</A><br/><br/>
        <A HREF="Admin?action=TransfererListeCategorie">
        Créer une sous-catégorie </A><br/><br/>
        <A HREF="Admin?action=TransfererListeRefArticle">
        Créer une Promotion </A><br/><br/>
        <A HREF="Admin?action=TransfererListeMagasin">
        Supprimer un magasin</A><br/><br/>
        <A HREF="Accueil.jsp">
        Sortir menu principal</A><br/><br/>
        <A HREF="Menu?action=CasterEnPersonne&idPersonneSession=<%=personneConnecte.getId()%>">
        Modifier mon mot de passe</A><br/><br/>

        <p> <%
        String attribut = (String) request.getAttribute("message");
        if(attribut==null){
            attribut="Aucune action effectuée";
        }
        else{
        out.println( attribut );}
        %> </p>
    </body>
</html>
