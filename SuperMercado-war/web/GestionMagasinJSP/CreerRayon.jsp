²<%-- 
    Document   : CreerRayon
    Created on : 13 mars 2018, 17:37:52
    Author     : tangu_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
        <link rel="stylesheet" href="test.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulaire de création de rayon</h1>
        <form method="get" action="/SuperMercado-war/DirecteurServlet">
        <fieldset>
        <legend>Informations Rayon (majuscules et accents interdits)</legend>
        <label for="libelleRayon">Nom du Rayon<span class="requis">*</span></label>
        <input type="text" name="libelleRayon" value="" size="20" maxlength="20" />
        <br />
        <label for="Secteur">Secteur <span class="requis">*</span></label>
        <input type="text" name="Secteur" value="" size="20" maxlength="20" />
        <br />
        <label for="ChefRayon">Chef de rayon <span class="requis">*</span></label>
        <input type="text" name="ChefRayon" value="" size="20" maxlength="20" />
        <br />
        <input type="hidden" name="action" value="insererRayon">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
    </body>
</html>