<%-- 
    Document   : CreerCasse
    Created on : 19 mars 2018, 11:36:48
    Author     : CGAILLOTDREVON
--%>

<%@page import="entités.gestionMagasin.AgentRayon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="essai.css" type="text/css">
        <jsp:useBean id="AgentRayonConnecte" scope="session" class="AgentRayon"></jsp:useBean>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% AgentRayon a= AgentRayonConnecte;{%>
        <h1>Saisie de la casse article</h1>
        <form method="get" action="/SuperMercado-war/AgentRayonServlet">
        <fieldset>
        <br />
        <label for="idLotArticle">Id de l'article<span class="requis">*</span></label>
        <input input type="number" name="idLotArticle" min="0" max="2000"/>
        <br />
        
        <br />
        <label for="QteCasse">Quantité casse article<span class="requis">*</span></label>
        <input input type="number" name="QteCasse" min="0" max="2000"/>
        <br />
        
        <legend>Informations Casse (majuscules et accents interdits)</legend>
        <label for="motifCasse">Motif Casse <span class="requis">*</span></label>
        <input type="text" name="motifCasse" value="" size="60" maxlength="60" />
        <br />
        
        <input type="hidden" name="idAgentRayon" value="<%=a.getId()%>" />
        <br />
        <input type="hidden" name="action" value="insererCasse">
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </fieldset>
        </form>
    </body>
</html>
