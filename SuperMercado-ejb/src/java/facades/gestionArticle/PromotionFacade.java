/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.Promotion;
import entités.gestionArticle.ReferentielArticle;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    @Override
    public Promotion RechercherPromotionEnCoursParArticle(ReferentielArticle referentielArticle){
        Promotion p = null;
        Date dateJour= new Date();
        Query req = getEntityManager().createQuery("Select p from Promotion as p where p.article=:referentielArticle");
        req.setParameter("referentielArticle", referentielArticle);
        Collection<Promotion>col=req.getResultList();
            for(Promotion p2:col)
        {
        if(dateJour.compareTo(p2.getDateFin())==-1){
             p=p2;
               
                }
        }
        return p;
      }
    
    
 }
    
    
    
    
    

