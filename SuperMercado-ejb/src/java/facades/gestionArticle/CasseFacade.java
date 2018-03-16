/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.Casse;
import entités.gestionArticle.LotArticle;
import entités.gestionMagasin.AgentRayon;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC Tim
 */
@Stateless
public class CasseFacade extends AbstractFacade<Casse> implements CasseFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CasseFacade() {
        super(Casse.class);
    }

    @Override
    public void CreerCasse(Date dateCasse, int qteCasse, String motifCasse, AgentRayon agentRayon, LotArticle lotArticle ) {
        
        Casse ca = new Casse ();
        ca.setDateCasse(dateCasse);
        ca.setQuantiteCasse(qteCasse);
        ca.setMotifCasse(motifCasse);
        ca.setAgentRayon(agentRayon);
        ca.setLotArticleCasse(lotArticle);
        
        em.persist(ca);
    }
    
    
    
}
