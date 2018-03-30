<%-- 
    Document   : AfficherCommandeEnCours
    Created on : 16 mars 2018, 15:57:17
    Author     : Soldat
--%>
<% 
        
    if (session.getAttribute("agentRayonConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>

<%@page import="entités.gestionArticle.Casse"%>
<%@page import="entités.gestionMagasin.AgentRayon"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="liste" scope="session" class="List<Casse>"></jsp:useBean>
        <jsp:useBean id="agentRayonConnecte" scope="session" class="AgentRayon"></jsp:useBean>
<title>Liste des bons de commandes</title>
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
<h1>Liste des casses du rayon <%=agentRayonConnecte.getRayon().getLibelleRayon() %> </h1>

<TABLE border width=50%>
<tr> <TD>Nom article</TD>
<TD>Date</TD>
<TD>Quantite casse</TD>
<TD>Motif</TD>
 </tr>
<%
for(Casse c : liste){%>
<tr><td Width=15%><%=c.getLotArticleCasse().getArticle().getLibelleArticle() %></td>
<td Width=15%><%=c.getDateCasse() %></td>
<td Width=15%><%=c.getQuantiteCasse() %></td>
<td Width=30%><%=c.getMotifCasse() %></td>

</tr><%}%></TABLE>
<hr>
</center>
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>