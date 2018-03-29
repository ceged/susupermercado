<%@page import="entités.gestionMagasin.Personne"%>
<%@page import="entités.gestionArticle.ReferentielArticle"%>
<%@page import="java.util.List"%>

<%-- 
    Document   : CreerPromotion
    Created on : 15 mars 2018, 10:47:16
    Author     : CGAILLOTDREVON
--%>
<% 
        
    if (session.getAttribute("personneConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="personneConnecte" scope="session" class="Personne"></jsp:useBean>
        <jsp:useBean id="listeRefArticle" scope="session" class="List<ReferentielArticle>"></jsp:useBean>
        <title>Création promotion</title>
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
					<a href="Accueil.jsp" class="pull-left"><img src="<%= request.getContextPath() %>/template/images/logo5.png" class="site_logo" alt=""></a>
					<nav id="menu" class="pull-right">
						<ul>
							<li><a >Magasin</a>					
								<ul>
									<li><a href="Admin?action=CreerMagasin">Creer un magasin</a></li>
                                                                       
								</ul>
							</li>															
							<li><a href="Admin?action=TransfererListeMagasinPourAjoutDirecteur">Créer un directeur</a></li>			
							<li><a >Catégorie</a>
								<ul>									
									<li><a href="Admin?action=CreerCategorie"">Créer une Catégorie</a></li>
									<li><a href="Admin?action=TransfererListeCategorie">Créer une sous-catégorie </a></li>
								</ul>
							</li>							
							<li><a href="Admin?action=TransfererListeRefArticle">Créer une Promotion </a></li>
                                                        <li><a href="Menu?action=CasterEnPersonne&idPersonneSession=<%=personneConnecte.getId()%>">Modifier mon mot de passe</a></li>
							<li><a href="MenuAdmin.jsp">Retour menu principal</a></li>
                                                        <li><a href="Accueil.jsp">Se déconnecter</a></li>
                                                </ul>
					</nav>
				</div>
			</section>
     
    <body>
        
       <h1>Créer une Promotion</h1>
        
    <center>
        <form method="get" action="/SuperMercado-war/Admin">
        <fieldset>
        
        <label for="dob">Date de début de la promotion <span class="requis">*</span></label>
        <input type="date" name="dateDeb" value="" size="20" maxlength="20" required/>
        <br />    
        
        <label for="dob">Date de fin de la promotion <span class="requis">*</span></label>
        <input type="date" name="dateFin" value="" size="20" maxlength="20" required/>
        <br />  
        
        <label for="prixPromo">Prix de la promotion <span class="requis">*</span></label>
        <input type="number" name="prixPromo" min="0" step="0.01" required/>
        <br />
            
        <label for="libelle"> Libellé Article <span class="requis">*</span></label>
        <SELECT name="libelle" size="1" required="">
            <%
            for(ReferentielArticle a: listeRefArticle){ %>
            <OPTION value="<%=a.getCodeBarre() %>"><%=a.getLibelleArticle()%>
                <%}%>
        </SELECT>
        
        <input type="hidden" name="action" value="insererPromotion">
        
        
        </fieldset>
        
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form> 
      </center> 
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>