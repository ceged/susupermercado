<%-- 
    Document   : CreerFournisseur
    Created on : 14 mars 2018, 11:59:16
    Author     : Sophia
--%>
<% 
        
    if (session.getAttribute("chefRayonConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>


<%@page import="entités.gestionMagasin.Rayon"%>
<%@page import="java.util.List"%>
<%@page import="entités.gestionMagasin.DirecteurMagasin"%>
<%@page import="entités.gestionMagasin.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
        <title>JSP Page</title>
      <%@ include file="/include/css.jsp" %>
    </head>
     <%@ include file="/include/header.jsp" %>
     <%@ include file="/include/sidebar_chefrayon.jsp" %>
     
    <body>

         <h1>Formulaire de création Fournisseur</h1>
    <center>
        <form method="get" action="/SuperMercado-war/ChefRayonServlet">
        <fieldset>
        <legend>Informations Fournisseur (majuscules et accents interdits)</legend>
        <label for="nom">Nom <span class="requis">*</span></label>
        <input type="text" name="nom" value="" size="20" maxlength="20" required/>
        <br />
        <label for="prenom"> Prénom <span class="requis">*</span></label>
        <input type="text" name="prenom" value="" size="20" maxlength="20"/>
        <br />
        <label for="login">Login <span class="requis">*</span></label>
        <input type="text" name="login" value="" size="20" maxlength="20" required/>
        <br />
        <label for="mdp">Mot de passe <span class="requis">*</span></label>
        <input type="text" name="mdp" value="" size="20" maxlength="20" required />
        <br />
        <label for="sexe">Sexe <span class="requis">*</span></label>
        <SELECT name="sexe" size="1">
        <OPTION value="masculin">Masculin
        <OPTION value="feminin">Féminin
        </SELECT>
        <br />
        <label for="dob">Date de naissance <span class="requis">*</span></label>
        <input type="date" name="dob" value="" size="20" maxlength="20" required/>
        <br />
        <label for="adresse">Adresse <span class="requis">*</span></label>
        <input type="text" name="adresse" value="" size="20" maxlength="20" required />
        <br />
        <label for="codePostal">Code Postal <span class="requis">*</span></label>
        <input type="number" name="codePostal" value="" size="5" maxlength="5" required/>
        <br />
        <input type="hidden" name="action" value="insererFournisseur">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
      </center> 
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
        
