<%-- 
    Document   : CreerRayon
    Created on : 13 mars 2018, 17:37:52
    Author     : tangu_000
--%>
<% 
        
    if (session.getAttribute("directeurConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>
<%@page import="entités.gestionMagasin.Secteur"%>
<%@page import="java.util.List"%>
<%@page import="entités.gestionMagasin.DirecteurMagasin"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="test.css" type="text/css">
<jsp:useBean id="directeurConnecte" scope="session" class="DirecteurMagasin"></jsp:useBean>
<jsp:useBean id="listeSecteur" scope="session" class="List<Secteur>"></jsp:useBean>
        <title>JSP Page</title>
    <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>
     <% DirecteurMagasin p= directeurConnecte;%>
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
							<li><a>Rayon</a>					
								<ul>
									<li><a href="DirecteurServlet?action=transferListeSecteur&directeur=<%=p.getId()%>">Creer un rayon</a></li>
                                                                        <li><a href="DirecteurServlet?action=passageInfospourModifierRayon&directeur=<%=p.getId()%>">Modifier un rayon</a></li>
                                                                
                                                                        <li><a href="DirecteurServlet?action=transferListeRayon&directeur=<%=p.getId()%>">Creer un chef rayon</a></li>
                                                                        <li><a href="DirecteurServlet?action=transferListeRayon2&directeur=<%=p.getId()%>">Créer un agent de rayon </a></li>                                                                    
								</ul>
							</li>															
							<li><a href="DirecteurServlet?action=CreerSecteur">Créer un secteur</a></li>	
                                                        <li><a href="DirecteurServlet?action=CreerAgentLivraison">Créer un agent livraison</a></li>
							<li><a>Caisse</a>
								<ul>									
									<li><a href="DirecteurServlet?action=CreerCaisse">Créer une Caisse</a></li>
							
                                                                        <li><a href="DirecteurServlet?action=CreerAgentCaisse"> Créer un agent caisse </a></li>
                                                                        
                                                                        <li><a href="DirecteurServlet?action=transferListeCaisseEtAgentCaisse&directeur=<%=p.getId()%>"> Créer une affectation caisse </a></li>
								</ul>
							</li>							
							<li><a href="Menu?action=CasterEnPersonne&idPersonneSession=<%=p.getId()%>">Modifier mot de passe</a></li>
							<li><a href="MenuDirecteur.jsp">Retour Menu Principal</a></li>
                                                        <li><a href="Menu?action=sedeconnecter">Se déconnecter</a></li>
                                                    						</ul>

					</nav>
				</div>
			</section>
                </div>

   

     <body><center>
<% 
    List<Secteur> listeSecteur2 =listeSecteur;%>
    <center> 
<tr> <td Width=15%>Bienvenue <%=p.getNom()%></td>

        
            <form method="get" action="/SuperMercado-war/DirecteurServlet">
                <fieldset>
                    <legend>Informations de votre nouveau rayon</legend>
                    <label for="libellesecteur">Secteur <span class="requis">*</span></label>
                    <SELECT name="libellesecteur" size="1">
                        <%
                        for(Secteur s: listeSecteur2){ %>
                        <OPTION><%=s.getLibelleSecteur()%>
                        <%}%>
                    </SELECT>
                    <br />
                    <label for="libelleRayon">Nom du Rayon<span class="requis">*</span></label>
                    <input type="text" name="libelleRayon" value="" size="20" maxlength="20" required/>
                    <br />

                    <input type="hidden" name="action" value="insererRayon">
                </fieldset>
                <input type="submit" value="Valider" />
                <input type="reset" value="Remettre à zéro" /> <br />
            </form>
        </center> 
     <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
