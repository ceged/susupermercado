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
							<li><a >Magasin</a>					
								<ul>
									<li><a href="Admin?action=CreerMagasin">Creer un magasin</a></li>
                                                                       
								</ul>
							</li>															
							<li><a href="Admin?action=TransfererListeMagasinPourAjoutDirecteur">Cr�er un directeur</a></li>			
							<li><a >Cat�gorie</a>
								<ul>									
									<li><a href="Admin?action=CreerCategorie"">Cr�er une Cat�gorie</a></li>
									<li><a href="Admin?action=TransfererListeCategorie">Cr�er une sous-cat�gorie </a></li>
								</ul>
							</li>							
							<li><a href="Admin?action=TransfererListeRefArticle">Cr�er une Promotion </a></li>
                                                        <li><a href="Menu?action=CasterEnPersonne&idPersonneSession=<%=personneConnecte.getId()%>">Modifier mon mot de passe</a></li>
							<li><a href="MenuAdmin.jsp">Retour menu principal</a></li>
                                                        <li><a href="Accueil.jsp">Se d�connecter</a></li>
                                                </ul>
					</nav>
				</div>
			</section>
