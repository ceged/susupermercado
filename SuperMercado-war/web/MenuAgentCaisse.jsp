<%-- 
    Document   : MenuAgentCaisse
    Created on : 16 mars 2018, 15:19:32
    Author     : CGAILLOTDREVON
--%>

<%@page import="entités.gestionMagasin.AgentCaisse"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="agentCaisse" scope="session" class="AgentCaisse"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>

<tr> <td Width=15%>Bienvenue <%=agentCaisse.getPrenom()%></td>
</tr>
        <h1>Bienvenue sur le menu Caisse !</h1>
        
        <A HREF="EmployeCaisseServlet?action=passageInfoCreerAchatCaisse&idAgent=<%=agentCaisse.getId()%>">
        Créer un achat</A><br/><br/>
        <A HREF="Accueil.jsp">
        Sortir menu principal</A><br/><br/>
       
        
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
