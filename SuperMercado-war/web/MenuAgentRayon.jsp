<%-- 
    Document   : MenuAgentLivraison
    Created on : 20 mars 2018, 09:25:06
    Author     : Soldat
--%>

<%@page import="entités.gestionMagasin.AgentRayon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="agentRayonConnecte" scope="session" class="AgentRayon"></jsp:useBean>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Agent livraison</title>
    </head>
    <body>
    <tr> <td Width=15%>Bienvenue <%=agentRayonConnecte.getPrenom()%></td>
</tr>
        <h1>Menu Agent livraison</h1>
        <A HREF="GestionArticleJSP/CreerCasse.jsp">
        Saisir casse</A><br/><br/>
        <A HREF="AgentRayonServlet?action=passageListeCasseRayon&idAgent=<%=agentRayonConnecte.getId()%>">
        Consulter liste casse de mon rayon</A><br/><br/>
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