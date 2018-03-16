<%-- 
    Document   : AfficherCommandeEnCours
    Created on : 16 mars 2018, 15:57:17
    Author     : Soldat
--%>

<%@page import="entités.gestionCommande.Commande"%>
<%@page import="entités.gestionCommande.LigneCommande"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="commande" scope="session" class="Commande"></jsp:useBean>
        <jsp:useBean id="listeLigneCommande" scope="session" class="List<LigneCommande>"></jsp:useBean>
<title>Bon de commande en cours</title>
</head>
<body>
<h1>Liste des articles ajoutés</h1>
<p> <%
String attribut = (String) request.getAttribute("message");
out.println( attribut );
%> </p>
<A HREF="GestionCommandeJSP/CreerLigneCommande.jsp?commandeId=<%=commande.getId() %>">Ajouter un article</A><br />
<A HREF="ChefRayonServlet?action=validerBonCommande&commandeId=<%=commande.getId()%>">Valider le bon de commande</A><br />
<TABLE border width=50%>
<tr> <TD>Designation article</TD>
<TD>Quantité</TD>
<TD>Prix unitaire</TD>
<TD>Supprimer de la commande</TD>
 </tr>
<%
for(LigneCommande l : listeLigneCommande){%>
<tr><td Width=15%><%=l.getArticle().getLibelleArticle() %></td>
<td Width=15%><%=l.getQuantiteLigne() %></td>
<td Width=15%><%=l.getPrixAchatUnitaire()%></td>
<td Width=30%><A href="ChefRayonServlet?action=SupprimerLigneAchat&ligneId=<%=l.getId() %>"> Cliquez ici</A></td>

</tr><%}%></TABLE>

<hr>
</body>
</html>
