<%-- 
    Document   : MenuChefdeRayonJSP
    Created on : 12 mars 2018, 09:36:22
    Author     : PC Tim
--%>

<%@page import="entités.gestionMagasin.ChefRayon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="chefRayonConnecte" scope="session" class="ChefRayon"></jsp:useBean>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Accueil</title>    
    <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>
     <% ChefRayon c = chefRayonConnecte;
                {%>
               
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
           
        <tr> <td Width=15%>Bienvenue <%=c.getPrenom()%></td>
        </tr><%}%>
        <h1>Bienvenue sur le menu Chef de rayon !</h1>
        
        
        <p> <%
            String attribut = (String) request.getAttribute("message");
            if (attribut == null) {
                attribut = "Aucune action effectuée";
            } else {
                out.println(attribut);
            }
            %> </p>
        <%@ include file="/include/flexslider_chefrayon.jsp" %>
            <%@ include file="/include/footer.jsp" %>
    </body>
    <%@ include file="/include/js.jsp" %>
</html>
