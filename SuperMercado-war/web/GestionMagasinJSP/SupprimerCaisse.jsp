<%-- 
    Document   : SupprimerCaisse
    Created on : 16 mars 2018, 11:23:44
    Author     : tangu_000
--%>
<% 
        
    if (session.getAttribute("directeurConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>

<%@page import="entités.gestionMagasin.Caisse"%>
<%@page import="java.util.List"%>
<%@page import="entités.gestionMagasin.DirecteurMagasin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="test.css" type="text/css">
        <jsp:useBean id="directeurConnecte" scope="session" class="DirecteurMagasin"></jsp:useBean>
        <jsp:useBean id="listeCaisse" scope="session" class="List<Caisse>"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
 <% DirecteurMagasin a= directeurConnecte;
List<Caisse> listeCaisse2 =listeCaisse;{%>
<tr> <td Width=15%>Bienvenue <%=a.getNom()%></td>
</tr><%}%>
        <h1>Formulaire de suppression caisse</h1>
        <form method="get" action="/SuperMercado-war/DirecteurServlet">
        <fieldset>
        <legend>Informations caisses a supprimer (majuscules et accents interdits)</legend>
        
        <label for="id">Caisse<span class="requis">*</span></label>
        <SELECT name="id" size="1">
            <%
            for(Caisse c: listeCaisse2){ %>
            <OPTION><%=c.getId()%>
                <%}%>    
        </SELECT>
        <br /> 
        <input type="hidden" name="nomMagasin" value="<%=a.getMagasin().getNomMagasin()%>" />
        <br />
        <input type="hidden" name="action" value="supprimerCaisse">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
    </body>
</html>

