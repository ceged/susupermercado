<%-- 
    Document   : CreerCaisse
    Created on : 14 mars 2018, 14:44:46
    Author     : tangu_000
--%>

<%@page import="java.util.List"%>
<%@page import="entités.gestionMagasin.Magasin"%>
<%@page import="entités.gestionMagasin.DirecteurMagasin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
        <link rel="stylesheet" href="test.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:useBean id="directeurConnecte" scope="session" class="DirecteurMagasin"></jsp:useBean>
<jsp:useBean id="listeMagasins" scope="session" class="List<Magasin>"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
<% DirecteurMagasin a= directeurConnecte;
    List<Magasin> listeMagasin2 =listeMagasins;{%>
<tr> <td Width=15%>Bienvenue <%=a.getNom()%></td>
</tr><%}%>
        <h1>Formulaire de création de Caisse</h1>
        <form method="get" action="/SuperMercado-war/DirecteurServlet">
        <fieldset>
        <legend>Informations caisses(majuscules et accents interdits)</legend>
                <label for="libelleMagasin">Secteur <span class="requis">*</span></label>
        <SELECT name="libelleMagasin" size="1">
            <%
            for(Magasin s: listeMagasin2){ %>
            <OPTION><%=s.getNomMagasin()%>
                <%}%>
        </SELECT>
        <br />
        <label for="idCaisse">Numéro caisse<span class="requis">*</span></label>
        <input type="number" name="idCaisse" value="" size="20" maxlength="20" />
        <br />

        <input type="hidden" name="action" value="insererCaisse">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
    </body>
</html>