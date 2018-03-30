<%-- 
    Document   : MenuAdmin
    Created on : 13 mars 2018, 10:31:11
    Author     : Soldat
--%>
<% 
        
    if (session.getAttribute("personneConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>


<%@page import="java.io.IOException"%>
<%@page import="entités.gestionMagasin.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="personneConnecte" scope="session" class="Personne"></jsp:useBean>
<link rel="stylesheet" href="text.css" type="text/css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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
					<a href="Accueil.jsp" class="pull-left"><img src="<%= request.getContextPath() %>/template/images/logo5.png" class="site_logo" alt=""></a>
					<nav id="menu" class="pull-right">
						<ul>
							<li><a >Magasin</a>					
								<ul>
									<li><a href="Admin?action=CreerMagasin">Creer un magasin</a></li>
                                                                       
								</ul>
							</li>															
							<li><a href="Admin?action=TransfererListeMagasinPourAjoutDirecteur">Créer un directeur</a></li>			
							<li><a >Catégorie</a>
								<ul>									
									<li><a href="Admin?action=CreerCategorie">Créer une Catégorie</a></li>
									<li><a href="Admin?action=TransfererListeCategorie">Créer une sous-catégorie </a></li>
								</ul>
							</li>							
							<li><a href="Admin?action=TransfererListeRefArticle">Créer une Promotion </a></li>
                                                        <li><A HREF="http://127.0.0.1/ui/lnk/?_=eJxNkEELgzAMhf9LzoJsR28OBx4GG3otjCphFaotaVQ68b8vHUN2yvteeEnIBmsIUGywDLgiJcUDW4QCIgbIYMRp7rQ0YHKC7Jz9w8Ca53CQQeSA9uCenLXHqLdz4w%2F2PQPtfcI5yNoM1i6lzqJe5EWSlJOQoV7IJDlx9OkwxtFbzSgWPTQbsVSu8ga9Iw4qrwckTb2JKq%2FKtr7cy6Z6tuXt2kpikTBHKJhm%2FN4g6fSC%2FQNJFlSp&user=admin&pass=rD0BR%2FxTH4m4bXUdDMDd4A%3D%3D" target="_blank">Consulter les ventes</a></li>
                                                        <li><a href="Menu?action=CasterEnPersonne&idPersonneSession=<%=personneConnecte.getId()%>">Modifier mon mot de passe</a></li>
							<li><a href="MenuAdmin.jsp">Retour menu principal</a></li>
                                                        <li><a href="Menu?action=sedeconnecter">Se déconnecter</a></li>
                                                </ul>
					</nav>
				</div>
			</section>

    <body>
            
        <h1>Bienvenue sur le menu Admin !</h1>
        <p> <%
        String attribut = (String) request.getAttribute("message");
        if(attribut==null){
            attribut="Aucune action effectuée";
        }
        else{
        out.println( attribut );}
        %> </p>
       <%@ include file="/include/flexslider_admin.jsp" %>
        
      <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
