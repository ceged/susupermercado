<%-- 
    Document   : CreerDirecteur
    Created on : 13 mars 2018, 13:25:44
    Author     : Soldat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="test.css" type="text/css">
        <title>JSP Page</title>
    <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>
    <%@ include file="/include/sidebar_admin.jsp" %>
    <body>
        <h1>Formulaire de création directeur</h1>
        <center> 
            <form method="get" action="/SuperMercado-war/Admin">
        <fieldset>
        <legend>Informations Directeur (majuscules et accents interdits)</legend>
        <label for="nom">Nom <span class="requis">*</span></label>
        <input type="text" name="nom" value="" size="20" maxlength="20" />
        <br />
        <label for="prenom"> Prénom <span class="requis">*</span></label>
        <input type="text" name="prenom" value="" size="20" maxlength="20" />
        <br />
        <label for="login">Login <span class="requis">*</span></label>
        <input type="text" name="login" value="" size="20" maxlength="20" />
        <br />
        <label for="mdp">Mot de passe <span class="requis">*</span></label>
        <input type="text" name="mdp" value="" size="20" maxlength="20" />
        <br />
        <label for="sexe">Sexe <span class="requis">*</span></label>
        <SELECT name="sexe" size="1">
        <OPTION>Masculin
        <OPTION>Féminin
        </SELECT>
        <br />
        <label for="dob">Date de naissance <span class="requis">*</span></label>
        <input type="date" name="dob" value="" size="20" maxlength="20" />
        <br />
        <label for="adresse">Adresse <span class="requis">*</span></label>
        <input type="text" name="adresse" value="" size="20" maxlength="20" />
        <br />
        <label for="codePostal">Code Postal <span class="requis">*</span></label>
        <input type="text" name="codePostal" value="" size="20" maxlength="20" />
        <br />
        <label for="magasin">Magasin <span class="requis">*</span></label>
        <input type="text" name="magasin" value="" size="20" maxlength="20" />
        <br />
        <input type="hidden" name="action" value="insererDirecteur">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
            </center> 
     <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
