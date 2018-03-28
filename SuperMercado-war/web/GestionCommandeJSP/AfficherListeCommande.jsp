<%-- 
    Document   : AfficherCommandeEnCours
    Created on : 16 mars 2018, 15:57:17
    Author     : Soldat
--%>
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
        <jsp:useBean id="liste" scope="session" class="List<Commande>"></jsp:useBean>
        <jsp:useBean id="chefRayonConnecte" scope="session" class="ChefRayon"></jsp:useBean>
<title>Liste des bons de commandes</title>
  <%@ include file="/include/css.jsp" %>
    </head>
     <%@ include file="/include/header.jsp" %>
     <% ChefRayon c = chefRayonConnecte;
                %>
               
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
<h1>Liste des bons de commande</h1>
<p> <%
String attribut = (String) request.getAttribute("message");
if(attribut!=null){
    out.println( attribut );
            }
%> </p>
<A HREF="ChefRayonServlet?action=passageInfosCreerBonCommande&chefRayon=<%=chefRayonConnecte.getId()%>">Créer un bon de commande</A><br />
<A HREF="MenuChefdeRayon.jsp">Retour au menu</A><br />
<center>
    <form method="get" action="/SuperMercado-war/ChefRayonServlet">
<label for="statut">Trier par <span class="requis">*</span></label>
<SELECT name="statut" size="1">
            <OPTION value="aucun">        
            <OPTION value="encours">En cours
            <OPTION value="valider">Validée
            <OPTION value="livrer">Livrée
        </SELECT>
<input type="hidden" name="chefRayon" value="<%=chefRayonConnecte.getId()%>">
<input type="hidden" name="action" value="passageModifListeBonCommande">
<input type="submit" value="Valider" />
</form>
<TABLE border width=50%>
<tr> <TD>Founisseur</TD>
<TD>Date</TD>
<TD>Statut</TD>
<TD>Voir le bon de commande</TD>
 </tr>
<%
for(Commande cm : liste){%>
<tr><td Width=15%><%=cm.getFournisseur().getNom()%></td>
<td Width=15%><%=cm.getDateCommande()%></td>
<td Width=15%><%=cm.getStatutCommande()%></td>
<td Width=30%><A href="ChefRayonServlet?action=afficherBonCommande&commandeId=<%=cm.getId()%>"> Cliquez ici</A></td>

</tr><%}%></TABLE>

<hr>
    </center> 
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>