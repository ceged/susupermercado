<%-- 
    Document   : CreerCreneau
    Created on : 21 mars 2018, 15:01:15
    Author     : Soldat
--%>
<% 
        
    if (session.getAttribute("agentLivraisonConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>


<%@page import="entités.gestionLivraison.AgentLivraison"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="agentLivraisonConnecte" scope="session" class="AgentLivraison"></jsp:useBean>
        <title> Créer un créneau </title>
      <%@ include file="/include/css.jsp" %>
    </head>
     <%@ include file="/include/header.jsp" %>
     <%@ include file="/include/sidebar_agentlivraison.jsp" %>
     
    <body>
    <center>
        <form method="get" action="/SuperMercado-war/AgentLivraisonServlet">
        <fieldset>
        <legend>Informations du créneau (2h)</legend>
        <label for="date"> Date du créneau <span class="requis">*</span></label>
        <input type="date" name="date" value="" size="20" maxlength="20" />
        <br />
        <label for="heureDebut"> Heure début <span class="requis">*</span></label>
        <input type="time" name="heureDebut" value="" size="20" maxlength="20" />
        <br />
        <label for="heureFin"> Heure fin <span class="requis">*</span></label>
        <input type="time" name="heureFin" value="" size="20" maxlength="20" />
        <br />
        <input type="hidden" name="agentId" value="<%=agentLivraisonConnecte.getId()%>">
        <input type="hidden" name="action" value="insererCreneau">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
      </center> 
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
