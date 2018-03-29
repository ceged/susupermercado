/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.ProduitFrais;
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
public class ProduitFraisFacade extends AbstractFacade<ProduitFrais> implements ProduitFraisFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProduitFraisFacade() {
        super(ProduitFrais.class);
    }
    
    @Override
    public void CreerLotArticleFrais(int qteProduitFrais, ReferentielArticle refLotArticle,Date datePeremption, LigneLivraison l) {
        
        ProduitFrais pf = new ProduitFrais ();
        
        pf.setQuantiteLot(qteProduitFrais);
        pf.setArticle(refLotArticle);
        pf.setDatePeremption(datePeremption);
        pf.setLigneLivraison(l);
        Date date = new Date();
        pf.setDateCreation(date);
        
        em.persist(pf);
        
    }
    
}
