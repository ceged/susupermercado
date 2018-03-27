<% 
        
    if (session.getAttribute("fournisseurConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>

<%@page import="entités.gestionCommande.Fournisseur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="fournisseurConnecte" scope="session" class="Fournisseur"></jsp:useBean>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
    </head>
    <body>
        <% Fournisseur f= fournisseurConnecte;{%>
<tr> <td Width=15%>Bienvenue <%=f.getPrenom()%></td>
</tr><%}%>
        <h1>Bienvenue sur le menu Fournisseur !</h1>
        <A HREF="FournisseurServlet?action=passageInfosListeCommande&fournisseur=<%=f.getId()%>">
        Consulter mes commandes</A><br/><br/>
        <A HREF="Menu?action=CasterEnPersonne&idPersonneSession=<%=f.getId()%>">
        Modifier mon mot de passe</A><br/><br/>
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