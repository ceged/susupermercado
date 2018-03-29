<%-- 
    Document   : SupprimerArticle
    Created on : 15 mars 2018, 14:05:22
    Author     : Soldat
--%>
<% 
        
    if (session.getAttribute("chefRayonConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>


<%@page import="entités.gestionArticle.ReferentielArticle"%>
<%@page import="java.util.List"%>
<%@page import="entités.gestionMagasin.ChefRayon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="chefRayonConnecte" scope="session" class="ChefRayon"></jsp:useBean>
        <jsp:useBean id="listeReferentielArticle" scope="session" class="List<ReferentielArticle>"></jsp:useBean>
        <title>JSP Page</title>
      <%@ include file="/include/css.jsp" %>
    </head>
     <%@ include file="/include/header.jsp" %>
     <% ChefRayon c = chefRayonConnecte;
     List<ReferentielArticle> liste=listeReferentielArticle;{%>
                
               
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
                <a href="index.html" class="pull-left"><img src="<%= request.getContextPath()%>/template/images/logo5.png" class="site_logo" alt=""></a>
                <nav id="menu" class="pull-right">
                    <ul>
                        <li><a>Article</a>					
                            <ul>
                                <li><a href="ChefRayonServlet?action=passageListeSousCategorie">Créer un article</a></li>
                                <li><a href="ChefRayonServlet?action=passageInfospourModifierPrix&chefRayon=<%=c.getId()%>">Modifier prix article</a></li>	
                                <li><a href="ChefRayonServlet?action=passageInfospourSupprimerArticle&chefRayon=<%=c.getId()%>">Supprimer article</a></li>	
                            </ul>
                        </li>															

                        <li><a href="ChefRayonServlet?action=CreerFournisseur">Créer un fournisseur</a></li>
                        <li><a>Commande</a>
                            <ul>									
                                <li><a href="ChefRayonServlet?action=passageInfosCreerBonCommande&chefRayon=<%=c.getId()%>"> Créer bon de commande</a></li>
                                <li><a href="ChefRayonServlet?action=passageInfosListeBonCommande&chefRayon=<%=c.getId()%>">Afficher les bon de commandes </a></li>
                            </ul>
                        </li>	
                        <li><a href="MenuChefdeRayon.jsp">Retour Menu principal</a></li>
                        <li><a href="Menu?action=sedeconnecter">Se déconnecter</a></li>
                    </ul>
                </nav>
            </div>
        </section>
    <body>
       
</tr><%}%>
        <h1>Formulaire de suppresion d'article</h1>
        <center>
            <form method="get" action="/SuperMercado-war/ChefRayonServlet">
        <fieldset>
        <legend>Choisir l'article à supprimer</legend>
        <br />
        <input type="hidden" name="rayon" value=<%=c.getRayon().getLibelleRayon() %> size="20" maxlength="20" />
        <input type="hidden" name="magasin" value=<%=c.getRayon().getSecteur().getMagasin().getNomMagasin() %> size="20" maxlength="20" />
        <label for="libelleArticle">Article <span class="requis">*</span></label>
        <SELECT name="libelleArticle" size="1">
            <%
            for(ReferentielArticle r: liste){ %>
            <OPTION value="<%=r.getCodeBarre()%>"><%=r.getLibelleArticle()%>
                <%}%>
        </SELECT>
        <br />
        <input type="hidden" name="action" value="SupprimerArticle">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
          </center> 
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
