<%-- 
    Document   : CreerCategorie
    Created on : 13 mars 2018, 16:15:46
    Author     : CGAILLOTDREVON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="text.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Créer une catégorie</h1>
        
        <form method="get" action="/SuperMercado-war/Admin">
        <fieldset>
        <legend>libellé Catégorie (majuscules et accents interdits)</legend>
        <label for="libelleCategorie">Libellé catégorie <span class="requis">*</span></label>
        <input type="text" name="libelleCategorie" value="" size="20" maxlength="20" />
        <br />
        <input type="hidden" name="action" value="insererCategorie">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
        
        
        <h1>Créer une sous-catégorie</h1>
        
        <form method="get" action="/SuperMercado-war/Admin">
        <fieldset>
        <legend>libellé Catégorie (majuscules et accents interdits)</legend>
        <label for="libelleCategorie">Libellé catégorie <span class="requis">*</span></label>
        <input type="text" name="libelleCategorie" value="" size="20" maxlength="20" />
        <br />
        
        <legend>libellé sous - catégorie (majuscules et accents interdits)</legend>
        <label for="libelleSousCategorie">Libellé sous-catégorie <span class="requis">*</span></label>
        <input type="text" name="libelleSousCategorie" value="" size="20" maxlength="20" />
        <br />
        
        <input type="hidden" name="action" value="insererSousCategorie">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
        
    </body>
</html>
