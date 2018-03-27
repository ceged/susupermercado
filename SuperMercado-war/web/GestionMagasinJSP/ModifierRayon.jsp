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
    <%@ include file="/include/header.jsp" %>
     <% DirecteurMagasin a= directeurConnecte;{%>
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
							<li><a href="DirecteurServlet?action=transferListeSecteur&directeur=<%=a.getId()%>">Rayon</a>					
								<ul>
									<li><a href="DirecteurServlet?action=passageInfospourModifierRayon&directeur=<%=a.getId()%>">Modifier un rayon</a></li>
                                                                        <li><a href="DirecteurServlet?action=transferListeRayon&directeur=<%=a.getId()%>">Creer un chefrayon</a></li>
                                                                        <li><a href="DirecteurServlet?action=transferListeRayon2&directeur=<%=a.getId()%>">Créer un agent de rayon </a></li>
									<li><a href="DirecteurServlet?action=transferListeSecteur&directeur=<%=a.getId()%>">Creer un rayon</a></li>
                                                                        <li><a href="?action=TransfererListeRayon&directeur=<%=a.getId()%>">Supprimer un rayon</a></li>	
                                                                       
								</ul>
							</li>															
							<li><a href="GestionMagasinJSP/CreerSecteur.jsp">Créer un secteur</a></li>			
							<li><a href="GestionMagasinJSP/CreerCaisse.jsp">Caisse</a>
								<ul>									
									<li><a href="GestionMagasinJSP/CreerCaisse.jsp">Créer une Caisse</a></li>
									<li><a href="DirecteurServlet?action=TransfererListeCaisse&directeur=<%=a.getId()%>"> Supprimer une caisse </a></li>
                                                                        <li><a href="GestionMagasinJSP/CreerAgentCaisse.jsp"> Créer un agent caisse </a></li>
								</ul>
							</li>							
							
							<li><a href="MenuDirecteur.jsp">Sortir menu principal</a></li>
					</nav>
				</div>
			</section>

    <body>

        <% DirecteurMagasin d= directeurConnecte;
List<Rayon> listeRayon2 =listeRayonModifie;{%>
<tr> <td Width=15%>Bienvenue <%=d.getNom()%></td>
</tr><%}%>
        <h1>Formulaire de modification rayon</h1>
       <center> 
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
        <input type="text" name="newLibelleRayon" value="" size="20" maxlength="20" />
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
