<%-- 
    Document   : AfficherCommandeEnCours
    Created on : 16 mars 2018, 15:57:17
    Author     : Soldat
--%>


<%@page import="entités.gestionArticle.Casse"%>
<%@page import="entités.gestionMagasin.AgentRayon"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="liste" scope="session" class="List<Casse>"></jsp:useBean>
        <jsp:useBean id="agentRayonConnecte" scope="session" class="AgentRayon"></jsp:useBean>
<title>Liste des bons de commandes</title>
</head>
<body>
<h1>Liste des casses du rayon <%=agentRayonConnecte.getRayon().getLibelleRayon() %> </h1>

<TABLE border width=50%>
<tr> <TD>Nom article</TD>
<TD>Date</TD>
<TD>Quantite casse</TD>
<TD>Motif</TD>
 </tr>
<%
for(Casse c : liste){%>
<tr><td Width=15%><%=c.getLotArticleCasse().getArticle().getLibelleArticle() %></td>
<td Width=15%><%=c.getDateCasse() %></td>
<td Width=15%><%=c.getQuantiteCasse() %></td>
<td Width=30%><%=c.getMotifCasse() %></td>

</tr><%}%></TABLE>
<hr>

<A HREF="MenuAgentRayon.jsp">Retour au menu</A><br />
</body>
</html>
