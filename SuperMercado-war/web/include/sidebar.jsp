<%-- 
    Document   : sidebar
    Created on : 23 mars 2018, 16:42:41
    Author     : tangu_000
--%>

<div id="top-bar" class="container">
			<div class="row">
				
				<div class="span8">
					<div class="account pull-left">
						<ul class="user-menu">				
							<li><a href="Connexion.jsp">Mon compte</a></li>
							<li><a href="Connexion.jsp">Panier</a></li>					
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
							<li><a href="Connexion.jsp">Alimentaire</a>					
								<ul>
									<li><a href="Connexion.jsp">Fruit&Legume</a></li>
									<li><a href="Connexion.jsp">Laitier</a></li>	
                                                                        <li><a href="Connexion.jsp">Epicerie</a></li>	
                                                                        <li><a href="Connexion.jsp">Boucherie</a></li>
                                                                        <li><a href="Connexion.jsp">Boulangerie</a></li>
                                                                        <li><a href="Connexion.jsp">Poissonerie</a></li>	
								</ul>
							</li>															
							<li><a href="Connexion.jsp">Textile</a></li>			
							<li><a href="Connexion.jsp">Electromenager</a>
								<ul>									
									<li><a href="Connexion.jsp">Gros Electromenager</a></li>
									<li><a href="Connexion.jsp">Petit Electromenager</a></li>
								</ul>
							</li>							
							<li><a href="Connexion.jsp">Loisir</a></li>
							<li><a href="Connexion.jsp">Entretien</a></li>
							<li><a href="Connexion.jsp">Maison</a></li>
						</ul>
					</nav>
				</div>
			</section>
