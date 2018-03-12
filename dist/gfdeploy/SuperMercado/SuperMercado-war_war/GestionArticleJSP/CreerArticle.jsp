<%-- 
    Document   : CreerArticle
    Created on : 12 mars 2018, 09:47:40
    Author     : PC Tim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulaire de création d'article</h1>
        <form method="get" action="Menu">
        <fieldset>
        <legend>Informations Ouvrage (majuscules et accents interdits)</legend>
        <label for="">Numéro <span class="requis">*</span></label>
        <input type="number" name="numeroOuvrage" value="" size="20" maxlength="20" />
        <br />
        <label for="titreOuvrage">Titre <span class="requis">*</span></label>
        <input type="text" name="titreOuvrage" value="" size="20" maxlength="20" />
        <br />
        <label for="auteurOuvrage">Auteur <span class="requis">*</span></label>
        <input type="text" name="auteurOuvrage" value="" size="20" maxlength="20" />
        <br />
        <label for="editeurOuvrage">Éditeur <span class="requis">*</span></label>
        <input type="text" name="editeurOuvrage" value="" size="20" maxlength="20" />
        <br />
        <label for="motCle">Mots clés<span class="requis">*</span></label><br />
        <input type="checkbox" name="histoire" value="histoire" size="20"/>Histoire
        <input type="checkbox" name="drame" value="drame" size="20"/>Drame
        <input type="checkbox" name="fantastique" value="fantastique" size="20"/>Fantastique
        <input type="checkbox" name="roman" value="roman" size="20"/>Roman
        <br />
        <input type="hidden" name="action" value="insererOuvrage">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
    </body>
</html>
