/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionArticle.Casse;
import entités.gestionArticle.LotArticle;
import entités.gestionMagasin.AgentRayon;
import entités.gestionMagasin.Rayon;
import facades.gestionArticle.CasseFacadeLocal;
import facades.gestionArticle.LotArticleFacadeLocal;
import facades.gestionArticle.ReferentielArticleFacadeLocal;
import facades.gestionLivraison.AgentLivraisonFacadeLocal;
import facades.gestionMagasin.AgentRayonFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Soldat
 */
@Stateless
public class SessionAgentRayon implements SessionAgentRayonLocal {

    @EJB
    private ReferentielArticleFacadeLocal referentielArticleFacade;

    @EJB
    private AgentRayonFacadeLocal agentRayonFacade;

    

    @EJB
    private CasseFacadeLocal casseFacade;

    @EJB
    private LotArticleFacadeLocal lotArticleFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public String AjouterCasse(String idAgentRayon, Date dateCasse, String idLotArticle, String motifCasse, int quantiteCasse ){
        String message=null;
        AgentRayon a=agentRayonFacade.ChercherAgentRayonParId(idAgentRayon);
        Long idArticle=Long.parseLong(idLotArticle);
        LotArticle l=lotArticleFacade.RechercherLotArticleParId(idArticle);
        if(l==null){
            message="Lot article inconnu";
        }
        else{
            casseFacade.CreerCasse(a, dateCasse, l, motifCasse, quantiteCasse);
            this.ModifierQteLotArticle(idLotArticle, quantiteCasse);
            message="Casse ajouté";
        }
       
        return message;
    }
    
    @Override
    public List<Casse> ChercherListeCasseParRayon(String idAgentRayon){
        AgentRayon agent=agentRayonFacade.ChercherAgentRayonParId(idAgentRayon);
        List<Casse> liste=casseFacade.ChercherListeCasseParRayon(agent.getRayon());
        return liste;
    }
    
    @Override
    public void ModifierQteLotArticle(String idLotArticle, int newQte){
        Long idLot=Long.parseLong(idLotArticle);
        LotArticle lot= lotArticleFacade.RechercherLotArticleParId(idLot);
        lotArticleFacade.ModifierQteLotArticle(newQte, lot);
    }

    
}
