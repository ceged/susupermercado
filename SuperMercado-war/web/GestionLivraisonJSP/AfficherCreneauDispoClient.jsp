<%-- 
    Document   : AfficherCommandeEnCours
    Created on : 16 mars 2018, 15:57:17
    Author     : Soldat
--%>
<% 
        
    if (session.getAttribute("clientConnecte") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>

<%@page import="entités.gestionVenteEnLigne.AchatEnLigne"%>
<%@page import="entités.gestionMagasin.Magasin"%>
<%@page import="entités.gestionLivraison.AgentLivraison"%>
<%@page import="entités.gestionVenteEnLigne.Creneau"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
        <jsp:useBean id="liste" scope="session" class="List<Creneau>"></jsp:useBean>
        <jsp:useBean id="magasin" scope="session" class="Magasin"></jsp:useBean>
        <jsp:useBean id="achatLigne" scope="session" class="AchatEnLigne"></jsp:useBean>
<title>Liste des créneaux dispos client</title>
</head>
<body>
<h1>Liste des créneaux client</h1>
<p> <%
String attribut = (String) request.getAttribute("message");
if(attribut!=null){
    out.println( attribut );
            }
%> </p>
<A HREF="MenuAgentLivraison.jsp">Retour au menu</A><br />
<form method="get" action="/SuperMercado-war/AgentLivraisonServlet">
    <label for="dateChoisi">Choisir une date <span class="requis">*</span></label>
    <input type="date" name="date" value="" size="20" maxlength="20" />
    <input type="hidden" name="nomMagasin" value="<%=magasin.getNomMagasin() %>">
    <input type="hidden" name="action" value="passageDateChoisiClient">
    <input type="submit" value="Valider" />
</form>
<TABLE border width=50%>
<tr> <TD>Date</TD>
<TD>Heure début</TD>
<TD>Heure fin</TD>
<TD>Disponibilité</TD>
<TD>Choisir ce créneau</TD>
 </tr>
<%
for(Creneau c : liste){%>
<tr><td Width=15%><%=c.getDate() %></td>
<td Width=15%><%=c.getHeureDebut() %></td>
<td Width=15%><%=c.getHeureFin() %></td>
<td Width=15%><%=c.getDisponibilité() %></td>
<td Width=15%>
   <form method="get" action="/SuperMercado-war/ClientServlet">
    <input type="hidden" name="idCreneau" value="<%=c.getId() %>">
    <input type="hidden" name="achatLigne" value="<%=achatLigne.getId()%>">
    <input type="hidden" name="action" value="ChoisiCreneau">
    <input type="submit" value="Valider" />
</form>
</td>
</tr><%}%></TABLE>

<hr>
</body>
</html>
