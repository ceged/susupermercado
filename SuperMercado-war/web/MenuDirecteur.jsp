<%-- 
    Document   : MenuDirecteur
    Created on : 13 mars 2018, 13:50:24
    Author     : Soldat
--%>

<%@page import="entités.gestionMagasin.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="personneConnecte" scope="session" class="Personne"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
<body>
    <% Personne p= personneConnecte;{%>
<tr> <td Width=15%>Bienvenue <%=p.getPrenom()%></td>
</tr><%}%>
        <h1>Bienvenue sur le menu Directeur !</h1>
        <A HREF="GestionArticleJSP/CreerArticle.jsp">
        Créer un article</A><br/><br/>
        <A HREF="bibliothecairelogin.jsp">
        Modifier prix article</A><br/><br/>
        <A HREF="Accueil.jsp">
        Sortir menu principal</A><br/><br/>
<body>  
    <A HREF="GestionMagasinJSP/CreerSecteur.jsp">Créer un Secteur</A>
        <br/><br/>
    <A HREF="Accueil.jsp">Sortir menu principal</A>
        <br/><br/>
    
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
