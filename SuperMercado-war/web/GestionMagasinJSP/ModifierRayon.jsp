<%-- 
   Document   : ModifierRayon
    Created on : 16 mars 2018, 14:35:05
    Author     : tangu_000
--%>

<% 
        
    if (session.getAttribute("directeurConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>
<%@page import="entités.gestionMagasin.Rayon"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="entités.gestionMagasin.DirecteurMagasin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="test.css" type="text/css">
         <jsp:useBean id="directeurConnecte" scope="session" class="DirecteurMagasin"></jsp:useBean>
        <jsp:useBean id="listeRayonModifie" scope="session" class="List<Rayon>"></jsp:useBean>
        
        <title>JSP Page</title>
    <%@ include file="/include/css.jsp" %>    
    </head>    
    <% DirecteurMagasin p= directeurConnecte;%>
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
                                                        <li><a href="Accueil.jsp">Se déconnecter</a></li>
                                                    						</ul>

					</nav>
				</div>
			</section>
                </div>

    
 <center>
        <% DirecteurMagasin d= directeurConnecte;
List<Rayon> listeRayon2 =listeRayonModifie;%>
<tr> <td Width=15%>Bienvenue <%=d.getNom()%></td>

        <h1>Formulaire de modification rayon</h1>
    
           <form method="get" action="/SuperMercado-war/DirecteurServlet">
        <fieldset>
        <legend>Informations Rayon a modifier (majuscules et accents interdits)</legend>
        <br />
        <label for="libelleRayon">Rayon <span class="requis">*</span></label>
        <SELECT name="libelleRayon" size="1">
            <%
            for(Rayon r: listeRayon2){ %>
            <OPTION><%=r.getLibelleRayon()%>
                <%}%>
        </SELECT>
        <br />
        <label for="newLibelleRayon">Nouveau nom rayon <span class="requis">*</span></label>
        <input type="text" name="newLibelleRayon" value="" size="20" maxlength="20" required/>
        <br />
        <input type="hidden" name="magasin" value="<%=d.getMagasin().getNomMagasin()%>" />
        <br />
        <input type="hidden" name="action" value="modifierRayon">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
</form>
       </center> 
      <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
