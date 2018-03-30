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
							<li><a>Casse</a>					
								<ul>
									<li><a href="AgentRayonServlet?action=SaisirCasse">Saisir Casse</a></li>
									<li><a href="AgentRayonServlet?action=passageListeCasseRayon&idAgent=<%=agentRayonConnecte.getId()%>"> Consulter liste casse de mon rayon</a></li>	
                                                                        </ul>
							</li>															
									
							
                                                        <li><a>Rayon</a>
								<ul>									
									<li><a href="AgentRayonServlet?action=passageListelivraison&idAgent=<%=agentRayonConnecte.getId()%>"> Consulter liste livraison de mon rayon</a></li>
									<li><a href="AgentRayonServlet?action=passageListecommande&idAgent=<%=agentRayonConnecte.getId()%>">Consulter liste commandes de mon rayon</a></li>
								</ul>
							</li>	
                                                        <li><a href="Menu?action=CasterEnPersonne&idPersonneSession=<%=agentRayonConnecte.getId()%>"> Modifier mon mot de passe</a></li>
							<li><a href="MenuAgentRayon.jsp">Retour menu principal</a></li>
                                                        <li><a href="Menu?action=sedeconnecter">Se déconnecter</a></li>
                                                </ul>
					</nav>
				</div>
			</section>

     
<body>
<center>
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
  </center>
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>