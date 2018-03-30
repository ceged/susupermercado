<%-- 
    Document   : sidebar_agentcaisse
    Created on : 27 mars 2018, 14:31:49
    Author     : tangu_000
--%>
<%@page import="entités.gestionMagasin.AgentCaisse"%>
<jsp:useBean id="agentCaisse" scope="session" class="AgentCaisse"></jsp:useBean>
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
					<a href="Accueil.jsp" class="pull-left"><img src="<%= request.getContextPath() %>/template/images/logo5.png" class="site_logo" alt=""></a>
					<nav id="menu" class="pull-right">
						<ul>
							<li><a href="EmployeCaisseServlet?action=insererAchat">Achat</a>					
								<ul>
									<li><a href="EmployeCaisseServlet?action=insererAchat">Créer un achat</a></li>
									
                                                                </ul>
                                                        <li><a href="Menu?action=CasterEnPersonne&idPersonneSession=<%=agentCaisse.getId()%>">Modifier mot de passe</a></li>
                                                        <li><a href="MenuAgentCaisse.jsp">Retour menu principal</a></li>
                                                        <li><a href="Menu?action=sedeconnecter">Se déconnecter</a></li>
                                                </ul>
					</nav>
				</div>
			</section>