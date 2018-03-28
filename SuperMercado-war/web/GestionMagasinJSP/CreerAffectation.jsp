<%-- 
    Document   : CreerChefRayon
    Created on : 14 mars 2018, 11:59:16
    Author     : Sophia
--%>

<%@page import="entités.gestionMagasin.AgentCaisse"%>
<%@page import="entités.gestionMagasin.Caisse"%>
<%@page import="entités.gestionMagasin.Rayon"%>
<%@page import="java.util.List"%>
<%@page import="entités.gestionMagasin.DirecteurMagasin"%>
<%@page import="entités.gestionMagasin.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
        <meta http-equiv="Content-Type" content="test/html; charset=UTF-8">
        <link rel="stylesheet" href="text.css" type="text/css">
<jsp:useBean id="directeurConnecte" scope="session" class="DirecteurMagasin"></jsp:useBean>
<jsp:useBean id="listeCaisse" scope="session" class="List<Caisse>"></jsp:useBean>
<jsp:useBean id="listeAgentCaisse" scope="session" class="List<AgentCaisse>"></jsp:useBean>
        <title>JSP Page</title>
    <%@ include file="/include/css.jsp" %>    
    </head>    
    <%@ include file="/include/header.jsp" %>
    <%@ include file="/include/sidebar.jsp" %>
<body>
<% DirecteurMagasin a= directeurConnecte;
List<Caisse> listeCaisse2 =listeCaisse;
List<AgentCaisse>listeAgentCaisse2 =listeAgentCaisse;{%>
        
<tr> <td Width=15%>Bienvenue <%=a.getNom()%></td>
</tr><%}%>
         <h1>Formulaire d'affectation</h1>
        <form method="get" action="/SuperMercado-war/DirecteurServlet">
        <fieldset>
        
        <label for="dateDebut">Date de début d'affectation <span class="requis">*</span></label>
        <input type="date" name="dateDebut" value="" size="20" maxlength="20" required/>
        <br />
        
        <label for="dateFin">Date de fin d'affectation <span class="requis">*</span></label>
        <input type="date" name="dateFin" value="" size="20" maxlength="20" required />
        <br />

        
        <label for="id">Caisse : <span class="requis">*</span></label>
        <SELECT name="idCaisse" size="1">
            <%
            for(Caisse c: listeCaisse2){ %>
            <OPTION><%=c.getId().toString()%>
              <%}%>
        </SELECT>
        
        <label for="nomAgentCaisse">Agent de caisse à affecter<span class="requis">*</span></label>
        <SELECT name="nomAgentCaisse" size="1">
            <%
            for(AgentCaisse ac: listeAgentCaisse2){ %>
            <OPTION value="<%=ac.getId().toString()%>"><%=ac.getNom() %>
              <%}%>
        </SELECT>
        <br />
        <input type="hidden" name="magasin" value="<%=a.getMagasin().getNomMagasin()%>" />
        <br />
        <input type="hidden" name="action" value="insererAffectation">
        </fieldset>
        <input type="submit" value="Valider" />
        <input type="reset" value="Remettre à zéro" /> <br />
        </form>

     <%@ include file="/include/footer.jsp" %>
    </body>
     <%@ include file="/include/js.jsp" %>
</html>

