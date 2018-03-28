<%-- 
    Document   : index
    Created on : 23 mars 2018, 15:40:10
    Author     : tangu_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ include file="/include/css.jsp" %>
    </head>
    <body>
         <body>	
<div id="top-bar" class="container">
			<div class="row">
				<div class="span4">
					<form method="POST" class="search_form">
						<input type="text" class="input-block-level search-query" Placeholder="eg. T-sirt">
					</form>
				</div>
				<div class="span8">
					<div class="account pull-right">
						<ul class="user-menu">				
							<li><a href="#">My Account</a></li>
							<li><a href="cart.html">Your Cart</a></li>
							<li><a href="checkout.html">Checkout</a></li>					
							<li><a href="register.html">Login</a></li>		
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="wrapper" class="container">
        <%@ include file="/include/header.jsp" %>
        <%@ include file="/include/sidebar.jsp" %>
			<section class="main-content">
				<div class="row">
					<div class="span12">													
						<div class="row">
							<div class="span12">
								<h4 class="title">
									<span class="pull-left"><span class="text"><span class="line">Meilleures<strong>Ventes</strong></span></span></span>
									<span class="pull-right">
										<a class="left button" href="#myCarousel" data-slide="prev"></a><a class="right button" href="#myCarousel" data-slide="next"></a>
									</span>
								</h4>
								<div id="myCarousel" class="myCarousel carousel slide">
									<div class="carousel-inner">
										<div class="active item">
											<ul class="thumbnails">												
												<li class="span3">
													<div class="product-box">
														<span class="sale_tag"></span>
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/Electromenager/Seb.jpe" alt="" /></a></p>
														<a href="product_detail.html" class="title">Seb</a><br/>
														<a href="products.html" class="category">friteuse</a>
														<p class="price">17.25€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<span class="sale_tag"></span>
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/Boucherie/saucisse.jpe" alt="" /></a></p>
														<a href="product_detail.html" class="title">Knacchi</a><br/>
														<a href="products.html" class="category">Saucisse</a>
														<p class="price">$1.5€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/Poisson/poisson.jpg" alt="" /></a></p>
														<a href="product_detail.html" class="title">Atlantique</a><br/>
														<a href="products.html" class="category">Saumon Frais</a>
														<p class="price">14.20€/kg</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/Poisson/poisson2.jpg" alt="" /></a></p>
														<a href="product_detail.html" class="title">Poisson</a><br/>
														<a href="products.html" class="category">Langoustine</a>
														<p class="price">31.45€/kg</p>
													</div>
												</li>
											</ul>
										</div>
										<div class="item">
											<ul class="thumbnails">
												<li class="span3">
													<div class="product-box">
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/FruitLegume/avocat.jpg" alt="" /></a></p>
														<a href="product_detail.html" class="title">Avocat</a><br/>
														<a href="products.html" class="category">vert</a>
														<p class="price">2€</p>
													</div>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/FruitLegume/banane.jpe" alt="" /></a></p>
														<a href="product_detail.html" class="title">Kavendish</a><br/>
														<a href="products.html" class="category">banane</a>
														<p class="price">1€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/ladies/7.jpg" alt="" /></a></p>
														<a href="product_detail.html" class="title">Supermercadia</a><br/>
														<a href="products.html" class="category">Robe</a>
														<p class="price">22.30€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/FruitLegume/kiwi.jpg" alt="" /></a></p>
														<a href="product_detail.html" class="title">Kiwi</a><br/>
														<a href="products.html" class="category">Vert</a>
														<p class="price">2€/pièce</p>
													</div>
												</li>																																	
											</ul>
										</div>
									</div>							
								</div>
							</div>						
						</div>
						<br/>
						<div class="row">
							<div class="span12">
								<h4 class="title">
									<span class="pull-left"><span class="text"><span class="line">Produits à ne pas<strong>Manquer</strong></span></span></span>
									<span class="pull-right">
										<a class="left button" href="#myCarousel-2" data-slide="prev"></a><a class="right button" href="#myCarousel-2" data-slide="next"></a>
									</span>
								</h4>
								<div id="myCarousel-2" class="myCarousel carousel slide">
									<div class="carousel-inner">
										<div class="active item">
											<ul class="thumbnails">												
												<li class="span3">
													<div class="product-box">
														<span class="sale_tag"></span>
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/electromenager/dyson4.jpg" alt="" /></a></p>
														<a href="product_detail.html" class="title">Electrolux</a><br/>
														<a href="products.html" class="category">Sèche linge</a>
														<p class="price">25.50€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/electromenager/dyson.jpe" alt="" /></a></p>
														<a href="product_detail.html" class="title">Dyson</a><br/>
														<a href="products.html" class="category">dyson</a>
														<p class="price">77.55€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/electromenager/dyson2.jpe" alt="" /></a></p>
														<a href="product_detail.html" class="title">Aspirateur</a><br/>
														<a href="products.html" class="category">dyson</a>
														<p class="price">25.30€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/electromenager/dyson3.jpe" alt="" /></a></p>
														<a href="product_detail.html" class="title">Ventilateur/a><br/>
														<a href="products.html" class="category">dyson</a>
														<p class="price">$25.60</p>
													</div>
												</li>
											</ul>
										</div>
										<div class="item">
											<ul class="thumbnails">
												<li class="span3">
													<div class="product-box">
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/epicerie/amande.jpe" alt="" /></a></p>
														<a href="product_detail.html" class="title">Amande</a><br/>
														<a href="products.html" class="category">amande</a>
														<p class="price">5.50€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/cloth/Laitier/lait.jpe" alt="" /></a></p>
														<a href="product_detail.html" class="title">Lait</a><br/>
														<a href="products.html" class="category">Entier</a>
														<p class="price">0.50€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/Laitier/lait2.jpe" alt="" /></a></p>
														<a href="product_detail.html" class="title">Lait</a><br/>
														<a href="products.html" class="category">Demi ecremé/a>
														<p class="price">1.30€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/cloth/bootstrap-women-ware1.jpg" alt="" /></a></p>
														<a href="product_detail.html" class="title">Supermercadia</a><br/>
														<a href="products.html" class="category">Robe</a>
														<p class="price">$25.20</p>
													</div>
												</li>																																	
											</ul>
										</div>
									</div>							
								</div>
							</div>						
						</div>
						<div class="row feature_box">						
							<div class="span4">
								<div class="service">
									<div class="responsive">	
										<img src="<%= request.getContextPath() %>/template/images/feature_img_2.png" alt="" />
										<h4>MODERN <strong>DESIGN</strong></h4>
										<p>Lorem Ipsum is simply dummy text of the printing and printing industry unknown printer.</p>									
									</div>
								</div>
							</div>
							<div class="span4">	
								<div class="service">
									<div class="customize">			
										<img src="<%= request.getContextPath() %>/template/images/feature_img_1.png" alt="" />
										<h4>FREE <strong>SHIPPING</strong></h4>
										<p>Lorem Ipsum is simply dummy text of the printing and printing industry unknown printer.</p>
									</div>
								</div>
							</div>
							<div class="span4">
								<div class="service">
									<div class="support">	
										<img src="<%= request.getContextPath() %>/template/images/feature_img_3.png" alt="" />
										<h4>24/7 LIVE <strong>SUPPORT</strong></h4>
										<p>Lorem Ipsum is simply dummy text of the printing and printing industry unknown printer.</p>
									</div>
								</div>
							</div>	
						</div>		
					</div>				
				</div>
			</section>
         <%@ include file="/include/footer.jsp" %>
     
        </div>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>

