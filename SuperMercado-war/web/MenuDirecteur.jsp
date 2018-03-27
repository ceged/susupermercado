<%-- 
   Document   : ModifierRayon
    Created on : 16 mars 2018, 14:35:05
    Author     : tangu_000
--%>


<%@page import="entités.gestionMagasin.DirecteurMagasin"%>
<%@page import="entités.gestionMagasin.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="text.css" type="text/css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="directeurConnecte" scope="session" class="DirecteurMagasin"></jsp:useBean>
        <title>JSP Page</title>
    <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>
     <% DirecteurMagasin p= directeurConnecte;{%>
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
							<li><a href="GestionMagasinJSP/CreerRayon.jsp">Rayon</a>					
								<ul>
									<li><a href="DirecteurServlet?action=passageInfospourModifierRayon&directeur=<%=p.getId()%>">Modifier un rayon</a></li>
                                                                        <li><a href="DirecteurServlet?action=transferListeRayon&directeur=<%=p.getId()%>">Creer un chefrayon</a></li>
                                                                        <li><a href="DirecteurServlet?action=transferListeRayon2&directeur=<%=p.getId()%>">Créer un agent de rayon </a></li>
									<li><a href="DirecteurServlet?action=transferListeSecteur&directeur=<%=p.getId()%>">Creer un rayon</a></li>
                                                                        <li><a href="DirecteurServlet?action=TransfererListeRayon&directeur=<%=p.getId()%>">Supprimer un rayon</a></li>	
                                                                       
								</ul>
							</li>															
							<li><a href="GestionMagasinJSP/CreerSecteur.jsp">Créer un secteur</a></li>			
							<li><a href="GestionMagasinJSP/CreerCaisse.jsp">Caisse</a>
								<ul>									
									<li><a href="GestionMagasinJSP/CreerCaisse.jsp">Créer une Caisse</a></li>
									<li><a href="DirecteurServlet?action=TransfererListeCaisse&directeur=<%=p.getId()%>"> Supprimer une caisse </a></li>
                                                                        <li><a href="GestionMagasinJSP/CreerAgentCaisse.jsp"> Créer un agent caisse </a></li>
								</ul>
							</li>							
							
							<li><a href="MenuDirecteur.jsp">Sortir menu principal</a></li>
					</nav>
				</div>
			</section>
    <body>
   
<tr> <td Width=15%>Bienvenue <%=p.getPrenom()%></td>
</tr><%}%>
        <h1>Bienvenue sur le menu Directeur !</h1>
        <A HREF="GestionMagasinJSP/CreerSecteur.jsp">
        Créer un secteur</A><br/><br/>
        <A HREF="DirecteurServlet?action=transferListeRayon&directeur=<%=p.getId()%>">
        Créer un chef de rayon</A><br/><br/>
        <A HREF="DirecteurServlet?action=transferListeSecteur&directeur=<%=p.getId()%>">
        Créer un rayon</A><br/><br/>
        <A HREF="DirecteurServlet?action=passageInfospourModifierRayon&directeur=<%=p.getId()%>">
        Modifier un rayon</A><br/><br/>
        <A HREF="DirecteurServlet?action=TransfererListeRayon&directeur=<%=p.getId()%>">
        Supprimer un rayon</A><br/><br/>

        <A HREF="GestionMagasinJSP/CreerCaisse.jsp">
        Créer une caisse</A><br/><br/>
        <A HREF="DirecteurServlet?action=TransfererListeCaisse&directeur=<%=p.getId()%>">
        Supprimer une caisse</A><br/><br/>
        <A HREF="GestionMagasinJSP/CreerAgentCaisse.jsp">
        Créer un AgentCaisse</A><br/><br/>
        <A HREF="DirecteurServlet?action=transferListeRayon2&directeur=<%=p.getId()%>">
        Créer un AgentRayon</A><br/><br/>
        
        <A HREF="MenuDirecteur.jsp">
        Sortir menu principal</A><br/><br/>
        
        <p> <%
        String attribut = (String) request.getAttribute("message");
        if(attribut==null){
            attribut="Aucune action effectuée";
        }
        else{
        out.println( attribut );}
        %> </p>
     <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
