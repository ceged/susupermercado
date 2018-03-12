/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.ReferentielArticle;
import entités.gestionArticle.SousCategorie;
import entités.gestionMagasin.Magasin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC Tim
 */
@Stateless
public class ReferentielArticleFacade extends AbstractFacade<ReferentielArticle> implements ReferentielArticleFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReferentielArticleFacade() {
        super(ReferentielArticle.class);
    }
    
    public void CreerReferentielArticle (String libelleArticle, Magasin magasin, String marque, float prixVente, SousCategorie sousCategorie ){
        ReferentielArticle referentielArticleCree = new ReferentielArticle();
        referentielArticleCree.setLibelleArticle(libelleArticle);
        referentielArticleCree.setMagasin(magasin);
        referentielArticleCree.setMarque(marque);
        referentielArticleCree.setPrixVenteMagasin(prixVente);
        referentielArticleCree.setSousCategorie(sousCategorie);
        em.persist(referentielArticleCree);   
    }
    
}
