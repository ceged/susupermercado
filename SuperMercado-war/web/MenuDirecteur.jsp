<%-- 
    Document   : MenuDirecteur
    Created on : 13 mars 2018, 13:50:24
    Author     : Soldat
--%>

<%@page import="entités.gestionMagasin.DirecteurMagasin"%>
<%@page import="entités.gestionMagasin.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="directeurConnecte" scope="session" class="DirecteurMagasin"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
<body>
    <% DirecteurMagasin p= directeurConnecte;{%>
<tr> <td Width=15%>Bienvenue <%=p.getPrenom()%></td>
</tr><%}%>
        <h1>Bienvenue sur le menu Directeur !</h1>
        <A HREF="ChefRayonServlet?action=creerArticle">
        Créer un article</A><br/><br/>
        <A HREF="GestionArticleJSP/CreerArticle.jsp">
        Créer un article</A><br/><br/>
        <A HREF="bibliothecairelogin.jsp">
        Modifier prix article</A><br/><br/>
        <A HREF="Accueil.jsp">
        Sortir menu principal</A><br/><br/>
    </body>
</html>
