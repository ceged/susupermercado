<%@page import="entités.gestionMagasin.Secteur"%>
<%@page import="java.util.List"%>
<%@page import="entités.gestionMagasin.DirecteurMagasin"%>
²<%-- 
    Document   : CreerRayon
    Created on : 13 mars 2018, 17:37:52
    Author     : tangu_000
--%>
<% 
        
    if (session.getAttribute("directeurConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
        <link rel="stylesheet" href="test.css" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
<jsp:useBean id="directeurConnecte" scope="session" class="DirecteurMagasin"></jsp:useBean>
<jsp:useBean id="listeSecteur" scope="session" class="List<Secteur>"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
<% DirecteurMagasin a= directeurConnecte;
    List<Secteur> listeSecteur2 =listeSecteur;{%>
<tr> <td Width=15%>Bienvenue <%=a.getNom()%></td>
</tr><%}%>
        <h1>Formulaire de création de rayon</h1>
        <form method="get" action="/SuperMercado-war/DirecteurServlet">
        <fieldset>
        <legend>Informations Rayon (majuscules et accents interdits)</legend>
        <label for="libellesecteur">Secteur <span class="requis">*</span></label>
        <SELECT name="libellesecteur" size="1">
            <%
            for(Secteur s: listeSecteur2){ %>
            <OPTION><%=s.getLibelleSecteur()%>
                <%}%>
        </SELECT>
        <br />
        <label for="libelleRayon">Nom du Rayon<span class="requis">*</span></label>
        <input type="text" name="libelleRayon" value="" size="20" maxlength="20" required/>
        <br />

        <input type="hidden" name="action" value="insererRayon">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
    </body>
</html>