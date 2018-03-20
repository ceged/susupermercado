<%-- 
    Document   : AfficherCommandeEnCours
    Created on : 16 mars 2018, 15:57:17
    Author     : Soldat
--%>

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
        <jsp:useBean id="liste" scope="session" class="List<Livraison>"></jsp:useBean>
        <jsp:useBean id="fournisseurConnecte" scope="session" class="Fournisseur"></jsp:useBean>
<title>lListe de vos commandes</title>
</head>
<body>
<h1>Liste de vos commandes</h1>
<p> <%
String attribut = (String) request.getAttribute("message");
if(attribut!=null){
    out.println( attribut );
            }
%> </p>
<A HREF="MenuFournisseur.jsp">Retour au menu</A><br />
<TABLE border width=50%>
<tr> <TD>Magasin</TD>
<TD>Date</TD>
<TD>Statut</TD>
<TD>Voir la commande</TD>
 </tr>
<%
for(Livraison l : liste){%>
<tr><td Width=15%><%=l.getCommande().getChefRayon().getRayon().getSecteur().getMagasin().getNomMagasin() %></td>
<td Width=15%><%=l.getCommande().getDateCommande()%></td>
<td Width=15%><%=l.getStatut()%></td>
<td Width=30%><A href="FournisseurServlet?action=afficherCommandeFournisseur&livraisonId=<%=l.getId()%>"> Cliquez ici</A></td>

</tr><%}%></TABLE>

<hr>
</body>
</html>
