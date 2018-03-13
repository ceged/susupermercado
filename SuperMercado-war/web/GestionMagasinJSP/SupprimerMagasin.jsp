<%-- 
    Document   : SupprimerMagasin
    Created on : 13 mars 2018, 15:14:03
    Author     : tangu_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Magasin Page</title>
    </head>
    <body>
        <h1>Formulaire de suppression magasin</h1>
        <form method="delete" action="/SuperMercado-war/Menu">
        <fieldset>
        <legend>Indiquer le Magasin à supprimer (majuscules et accents interdits)</legend>
        <label for="libelleMagasin">Libéllé Magasin <span class="requis">*</span></label>
        <input type="text" name="libelleMagasin" value="" size="20" maxlength="20" />
        <br />
        
        <input type="hidden" name="action" value="supprimerMagasin">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
    </body>
</html>