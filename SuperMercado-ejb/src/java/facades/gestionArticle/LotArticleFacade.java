/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.LotArticle;
import entités.gestionArticle.ReferentielArticle;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    public void ModifierQteLotArticle(int qteAModifier, LotArticle LotArticle) {
        //règle signe : true = +, False = -
        int nouvelleQte = 0;    
        int ancienneQte = 0;
              
                ancienneQte = LotArticle.getQuantiteLot();
                
                nouvelleQte = ancienneQte - qteAModifier;
          
     LotArticle.setQuantiteLot(nouvelleQte);
     em.merge(LotArticle);
     
    }

    @Override
    public LotArticle RechercherLotArticleParId(long id) {
        
        LotArticle la;
        Query req = getEntityManager().createQuery("SELECT la FROM LotArticle AS la WHERE la.id=:id");
        req.setParameter("id", id);
        la = (LotArticle) req.getSingleResult();
        return la;
        
    }

    @Override
    public void CreerLotArticle(int qteLotArticle, ReferentielArticle refLotArticle) {
        
        LotArticle la = new LotArticle ();
        Date date = new Date();
        la.setQuantiteLot(qteLotArticle);
        la.setArticle(refLotArticle);
        la.setDateCreation(date);
        
        em.persist(la);
        
    }

    @Override
    public LotArticle RechercherLotArticleFIFO(ReferentielArticle article) {
        LotArticle la;
        Query req= getEntityManager().createQuery("SELECT la FROM LotArticle AS la WHERE la.article=:article");
        req.setParameter("article", article);
        List result = req.getResultList();
        return null;
    }
    
    
    
    
    
    
    
    
    
}
