<%-- 
    Document   : MenuChefdeRayonJSP
    Created on : 12 mars 2018, 09:36:22
    Author     : PC Tim
--%>

<%--<%@page import="entités.gestionMagasin.ChefRayon"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="text.css" type="text/css">
       <%-- <jsp:useBean id="chefRayonConnecte" scope="session" class="ChefRayon"></jsp:useBean>--%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
    <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>
    <%@ include file="/include/sidebar_chefrayon.jsp" %>
    <body>
       <%--<% ChefRayon c= chefRayonConnecte;{%>--%>
<%--<tr> <td Width=15%>Bienvenue <%=c.getPrenom()%></td>
</tr><%}%>
        <h1>Bienvenue sur le menu Chef de rayon !</h1>
        <A HREF="ChefRayonServlet?action=passageListeSousCategorie">
        Créer un article</A><br/><br/>
        <A HREF="ChefRayonServlet?action=passageInfospourModifierPrix&chefRayon=<%=c.getId()%>">
        Modifier prix article</A><br/><br/>
        <A HREF="ChefRayonServlet?action=passageInfospourSupprimerArticle&chefRayon=<%=c.getId()%>">
        Supprimer article</A><br/><br/>
        <A HREF="GestionCommandeJSP/CreerFournisseur.jsp">
        Créer un fournisseur</A><br/><br/>
        <A HREF="ChefRayonServlet?action=passageInfosCreerBonCommande&chefRayon=<%=c.getId()%>">
        Créer bon de commande</A><br/><br/>
        <A HREF="ChefRayonServlet?action=passageInfosListeBonCommande&chefRayon=<%=c.getId()%>">
        Afficher les bon de commandes</A><br/><br/>
        <A HREF="Accueil.jsp">
        Sortir menu principal</A><br/><br/>
        --%>
        <p> <%
        String attribut = (String) request.getAttribute("message");
        if(attribut==null){
            attribut="Aucune action effectuée";
        }
        else{
        out.println( attribut );}
        %> </p>
     <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
