<%-- 
    Document   : CreerSecteur
    Created on : 13 mars 2018, 14:39:53
    Author     : Sophia
--%>
<% 
        
    if (session.getAttribute("directeurConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>

<%@page import="entités.gestionMagasin.DirecteurMagasin"%>
<%@page import="entités.gestionMagasin.Personne"%>
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
        <h1>Formulaire de création de secteur</h1>
        <form method="get" action="/SuperMercado-war/DirecteurServlet">
        <fieldset>
        <legend>Informations Secteur (majuscules et accents interdits)</legend>
        <label for="libelleSecteur">Nom du Secteur <span class="requis">*</span></label>
        <input type="text" name="libelleSecteur" value="" size="20" maxlength="20" required/>
        <br />
        <input type="hidden" name="magasinSecteur" value="<%=a.getMagasin().getNomMagasin()%>" />
        <br />
        <input type="hidden" name="action" value="insererSecteur">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
    </body>
</html>
        

        
