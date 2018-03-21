<%-- 
    Document   : MenuAgentLivraison
    Created on : 20 mars 2018, 09:25:06
    Author     : Soldat
--%>

<%@page import="entités.gestionLivraison.AgentLivraison"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="agentLivraisonConnecte" scope="session" class="AgentLivraison"></jsp:useBean>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Agent Rayon</title>
    </head>
    <body>
    <tr> <td Width=15%>Bienvenue <%=agentLivraisonConnecte.getPrenom()%></td>
</tr>
        <h1>Menu Agent Rayon</h1>
        <A HREF="AgentLivraisonServlet?action=passageInfosListeReceptionLivraison&agentLivraison=<%=agentLivraisonConnecte.getId()%>">
        Consulter la liste de livraison</A><br/><br/>
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
