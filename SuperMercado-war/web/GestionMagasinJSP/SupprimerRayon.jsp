<%-- 
    Document   : SupprimerRayon
    Created on : 15 mars 2018, 16:07:59
    Author     : tangu_000
--%>

<%@page import="entités.gestionMagasin.DirecteurMagasin"%>
<%@page import="entités.gestionMagasin.Secteur"%>
<%@page import="entités.gestionMagasin.Rayon"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="test.css" type="text/css">
        <jsp:useBean id="listeRayon" scope="session" class="List<Rayon>"></jsp:useBean>
        <title>JSP Page</title>
    <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>
    <%@ include file="/include/sidebar_dir.jsp" %>
    <body>
 <% 
List<Rayon> listeRayon2 =listeRayon;{%>

        <h1>Formulaire de suppression caisse</h1>
        <center> 
            <form method="get" action="/SuperMercado-war/DirecteurServlet">
        <fieldset>
        <legend>Informations Rayon a supprimer (majuscules et accents interdits)</legend>
        
        <label for="libelleRayon">Rayon<span class="requis">*</span></label>
        <SELECT name="libelleRayon" size="1">
            <%
            for(Rayon r: listeRayon2){ %>
            <OPTION><%=r.getLibelleRayon()%>
                <%}%>    
        </SELECT>
        <br /> 
        <input type="hidden" name="nomMagasin" value="<%=p.getMagasin().getNomMagasin()%>" />
        <br />
        <input type="hidden" name="action" value="supprimerRayon">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
        </center> 
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
