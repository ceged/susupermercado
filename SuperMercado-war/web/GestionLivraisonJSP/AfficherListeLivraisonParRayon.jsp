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


<%@page import="entités.gestionLivraison.AgentLivraison"%>
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
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="liste" scope="session" class="List<Livraison>"></jsp:useBean>
        <jsp:useBean id="agentRayonConnecte" scope="session" class="AgentRayon"></jsp:useBean>
<title>Liste de vos livraisons</title>
  <%@ include file="/include/css.jsp" %>
    </head>
     <%@ include file="/include/header.jsp" %>
     <%@ include file="/include/sidebar_agentrayon.jsp" %>
     
<body>
<h1>Liste de vos livraisons</h1>
<p> <%
String attribut = (String) request.getAttribute("message");
if(attribut!=null){
    out.println( attribut );
            }
%> </p>
<A HREF="MenuAgentRayon.jsp">Retour au menu</A><br />
<TABLE border width=50%>
<tr> <TD>Fournisseur</TD>
<TD>Date livraison prévue</TD>
<TD>Statut</TD>
<TD>Voir la livraison</TD>
 </tr>
<%
for(Livraison l : liste){%>
<tr><td Width=15%><%=l.getCommande().getFournisseur().getNom()%></td>
<td Width=15%><%=l.getDatePrevue() %></td>
<td Width=15%><%=l.getStatut()%></td>
<td Width=30%><A href="AgentRayonServlet?action=afficherLivraisonAgent&livraisonId=<%=l.getId()%>"> Cliquez ici</A></td>

</tr><%}%></TABLE>

<hr>
  
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>