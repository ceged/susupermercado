/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.ChefRayon;
import entités.gestionMagasin.Rayon;
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
public class ChefRayonFacade extends AbstractFacade<ChefRayon> implements ChefRayonFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChefRayonFacade() {
        super(ChefRayon.class);
    }
    @Override
    public void CreerChefRayon(String nom, String prenom, String login, String mdp, Date dob, String sexe, String adresse, String codePostal, Rayon rayon) {
        
        ChefRayon chef = new ChefRayon();
        
        chef.setPrenom(prenom);
        chef.setNom(nom);
        chef.setLogin(login);
        chef.setMdp(mdp);
        chef.setDob(dob);
        chef.setSexe(sexe);
        chef.setAdresse(adresse);
        chef.setCodePostal(codePostal);
        chef.setRayon(rayon);

        em.persist(chef);
        
        
    }
    @Override
    public ChefRayon RechercherChefRayonParNom (String nom)
    {
        ChefRayon result = null ;
        Query req=getEntityManager().createQuery("SELECT c from ChefRayon as c where c.nom=:nom");
        req.setParameter("nom",nom);
        List<ChefRayon>l=req.getResultList();
        for(ChefRayon c:l){
            result = c;
    }
         
        
        return result ;
        
    }
}
