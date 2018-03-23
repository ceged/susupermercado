<%-- 
    Document   : SupprimerMagasin
    Created on : 15 mars 2018, 09:43:45
    Author     : tangu_000
--%>
<% 
        
    if (session.getAttribute("personneConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>

<%@page import="entités.gestionMagasin.Magasin"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="test.css" type="text/css">
        <jsp:useBean id="listeMagasin" scope="session" class="List<Magasin>"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulaire de suppression magasin</h1>
        <form method="get" action="/SuperMercado-war/Admin">
        <fieldset>
        <legend>Informations Magasin a supprimer (majuscules et accents interdits)</legend>
        <label for="nomMagasin">Magasin a supprimer <span class="requis">*</span></label>
        <SELECT name="nomMagasin" size="1">
            <%
            for(Magasin m: listeMagasin){ %>
            <OPTION><%=m.getNomMagasin()%>
                <%}%>
        </SELECT>
        
        <input type="hidden" name="action" value="supprimerMagasin">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
    </body>
</html>





        