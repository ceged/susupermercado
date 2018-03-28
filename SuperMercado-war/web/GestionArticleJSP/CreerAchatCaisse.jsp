<%-- 
    Document   : CreerAchatCaisse
    Created on : 22 mars 2018, 11:38:15
    Author     : Soldat
--%>
<% 
        
    if (session.getAttribute("agentCaisse") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>



<%@page import="entités.gestionArticle.AchatCaisse"%>
<%@page import="entités.gestionArticle.LigneAchat"%>
<%@page import="java.util.List"%>
<%@page import="entités.gestionMagasin.AgentCaisse"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="agentCaisse" scope="session" class="AgentCaisse"></jsp:useBean>
        <jsp:useBean id="liste" scope="session" class="List<LigneAchat>"></jsp:useBean>
        <jsp:useBean id="achatCaisse" scope="session" class="AchatCaisse"></jsp:useBean>
        
        <title>Menu Panier Achat Caisse</title>
      <%@ include file="/include/css.jsp" %>
    </head>
     <%@ include file="/include/header.jsp" %>
<%-- 
    Document   : sidebar_agentcaisse
    Created on : 27 mars 2018, 14:31:49
    Author     : tangu_000
--%>
<%@page import="entités.gestionMagasin.AgentCaisse"%>
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
							<li><a href="EmployeCaisseServlet?action=insererAchat">Achat</a>					
								<ul>
									<li><a href="EmployeCaisseServlet?action=insererAchat">Créer un achat</a></li>
									
                                                                </ul>
                                                        <li><a href="Menu?action=CasterEnPersonne&idPersonneSession=<%=agentCaisse.getId()%>">Modifier mot de passe</a></li>
                                                        <li><a href="MenuAgentCaisse.jsp">Retour menu principal</a></li>
                                                        <li><a href="Accueil.jsp">Se déconnecter</a></li>
                                                </ul>
					</nav>
				</div>
			</section>
     

        <body>
        <h1>Liste de vos achats caisse</h1>
        
        <p> <%
String attribut = (String) request.getAttribute("message");
if(attribut!=null){
    out.println( attribut );
}

%> </p>
        
        <center><form method="get" action="/SuperMercado-war/EmployeCaisseServlet">
            <label for="number"> Code barre lot article <span class="requis">*</span></label>
        <input type="number" name="idLotArticle" value="" size="20" maxlength="20" />
        <input type="hidden" name="idAchat" value="<%=achatCaisse.getId() %>">
        <input type="hidden" name="action" value="insererLigneAchat">
        <input type="submit" value="Valider" />
        <br />
        </form>
        </center> 
 <TABLE border width=50%>
<tr> <TD>Designation article</TD>
<TD>Quantité</TD>
<TD>Prix unitaire</TD>
<TD>Total</TD>
<TD>Supprimer de la commande</TD>
 </tr>
<%float t=0;
for(LigneAchat l : liste){t=t+l.getLotArticle().getArticle().getPrixVenteMagasin()*l.getQuantiteAchetee();%>
<tr><td Width=15%><%=l.getLotArticle().getArticle().getLibelleArticle() %></td>
<td Width=15%><%=l.getQuantiteAchetee()%></td>
<td Width=15%><%=l.getLotArticle().getArticle().getPrixVenteMagasin()%></td>
<td Width=15%><%=l.getLotArticle().getArticle().getPrixVenteMagasin()*l.getQuantiteAchetee()%></td>
<td Width=30%><A href="EmployeCaisseServlet?action=SupprimerLigneAchat&ligneId=<%=l.getId()%>&achatId=<%=l.getAchat().getId()%>"> Cliquez ici</A></td>

</tr><%}%></TABLE>
<table border width="50%">
    <tr>
        <td>Coût total : </td>
        <td><%=t%></td>
    </tr>
    
</table>       
        
        <center>
            <form method="get" action="/SuperMercado-war/EmployeCaisseServlet">
        <input type="hidden" name="idAchat" value="<%=achatCaisse.getId() %>">
        <input type="hidden" name="action" value="validerAchatCaisse">
        <input type="submit" value="Valider panier/Passer au paiement" />
        <br />
        </form>
    
    
   </center> 
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>