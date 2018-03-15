/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import com.sun.org.apache.xpath.internal.operations.Bool;
import entités.gestionMagasin.Personne;
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
public class PersonneFacade extends AbstractFacade<Personne> implements PersonneFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonneFacade() {
        super(Personne.class);
    }
    
      @Override
    public Personne SeConnecter(String login, String mdp) {
        Personne result =null;
        Query req = getEntityManager().createQuery("SELECT p FROM Personne AS p WHERE p.mdp=:mdp AND p.login=:login");
        req.setParameter("mdp", mdp);
        req.setParameter("login", login);
        List <Personne> l=req.getResultList();
        for(Personne p : l){
            result=p;
        }
        return result;
    }

    @Override
    public void ModifierMdp(long id, String mdpActuel, String mdpNouveau) {
        
        Query req = getEntityManager().createQuery("SELECT p FROM Personne AS p WHERE p.mdp=:mdpActuel AND p.id=:id");
        req.setParameter("id", id);
        req.setParameter("mdpActuel", mdpActuel);
        List <Personne> l=req.getResultList();
        for(Personne p : l){
            p.setLogin(mdpNouveau);
            em.merge(p);
        }
    }

    @Override
    public Personne RechercherPersonneParId(Long id) {
        Personne result=null;
        Query req = getEntityManager().createQuery("SELECT p FROM Personne AS p WHERE p.id=:id");
        req.setParameter("id", id);
        List <Personne> l=req.getResultList();
        for(Personne p : l){
            result=p;
        }
        return result;
    }

    @Override
    public List RechercherPersonneParNom(String nom) {
        List<Personne> result = null;
        Query req = em.createQuery("SELECT p FROM Personne AS P WHERE p.nom=:nom");   
        req.setParameter("nom", nom);
        List <Personne> l=req.getResultList();
        for(Personne p : l){
            result.add(p);
        }
        return result;
    }
    
    @Override
    public void SupprimerPersonne(Personne personne) {
        em.remove(personne);
    }

    @Override
    public Personne GetPersonneParLogin(String login) {
        Personne result=null;
        Query req = getEntityManager().createQuery("SELECT p FROM Personne AS p WHERE p.login=:login");
        req.setParameter("login", login);
        List <Personne> l=req.getResultList();
        for(Personne p : l){
            result=p;
        }
        return result;
    }

    @Override
    public Boolean LoginEstUnique(String login) {
        Personne personne=this.GetPersonneParLogin(login);
        return personne==null;
    }
    
}
