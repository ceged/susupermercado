<%-- 
    Document   : MenuAdmin
    Created on : 13 mars 2018, 10:31:11
    Author     : Soldat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <A HREF="GestionMagasinJSP/CreerDirecteur.jsp">
        Créer un directeur</A><br/><br/>
        <A HREF="GestionArticleJSP/CreerCategorie.jsp">
        Créer une Catégorie</A><br/><br/>
        <A HREF="Admin?action=TransfererListeCategorie">
        Créer une sous-catégorie </A><br/><br/>
        <A HREF="Admin?action=TransfererListeRefArticle">
        Créer une Promotion </A><br/><br/>
        <A HREF="Accueil.jsp">
        Sortir menu principal</A><br/><br/>
        
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
