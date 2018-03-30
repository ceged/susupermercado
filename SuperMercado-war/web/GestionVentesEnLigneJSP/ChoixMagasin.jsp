<%-- 
    Document   : ChoixMagasin
    Created on : 19 mars 2018, 17:54:00
    Author     : Sophia
--%>
<% 
        
    if (session.getAttribute("client") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>

<%@page import="java.util.List"%>
<%@page import="entités.gestionMagasin.Magasin"%>
<%@page import="entités.gestionVenteEnLigne.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
        <title>JSP Page</title>
        <jsp:useBean id="client" scope="session" class="Client"></jsp:useBean>
        <jsp:useBean id="listeMagasin" scope="session" class="List<Magasin>"></jsp:useBean>
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
																						
							
                                                        <li><a href="MenuClient.jsp">Retour menu principal</a></li>
                                                        <li><a href="Menu?action=sedeconnecter">Se déconnecter</a></li>
                                        </ul>
                                            </nav>
				</div>
			</section>
    <body>
         <% Client c = client;%>
        <h1>Choisissez un magasin</h1>
    <center>
        <form method="post" action="/SuperMercado-war/ClientServlet">
        <fieldset>

        
        <label for="magasin">Magasin disponible : <span class="requis">*</span></label>
        <SELECT name="magasin" size="1">
            <%
            for(Magasin m: listeMagasin){ %>
            <OPTION><%=m.getNomMagasin()%>
                <%}%>
        </SELECT>
        
        <input type="hidden" name="idClient" value=<%=c.getId()%>>
        <input type="hidden" name="action" value="transferArticlesParMagasin">
        </fieldset> 
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
        
        <p>      <%
String attribut = (String) request.getAttribute("message");
if(attribut!=null){
    out.println( attribut );
            }
%> 
      </p>
        
    </center> 
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>

