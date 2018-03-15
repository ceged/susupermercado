<%-- 
    Document   : Connexion
    Created on : 12 mars 2018, 17:36:17
    Author     : PC Tim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
        <title>Page de connexion</title>
    </head>
    <body>
        <h1>Identifiants de connexion</h1>
        <form method="get" action="Menu">
        <label for="loginUser">Login <span class="requis">*</span></label>
        <input type="text" name="loginUser" value="" size="20" maxlength="20" />
        <br />
        <label for="mdpUser">Mot de passe <span class="requis">*</span></label>
        <input type="password" name="mdpUser" value="" size="20" maxlength="20" />
        <br /><br />
        <input type="hidden" name="action" value="connexionUser">
        <input type="submit" value="Valider" />
        </form>
    </body>
</html>
