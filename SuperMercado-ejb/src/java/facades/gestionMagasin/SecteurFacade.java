/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.Magasin;
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
public class SecteurFacade extends AbstractFacade<Secteur> implements SecteurFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SecteurFacade() {
        super(Secteur.class);
    }
    
    public Secteur RechercherSecteurParId (int id)
    {
        Secteur result = null ;
        Query req=getEntityManager().createQuery("SELECT s from Secteur as s where s.id=:id");
        req.setParameter("id",id);
        List<Secteur>l=req.getResultList();
        for(Secteur s:l){
            result = s;
    }
         
        
        return result ;
        
    }
    
    public Secteur RechercherSecteurParLibelle (String libelleSecteur)
    {
        Secteur result = null ;
        Query req=getEntityManager().createQuery("SELECT s from Secteur as s where s.libelleSecteur=:libelleSecteur");
        req.setParameter("libelleSecteur",libelleSecteur);
        List<Secteur>l=req.getResultList();
        for(Secteur s:l){
            result = s;
    }
         
        
        return result ;
        
    }

 @Override
    public void CreerSecteur(String libelle, Magasin magasin) {
        
        Secteur secteur = new Secteur();
        secteur.setLibelleSecteur(libelle);
        secteur.setMagasin(magasin);
        
        em.persist(secteur);
    }

    @Override
    public void ModifierSecteur(Secteur secteur, String libelle) {

        secteur.setLibelleSecteur(libelle);
        em.merge(secteur);
    }
}
    

