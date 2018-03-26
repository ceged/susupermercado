<%-- 
    Document   : AfficherListeArticles
    Created on : 20 mars 2018, 10:59:08
    Author     : Sophia
--%>


<%@page import="entités.gestionVenteEnLigne.AchatEnLigne"%>
<%@page import="entités.gestionMagasin.Magasin"%>
<%@page import="entités.gestionArticle.ReferentielArticle"%>
<%@page import="java.util.List"%>
<%@page import="entités.gestionVenteEnLigne.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
        <title>JSP Page</title>
        <jsp:useBean id="magasinChoisi" scope="session" class="Magasin"></jsp:useBean>
        <jsp:useBean id="client" scope="session" class="Client"></jsp:useBean>
        <jsp:useBean id="listeArticle" scope="session" class="List<ReferentielArticle>"></jsp:useBean>
        <jsp:useBean id="achatEnCours" scope="session" class="AchatEnLigne"></jsp:useBean>
        
    <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>
    <%@ include file="/include/sidebar.jsp" %>
    <body>
        <% Magasin m= magasinChoisi;
        Client c = client;
        AchatEnLigne ach = achatEnCours;%>
        <h1></h1>
        <form method="get" action="/SuperMercado-war/ClientServlet">
            <fieldset>
                <td Width=15%>Bienvenue <%=c.getPrenom()%></td>   
                <br />
                <label for="nomMagasin">Articles disponibles pour le magasin <%=m.getNomMagasin()%> <span class="requis"></span></label>
                <br />
        
                <% for(ReferentielArticle a: listeArticle){ %>
                <input type="radio" name="article" value=<%=a.getCodeBarre()%> size="20"/>
                <label><%=a.getLibelleArticle()%></label> <br />
                <%}%>  
                
                 <br />
                    <input type="hidden" name="idClient" value=<%=c.getId()%>>
                    <input type="hidden" name="idAchat" value=<%=ach.getId()%>>
                    <input type="hidden" id="idqte" name="quantite" value="">
                <button onclick="getQuantite()" id="action" name="action" value=""> Ajouter au panier</button>
                <input type="reset" value="Remettre à zéro" /> <br />
            </fieldset>
            <button name="action2" value="consulterVotrePanier"> consulter votre panier </button>
        </form> 
        <form method="get" action="/SuperMercado-war/ClientServlet">
      <input type="hidden" name="action" value="transferListeMagasin">
      <button type="submit">Changer de magasin</button> 
        </form>
        <script>
            function getQuantite() {
            var qte = prompt("Quelle quantité souhaitez vous achetez?", "");
            if (qte !== null) {
            document.getElementById('idqte').value = qte;
            document.getElementById('action').value = "insererLignePanier";
            }
            else {
                document.getElementById('action').value = "annulerInsertionLigne";
            }
            }
        </script>
            <p>      <%
String attribut = (String) request.getAttribute("message");
if(attribut!=null){
    out.println( attribut );
            }
%> 
      </p>
    </body>
</html>

