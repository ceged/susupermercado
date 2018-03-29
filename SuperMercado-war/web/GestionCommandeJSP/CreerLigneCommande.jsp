<%-- 
    Document   : CreerFournisseur
    Created on : 14 mars 2018, 11:59:16
    Author     : Sophia
--%>
<% 
        
    if (session.getAttribute("chefRayonConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>


<%@page import="entités.gestionArticle.ReferentielArticle"%>
<a href="CreerLigneCommande.jsp"></a>
<%@page import="entités.gestionCommande.Commande"%>
<%@page import="entités.gestionCommande.Fournisseur"%>
<%@page import="entités.gestionMagasin.ChefRayon"%>
<%@page import="entités.gestionMagasin.Rayon"%>
<%@page import="java.util.List"%>
<%@page import="entités.gestionMagasin.DirecteurMagasin"%>
<%@page import="entités.gestionMagasin.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="chefRayonConnecte" scope="session" class="ChefRayon"></jsp:useBean>
        <jsp:useBean id="commande" scope="session" class="Commande"></jsp:useBean>
        <jsp:useBean id="listeArticle" scope="session" class="List<ReferentielArticle>"></jsp:useBean>
        <link rel="stylesheet" href="test.css" type="test/css">
        <title>Création Ligne Commande</title>
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
                <a href="index.html" class="pull-left"><img src="<%= request.getContextPath()%>/template/images/logo5.png" class="site_logo" alt=""></a>
                <nav id="menu" class="pull-right">
                    <ul>
                        <li><a>Article</a>					
                            <ul>
                                <li><a href="ChefRayonServlet?action=passageListeSousCategorie">Créer un article</a></li>
                                <li><a href="ChefRayonServlet?action=passageInfospourModifierPrix&chefRayon=<%=chefRayonConnecte.getId()%>">Modifier prix article</a></li>	
                                <li><a href="ChefRayonServlet?action=passageInfospourSupprimerArticle&chefRayon=<%=chefRayonConnecte.getId()%>">Supprimer article</a></li>	
                            </ul>
                        </li>															

                        <li><a href="ChefRayonServlet?action=CreerFournisseur">Créer un fournisseur</a></li>
                        <li><a>Commande</a>
                            <ul>									
                                <li><a href="ChefRayonServlet?action=passageInfosCreerBonCommande&chefRayon=<%=chefRayonConnecte.getId()%>"> Créer bon de commande</a></li>
                                <li><a href="ChefRayonServlet?action=passageInfosListeBonCommande&chefRayon=<%=chefRayonConnecte.getId()%>">Afficher les bon de commandes </a></li>
                            </ul>
                        </li>	
                        <li><a href="MenuChefdeRayon.jsp">Retour Menu principal</a></li>
                        <li><a href="Menu?action=sedeconnecter">Se déconnecter</a></li>
                    </ul>
                </nav>
            </div>
        </section>
     
    <body>

         <h1>Formulaire de ligne commande</h1>
    <center>
        <form method="get" action="/SuperMercado-war/ChefRayonServlet">
        <fieldset>
        <legend>Informations ligne commande</legend>
        <label for="article">Article du fournisseur<span class="requis">*</span></label>
        <SELECT name="article" size="1" required="">
            <%
            for(ReferentielArticle r: listeArticle){ %>
            <OPTION value="<%=r.getCodeBarre()%>"> <%=r.getLibelleArticle()%>
                <%}%>
        </SELECT>
        <br />
        <label for="quantite"> Quantité <span class="requis">*</span></label>
        <input type="number" name="quantite" value="" size="20" maxlength="20" required/>
        <br />
        <label for="prix"> Prix Unitaire <span class="requis">*</span></label>
        <input type="number" step="0.01" name="prix" value="" size="20" maxlength="20" required/>
        <br />
        <input type="hidden" name="commandeId" value="<%=commande.getId()%>">
        <input type="hidden" name="action" value="insererLigneCommande">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
      </center> 
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
