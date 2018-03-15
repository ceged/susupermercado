/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.ChefRayon;
import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Rayon;
import entités.gestionMagasin.Secteur;
import java.util.Collection;
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

    @Override
    public List <Rayon> ConsulterListeRayonsParMagasin(Magasin magasin) {
        
        Query req=getEntityManager().createQuery("SELECT r from Rayon AS r WHERE r.secteur.magasin=:magasin ");
        req.setParameter("magasin",magasin);
        List result = req.getResultList();
        return result;
    }

    @Override
    public Rayon RechercherRayonParNom(String nomRayon, Magasin magasin) {
        Rayon result = null ;
        Query req=getEntityManager().createQuery("SELECT r from Rayon as r where r.libelleRayon=:nomRayon AND r.secteur.magasin=:magasin");
        req.setParameter("nomRayon",nomRayon);
        req.setParameter("magasin",magasin);
        List<Rayon>l=req.getResultList();
        for(Rayon r:l){
            result = r;
    }
        return result ;
    }   
}   
