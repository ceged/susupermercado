<%-- 
    Document   : CreerCategorie
    Created on : 13 mars 2018, 16:15:46
    Author     : CGAILLOTDREVON
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="agentRayonConnecte" scope="session" class="AgentRayon"></jsp:useBean>
        <link rel="stylesheet" href="text.css" type="text/css">
        <title>Saisir casse</title>
    </head>
    <body>
        <h1>Formulaire de saisie casse</h1>
        <tr> <td Width=15%>Bienvenue <%=agentRayonConnecte.getPrenom()%></td>
</tr>
        
        <form method="get" action="/SuperMercado-war/AgentRayonServlet">
        <fieldset>
        <label for="idLotArticle">Code barre du lot Article <span class="requis">*</span></label>
        <input type="number" name="idLotArticle" value="" size="20" maxlength="20" />
        <br />
        <label for="quantite">Quantité casse <span class="requis">*</span></label>
        <input type="number" name="quantite" value="" size="20" maxlength="20" />
        <br />
        <label for="motif">Motif de casse <span class="requis">*</span></label>
        <input type="text" name="motif" value="" size="20" maxlength="20" />
        <br />
        <input type="hidden" name="idAgent" value="<%=agentRayonConnecte.getId()%>">
        <input type="hidden" name="action" value="insererCasse">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>

    </body>
</html>
