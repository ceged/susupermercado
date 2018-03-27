<%-- 
    Document   : CreerCategorie
    Created on : 13 mars 2018, 16:15:46
    Author     : CGAILLOTDREVON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Article.css" type="text/css">
        <title>JSP Page</title>
    <%@ include file="/include/css.jsp" %>
    </head>
     <%@ include file="/include/header.jsp" %>
     <%@ include file="/include/sidebar_admin.jsp" %>
    <body>
        <h1>Créer une catégorie</h1>
        
        
        <center> <form method="get" action="/SuperMercado-war/Admin">
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
        </center>
        
        <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
 
