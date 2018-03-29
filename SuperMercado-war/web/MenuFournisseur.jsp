<% 
        
    if (session.getAttribute("fournisseurConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>

<%@page import="entités.gestionCommande.Fournisseur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="fournisseurConnecte" scope="session" class="Fournisseur"></jsp:useBean>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
    <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>
    <% Fournisseur f= fournisseurConnecte;{%>
    
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
					<a href="Connexion.jsp" class="pull-left"><img src="<%= request.getContextPath() %>/template/images/logo5.png" class="site_logo" alt=""></a>
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
        
<tr> <td Width=15%>Bienvenue <%=f.getPrenom()%></td>
</tr><%}%>
        <h1>Bienvenue sur le menu Fournisseur !</h1>
       
        
        <p> <%
        String attribut = (String) request.getAttribute("message");
        if(attribut==null){
            attribut="Aucune action effectuée";
        }
        else{
        out.println( attribut );}
        %> </p>
    <%@ include file="/include/flexslider_fournisseur.jsp" %>
     <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
