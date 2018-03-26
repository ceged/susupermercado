/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionVenteEnLigne;

import entités.gestionMagasin.Magasin;
import entités.gestionVenteEnLigne.Creneau;
import static java.lang.Boolean.TRUE;
import java.sql.Time;
import java.util.ArrayList;
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
public class CreneauFacade extends AbstractFacade<Creneau> implements CreneauFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CreneauFacade() {
        super(Creneau.class);
    }
    
    @Override
    public void CreerCreneau(Time heureDebut, Time heureFin, Date date, Magasin magasin){
        Creneau c=new Creneau();
        c.setDisponibilité(Boolean.TRUE);
        c.setHeureDebut(heureDebut);
        c.setHeureFin(heureFin);
        c.setDate(date);
        c.setMagasin(magasin);
        em.merge(c);
    }
    
    @Override
    public void ModifierCreneau(Creneau creneau){
        creneau.setDisponibilité(Boolean.FALSE);
        em.merge(creneau);
    }
    
    @Override
    public Creneau ChercherCreneauParId(String idCreneau){
        Creneau creneau=null;
        Long id=Long.parseLong(idCreneau);
        Query req=getEntityManager().createQuery("SELECT c from Creneau AS c WHERE c.id=:id");
        req.setParameter("id",id);
        List<Creneau> liste=req.getResultList();
        for (Creneau c:liste){
            creneau=c;
        }
        return creneau;
    }
    
    @Override
    public Creneau ChercherCreneauHoraire(Date heureDebut, Date heureFin){
        Creneau creneau=null;
        Query req=getEntityManager().createQuery("SELECT c from Creneau AS c WHERE c.id=:id");
        req.setParameter("heureDebut",heureDebut);
        req.setParameter("heureFin",heureFin);
        List<Creneau> liste=req.getResultList();
        for (Creneau c:liste){
            creneau=c;
        }
        return creneau;
    }
    
    @Override
    public List<Creneau> ChercherCreneauDispo(){
        List<Creneau> result=null;
        Query req=getEntityManager().createQuery("SELECT c from Creneau AS c WHERE c.disponibilité=:TRUE");
        List<Creneau> liste=req.getResultList();
        for (Creneau c:liste){
            result.add(c);
        }
        return result;
    }
    
    @Override
    public List<Creneau> ChercherCreneauDispoParMagasin(Magasin magasin){
        Boolean dispo=TRUE;
        List<Creneau> result=new ArrayList<Creneau>();
        Query req=getEntityManager().createQuery("SELECT c from Creneau AS c WHERE c.disponibilité=:dispo AND c.magasin=:magasin");
        req.setParameter("magasin",magasin);
        req.setParameter("dispo",dispo);
        List<Creneau> liste=req.getResultList();
        for (Creneau c:liste){
            result.add(c);
        }
        return result;
    }
    
    @Override
    public List<Creneau> ChercherCreneauDispoParMagasinParDate(Magasin magasin,Date date){
        Boolean dispo=TRUE;
        List<Creneau> result=new ArrayList<Creneau>();
        Query req=getEntityManager().createQuery("SELECT c from Creneau AS c WHERE c.disponibilité=:dispo AND c.magasin=:magasin AND c.dateCreneau=:date");
        req.setParameter("magasin",magasin);
        req.setParameter("date",date);
        req.setParameter("dispo",dispo);
        List<Creneau> liste=req.getResultList();
        for (Creneau c:liste){
            result.add(c);
        }
        return result;
    }
    
}
