<%-- 
    Document   : AfficherPanierEnCours
    Created on : 21 mars 2018, 17:22:18
    Author     : Sophia
--%>

<%@page import="entités.gestionVenteEnLigne.AchatEnLigne"%>
<%@page import="entités.gestionArticle.LigneAchat"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:useBean id="listeLignesPanier" scope="session" class="List<LigneAchat>"></jsp:useBean>
        <jsp:useBean id="achatEnCours" scope="session" class="AchatEnLigne"></jsp:useBean>
    </head>
    <body>
        <h1>Mon Panier!</h1>
        <form>
            
        </form>
        <TABLE border width=50%>
<tr> 
<TD>Article</TD>
<TD>Quantité</TD>
<TD>Prix</TD>
<TD></TD>
 </tr>
<%
for(LigneAchat c : listeLignesPanier){%>
<tr><td Width=15%><%=c.getLotArticle().getArticle().getLibelleArticle()%></td>
<td Width=15%><%=c.getQuantiteAchetee()%></td>
<td Width=15%><%=c.getLotArticle().getArticle().getPrixVenteMagasin()%></td>
<td Width=30%><A href="ClientServlet?action=SupprimerLigneAchat&ligneAchatId=<%=c.getId()%>&idAchat=<%=achatEnCours.getId()%>"> Supprimer du panier</A></td>

</tr><%}%>
</TABLE>
    </body>
</html>
