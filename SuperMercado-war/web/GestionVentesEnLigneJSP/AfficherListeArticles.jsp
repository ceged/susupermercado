<%-- 
    Document   : AfficherListeArticles
    Created on : 20 mars 2018, 10:59:08
    Author     : Sophia
--%>
<% 
        
    if (session.getAttribute("client") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>

<%@page import="entités.gestionVenteEnLigne.AchatEnLigne"%>
<%@page import="entités.gestionMagasin.Magasin"%>
<%@page import="entités.gestionArticle.ReferentielArticle"%>
<%@page import="java.util.List"%>
<%@page import="entités.gestionVenteEnLigne.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
        
        <title>JSP Page</title>
        <jsp:useBean id="magasinChoisi" scope="session" class="Magasin"></jsp:useBean>
        <jsp:useBean id="client" scope="session" class="Client"></jsp:useBean>
        <jsp:useBean id="listeArticle" scope="session" class="List<ReferentielArticle>"></jsp:useBean>
        <jsp:useBean id="achatEnCours" scope="session" class="AchatEnLigne"></jsp:useBean>
        
    <%@ include file="/include/css.jsp" %>      
    </head>    
    <%@ include file="/include/header.jsp" %>
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
																						
							
                                                        <li><a href="MenuClient.jsp">Retour menu principal</a></li>
                                                        <li><a href="Menu?action=sedeconnecter">Se déconnecter</a></li>
                                        </ul>
                                            </nav>
				</div>
			</section>
    <body>
        <% Magasin m= magasinChoisi;
        Client c = client;
        AchatEnLigne ach = achatEnCours;%>
        
        <p>      <%
String attribut = (String) request.getAttribute("message");
if(attribut!=null){
    out.println( attribut );
            }
%> 
      </p>
          <section>
        <form method="get" action="/SuperMercado-war/ClientServlet">


               <h4 class="title">
                    <span class="pull-left"><span class="text"><span class="line">  Article disponible pour le magasin<strong>  <%=m.getNomMagasin()%></strong></span></span></span>
                    <span class="pull-center">
			<a class="left button" href="#myCarousel" data-slide="prev"></a><a class="right button" href="#myCarousel" data-slide="next"></a>
                    </span>
                </h4>
                        <div id="myCarousel" class="myCarousel carousel slide">
                            <div class="carousel-inner">
				<div class="active item">
                                    <ul class="thumbnails">												
                    <li class="span3">
			<div class="row">
                            <span class="sale_tag"></span>
                            
                            <div class="container">
                                <center>
                              <table>
                            <% int i=0; for(ReferentielArticle ar: listeArticle){ 
                                                               if(i==0){
                                       %><tr><%
                                   }
                                   i++;%>
                             <td>
				<p><a href="product_detail.html"><img src="<%= request.getContextPath() %>/template/images/logo4.png" alt="" /></a></p>
				<a href="product_detail.html" class="title"><%=ar.getMarque()%></a><br/>
                                <a href="products.html" class="category"><%=ar.getLibelleArticle()%></a>
                                <p class="price"><%=ar.getPrixVenteMagasin()%>€</p>
                                <input type="radio" name="article" value=<%=ar.getCodeBarre()%> size="20" required/>
                             </td>
                                <%if(i==4){
                                    i=0;
                                       %></tr><%
                                   }
                                    }%> 
                                </table>
                            </center>
                        </div>
                        </div>
                    </li>
                    </ul>
            </div>
	</div>							
    </div>
    </div>						
</div>
<br/>
</fieldset>
                                </center>
                                                                                         
       <center>
            <fieldset>
                    <input type="hidden" name="idClient" value=<%=c.getId()%>>
                    <input type="hidden" name="idAchat" value=<%=achatEnCours.getId()%>>
                    <input type="hidden" id="idqte" name="quantite" value="">
                <button onclick="getQuantite()" id="action" name="action" value=""> Ajouter au panier</button>
                <input type="reset" value="Remettre à zéro" /> <br />
               
            
                    
        </form> 
                     <form method="get" action="/SuperMercado-war/ClientServlet">
                     <input type="hidden" name="idClient" value=<%=c.getId()%>>
                    <input type="hidden" name="idAchat" value=<%=ach.getId()%>>
                    <input type="hidden" id="idqte" name="quantite" value="">
     <button name="action2" value="consulterVotrePanier"> consulter votre panier </button>
                    </form>
                    </section>
        </center>
                   
        <script>
            function getQuantite() {
            var qte = prompt("Quelle quantité souhaitez vous achetez?", "");
            if (qte !== null) {
            document.getElementById('idqte').value = qte;
            document.getElementById('action').value = "insererLignePanier";
            }
            else {
                document.getElementById('action').value = "annulerInsertionLigne";
            }
            }
        </script>
        
    </body>
</html>

