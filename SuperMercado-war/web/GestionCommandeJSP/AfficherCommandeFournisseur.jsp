<%-- 
    Document   : AfficherCommandeEnCours
    Created on : 16 mars 2018, 15:57:17
    Author     : Soldat
--%>

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
        <jsp:useBean id="livraison" scope="session" class="Livraison"></jsp:useBean>
        <jsp:useBean id="liste" scope="session" class="List<LigneLivraison>"></jsp:useBean>
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
<A HREF="MenuFournisseur.jsp">Retour au menu</A><br />
<TABLE border width=50%>
<tr> <TD>Designation article</TD>
<TD>Quantité</TD>
<TD>Statut</TD>
<TD>Valider la ligne</TD>
<TD>Supprimer la ligne</TD>
 </tr>
<%float t=0;
for(LigneLivraison l : liste){%>
<tr><td Width=15%><%=l.getArticle().getLibelleArticle() %></td>
<td Width=15%><%=l.getQuantiteFournisseur()%></td>
<td Width=15%><%=l.getMentionStatut()%></td>
<td Width=30%><A href="FournisseurServlet?action=ValiderLigneLivraison&ligneId=<%=l.getId() %>&livraisonId=<%=livraison.getId() %>"> Cliquez ici</A></td>
<td Width=30%><A href="FournisseurServlet?action=SupprimerLigneLivraison&ligneId=<%=l.getId() %>&livraisonId=<%=livraison.getId()%>"> Cliquez ici</A></td>
</tr><%}%></TABLE>

<A HREF="MenuFournisseur.jsp">Valider la commande pour livraison</A><br />
<hr>
</body>
</html>
