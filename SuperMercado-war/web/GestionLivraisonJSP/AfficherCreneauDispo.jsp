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

<%@page import="entités.gestionLivraison.AgentLivraison"%>
<%@page import="entités.gestionVenteEnLigne.Creneau"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="liste" scope="session" class="List<Creneau>"></jsp:useBean>
        <jsp:useBean id="agentLivraisonConnecte" scope="session" class="AgentLivraison"></jsp:useBean>
<title>Liste des créneaux dispos</title>
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
							<li><a href="AgentLivraisonServlet?action=passageInfosCreneauDispo&agentLivraison=<%=agentLivraisonConnecte.getId()%>">Créneau</a>					
								<ul>
									<li><a href="AgentLivraisonServlet?action=passageInfosCreneauDispo&agentLivraison=<%=agentLivraisonConnecte.getId()%>">Consulter la liste des créneaux dispos</a></li>
									<li><a href="AgentLivraisonServlet?action=CreerCreneau">Créer créneau</a></li>		
                                                                       
								</ul>
							</li>															
							<li><a href="AgentLivraisonServlet?action=passageInfosListeReceptionLivraison&agentLivraison=<%=agentLivraisonConnecte.getId()%>">Consulter la liste de livraison</a></li>			
							
							<li><a href="MenuAgentLivraison.jsp">Sortir menu principal</a></li>
                                                        <li><a href="Menu?action=sedeconnecter">Se déconnecter</a></li>
                                                </ul>
					</nav>
				</div>
			</section>

     
<body>
<h1>Liste des créneaux</h1>
<p> <%
String attribut = (String) request.getAttribute("message");
if(attribut!=null){
    out.println( attribut );
            }
%> </p>
<A HREF="MenuAgentLivraison.jsp">Retour au menu</A><br />
<center>
    <form method="get" action="/SuperMercado-war/AgentLivraisonServlet">
    <label for="dateChoisi">Choisir une date <span class="requis">*</span></label>
    <input type="date" name="date" value="" size="20" maxlength="20" />
    <input type="hidden" name="idAgent" value="<%=agentLivraisonConnecte.getId()%>">
    <input type="hidden" name="action" value="passageDateChoisi">
    <input type="submit" value="Valider" />
</form>
<TABLE border width=50%>
<tr> <TD>Date</TD>
<TD>Heure début</TD>
<TD>Heure fin</TD>
<TD>Disponibilité</TD>
 </tr>
<%
for(Creneau c : liste){%>
<tr><td Width=15%><%=c.getDate() %></td>
<td Width=15%><%=c.getHeureDebut() %></td>
<td Width=15%><%=c.getHeureFin() %></td>
<td Width=15%><%=c.getDisponibilité() %></td>

</tr><%}%></TABLE>

<hr>
  </center> 
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
