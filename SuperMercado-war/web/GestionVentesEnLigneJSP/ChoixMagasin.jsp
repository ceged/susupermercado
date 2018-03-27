<%-- 
    Document   : ChoixMagasin
    Created on : 19 mars 2018, 17:54:00
    Author     : Sophia
--%>

<%@page import="java.util.List"%>
<%@page import="entités.gestionMagasin.Magasin"%>
<%@page import="entités.gestionVenteEnLigne.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
        <title>JSP Page</title>
        <jsp:useBean id="client" scope="session" class="Client"></jsp:useBean>
        <jsp:useBean id="listeMagasin" scope="session" class="List<Magasin>"></jsp:useBean>
    </head>
    <body>
         <% Client c = client;%>
        <h1>Choisissez un magasin</h1>
        <form method="get" action="/SuperMercado-war/ClientServlet">
        <fieldset>

        
        <label for="magasin">Magasin : <span class="requis">*</span></label>
         <%
            for(Magasin m: listeMagasin){ %>
            <input type="radio" name="magasin" value="<%=m.getNomMagasin()%>" size="20"/><%=m.getNomMagasin()%>
                <%}%>
        <br />
        <input type="hidden" name="idClient" value=<%=c.getId()%>>
        <input type="hidden" name="action" value="transferArticlesParMagasin" >
        </fieldset> 
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>
        
        <p>      <%
String attribut = (String) request.getAttribute("message");
if(attribut!=null){
    out.println( attribut );
            }
%> 
      </p>
        
    </body>
</html>
