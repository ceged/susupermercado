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

<%@page import="entités.gestionLivraison.Mention"%>
<%@page import="entités.gestionLivraison.Livraison"%>
<%@page import="entités.gestionLivraison.LigneLivraison"%>
<%@page import="entités.gestionCommande.Commande"%>
<%@page import="entités.gestionCommande.LigneCommande"%>
<%@page import="java.util.List"%>
<jsp:useBean id="agentRayonConnecte" scope="session" class="AgentRayon"></jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="commande" scope="session" class="Commande"></jsp:useBean>
        <jsp:useBean id="liste" scope="session" class="List<LigneCommande>"></jsp:useBean>
<title>Commande</title>
  <%@ include file="/include/css.jsp" %>
    </head>
     <%@ include file="/include/header.jsp" %>
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
							<li><a href="GestionArticleJSP/CreerCasse.jsp">Casse</a>					
								<ul>
									<li><a href="GestionArticleJSP/CreerCasse.jsp">Saisir Casse</a></li>
									<li><a href="AgentRayonServlet?action=passageListeCasseRayon&idAgent=<%=agentRayonConnecte.getId()%>"> Consulter liste casse de mon rayon</a></li>	
                                                                        </ul>
							</li>															
									
							
                                                            <li><a href="GestionCommandeJSP/CreerFournisseur.jsp">Rayon</a>
								<ul>									
									<li><a href="AgentRayonServlet?action=passageListelivraison&idAgent=<%=agentRayonConnecte.getId()%>">"> Consulter liste livraison de mon rayon</a></li>
									<li><a href="AgentRayonServlet?action=passageListecommande&idAgent=<%=agentRayonConnecte.getId()%>">Consulter liste commandes de mon rayon</a></li>
								</ul>
							</li>					
							<li><a href="MenuAgentRayon.jsp">Sortir menu principal</a></li>
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
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
