<%-- 
    Document   : AfficherCommandeEnCours
    Created on : 16 mars 2018, 15:57:17
    Author     : Soldat
--%>

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
        <jsp:useBean id="chefRayonConnecte" scope="session" class="ChefRayon"></jsp:useBean>
<title>lListe des bons de commandes</title>
</head>
<body>
<h1>Liste des bons de commande</h1>
<p> <%
String attribut = (String) request.getAttribute("message");
if(attribut!=null){
    out.println( attribut );
            }
%> </p>
<A HREF="ChefRayonServlet?action=passageInfosCreerBonCommande&chefRayon=<%=chefRayonConnecte.getId()%>">Créer un bon de commande</A><br />
<A HREF="MenuChefdeRayon.jsp">Retour au menu</A><br />
<form method="get" action="/SuperMercado-war/ChefRayonServlet">
<label for="statut">Trier par <span class="requis">*</span></label>
<SELECT name="statut" size="1">
            <OPTION value="aucun">        
            <OPTION value="encours">En cours
            <OPTION value="valider">Validée
            <OPTION value="livrer">Livrée
        </SELECT>
<input type="hidden" name="chefRayon" value="<%=chefRayonConnecte.getId()%>">
<input type="hidden" name="action" value="passageModifListeBonCommande">
<input type="submit" value="Valider" />
</form>
<TABLE border width=50%>
<tr> <TD>Founisseur</TD>
<TD>Date</TD>
<TD>Statut</TD>
<TD>Voir le bon de commande</TD>
 </tr>
<%
for(Commande c : liste){%>
<tr><td Width=15%><%=c.getFournisseur().getNom()%></td>
<td Width=15%><%=c.getDateCommande()%></td>
<td Width=15%><%=c.getStatutCommande()%></td>
<td Width=30%><A href="ChefRayonServlet?action=afficherBonCommande&commandeId=<%=c.getId()%>"> Cliquez ici</A></td>

</tr><%}%></TABLE>

<hr>
</body>
</html>
