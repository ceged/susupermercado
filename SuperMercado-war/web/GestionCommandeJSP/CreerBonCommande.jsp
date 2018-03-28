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
        <jsp:useBean id="listeFournisseur" scope="session" class="List<Fournisseur>"></jsp:useBean>
        <link rel="stylesheet" href="test.css" type="test/css">
        <title>JSP Page</title>
      <%@ include file="/include/css.jsp" %>
    </head>
     <%@ include file="/include/header.jsp" %>
     <% ChefRayon c = chefRayonConnecte;
                {%></tr><%}%>
               
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
                        <li><a href="ChefRayonServlet?action=passageListeSousCategorie">Article</a>					
                            <ul>
                                <li><a href="ChefRayonServlet?action=passageListeSousCategorie">Créer un article</a></li>
                                <li><a href="ChefRayonServlet?action=passageInfospourModifierPrix&chefRayon=<%=c.getId()%>">Modifier prix article</a></li>	
                                <li><a href="ChefRayonServlet?action=passageInfospourSupprimerArticle&chefRayon=<%=c.getId()%>">Supprimer article</a></li>	
                            </ul>
                        </li>															

                        <li><a href="GestionCommandeJSP/CreerFournisseur.jsp">Créer un fournisseur</a></li>
                        <li><a href="ChefRayonServlet?action=passageInfosCreerBonCommande&chefRayon=<%=c.getId()%>">Commande</a>
                            <ul>									
                                <li><a href="ChefRayonServlet?action=passageInfosCreerBonCommande&chefRayon=<%=c.getId()%>"> Créer bon de commande</a></li>
                                <li><a href="ChefRayonServlet?action=passageInfosListeBonCommande&chefRayon=<%=c.getId()%>">Afficher les bon de commandes </a></li>
                            </ul>
                        </li>	
                        <li><a href="MenuChefdeRayon.jsp">Menu chef rayon</a></li>
                </nav>
            </div>
        </section>
    <body>
         <h1>Formulaire de bon de commande</h1>
        <center>
        <form method="get" action="/SuperMercado-war/ChefRayonServlet">
        <fieldset>
        <legend>Informations bon de commande (majuscules et accents interdits)</legend>
        <label for="fournisseur">Fournisseur <span class="requis">*</span></label>
        <SELECT name="fournisseur" size="1">
            <%
            for(Fournisseur f: listeFournisseur){ %>
            <OPTION> <%=f.getNom()%>
                <%}%>
        </SELECT>
        <br />
        <label for="date"> Date <span class="requis">*</span></label>
        <input type="date" name="date" value="" size="20" maxlength="20" required />
        <br />
        <input type="hidden" name="chefRayon" value="<%=chefRayonConnecte.getId()%>">
        <input type="hidden" name="action" value="insererBonCommande">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
      </center> 
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
        
