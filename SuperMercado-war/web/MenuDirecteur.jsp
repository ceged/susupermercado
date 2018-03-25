<%-- 
    Document   : MenuDirecteur
    Created on : 13 mars 2018, 13:50:24
    Author     : Soldat
--%>

<%@page import="entités.gestionMagasin.DirecteurMagasin"%>
<%@page import="entités.gestionMagasin.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="text.css" type="text/css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="directeurConnecte" scope="session" class="DirecteurMagasin"></jsp:useBean>
        <title>JSP Page</title>
    <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>
    <%@ include file="/include/sidebar.jsp" %>
    <body>
    <% DirecteurMagasin p= directeurConnecte;{%>
<tr> <td Width=15%>Bienvenue <%=p.getPrenom()%></td>
</tr><%}%>
        <h1>Bienvenue sur le menu Directeur !</h1>
        <A HREF="GestionMagasinJSP/CreerSecteur.jsp">
        Créer un secteur</A><br/><br/>
        <A HREF="DirecteurServlet?action=transferListeRayon&directeur=<%=p.getId()%>">
        Créer un chef de rayon</A><br/><br/>
        <A HREF="DirecteurServlet?action=transferListeSecteur&directeur=<%=p.getId()%>">
        Créer un rayon</A><br/><br/>
        <A HREF="DirecteurServlet?action=passageInfospourModifierRayon&directeur=<%=p.getId()%>">
        Modifier un rayon</A><br/><br/>
        <A HREF="DirecteurServlet?action=TransfererListeRayon&directeur=<%=p.getId()%>">
        Supprimer un rayon</A><br/><br/>

        <A HREF="GestionMagasinJSP/CreerCaisse.jsp">
        Créer une caisse</A><br/><br/>
        <A HREF="DirecteurServlet?action=TransfererListeCaisse&directeur=<%=p.getId()%>">
        Supprimer une caisse</A><br/><br/>
        <A HREF="GestionMagasinJSP/CreerAgentCaisse.jsp">
        Créer un AgentCaisse</A><br/><br/>
        <A HREF="DirecteurServlet?action=transferListeRayon2&directeur=<%=p.getId()%>">
        Créer un AgentRayon</A><br/><br/>
        
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
     <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
