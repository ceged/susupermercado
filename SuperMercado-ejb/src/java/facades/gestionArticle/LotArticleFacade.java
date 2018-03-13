/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.LotArticle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC Tim
 */
@Stateless
public class LotArticleFacade extends AbstractFacade<LotArticle> implements LotArticleFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LotArticleFacade() {
        super(LotArticle.class);
    }
    
    

    @Override
    public void ModifierQteLotArticle(int qteAModifier, boolean signe, LotArticle LotArticle) {
        //règle signe : true = +, False = -
        int nouvelleQte = 0;    
        int ancienneQte = 0;
                
                if (signe = true) {
                
                ancienneQte = LotArticle.getQuantiteLot();
                
                nouvelleQte = ancienneQte + qteAModifier;
               
        }
                else if (signe = false) {
              
                ancienneQte = LotArticle.getQuantiteLot();
                
                nouvelleQte = ancienneQte - qteAModifier;
               
                }
                
     LotArticle.setQuantiteLot(nouvelleQte);
     em.merge(LotArticle);
    
             
                
     
        
    }
    
    
    
}
