<%-- 
    Document   : MenuAgentLivraison
    Created on : 20 mars 2018, 09:25:06
    Author     : Soldat
--%>
<% 
        
    if (session.getAttribute("agentRayonConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>

<%@page import="entités.gestionMagasin.AgentRayon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="agentRayonConnecte" scope="session" class="AgentRayon"></jsp:useBean>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Agent Rayon</title>
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
					<a href="index.html" class="pull-left"><img src="<%= request.getContextPath() %>/template/images/logo5.png" class="site_logo" alt=""></a>
					<nav id="menu" class="pull-right">
						<ul>
							<li><a>Casse</a>					
								<ul>
									<li><a href="AgentRayonServlet?action=SaisirCasse">Saisir Casse</a></li>
									<li><a href="AgentRayonServlet?action=passageListeCasseRayon&idAgent=<%=agentRayonConnecte.getId()%>"> Consulter liste casse de mon rayon</a></li>	
                                                                        </ul>
							</li>															
									
							
                                                        <li><a>Rayon</a>
								<ul>									
									<li><a href="AgentRayonServlet?action=passageListelivraison&idAgent=<%=agentRayonConnecte.getId()%>"> Consulter liste livraison de mon rayon</a></li>
									<li><a href="AgentRayonServlet?action=passageListecommande&idAgent=<%=agentRayonConnecte.getId()%>">Consulter liste commandes de mon rayon</a></li>
								</ul>
							</li>
                                                        <li><A HREF="http://127.0.0.1/ui/lnk/?_=eJxNkEELgzAMhf9LzoJsR28OBx4GG3otjCphFaotaVQ68b8vHUN2yvteeEnIBmsIUGywDLgiJcUDW4QCIgbIYMRp7rQ0YHKC7Jz9w8Ca53CQQeSA9uCenLXHqLdz4w%2F2PQPtfcI5yNoM1i6lzqJe5EWSlJOQoV7IJDlx9OkwxtFbzSgWPTQbsVSu8ga9Iw4qrwckTb2JKq%2FKtr7cy6Z6tuXt2kpikTBHKJhm%2FN4g6fSC%2FQNJFlSp&user=admin&pass=rD0BR%2FxTH4m4bXUdDMDd4A%3D%3D" target="_blank">Consulter les ventes</a></li>
                                                        <li><a href="Menu?action=CasterEnPersonne&idPersonneSession=<%=agentRayonConnecte.getId()%>"> Modifier mon mot de passe</a></li>
							<li><a href="MenuAgentRayon.jsp">Retour menu principal</a></li>
                                                        <li><a href="Accueil.jsp">Se déconnecter</a></li>
                                                </ul>
					</nav>
				</div>
			</section>


    <body>
    <tr> <td Width=15%>Bienvenue <%=agentRayonConnecte.getPrenom()%></td>
</tr>
        <h1>Menu Agent Rayon</h1>
        <p> <%
        String attribut = (String) request.getAttribute("message");
        if(attribut==null){
            attribut="Aucune action effectuée";
        }
        else{
        out.println( attribut );}
        %> </p>
      
       <%@ include file="/include/flexslider_agentrayon.jsp" %>
        
       
      
     <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
