<%-- 
    Document   : sidebar_agentlivraison
    Created on : 27 mars 2018, 14:32:03
    Author     : tangu_000
--%>

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
							<li><a href="AgentLivraisonServlet?action=passageInfosCreneauDispo&agentLivraison=<%=agentLivraisonConnecte.getId()%>">Cr�neau</a>					
								<ul>
									<li><a href="AgentLivraisonServlet?action=passageInfosCreneauDispo&agentLivraison=<%=agentLivraisonConnecte.getId()%>">Consulter la liste des cr�neaux dispos</a></li>
									<li><a href="GestionLivraisonJSP/CreerCreneau.jsp">Cr�er cr�neau</a></li>	
                                                                       
								</ul>
							</li>															
							<li><a href="AgentLivraisonServlet?action=passageInfosListeReceptionLivraison&agentLivraison=<%=agentLivraisonConnecte.getId()%>">Consulter la liste de livraison</a></li>			
							<li><a href="Menu?action=CasterEnPersonne&idPersonneSession=<%=agentLivraisonConnecte.getId()%>">Modifier mon mot de passe</a></li>
							<li><a href="MenuAgentLivraison.jsp">Retour menu principal</a></li>
                                                        <li><a href="Accueil.jsp">Se d�connecter</a></li>
                                                </ul>	
					</nav>
				</div>
			</section>

