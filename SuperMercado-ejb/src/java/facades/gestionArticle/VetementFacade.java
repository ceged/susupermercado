/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.ReferentielArticle;
import entités.gestionArticle.Vetement;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC Tim
 */
@Stateless
public class VetementFacade extends AbstractFacade<Vetement> implements VetementFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VetementFacade() {
        super(Vetement.class);
    }
    
    @Override
    public void CreerLotArticle(int qteLotArticle, ReferentielArticle refLotArticle,int taille, String couleur) {
        
        Vetement v = new Vetement();
        
        v.setQuantiteLot(qteLotArticle);
        v.setArticle(refLotArticle);
        v.setTaille(qteLotArticle);
        v.setCouleur(couleur);
        
        em.persist(v);
        
    }
    
}
