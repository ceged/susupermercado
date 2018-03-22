<%-- 
    Document   : AfficherCommandeEnCours
    Created on : 16 mars 2018, 15:57:17
    Author     : Soldat
--%>

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
        <jsp:useBean id="agentLivraisonConnecte" scope="session" class="AgentLivraison"></jsp:useBean>
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
<A HREF="MenuAgentLivraison.jsp">Retour au menu</A><br />
<TABLE border width=50%>
<tr> <TD>Designation article</TD>
<TD>Quantité Fournisseur</TD>
<TD>Quantité Livrée</TD>
<TD>Quantité Receptionnée</TD>
<TD>Statut</TD>
<TD>Garantie(mois)</TD>
<TD>Couleur</TD>
<TD>Taille</TD>
<TD>Date péremption</TD>
<TD>Valider la ligne</TD>
 </tr>
<%
for(LigneLivraison l : liste){%>
<form method="get" action="/SuperMercado-war/AgentLivraisonServlet"><tr><td Width=15%><%=l.getArticle().getLibelleArticle() %></td>
<td Width=15%><%=l.getQuantiteFournisseur()%></td>
<td Width=15%><input type="number" name="quantiteLivrer" value="" size="20" maxlength="20" /></td>
<td Width=15%><input type="number" name="quantiteReceptionner" value="" size="20" maxlength="20" /></td>
<td Width=15%><%=l.getMentionStatut()%></td>
<td Width=15%><input type="number" name="garantie" value="" size="20" maxlength="20" /></td>
<td Width=15%><SELECT name="couleur" size="1">
        <OPTION>
        <OPTION>Bleu
        <OPTION>Rose
        <OPTION>Jaune
        <OPTION>Vert
        <OPTION>Blanc
        <OPTION>Noir
        </SELECT></td>
<td Width=15%><SELECT name="taille" size="1">
        <OPTION>
        <OPTION>XS
        <OPTION>S
        <OPTION>M
        <OPTION>L
        <OPTION>XL
        <OPTION>XXL
        </SELECT></td>
<td Width=15%><input type="date" name="datePeremption" value="" size="20" maxlength="20" /></td>
<% Mention e=Mention.validation ; if(l.getMentionStatut().equals(e)){%> <td Width=30%>
    <input type="hidden" name="ligneId" value=<%=l.getId()%>>
    <input type="hidden" name="agentLivraisonId" value=<%= agentLivraisonConnecte.getId() %>>
    <input type="hidden" name="livraisonId" value=<%=livraison.getId() %>>
    <input type="hidden" name="action" value="ValiderLigneLivraison">
    <input type="submit" value="Valider" /></td><%}else{%><td Width=30%>Déjà valider</td>
    </tr></form><%}}%></TABLE>
    
<form method="get" action="/SuperMercado-war/AgentLivraisonServlet">
<label for="date"> Date de livraison effective <span class="requis">*</span></label>
        <input type="date" name="date" value="" size="20" maxlength="20" />
        <br />
<label for="statut">Statut de la livraison <span class="requis">*</span></label>
        <SELECT name="statut" size="1">
        <OPTION value="receptionner">Réceptionner
        <OPTION value="probleme">Problème livraison
        </SELECT>
        <br />
        <input type="hidden" name="agentLivraisonId" value=<%= agentLivraisonConnecte.getId() %>>
        <input type="hidden" name="livraisonId" value=<%=livraison.getId() %>>
        <input type="hidden" name="action" value="ValiderLivraison">
    <input type="submit" value="Valider"/></td>
</form>
<hr>
</body>
</html>
