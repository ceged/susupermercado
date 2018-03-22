/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;


import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Rayon;
import entités.gestionMagasin.Secteur;
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

    @Override // modification du libelle Rayon
    public void ModifierRayon(String newLibelleRayon, Rayon rayonModifie) {
        
        rayonModifie.setLibelleRayon(newLibelleRayon);
        em.merge(rayonModifie);
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
        Query req=getEntityManager().createQuery("SELECT r from Rayon as r where r.libelleRayon=:libelleRayon AND r.secteur.magasin=:magasin");
        req.setParameter("libelleRayon",nomRayon);
        req.setParameter("magasin",magasin);
        List<Rayon>l=req.getResultList();
        for(Rayon r:l){
            result = r;
    }
        return result ;
    }   

    @Override
    public List <Rayon> ConsulterRayonsSansChef(Magasin magasin) {
        Query req=getEntityManager().createQuery("SELECT r from Rayon AS r WHERE r.secteur.magasin=:magasin AND r.chefRayon IS NULL");
        req.setParameter("magasin",magasin);
        List result = req.getResultList();
        return result;
    }
    
    @Override
    public Rayon ChercherRayonParId(String idRayon){
        Long id=Long.getLong(idRayon);
        Rayon result=new Rayon();
        Query req=getEntityManager().createQuery("SELECT r from Rayon AS r WHERE r.id=:id");
        req.setParameter("id",id);
        List<Rayon>l=req.getResultList();
        for(Rayon r:l)
        {
            result=r;
        }
        return result;
    }
}   
