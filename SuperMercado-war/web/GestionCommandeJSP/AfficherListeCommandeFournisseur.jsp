<%-- 
    Document   : AfficherCommandeEnCours
    Created on : 16 mars 2018, 15:57:17
    Author     : Soldat
--%>
<%@page import="entités.gestionLivraison.LigneLivraison"%>
<% 
        
    if (session.getAttribute("fournisseurConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>


<%@page import="entités.gestionLivraison.Livraison"%>
<%@page import="entités.gestionCommande.Fournisseur"%>
<%@page import="entités.gestionMagasin.ChefRayon"%>
<%@page import="entités.gestionCommande.Commande"%>
<%@page import="entités.gestionCommande.LigneCommande"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="liste" scope="session" class="List<Livraison>"></jsp:useBean>
        <jsp:useBean id="fournisseurConnecte" scope="session" class="Fournisseur"></jsp:useBean>
<title>Vos commandes</title>
  <%@ include file="/include/css.jsp" %>
    </head>
     <%@ include file="/include/header.jsp" %>
     <% Fournisseur f= fournisseurConnecte;%>
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
							<li><a href="FournisseurServlet?action=passageInfosListeCommande&fournisseur=<%=f.getId()%>">Consulter mes commandes</a></li>						
								
										
						
                                                         <li><a href="Menu?action=CasterEnPersonne&idPersonneSession=<%=f.getId()%>">Modifier mon mot de passe</a></li>
                                                        <li><a href="MenuFournisseur.jsp">Retour menu principal</a></li>
                                                        <li><a href="Menu?action=sedeconnecter">Se déconnecter</a></li>
                                                       </ul>
					</nav>
				</div>
			</section>

     
<body>
    <center>
<h1>Liste de vos commandes</h1>
<p> <%
String attribut = (String) request.getAttribute("message");
if(attribut!=null){
    out.println( attribut );
            }
%> </p>
<A HREF="MenuFournisseur.jsp">Retour au menu</A><br />

    <form method="get" action="/SuperMercado-war/FournisseurServlet">
        <label for="date"> Recherche entre 2 dates <span class="requis">*</span></label>
        <input type="date" name="date1" value="" size="20" maxlength="20" />
        <input type="date" name="date2" value="" size="20" maxlength="20" />
        <input type="hidden" name="action" value="ChoisirDateLivraison">
        <input type="hidden" name="fournisseurId" value=<%=fournisseurConnecte.getId()%>>
        <input type="submit" value="Valider la date"/>
        <br />
 </form>
<TABLE border width=50%>
<tr> <TD>Magasin</TD>
<TD>Date</TD>
<TD>Statut</TD>
<TD>Voir la commande</TD>
 </tr>
<%
for(Livraison l : liste){%>
<tr><td Width=15%><%=l.getCommande().getChefRayon().getRayon().getSecteur().getMagasin().getNomMagasin() %></td>
<td Width=15%><%=l.getCommande().getDateCommande()%></td>
<td Width=15%><%=l.getStatut()%></td>
<td Width=30%><A href="FournisseurServlet?action=afficherCommandeFournisseur&livraisonId=<%=l.getId()%>"> Cliquez ici</A></td>

</tr><%}%></TABLE>

<hr>
  </center> 
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>