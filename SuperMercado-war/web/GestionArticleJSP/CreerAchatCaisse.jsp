<%-- 
    Document   : CreerAchatCaisse
    Created on : 22 mars 2018, 11:38:15
    Author     : Soldat
--%>

<%@page import="entités.gestionArticle.AchatCaisse"%>
<%@page import="entités.gestionArticle.LigneAchat"%>
<%@page import="java.util.List"%>
<%@page import="entités.gestionMagasin.AgentCaisse"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="agentCaisse" scope="session" class="AgentCaisse"></jsp:useBean>
        <jsp:useBean id="liste" scope="session" class="List<LigneAchat>"></jsp:useBean>
        <jsp:useBean id="achatCaisse" scope="session" class="AchatCaisse"></jsp:useBean>
        
        <title>Menu Panier Achat Caisse</title>
    </head>

        <body>
        <h1>Liste de vos achats caisse</h1>
        
        <p> <%
String attribut = (String) request.getAttribute("message");
if(attribut!=null){
    out.println( attribut );
}

%> </p>
        
        <form method="get" action="/SuperMercado-war/EmployeCaisseServlet">
            <label for="number"> Code barre lot article <span class="requis">*</span></label>
        <input type="number" name="idLotArticle" value="" size="20" maxlength="20" />
        <input type="hidden" name="idAchat" value="<%=achatCaisse.getId() %>">
        <input type="hidden" name="action" value="insererLigneAchat">
        <input type="submit" value="Valider" />
        <br />
        </form>
 <TABLE border width=50%>
<tr> <TD>Designation article</TD>
<TD>Quantité</TD>
<TD>Prix unitaire</TD>
<TD>Total</TD>
<TD>Supprimer de la commande</TD>
 </tr>
<%float t=0;
for(LigneAchat l : liste){t=t+l.getLotArticle().getArticle().getPrixVenteMagasin()*l.getQuantiteAchetee();%>
<tr><td Width=15%><%=l.getLotArticle().getArticle().getLibelleArticle() %></td>
<td Width=15%><%=l.getQuantiteAchetee()%></td>
<td Width=15%><%=l.getLotArticle().getArticle().getPrixVenteMagasin()%></td>
<td Width=15%><%=l.getLotArticle().getArticle().getPrixVenteMagasin()*l.getQuantiteAchetee()%></td>
<td Width=30%><A href="EmployeCaisseServlet?action=SupprimerLigneAchat&ligneId=<%=l.getId()%>&achatId=<%=l.getAchat().getId()%>"> Cliquez ici</A></td>

</tr><%}%></TABLE>
<table border width="50%">
    <tr>
        <td>Coût total : </td>
        <td><%=t%></td>
    </tr>
    
</table>       
        
    
    
    </body>
</html>
