<%-- 
    Document   : ModifierMdp
    Created on : 16 mars 2018, 10:17:30
    Author     : Sophia
--%>
<% 
        
    if (session.getAttribute("personneConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>

<%@page import="entités.gestionMagasin.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="personneConnecte" scope="session" class="Personne"></jsp:useBean>    
        <title>JSP Page</title>
 <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>
<body>
<%Personne p = personneConnecte;{%>
<tr> <td Width=15%>Bienvenue <%=p.getPrenom()%></td>
        <h1>Formulaire de changement de mot de passe</h1>
<%}%>
<center>
    
<form method="get" action="/SuperMercado-war/Menu">
<fieldset>
<legend>Informations</legend>
<label for="ancienMdp">Ancien mot de passe<span class="requis">*</span></label>
<input type="password" name="ancienMdp" value="" size="20" maxlength="20" required/>
<br>
<label for="nouveauMdp">Nouveau mot de passe<span class="requis">*</span></label>
<input type="password" name="nouveauMdp" value="" size="20" maxlength="20" required/>
</fieldset>
    <input type="hidden" name="id" value="<%=p.getId()%>"/>
    <br />
    <input type="hidden" name="action" value="modifierMdp"/>
    <br />
    <input type="submit" value="Valider" />
</form>
    </center>
     <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
