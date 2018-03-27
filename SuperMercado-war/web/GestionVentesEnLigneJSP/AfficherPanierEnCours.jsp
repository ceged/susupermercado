<%-- 
    Document   : AfficherPanierEnCours
    Created on : 21 mars 2018, 17:22:18
    Author     : Sophia
--%>
<% 
        
    if (session.getAttribute("client") == null) {
        RequestDispatcher rd = request.getRequestDispatcher("Accueil.jsp");
        rd.forward(request, response);
        response.sendRedirect( request.getContextPath() + "/Accueil.jsp");
 } %>


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
     <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>
    <%@ include file="/include/sidebar.jsp" %>
    <body>
    <center>
        <h1>Mon Panier!</h1>
        
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
    </center>
        
    <center>
        <form method="get" action="GestionVentesEnLigneJSP\AfficherListeArticles.jsp">
      <button type="submit">Continue Shopping</button>   
    </form>
    </center>
    <center> 
        <form method="get" action="/SuperMercado-war/ClientServlet">
      <input type="hidden" name="action" value="transferListeMagasin">
      <button type="submit">Changer de magasin</button>   
        </form></center>
<center>
    <form method="get" action="/SuperMercado-war/ClientServlet">
      <input type="hidden" name="idAchat" value=<%=achatEnCours.getId()%>>
      <input type="hidden" name="action" value="validerPanier">
      <button type="submit"> Valider mon panier </button>   
    </form>
</center>
      <p>      <%
String attribut = (String) request.getAttribute("message");
if(attribut!=null){
    out.println( attribut );
            }
%> 
      </p>
    </center> 
    <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>
