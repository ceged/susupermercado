/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.Electromenager;
import entités.gestionArticle.ReferentielArticle;
import entités.gestionLivraison.LigneLivraison;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC Tim
 */
@Stateless
public class ElectromenagerFacade extends AbstractFacade<Electromenager> implements ElectromenagerFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ElectromenagerFacade() {
        super(Electromenager.class);
    }
    
    @Override
    public void CreerLotArticleElectromenager(int qteLotArticle, ReferentielArticle refLotArticle,int garantie, LigneLivraison l) {
        
        Electromenager e = new Electromenager ();
        
        e.setQuantiteLot(qteLotArticle);
        e.setArticle(refLotArticle);
        e.setLigneLivraison(l);
        e.setGarantie(garantie);
        Date date = new Date();
        e.setDateCreation(date);
        
        em.persist(e);
        
    }
    
}
