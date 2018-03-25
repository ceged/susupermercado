<%-- 
    Document   : footer
    Created on : 23 mars 2018, 16:42:14
    Author     : tangu_000
--%>

<section id="footer-bar">
				<div class="row">
					<div class="span3">
						<h4>Navigation</h4>
						<ul class="nav">
							<li><a href="./index.html">Homepage</a></li>  
							<li><a href="./about.html">About Us</a></li>
							<li><a href="./contact.html">Contac Us</a></li>
							<li><a href="./cart.html">Your Cart</a></li>
							<li><a href="Connexion.jsp">Login</a></li>							
						</ul>					
					</div>
					<div class="span4">
						<h4>My Account</h4>
						<ul class="nav">
							<li><a href="Connexion.jsp">My Account</a></li>
							<li><a href="#">Order History</a></li>
							<li><a href="#">Wish List</a></li>
							<li><a href="#">Newsletter</a></li>
						</ul>
					</div>
					<div class="span5">
						<p class="logo"><img src="<%= request.getContextPath() %>/template/images/logo5.png" class="site_logo" alt=""></p>
						<p> Susupermercado est un groupe Français de grande distribution. Depuis 1961, notre unique préocupation est de fournir des produits et services de qualité à notre clientèle. </p>
						<br/>
						<span class="social_icons">
							<a class="facebook" <img src="<%= request.getContextPath() %>/template/images/facebook.png">Facebook</a>
							<a class="twitter" <img src="<%= request.getContextPath() %>/template/images/twitter.jpg">Twitter</a>
							
						</span>
					</div>					
				</div>	
			</section>