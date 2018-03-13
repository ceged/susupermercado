<%-- 
    Document   : MenuChefdeRayonJSP
    Created on : 12 mars 2018, 09:36:22
    Author     : PC Tim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="essai.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
    </head>
    <body>
        <h1>Bienvenue sur le menu Chef de rayon !</h1>
        <A HREF="ChefRayonServlet?action=creerArticle">
        Créer un article</A><br/><br/>
        <A HREF="bibliothecairelogin.jsp">
        Modifier prix article</A><br/><br/>
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
