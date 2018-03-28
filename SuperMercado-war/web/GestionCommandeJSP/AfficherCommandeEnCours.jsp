
<% 
        
    if (session.getAttribute("chefRayonConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>

<%@page import="entités.gestionMagasin.ChefRayon"%>
<%@page import="entités.gestionCommande.Commande"%>
<%@page import="entités.gestionCommande.LigneCommande"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="chefRayonConnecte" scope="session" class="ChefRayon"></jsp:useBean>
         <jsp:useBean id="commande" scope="session" class="Commande"></jsp:useBean>
        <jsp:useBean id="listeLigneCommande" scope="session" class="List<LigneCommande>"></jsp:useBean>
        <link rel="stylesheet" href="test.css" type="test/css">
        <title>Bon de commande en cours</title>
      <%@ include file="/include/css.jsp" %>
    </head>
     <%@ include file="/include/header.jsp" %>
    <% ChefRayon c = chefRayonConnecte;%>

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
<h1>Liste des articles ajoutés</h1>
<p> <%
String attribut = (String) request.getAttribute("message");
if(attribut!=null){
    out.println( attribut );
}

%> </p>
<A HREF="GestionCommandeJSP/CreerLigneCommande.jsp?commandeId=<%=commande.getId() %>">Ajouter un article</A><br />
<A HREF="ChefRayonServlet?action=validerBonCommande&commandeId=<%=commande.getId()%>">Valider le bon de commande</A><br />
<A HREF="MenuChefdeRayon.jsp">Retour au menu</A><br />
<TABLE border width=50%>
<tr> <TD>Designation article</TD>
<TD>Quantité</TD>
<TD>Prix unitaire</TD>
<TD>Total</TD>
<TD>Supprimer de la commande</TD>
 </tr>
<%float t=0;
for(LigneCommande l : listeLigneCommande){t=t+l.getPrixAchatUnitaire()*l.getQuantiteLigne();%>
<tr><td Width=15%><%=l.getArticle().getLibelleArticle() %></td>
<td Width=15%><%=l.getQuantiteLigne()%></td>
<td Width=15%><%=l.getPrixAchatUnitaire()%></td>
<td Width=15%><%=l.getPrixAchatUnitaire()*l.getQuantiteLigne()%></td>
<td Width=30%><A href="ChefRayonServlet?action=SupprimerLigneAchat&ligneId=<%=l.getId() %>&commandeId=<%=commande.getId()%>"> Cliquez ici</A></td>
<%}%>

</tr></TABLE>
<table border width="50%">
    <tr>
        <td>Coût total : </td>
        <td><%=t%></td>
    </tr>
    
</table>

<hr>

    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
