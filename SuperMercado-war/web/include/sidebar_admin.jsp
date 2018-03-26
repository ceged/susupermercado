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
							<li><a href="Accueil.jsp">Mon compte</a></li>					
							<li><a href="Accueil.jsp">Portail de connexion</a></li>		
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
							<li><a href="GestionMagasinJSP/CreerMagasin.jsp">Magasin</a>					
								<ul>
									<li><a href="GestionMagasinJSP/CreerMagasin.jsp">Creer un magasin</a></li>
									<li><a href="Admin?action=TransfererListeMagasin">Supprimer un magasin</a></li>	
                                                                       
								</ul>
							</li>															
							<li><a href="GestionMagasinJSP/CreerDirecteur.jsp">Créer un directeur</a></li>			
							<li><a href="GestionArticleJSP/CreerCategorie.jsp">Catégorie</a>
								<ul>									
									<li><a href="GestionArticleJSP/CreerCategorie.jsp">Créer une Catégorie</a></li>
									<li><a href="Admin?action=TransfererListeCategorie">Créer une sous-catégorie </a></li>
								</ul>
							</li>							
							<li><a href="Admin?action=TransfererListeRefArticle">Créer une Promotion </a></li>
							<li><a href="Accueil.jsp">Sortir menu principal</a></li>
					</nav>
				</div>
			</section>
