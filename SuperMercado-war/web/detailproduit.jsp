<%-- 
    Document   : detailproduit
    Created on : 25 mars 2018, 17:16:13
    Author     : So'
--%>
<%@page import="entités.gestionArticle.ReferentielArticle"%>
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
        <%@ include file="/include/header.jsp" %>
        <%@ include file="/include/sidebar.jsp" %>
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
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/electromenager/Seb.jpe" alt="" /></a></p>
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
														<p class="price">1.5€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/Poisson/poisson.jpg" alt="" /></a></p>
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
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/Boulangerie/gateaux.jpe" alt="" /></a></p>
														<a href="product_detail.html" class="title">Gateaux</a><br/>
														<a href="products.html" class="category">Exotique</a>
														<p class="price">15€</p>
													</div>
												</li>
												<li class="span3">
													<div class="product-box">
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/ladies/2.jpg" alt="" /></a></p>
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
                                                                                                <li class="span3">
													<div class="product-box">
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/Boulangerie/pain2.jpe" alt="" /></a></p>
														<a href="product_detail.html" class="title">Pain</a><br/>
														<a href="products.html" class="category">Mie</a>
														<p class="price">1€</p>
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
												</li>
                                                                                                <li class="span3">
													<div class="product-box">
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/Boulangerie/gateaux5.jpg" alt="" /></a></p>
														<a href="product_detail.html" class="title">Gateaux</a><br/>
														<a href="products.html" class="category">Fraise</a>
														<p class="price">20€</p>
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
														<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/Boulangerie/pain3.jpe" alt="" /></a></p>
														<a href="product_detail.html" class="title">Pain</a><br/>
														<a href="products.html" class="category">tradition</a>
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
                                               <section class="main-content">
				<div class="row">
					<div class="span12">													
						<div class="row">
							<div class="span12"> 
                    
                        <% for(ReferentielArticle a: ){ 
                        <input type="radio" name="article" value=<%=.getCodeBarre()%> size="20"/>
                         <label><%=.getLibelleArticle()%></label> <br />
                         <%}%>  
                    
               </ul>