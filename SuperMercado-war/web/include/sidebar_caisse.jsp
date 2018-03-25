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
							<li><a href="Accueil.jsp">Panier</a></li>					
							<li><a href="Accueil.jsp">Portail de connection</a></li>		
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
							<li><a href="EmployeCaisseServlet?action=insererAchat">Achat</a>					
								<ul>
									<li><a href="EmployeCaisseServlet?action=insererAchat">Créer un achat</a></li>
									
						</ul>
					</nav>
				</div>
			</section>
