<%-- 
    Document   : AfficherCommandeEnCours
    Created on : 16 mars 2018, 15:57:17
    Author     : Soldat
--%>
<%@page import="entités.gestionLivraison.Mention"%>
<% 
        
    if (session.getAttribute("agentRayonConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>


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
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="commande" scope="session" class="Commande"></jsp:useBean>
        <jsp:useBean id="liste" scope="session" class="List<LigneCommande>"></jsp:useBean>
<title>Commande</title>
</head>
<body>
<h1>Liste des articles</h1>
<p> <%
String attribut = (String) request.getAttribute("message");
if(attribut!=null){
    out.println( attribut );
}

%> </p>
<A HREF="MenuAgentRayon.jsp">Retour au menu</A><br />
<TABLE border width=50%>
<tr> <TD>Designation article</TD>
<TD>Quantité</TD>
<TD>Prix achat unitaire</TD>
<TD>Fournisseur</TD>
 </tr>
<%float t=0;
for(LigneCommande l : liste){
    
    t=t+l.getPrixAchatUnitaire()*l.getQuantiteLigne();
%>
<tr><td Width=15%><%=l.getArticle().getLibelleArticle() %></td>
<td Width=15%><%=l.getQuantiteLigne() %></td>
<td Width=15%><%=l.getPrixAchatUnitaire() %></td>
<td Width=15%><%=l.getCommande().getFournisseur().getNom()%></td>
</tr><%}%></TABLE>
<br />
<table border width="50%">
    <tr>
        <td>Montant total : </td>
        <td><%=t%></td>
    </tr>
    
</table>
<hr>
</body>
</html>
