<%-- 
    Document   : SupprimerMagasin
    Created on : 13 mars 2018, 15:14:03
    Author     : tangu_000
--%>

<%@page import="entités.gestionLivraison.AgentLivraison"%>
<%@page import="java.util.List"%>
<%@page import="entités.gestionMagasin.Secteur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="test.css" type="text/css">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeSecteurs" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="listeAgentLivraisons" scope="request" class="java.util.List"></jsp:useBean>
 
        <title>Magasin</title>
    </head>
    <body>
        <h1>Suppression</h1>
        
        <% List<Secteur> Sect=listeSecteurs;
        for(Secteur s : Sect){%>
        <tr> <td Width=15%><%=s.getLibelleSecteur()%></td>
        <td Width=15%><%=s.getMagasin()%></td>
        </tr><%}%>
        
        <% List<AgentLivraison> AL=listeAgentLivraisons;
        for(AgentLivraison a : AL){%>
        
        <tr> <td Width=30%><%=a.getLogin()%></td>
        
        <td Width=30%><%=a.getMagasin()%></td>
        </tr><%}%>
        
        <A HREF=MenuAdmin.jsp"> Retour au portail admin </A></td>
        </tr></TABLE>
        <input type="hidden" name="action" value="supprimerMagasin">
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        
    </body>
</html>
        