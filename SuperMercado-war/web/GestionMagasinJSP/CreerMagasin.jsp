<%-- 
    Document   : CreerMagasin
    Created on : 13 mars 2018, 12:00:11
    Author     : Soldat
--%>
<% 
        
    if (session.getAttribute("personneConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="test.css" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulaire de création magasin</h1>
        <form method="post" action="/SuperMercado-war/Admin">
        <fieldset>
        <legend>Informations Magasin (majuscules et accents interdits)</legend>
        <label for="libelleMagasin">Libéllé Magasin <span class="requis">*</span></label>
        <input type="text" name="libelleMagasin" value="" size="20" maxlength="20" required/>
        <br />
        <label for="adresse"> Adresse <span class="requis">*</span></label>
        <input type="text" name="adresse" value="" size="20" maxlength="20" required/>
        <br />
        <label for="codePostal">Code Postal <span class="requis">*</span></label>
        <input type="text" name="codePostal" value="" size="20" maxlength="20" required/>
        <br />
        <input type="hidden" name="action" value="insererMagasin">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
    </body>
</html>
