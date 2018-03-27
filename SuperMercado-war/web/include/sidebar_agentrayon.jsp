<%-- 
    Document   : sidebar_agentrayon
    Created on : 27 mars 2018, 14:32:26
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
							<li><a href="ChefRayonServlet?action=passageListeSousCategorie">Article</a>					
								<ul>
									<li><a href="ChefRayonServlet?action=passageListeSousCategorie">Créer un article</a></li>
									<li><a href="Admin?action=TransfererListeMagasin">Modifier prix article</a></li>	
                                                                        <li><a href="GestionMagasinJSP/CreerDirecteur.jsp">Supprimer article</a></li>	
								</ul>
							</li>															
									
							<li><a href="GestionCommandeJSP/CreerFournisseur.jsp">Créer un fournisseur</a></li>
                                                            <li><a href="GestionCommandeJSP/CreerFournisseur.jsp">Commande</a>
								<ul>									
									<li><a href="GestionArticleJSP/CreerCategorie.jsp"> Créer bon de commande</a></li>
									<li><a href="Admin?action=TransfererListeCategorie">Afficher les bon de commandes </a></li>
								</ul>
							</li>							
							<li><a href="Admin?action=TransfererListeRefArticle">Créer une Promotion </a></li>
							<li><a href="Accueil.jsp">Sortir menu principal</a></li>
					</nav>
				</div>
			</section>

