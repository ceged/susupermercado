<%-- 
    Document   : CreerChefRayon
    Created on : 14 mars 2018, 11:59:16
    Author     : Sophia
--%>

<%@page import="entités.gestionMagasin.AgentCaisse"%>
<%@page import="entités.gestionMagasin.Caisse"%>
<%@page import="entités.gestionMagasin.Rayon"%>
<%@page import="java.util.List"%>
<%@page import="entités.gestionMagasin.DirecteurMagasin"%>
<%@page import="entités.gestionMagasin.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
        <meta http-equiv="Content-Type" content="test/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
<jsp:useBean id="directeurConnecte" scope="session" class="DirecteurMagasin"></jsp:useBean>
<jsp:useBean id="listeCaisse" scope="session" class="List<Caisse>"></jsp:useBean>
<jsp:useBean id="listeAgentCaisse" scope="session" class="List<AgentCaisse>"></jsp:useBean>
        <title>JSP Page</title>
    <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>

<body>
<% DirecteurMagasin p= directeurConnecte;
List<Caisse> listeCaisse2 =listeCaisse;
List<AgentCaisse>listeAgentCaisse2 =listeAgentCaisse;{%>
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
							<li><a>Rayon</a>					
								<ul>
									<li><a href="DirecteurServlet?action=transferListeSecteur&directeur=<%=p.getId()%>">Creer un rayon</a></li>
                                                                        <li><a href="DirecteurServlet?action=passageInfospourModifierRayon&directeur=<%=p.getId()%>">Modifier un rayon</a></li>
                                                                
                                                                        <li><a href="DirecteurServlet?action=transferListeRayon&directeur=<%=p.getId()%>">Creer un chef rayon</a></li>
                                                                        <li><a href="DirecteurServlet?action=transferListeRayon2&directeur=<%=p.getId()%>">Créer un agent de rayon </a></li>                                                                    
								</ul>
							</li>															
							<li><a href="DirecteurServlet?action=CreerSecteur">Créer un secteur</a></li>	
                                                        <li><a href="DirecteurServlet?action=CreerAgentLivraison">Créer un agent livraison</a></li>
							<li><a>Caisse</a>
								<ul>									
									<li><a href="DirecteurServlet?action=CreerCaisse">Créer une Caisse</a></li>
							
                                                                        <li><a href="DirecteurServlet?action=CreerAgentCaisse"> Créer un agent caisse </a></li>
                                                                        
                                                                        <li><a href="DirecteurServlet?action=transferListeCaisseEtAgentCaisse&directeur=<%=p.getId()%>"> Créer une affectation caisse </a></li>
								</ul>
							</li>							
							<li><a href="Menu?action=CasterEnPersonne&idPersonneSession=<%=p.getId()%>">Modifier mot de passe</a></li>
							<li><a href="MenuDirecteur.jsp">Retour Menu Principal</a></li>
                                                        <li><a href="Accueil.jsp">Se déconnecter</a></li>
                                                    						</ul>

					</nav>
				</div>
			</section>
                </div>

        
<tr> <td Width=15%>Bienvenue <%=p.getNom()%></td>
</tr><%}%>
         <h1>Formulaire d'affectation</h1>
        <form method="get" action="/SuperMercado-war/DirecteurServlet">
        <fieldset>
        
        <label for="dateDebut">Date de début d'affectation <span class="requis">*</span></label>
        <input type="date" name="dateDebut" value="" size="20" maxlength="20" required/>
        <br />
        
        <label for="dateFin">Date de fin d'affectation <span class="requis">*</span></label>
        <input type="date" name="dateFin" value="" size="20" maxlength="20" required />
        <br />

        
        <label for="id">Caisse : <span class="requis">*</span></label>
        <SELECT name="idCaisse" size="1">
            <%
            for(Caisse c: listeCaisse2){ %>
            <OPTION><%=c.getId().toString()%>
              <%}%>
        </SELECT>
        
        <label for="nomAgentCaisse">Agent de caisse à affecter<span class="requis">*</span></label>
        <SELECT name="nomAgentCaisse" size="1">
            <%
            for(AgentCaisse ac: listeAgentCaisse2){ %>
            <OPTION value="<%=ac.getId().toString()%>"><%=ac.getNom() %>
              <%}%>
        </SELECT>
        <br />
        <input type="hidden" name="magasin" value="<%=p.getMagasin().getNomMagasin()%>" />
        <br />
        <input type="hidden" name="action" value="insererAffectation">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>

     <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>

