<%-- 
    Document   : AfficherCommandeEnCours
    Created on : 16 mars 2018, 15:57:17
    Author     : Soldat
--%>


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
        <jsp:useBean id="agentLivraisonConnecte" scope="session" class="AgentLivraison"></jsp:useBean>
<title>Liste des créneaux dispos</title>
</head>
<body>
<h1>Liste des créneaux</h1>
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
    <input type="hidden" name="idAgent" value="<%=agentLivraisonConnecte.getId()%>">
    <input type="hidden" name="action" value="passageDateChoisi">
    <input type="submit" value="Valider" />
</form>
<TABLE border width=50%>
<tr> <TD>Date</TD>
<TD>Heure début</TD>
<TD>Heure fin</TD>
<TD>Disponibilité</TD>
 </tr>
<%
for(Creneau c : liste){%>
<tr><td Width=15%><%=c.getDate() %></td>
<td Width=15%><%=c.getHeureDebut() %></td>
<td Width=15%><%=c.getHeureFin() %></td>
<td Width=15%><%=c.getDisponibilité() %></td>

</tr><%}%></TABLE>

<hr>
</body>
</html>
