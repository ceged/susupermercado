<%-- 
    Document   : CreerCategorie
    Created on : 13 mars 2018, 16:15:46
    Author     : CGAILLOTDREVON
--%>
<% 
        
    if (session.getAttribute("personneConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Créer une catégorie</h1>
        
        
        <form method="get" action="/SuperMercado-war/Admin" acceptCharset="utf-8">
        <fieldset>
        <legend>libellé Catégorie (majuscules et accents interdits)</legend>
        <label for="libelleCategorie">Libellé catégorie <span class="requis">*</span></label>
        <input type="text" name="libelleCategorie" value="" size="20" maxlength="20" required />
        <br />
        <input type="hidden" name="action" value="insererCategorie">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
        
        
        
        
    </body>
</html>
