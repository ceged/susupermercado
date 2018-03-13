<%-- 
    Document   : MenuDirecteur
    Created on : 13 mars 2018, 13:50:24
    Author     : Soldat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<body>  
    <A HREF="GestionMagasinJSP/CreerSecteur.jsp">Créer un Secteur</A>
        <br/><br/>
    <A HREF="Accueil.jsp">Sortir menu principal</A>
        <br/><br/>
    
        <p> <%
        String attribut = (String) request.getAttribute("message");
        if(attribut==null){
            attribut="Aucune action effectuée";
        }
        else{
        out.println( attribut );}
        %> </p>
      
    </body>
</html>
