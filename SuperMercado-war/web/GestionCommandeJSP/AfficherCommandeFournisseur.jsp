 <%@page import="entités.gestionCommande.Fournisseur"%>
<%-- 
    Document   : AfficherCommandeEnCours
    Created on : 16 mars 2018, 15:57:17
    Author     : Soldat
--%>
<%@page import="entités.gestionLivraison.Mention"%>
<% 
        
    if (session.getAttribute("fournisseurConnecte") == null) {
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
        <jsp:useBean id="livraison" scope="session" class="Livraison"></jsp:useBean>
        <jsp:useBean id="liste" scope="session" class="List<LigneLivraison>"></jsp:useBean>
        <jsp:useBean id="fournisseurConnecte" scope="session" class="Fournisseur"></jsp:useBean>
<title>Commande</title>
  <%@ include file="/include/css.jsp" %>
    </head>
     <%@ include file="/include/header.jsp" %>
     <% Fournisseur f= fournisseurConnecte;%>
    <div id="top-bar" class="container">
			<div class="row">
				
				<div class="span8">
					<div class="account pull-left">
						<ul class="user-menu">					
							<li><a href="Connexion.jsp">Portail de connexion</a></li>		
						</ul>
					</div>
				</div>
			</div>
		</div>
                <div id="wrapper" class="container">
			<section class="navbar main-menu">
				<div class="navbar-inner main-menu">				
					<a href="index.html" class="pull-left"><img src="<%= request.getContextPath() %>/template/images/logo5.png" class="site_logo" alt=""></a>
					<nav id="menu" class="pull-right">
						<ul>
							<li><a href="FournisseurServlet?action=passageInfosListeCommande&fournisseur=<%=f.getId()%>">Consulter mes commandes</a></li>						
								
										
						
                                                         <li><a href="Menu?action=CasterEnPersonne&idPersonneSession=<%=f.getId()%>">Modifier mon mot de passe</a></li>
                                                        <li><a href="MenuFournisseur.jsp">Retour menu principal</a></li>
                                                        <li><a href="Menu?action=sedeconnecter">Se déconnecter</a></li>
                                                       </ul>
					</nav>
				</div>
			</section>


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
for(LigneLivraison l : liste){
    if(l.getMentionStatut()!= Mention.nonlivrer){
    t=t+l.getLigneCommande().getPrixAchatUnitaire()*l.getLigneCommande().getQuantiteLigne();
}%>
<tr><td Width=15%><%=l.getLigneCommande().getArticle().getLibelleArticle() %></td>
<td Width=15%><%=l.getQuantiteFournisseur()%></td>
<td Width=15%><%=l.getMentionStatut()%></td>
<td Width=30%><A href="FournisseurServlet?action=ValiderLigneLivraison&ligneId=<%=l.getId() %>&livraisonId=<%=livraison.getId() %>"> Cliquez ici</A></td>
<td Width=30%><A href="FournisseurServlet?action=ExclureLigneLivraison&ligneId=<%=l.getId() %>&livraisonId=<%=livraison.getId()%>"> Cliquez ici</A></td>
</tr><%}%></TABLE>
<br />
<table border width="50%">
    <tr>
        <td>Montant total : </td>
        <td><%=t%></td>
    </tr>
    
</table>
<center>
    <form method="get" action="/SuperMercado-war/FournisseurServlet">
        <label for="date"> Date de livraison prévue <span class="requis">*</span></label>
        <input type="date" name="date" value="" size="20" maxlength="20" required/>
        <input type="hidden" name="action" value="ValiderLivraison">
        <input type="hidden" name="statut" value="attentereception">
        <input type="hidden" name="livraisonId" value=<%=livraison.getId() %>>
        <input type="hidden" name="fournisseurId" value=<%=livraison.getCommande().getFournisseur().getId()%>>
        <input type="submit" value="Valider la commande pour livraison"/>
        <br />
 </form>
<hr>
  </center> 
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
