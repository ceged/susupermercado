/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.Promotion;
import entités.gestionArticle.ReferentielArticle;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC Tim
 */
@Stateless
public class PromotionFacade extends AbstractFacade<Promotion> implements PromotionFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PromotionFacade() {
        super(Promotion.class);
    }

    @Override
    public void CreerPromotion(Date dateDeb,Date dateFin,float prixPromo, ReferentielArticle article) {
        Promotion P = new Promotion () ;
        
        P.setDateDebut(dateDeb);
        P.setDateFin(dateFin);
        P.setPrixPromotion(prixPromo);
        P.setArticle(article);
        
        em.persist(P);
    }
    
    
    
    
    
}
