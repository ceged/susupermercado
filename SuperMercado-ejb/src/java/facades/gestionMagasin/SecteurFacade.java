/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.Magasin;
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
    
    @Override
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
    
    @Override
    public Secteur RechercherSecteurParLibelle (String libelleSecteur)
    {
        Secteur result = null ;
        Query req=getEntityManager().createQuery("SELECT s from Secteur as s where s.libelleSecteur=:libelleSecteur");
        req.setParameter("libelleSecteur",libelleSecteur);
        Collection<Secteur>col=req.getResultList();
            for(Secteur s:col)
    {
        result=s;
    }
        return result;
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

    @Override
    public void SupprimerSecteur(Secteur secteur) {
        em.remove(secteur);
    }

    @Override
    public List ConsulterSecteursParMagasin(Magasin magasin) {
         
        Query req=getEntityManager().createQuery("SELECT s from Secteur AS s WHERE s.magasin=:magasin");
        req.setParameter("magasin",magasin);
        List result = req.getResultList();
        return result;
    }
    }
