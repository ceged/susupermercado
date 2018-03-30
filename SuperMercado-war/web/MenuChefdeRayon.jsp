<%-- 
    Document   : MenuChefdeRayonJSP
    Created on : 12 mars 2018, 09:36:22
    Author     : PC Tim
--%>
<% 
        
    if (session.getAttribute("chefRayonConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>


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
                        <li><A HREF="http://127.0.0.1/ui/lnk/?_=eJxNkEELgzAMhf9LzoJsR28OBx4GG3otjCphFaotaVQ68b8vHUN2yvteeEnIBmsIUGywDLgiJcUDW4QCIgbIYMRp7rQ0YHKC7Jz9w8Ca53CQQeSA9uCenLXHqLdz4w%2F2PQPtfcI5yNoM1i6lzqJe5EWSlJOQoV7IJDlx9OkwxtFbzSgWPTQbsVSu8ga9Iw4qrwckTb2JKq%2FKtr7cy6Z6tuXt2kpikTBHKJhm%2FN4g6fSC%2FQNJFlSp&user=admin&pass=rD0BR%2FxTH4m4bXUdDMDd4A%3D%3D" target="_blank">Consulter les ventes</a></li>
                        <li><a href="Menu?action=CasterEnPersonne&idPersonneSession=<%=c.getId()%>">Modifier mot de passe</a></li>
                        <li><a href="MenuChefdeRayon.jsp">Retour Menu principal</a></li>
                        <li><a href="Menu?action=sedeconnecter">Se déconnecter</a></li>
                    </ul>
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
