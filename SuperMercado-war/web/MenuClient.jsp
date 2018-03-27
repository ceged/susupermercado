<%-- 
    Document   : MenuClient
    Created on : 19 mars 2018, 16:18:05
    Author     : Sophia
--%>

<%@page import="entités.gestionVenteEnLigne.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="client" scope="session" class="Client"></jsp:useBean>
        <title>JSP Page</title>
    <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>
    <%@ include file="/include/sidebar.jsp" %>
    
    <body>
         <% Client c= client;{%>
<tr> <td Width=15%>Bienvenue <%=c.getPrenom()%></td>
    </tr><%}%>
        <h1>Menu Client</h1>
        
        <%@ include file="/include/flexslider.jsp" %>
        
        <center>
        
        <A HREF="ClientServlet?action=transferListeMagasin">
        Vente en ligne</A><br/><br/>
        <A HREF="Accueil.jsp">
        Sortir menu principal</A><br/><br/>
        </center>
        
        
        
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
