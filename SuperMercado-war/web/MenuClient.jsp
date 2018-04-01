<%-- 
    Document   : MenuClient
    Created on : 19 mars 2018, 16:18:05
    Author     : Sophia
--%>
<% 
        
    if (session.getAttribute("client") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>


<%@page import="entités.gestionVenteEnLigne.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="client" scope="session" class="Client"></jsp:useBean>
        <title>JSP Page</title>
    <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>
    <% Client c= client;%>
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
																						
							<li><a href="ClientServlet?action=transferListeMagasin">Vente en ligne</a></li>			
							
							<li><a href="Menu?action=CasterEnPersonne&idPersonneSession=<%=c.getId()%>">Modifier mon mot de passe</a></li>
                                                        <li><a href="MenuClient.jsp">Retour menu principal</a></li>
                                                        <li><a href="ClientServlet?action=SupprimerCompteClient"
                                                               onclick="return confirm('êtes vous sûr de vouloir supprimer votre compte ? Cette action est irréversible')">
                                                                Supprimer mon compte</a></li>

                                                        <li><a href="Menu?action=sedeconnecter">Se déconnecter</a></li>
                                        </ul>
                                            </nav>
				</div>
			</section>
    
    <body>
         
<tr> <td Width=15%>Bienvenue <%=c.getPrenom()%></td>
    </tr>
        <h1>Menu Client</h1>
        
        <%@ include file="/include/flexslider.jsp" %>
       
        
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
