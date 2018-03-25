<%-- 
    Document   : AfficherCommandeEnCours
    Created on : 16 mars 2018, 15:57:17
    Author     : Soldat
--%>
<%@page import="entités.gestionMagasin.AgentRayon"%>
<% 
        
    if (session.getAttribute("agentRayonConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>

<%@page import="entités.gestionLivraison.Mention"%>
<%@page import="entités.gestionLivraison.AgentLivraison"%>
<%@page import="entités.gestionLivraison.Livraison"%>
<%@page import="entités.gestionLivraison.LigneLivraison"%>
<%@page import="entités.gestionCommande.Commande"%>
<%@page import="entités.gestionCommande.LigneCommande"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="agentRayonConnecte" scope="session" class="AgentRayon"></jsp:useBean>
        <jsp:useBean id="livraison" scope="session" class="Livraison"></jsp:useBean>
        <jsp:useBean id="liste" scope="session" class="List<LigneLivraison>"></jsp:useBean>
<title>Commande</title>
</head>
<body>
<h1>Liste des articles de la livraison</h1>
<p> <%
String attribut = (String) request.getAttribute("message");
if(attribut!=null){
    out.println( attribut );
}

%> </p>
<A HREF="MenuAgentRayon.jsp">Retour au menu</A><br />
<TABLE border width=50%>
<tr> <TD>Designation article</TD>
<TD>Quantité Receptionnée</TD>
<TD>Statut</TD>
 </tr>
<%
for(LigneLivraison l : liste){%>
<tr><td Width=15%><%=l.getLigneCommande().getArticle().getLibelleArticle() %></td>
    <% if(l.getMentionStatut().equals(Mention.validation)){%>
        <td Width=15%></td>
        <td Width=15%>attente réception</td>
        <%}else{%>
        <td Width=15%><%=l.getQuantiteReceptionnee() %></td>
<td Width=15%><%=l.getMentionStatut()%></td>
</tr><%}}%>

<hr>
</body>
</html>
