/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.ChefRayon;
import entités.gestionMagasin.Rayon;
import entités.gestionMagasin.Secteur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC Tim
 */
@Stateless
public class RayonFacade extends AbstractFacade<Rayon> implements RayonFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RayonFacade() {
        super(Rayon.class);
    }
    
    @Override
    public void CreerRayon(Secteur secteur, String libelleRayon) {
    Rayon r = new Rayon();
    r.setSecteur(secteur);
    r.setLibelleRayon(libelleRayon);
    em.persist(r);
    }

    @Override
    public void SupprimerRayon(Rayon rayonasupprimer) {
        
        em.remove(rayonasupprimer);
    }

    @Override // modification du chef de rayon, utile? 
    public void ModifierRayon(Rayon rayon, ChefRayon chefRayon) {
        rayon.setChefRayon(chefRayon);
        em.merge(rayon);
    }
    
}
