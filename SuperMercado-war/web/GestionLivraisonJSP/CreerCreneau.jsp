<%-- 
    Document   : CreerCreneau
    Created on : 21 mars 2018, 15:01:15
    Author     : Soldat
--%>
<% 
        
    if (session.getAttribute("agentLivraisonConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>


<%@page import="entités.gestionLivraison.AgentLivraison"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="agentLivraisonConnecte" scope="session" class="AgentLivraison"></jsp:useBean>
        <title> Créer un créneau </title>
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
									<li><a href="GestionLivraisonJSP/CreerCreneau.jsp">Créer créneau</a></li>	
                                                                       
								</ul>
							</li>															
							<li><a href="AgentLivraisonServlet?action=passageInfosListeReceptionLivraison&agentLivraison=<%=agentLivraisonConnecte.getId()%>">Consulter la liste de livraison</a></li>			
							
							<li><a href="MenuAgentLivraison.jsp">Sortir menu principal</a></li>
					</nav>
				</div>
			</section>

     
    <body>
    <center>
        <form method="get" action="/SuperMercado-war/AgentLivraisonServlet">
        <fieldset>
        <legend>Informations du créneau (2h)</legend>
        <label for="date"> Date du créneau <span class="requis">*</span></label>
        <input type="date" name="date" value="" size="20" maxlength="20" />
        <br />
        <label for="heureDebut"> Heure début <span class="requis">*</span></label>
        <input type="time" name="heureDebut" value="" size="20" maxlength="20" />
        <br />
        <label for="heureFin"> Heure fin <span class="requis">*</span></label>
        <input type="time" name="heureFin" value="" size="20" maxlength="20" />
        <br />
        <input type="hidden" name="agentId" value="<%=agentLivraisonConnecte.getId()%>">
        <input type="hidden" name="action" value="insererCreneau">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
      </center> 
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
