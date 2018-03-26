<%-- 
   Document   : ModifierRayon
    Created on : 16 mars 2018, 14:35:05
    Author     : tangu_000
--%>



<%@page import="entités.gestionMagasin.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="text.css" type="text/css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
        <title>JSP Page</title>
    <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>
    <%@ include file="/include/sidebar_dir.jsp" %>
    <body>
        

        
        <p> <%
        String attribut = (String) request.getAttribute("message");
        if(attribut==null){
            attribut="Aucune action effectuée";
        }
        else{
        out.println( attribut );}
        %> </p>
     <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
