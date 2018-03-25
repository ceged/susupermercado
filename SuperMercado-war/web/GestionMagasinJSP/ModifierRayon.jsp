<%-- 
    Document   : ModifierRayon
    Created on : 16 mars 2018, 14:35:05
    Author     : tangu_000
--%>

<%@page import="entités.gestionMagasin.Rayon"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="entités.gestionMagasin.DirecteurMagasin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="test.css" type="text/css">
         <jsp:useBean id="directeurConnecte" scope="session" class="DirecteurMagasin"></jsp:useBean>
        <jsp:useBean id="listeRayonModifie" scope="session" class="List<Rayon>"></jsp:useBean>
        <title>JSP Page</title>
    <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>
    <%@ include file="/include/sidebar.jsp" %>
    <body>
        <% DirecteurMagasin d= directeurConnecte;
List<Rayon> listeRayon2 =listeRayonModifie;{%>
<tr> <td Width=15%>Bienvenue <%=d.getNom()%></td>
</tr><%}%>
        <h1>Formulaire de modification rayon</h1>
       <center> 
           <form method="get" action="/SuperMercado-war/DirecteurServlet">
        <fieldset>
        <legend>Informations Rayon a modifier (majuscules et accents interdits)</legend>
        <br />
        <label for="libelleRayon">Rayon <span class="requis">*</span></label>
        <SELECT name="libelleRayon" size="1">
            <%
            for(Rayon r: listeRayon2){ %>
            <OPTION><%=r.getLibelleRayon()%>
                <%}%>
        </SELECT>
        <br />
        <label for="newLibelleRayon">Nouveau nom rayon <span class="requis">*</span></label>
        <input type="text" name="newLibelleRayon" value="" size="20" maxlength="20" />
        <br />
        <input type="hidden" name="magasin" value="<%=d.getMagasin().getNomMagasin()%>" />
        <br />
        <input type="hidden" name="action" value="modifierRayon">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
           </form>
       </center> 
      <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
