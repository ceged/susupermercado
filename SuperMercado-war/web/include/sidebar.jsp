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
					<a href="index.html" class="pull-left"><img src="<%= request.getContextPath() %>/template/images/logo5.png" class="site_logo" alt=""></a>
					<nav id="menu" class="pull-right">
						<ul>
							<li><a href="./products.html">Alimentaire</a>					
								<ul>
									<li><a href="./products.html">Fruit&Legume</a></li>
									<li><a href="./products.html">Laitier</a></li>	
                                                                        <li><a href="./products.html">Epicerie</a></li>	
                                                                        <li><a href="./products.html">Boucherie</a></li>
                                                                        <li><a href="./products.html">Boulangerie</a></li>
                                                                        <li><a href="./products.html">Poissonerie</a></li>	
								</ul>
							</li>															
							<li><a href="./products.html">Textile</a></li>			
							<li><a href="./products.html">Electromenager</a>
								<ul>									
									<li><a href="./products.html">Gros Electromenager</a></li>
									<li><a href="./products.html">Petit Electromenager</a></li>
								</ul>
							</li>							
							<li><a href="./products.html">Loisir</a></li>
							<li><a href="./products.html">Entretien</a></li>
							<li><a href="./products.html">Maison</a></li>
						</ul>
					</nav>
				</div>
			</section>
