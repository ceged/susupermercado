<%-- 
    Document   : CreerCaisse
    Created on : 14 mars 2018, 14:44:46
    Author     : tangu_000
--%>
<% 
        
    if (session.getAttribute("directeurConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>

<%@page import="java.util.List"%>
<%@page import="entités.gestionMagasin.Magasin"%>
<%@page import="entités.gestionMagasin.DirecteurMagasin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="test.css" type="text/css">
        <jsp:useBean id="directeurConnecte" scope="session" class="DirecteurMagasin"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
<% DirecteurMagasin a= directeurConnecte;{%>
<tr> <td Width=15%>Bienvenue <%=a.getNom()%></td>
</tr><%}%>
        <h1>Formulaire de création de caisse</h1>
        <form method="get" action="/SuperMercado-war/DirecteurServlet">
        <fieldset>
        <legend>Informations Caisse (majuscules et accents interdits)</legend>
        <label for="id">Numéro de la caisse <span class="requis">*</span></label>
        <input type="text" name="id" value="" size="20" maxlength="20" required/>
        <br />
        <input type="hidden" name="magasinCaisse" value="<%=a.getMagasin().getNomMagasin()%>" required/>
        <br />
        <input type="hidden" name="action" value="insererCaisse" required>
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
    </body>
</html>