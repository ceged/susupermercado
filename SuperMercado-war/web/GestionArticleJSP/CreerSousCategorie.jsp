<%@page import="entités.gestionArticle.Categorie"%>
<%@page import="java.util.List"%>

<%-- 
    Document   : CreerSousCategorie
    Created on : 14 mars 2018, 15:43:25
    Author     : CGAILLOTDREVON
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Article.css" type="text/css">
        <jsp:useBean id="listeCategorie" scope="session" class="List<Categorie>"></jsp:useBean>
        <title>JSP Page</title>
    <%@ include file="/include/css.jsp" %>
    </head>
     <%@ include file="/include/header.jsp" %>
     <%@ include file="/include/sidebar_admin.jsp" %>
    <body>
 
        
            <h1>Créer une sous-catégorie</h1>
        
        <center> <form method="get" action="/SuperMercado-war/Admin">
        <fieldset>
            
        <legend>libellé Catégorie (majuscules et accents interdits)</legend>
        <label for="libelleCategorie">Catégorie <span class="requis">*</span></label>
        <SELECT name="libelleCategorie" size="1">
            <%
            for(Categorie s: listeCategorie){ %>
            <OPTION><%=s.getLibelleCategorie()%>
                <%}%>
        </SELECT>
        
        
        <legend>libellé sous - catégorie (majuscules et accents interdits)</legend>
        <label for="libelleSousCategorie">Libellé sous-catégorie <span class="requis">*</span></label>
        <input type="text" name="libelleSousCategorie" value="" size="20" maxlength="20" required/>
        <br />
        <input type="hidden" name="action" value="insererSousCategorie">
        </fieldset>
        
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form> 
        </center> 
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
