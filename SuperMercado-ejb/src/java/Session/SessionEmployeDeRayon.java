/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionArticle.LotArticle;
import entités.gestionMagasin.AgentRayon;
import facades.gestionArticle.CasseFacadeLocal;
import facades.gestionArticle.LotArticleFacadeLocal;
import facades.gestionMagasin.AgentRayonFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;



/**
 *
 * @author CGAILLOTDREVON
 */

@Stateless
public class SessionEmployeDeRayon implements SessionEmployeDeRayonLocal {

    @EJB
    private CasseFacadeLocal casseFacade;

    @EJB
    private AgentRayonFacadeLocal agentRayonFacade;

    @EJB
    private LotArticleFacadeLocal lotArticleFacade;
    
    
    
    
    

    @Override
    public String EnregistrerCasse(int qteCasse, String motifCasse, long idLotArticle, long idAgentRayon) {
        String message = "merci de vous reconnecter ";
        LotArticle la = null;
        AgentRayon ar = null;
        Date dateJour = new Date();
        
        ar = agentRayonFacade.RechercherAgentDeRayonParId(idAgentRayon);
        
        if (ar!=null)
        {
            message = "le lot article est inconnu";
            la = lotArticleFacade.RechercherLotArticleParId(idLotArticle);
            if (la!=null)
            {
                casseFacade.CreerCasse(dateJour, qteCasse, motifCasse, ar, la);
                lotArticleFacade.ModifierQteLotArticle(qteCasse, la);
                message = "la casse a bien été enregistrée";
            }
        }
        
        
        return message;
    }

    
}
