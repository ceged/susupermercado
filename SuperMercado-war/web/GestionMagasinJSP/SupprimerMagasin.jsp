<%-- 
    Document   : SupprimerMagasin
    Created on : 15 mars 2018, 09:43:45
    Author     : tangu_000
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entités.gestionMagasin.Magasin"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="test.css" type="text/css">
        <jsp:useBean id="listeMagasin" scope="session" class="List<Magasin>"></jsp:useBean>
        <title>JSP Page</title>
    <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>
    <%@ include file="/include/sidebar.jsp" %>
    <body>
        <h1>Formulaire de suppression magasin</h1>
       <center> 
           <form method="get" action="/SuperMercado-war/Admin">
        <fieldset>
        <legend>Informations Magasin a supprimer (majuscules et accents interdits)</legend>
        <label for="nomMagasin">Magasin a supprimer <span class="requis">*</span></label>
        <SELECT name="nomMagasin" size="1">
            <%
            for(Magasin m: listeMagasin){ %>
            <OPTION><%=m.getNomMagasin()%>
                <%}%>
        </SELECT>
        
        <input type="hidden" name="action" value="supprimerMagasin">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
        </center> 
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>




        