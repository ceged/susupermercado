<%-- 
    Document   : AfficherCommandeEnCours
    Created on : 16 mars 2018, 15:57:17
    Author     : Soldat
--%>
<% 
        
    if (session.getAttribute("agentLivraisonConnecte") == null) {
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
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="agentLivraisonConnecte" scope="session" class="AgentLivraison"></jsp:useBean>
        <jsp:useBean id="livraison" scope="session" class="Livraison"></jsp:useBean>
        <jsp:useBean id="liste" scope="session" class="List<LigneLivraison>"></jsp:useBean>
<title>Commande</title>
  <%@ include file="/include/css.jsp" %>
    </head>
     <%@ include file="/include/header.jsp" %>
     <%@ include file="/include/sidebar_agentlivraison.jsp" %>
     
<body>
<center>
<h1>Liste des articles</h1>
<p> <%
String attribut = (String) request.getAttribute("message");
if(attribut!=null){
    out.println( attribut );
}

%> </p>
<A HREF="MenuAgentLivraison.jsp">Retour au menu</A><br />
<center>
<TABLE border>
<tr> <TD Width=5%>Designation article</TD>
<TD Width=5%>Quantité Fournisseur</TD>
<TD Width=5%>Quantité Livrée</TD>
<TD Width=5%>Quantité Receptionnée</TD>
<TD Width=5%>Statut</TD>
<TD Width=5%>Garantie(mois)</TD>
<TD Width=5%>Couleur</TD>
<TD Width=5%> Taille</TD>
<TD Width=5%>Date péremption</TD>
<TD Width=5%>Valider la ligne</TD>
 </tr>
<%
for(LigneLivraison l : liste){if(l.getMentionStatut()!=Mention.nonlivrer) {
%>
<form method="get" action="/SuperMercado-war/AgentLivraisonServlet"><tr><td ><%=l.getLigneCommande().getArticle().getLibelleArticle() %></td>
<td ><%=l.getQuantiteFournisseur()%></td>
<td ><input type="number" name="quantiteLivrer" value="" style="width: 40px;" required=""/></td>
<td ><input type="number" name="quantiteReceptionner" value="" style="width: 40px;" required=""/></td>
<td ><%=l.getMentionStatut()%></td>
<td ><input type="number" name="garantie" value="" style="width: 40px;" /></td>
<td ><SELECT name="couleur" style="width: 80px;">
        <OPTION>
        <OPTION>Bleu
        <OPTION>Rose
        <OPTION>Jaune
        <OPTION>Vert
        <OPTION>Blanc
        <OPTION>Noir
        </SELECT></td>
<td ><SELECT name="taille" style="width: 80px;">
        <OPTION>
        <OPTION>XS
        <OPTION>S
        <OPTION>M
        <OPTION>L
        <OPTION>XL
        <OPTION>XXL
        </SELECT></td>
<td ><input type="date" name="datePeremption" value="" style="width: 80px;"/></td>
<% Mention e=Mention.validation ; if(l.getMentionStatut().equals(e)){%> <td>
    <input type="hidden" name="ligneId" value=<%=l.getId()%>>
    <input type="hidden" name="agentLivraisonId" value=<%= agentLivraisonConnecte.getId() %>>
    <input type="hidden" name="livraisonId" value=<%=livraison.getId() %>>
    <input type="hidden" name="action" value="ValiderLigneLivraison">
    <input type="submit" value="Valider" /></td><%}else{%><td>Déjà valider</td>
    </tr></form><%}}}%></TABLE> </center>  

    <form method="get" action="/SuperMercado-war/AgentLivraisonServlet">
<label for="date"> Date de livraison effective <span class="requis">*</span></label>
<input type="date" name="date" value="" size="20" maxlength="20"/>
        <br />
<label for="statut">Statut de la livraison <span class="requis">*</span></label>
<SELECT name="statut" size="1" >
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
  </center> 
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>