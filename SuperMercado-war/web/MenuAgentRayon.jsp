<%-- 
    Document   : MenuAgentRayon
    Created on : 16 mars 2018, 17:28:38
    Author     : CGAILLOTDREVON
--%>

<%@page import="entités.gestionMagasin.AgentRayon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="essai.css" type="text/css">
        <jsp:useBean id="AgentRayonConnecte" scope="session" class="AgentRayon"></jsp:useBean>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% AgentRayon a= AgentRayonConnecte;{%>
        <tr> <td Width=15%>Bienvenue <%=a.getPrenom()%></td>
        </tr><%}%>
        <h1>Bienvenue sur le menu Agent de Rayon !</h1>
        
        <A HREF="GestionArticleJSP/CreerCasse.jsp">
        Saisir une casse article</A><br/><br/>
        
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
