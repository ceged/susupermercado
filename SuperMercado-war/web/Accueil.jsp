<%-- 
    Document   : sidebar
    Created on : 23 mars 2018, 16:42:41
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
        <%@ include file="/include/header.jsp" %>
        <%@ include file="/include/sidebar.jsp" %>
        <%@ include file="/include/flexslider.jsp" %>
		<section class="main-content">
				<div class="row">
					<div class="span12">													
						<div class="row">
							<div class="span12">
								<h4 class="title">
									<span class="pull-left"><span class="text"><span class="line">  Meilleures<strong>Ventes</strong></span></span></span>
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
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/electromenager/Seb.jpe" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Seb</a><br/>
														<a href="Connexion.jsp" class="category">friteuse</a>
														<p class="price">37.25€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<span class="sale_tag"></span>
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/Boucherie/saucisse.jpe" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Knacchi</a><br/>
														<a href="Connexion.jsp" class="category">Saucisse</a>
														<p class="price">1.5€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/Poisson/poisson.jpg" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Atlantique</a><br/>
														<a href="Connexion.jsp" class="category">Saumon Frais</a>
														<p class="price">14.20€/kg</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/Poisson/poisson2.jpg" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Poisson</a><br/>
														<a href="Connexion.jsp" class="category">Langoustine</a>
														<p class="price">31.45€/kg</p>
													</div>
												</li>
                                                                                                
											</ul>
										</div>
                                                                                <div class="item">
											<ul class="thumbnails">
												<li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/Boulangerie/gateaux.jpe" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Gateaux</a><br/>
														<a href="Connexion.jsp" class="category">Exotique</a>
														<p class="price">35€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/ladies/2.jpg" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Supermercadia</a><br/>
														<a href="Connexion.jsp" class="category">Robe</a>
														<p class="price">22.30€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/FruitLegume/kiwi.jpg" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Kiwi</a><br/>
														<a href="Connexion.jsp" class="category">Vert</a>
														<p class="price">2€/pièce</p>
													</div>
												</li>
                                                                                                <li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/Boulangerie/pain2.jpe" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Pain</a><br/>
														<a href="Connexion.jsp" class="category">Mie</a>
														<p class="price">1€</p>
													</div>
                                                                                                </li>
                                                                                            </ul>
										</div>
										<div class="item">
											<ul class="thumbnails">
												<li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/FruitLegume/avocat.jpg" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Avocat</a><br/>
														<a href="Connexion.jsp" class="category">vert</a>
														<p class="price">2€</p>
													</div>
												</li>
                                                                                                <li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/Boulangerie/gateaux5.jpg" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Gateaux</a><br/>
														<a href="Connexion.jsp" class="category">Fraise</a>
														<p class="price">25€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/FruitLegume/banane.jpe" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Kavendish</a><br/>
														<a href="Connexion.jsp" class="category">banane</a>
														<p class="price">1€</p>
													</div>
												</li>
                                                                                                <li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/Boulangerie/pain3.jpe" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Pain</a><br/>
														<a href="Connexion.jsp" class="category">tradition</a>
														<p class="price">1€</p>
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
									<span class="pull-left"><span class="text"><span class="line">    A ne pas<strong>Manquer</strong></span></span></span>
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
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/electromenager/dyson4.jpg" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Dyson</a><br/>
														<a href="Connexion.jsp" class="category">Sèche cheveux</a>
														<p class="price">45.50€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/electromenager/dyson.jpe" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Dyson</a><br/>
														<a href="Connexion.jsp" class="category">dyson</a>
														<p class="price">77.55€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/electromenager/dyson2.jpe" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Aspirateur</a><br/>
														<a href="Connexion.jsp" class="category">dyson</a>
														<p class="price">125.30€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/electromenager/dyson3.jpe" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Ventilateur</a><br/>
														<a href="Connexion.jsp" class="category">dyson</a>
														<p class="price">55.30€</p>
													</div>
												</li>
											</ul>
										</div>
										<div class="item">
											<ul class="thumbnails">
												<li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/epicerie/amande.jpe" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Amande</a><br/>
														<a href="Connexion.jsp" class="category">amande</a>
														<p class="price">5.50€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/Laitier/lait.jpe" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Lait</a><br/>
														<a href="Connexion.jsp" class="category">Entier</a>
														<p class="price">0.50€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/Laitier/lait2.jpe" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Lait</a><br/>
														<a href="Connexion.jsp" class="category">Demi ecremé/a>
														<p class="price">1.30€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/ladies/8.jpg" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Supermercadia</a><br/>
														<a href="Connexion.jsp" class="category">Robe</a>
														<p class="price">25.20€</p>
													</div>
												</li>	
                                                                                            </ul>
										</div>
                                                                                 <div class="item">
											<ul class="thumbnails">
												<li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/Boulangerie/pain4.jpg" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">PAIN</a><br/>
														<a href="Connexion.jsp" class="category">Levain</a>
														<p class="price">1€</p>
													</div>
												</li>
                                                                                                 <li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/Boulangerie/pain5.jpg" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">PAIN</a><br/>
														<a href="Connexion.jsp" class="category">Levain</a>
														<p class="price">1€</p>
													</div>
												</li>
                                                                                                 <li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/Boulangerie/pain6.jpe" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">PAIN</a><br/>
														<a href="Connexion.jsp" class="category">Baguette</a>
														<p class="price">1€</p>
													</div>
												</li>
                                                                                                 <li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/Boulangerie/gateaux3.jpe" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">GATEAUX</a><br/>
														<a href="Connexion.jsp" class="category">Macaronade</a>
														<p class="price">10€</p>
													</div>
												</li>
                                                                                            </ul>
										</div>
                                                                                <div class="item">
											<ul class="thumbnails">
                                                                                                <li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/Boulangerie/gateaux4.jpe" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">GATEAUX</a><br/>
														<a href="Connexion.jsp" class="category">Chou</a>
														<p class="price">10€</p>
													</div>
												</li>
                                                                                                <li class="span3">
													<div class="product-box">
														<p><a href="Connexion.jsp"><img src="<%= request.getContextPath() %>/template/images/Boulangerie/gateaux2.jpg" alt="" /></a></p>
														<a href="Connexion.jsp" class="title">Gateaux</a><br/>
														<a href="Connexion.jsp" class="category">fruits rouges</a>
														<p class="price">12€</p>
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
										<h4>SERVICE <strong>CLIENT</strong></h4>
										<p>SAV 24/7</p>									
									</div>
								</div>
							</div>
							<div class="span4">	
								<div class="service">
									<div class="customize">			
										<img src="<%= request.getContextPath() %>/template/images/feature_img_1.png" alt="" />
										<h4>LIVRAISON <strong>GRATUITE</strong></h4>
										<p>Dès 1€ d'achat.</p>
									</div>
								</div>
							</div>
							<div class="span4">
								<div class="service">
									<div class="support">	
										<img src="<%= request.getContextPath() %>/template/images/feature_img_3.png" alt="" />
										<h4>QUALITE <strong>SUPERIEUR</strong></h4>
										<p>Produit Made in France.</p>
									</div>
								</div>
							</div>	
						</div>		
					</div>				
				</div>
			</section>
                    

        <p> <%
        String attribut = (String) request.getAttribute("message");
        if(attribut==null){
            attribut="Aucune action effectuée";
        }
        else{
        out.println( attribut );}
        %> </p>
        <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>

