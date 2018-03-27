<%-- 
    Document   : sidebar_menuclient
    Created on : 27 mars 2018, 15:44:37
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
																						
							<li><a href="ClientServlet?action=transferListeMagasin">Vente en ligne</a></li>			
							
							<li><a href="MenuClient.jsp">Sortir menu principal</a></li>
                                        </ul>
                                            </nav>
				</div>
			</section>
