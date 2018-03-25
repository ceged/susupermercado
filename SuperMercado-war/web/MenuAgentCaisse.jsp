<%-- 
    Document   : MenuAgentCaisse
    Created on : 16 mars 2018, 15:19:32
    Author     : CGAILLOTDREVON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>
    <%@ include file="/include/sidebar_caisse.jsp" %>
    <body>
        <h1>Bienvenue sur le menu Caisse !</h1>
        
        <A HREF="EmployeCaisseServlet?action=insererAchat">
        Créer un achat</A><br/><br/>
       
     <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
