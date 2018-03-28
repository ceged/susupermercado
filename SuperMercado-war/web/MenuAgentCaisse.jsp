 <%-- 
    Document   : MenuAgentCaisse
    Created on : 16 mars 2018, 15:19:32
    Author     : CGAILLOTDREVON
--%>


<% 
        
    if (session.getAttribute("agentCaisse") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>

<%@page import="entités.gestionMagasin.AgentCaisse"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="agentCaisse" scope="session" class="AgentCaisse"></jsp:useBean>
        <title>JSP Page</title>
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
							<li><a href="EmployeCaisseServlet?action=insererAchat">Achat</a>					
								<ul>
									<li><a href="EmployeCaisseServlet?action=passageInfoCreerAchatCaisse&idAgent=<%=agentCaisse.getId()%>">Créer un achat</a></li>
									
						</ul>
                                                        
                                                        <li><a href="Menu?action=CasterEnPersonne&idPersonneSession=<%=agentCaisse.getId()%>">Modifier mot de passe</a></li>
                                                        <li><a href="MenuAgentCaisse.jsp">Retour Menu Agent caisse</a></li>
                                        </nav>
				</div>
			</section>

    <body>

<tr> <td Width=15%>Bienvenue <%=agentCaisse.getPrenom()%></td>
</tr>
        <h1>Bienvenue sur le menu Caisse !</h1>
         <p> <%
        String attribut = (String) request.getAttribute("message");
        if(attribut==null){
            attribut="Aucune action effectuée";
        }
        else{
        out.println( attribut );}
        %> </p>
        
        
      <%@ include file="/include/flexslider_caisse.jsp" %>
        
       
      
     <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>