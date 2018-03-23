<%-- 
    Document   : AfficherCommandeEnCours
    Created on : 16 mars 2018, 15:57:17
    Author     : Soldat
--%>
<%@page import="entités.gestionMagasin.AgentRayon"%>
<%@page import="entités.gestionLivraison.LigneLivraison"%>
<% 
        
    if (session.getAttribute("agentRayonConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>


<%@page import="entités.gestionLivraison.Livraison"%>
<%@page import="entités.gestionCommande.Fournisseur"%>
<%@page import="entités.gestionMagasin.ChefRayon"%>
<%@page import="entités.gestionCommande.Commande"%>
<%@page import="entités.gestionCommande.LigneCommande"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="liste" scope="session" class="List<Commande>"></jsp:useBean>
        <jsp:useBean id="agentRayonConnecte" scope="session" class=" AgentRayon"></jsp:useBean>
<title>Liste de vos commandes</title>
</head>
<body>
<h1>Liste de vos commandes</h1>
<p> <%
String attribut = (String) request.getAttribute("message");
if(attribut!=null){
    out.println( attribut );
            }
%> </p>
<A HREF="MenuAgentRayon.jsp">Retour au menu</A><br />
<TABLE border width=50%>
<tr> <TD>Rayon</TD>
<TD>Date</TD>
<TD>Statut</TD>
<TD>Voir la commande</TD>
 </tr>
<%
for(Commande l : liste){%>
<tr><td Width=15%><%=l.getChefRayon().getRayon().getLibelleRayon() %></td>
<td Width=15%><%=l.getDateCommande()%></td>
<td Width=15%><%=l.getStatut()%></td>
<td Width=30%><A href="AgentRayonServlet?action=afficherCommandeRayon&commandeId=<%=l.getId()%>"> Cliquez ici</A></td>

</tr><%}%></TABLE>

<hr>
</body>
</html>
