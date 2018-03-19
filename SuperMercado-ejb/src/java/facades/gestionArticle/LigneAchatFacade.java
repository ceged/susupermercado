/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.Achat;
import entités.gestionArticle.LigneAchat;
import entités.gestionArticle.LotArticle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC Tim
 */
@Stateless
public class LigneAchatFacade extends AbstractFacade<LigneAchat> implements LigneAchatFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LigneAchatFacade() {
        super(LigneAchat.class);
    }

    @Override
    public void CreerLigneAchat(int qteAchetees, LotArticle lotArticle, Achat achat) {
        
        LigneAchat ligneAchat = new LigneAchat () ;
        ligneAchat.setQuantiteAchetee(qteAchetees);
        ligneAchat.setLotArticle(lotArticle);
        ligneAchat.setAchat(achat);
        em.persist(ligneAchat);
    }
    
    
    
    
    
}
