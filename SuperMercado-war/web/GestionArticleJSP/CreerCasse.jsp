<%-- 
    Document   : CreerCategorie
    Created on : 13 mars 2018, 16:15:46
    Author     : CGAILLOTDREVON
--%>
<% 
        
    if (session.getAttribute("agentRayonConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>


<%@page import="entités.gestionMagasin.AgentRayon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="agentRayonConnecte" scope="session" class="AgentRayon"></jsp:useBean>
        <link rel="stylesheet" href="text.css" type="text/css">
        <title>Saisir casse</title>
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
							<li><a href="GestionArticleJSP/CreerCasse.jsp">Casse</a>					
								<ul>
									<li><a href="GestionArticleJSP/CreerCasse.jsp">Saisir Casse</a></li>
									<li><a href="AgentRayonServlet?action=passageListeCasseRayon&idAgent=<%=agentRayonConnecte.getId()%>"> Consulter liste casse de mon rayon</a></li>	
                                                                        </ul>
							</li>															
									
							
                                                            <li><a href="GestionCommandeJSP/CreerFournisseur.jsp">Rayon</a>
								<ul>									
									<li><a href="AgentRayonServlet?action=passageListelivraison&idAgent=<%=agentRayonConnecte.getId()%>">"> Consulter liste livraison de mon rayon</a></li>
									<li><a href="AgentRayonServlet?action=passageListecommande&idAgent=<%=agentRayonConnecte.getId()%>">Consulter liste commandes de mon rayon</a></li>
								</ul>
							</li>					
							<li><a href="MenuAgentRayon.jsp">Sortir menu principal</a></li>
					</nav>
				</div>
			</section>

     
    <body>
        <h1>Formulaire de saisie casse</h1>
        <tr> <td Width=15%>Bienvenue <%=agentRayonConnecte.getPrenom()%></td>
</tr>
        
<center>
    <form method="get" action="/SuperMercado-war/AgentRayonServlet">
        <fieldset>
        <label for="idLotArticle">Code barre du lot Article <span class="requis">*</span></label>
        <input type="number" name="idLotArticle" value="" size="20" maxlength="20" required/>
        <br />
        <label for="quantite">Quantité casse <span class="requis">*</span></label>
        <input type="number" name="quantite" value="" size="20" maxlength="20" required/>
        <br />
        <label for="motif">Motif de casse <span class="requis">*</span></label>
        <input type="text" name="motif" value="" size="20" maxlength="20" required/>
        <br />
        <input type="hidden" name="idAgent" value="<%=agentRayonConnecte.getId()%>">
        <input type="hidden" name="action" value="insererCasse">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
  </center> 
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>

