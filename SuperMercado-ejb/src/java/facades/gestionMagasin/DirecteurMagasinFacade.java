/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.DirecteurMagasin;
import entités.gestionMagasin.Magasin;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PC Tim
 */
@Stateless
public class DirecteurMagasinFacade extends AbstractFacade<DirecteurMagasin> implements DirecteurMagasinFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DirecteurMagasinFacade() {
        super(DirecteurMagasin.class);
    }
    
    
    @Override
    public void CreerDirecteurMagasin(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal, Magasin magasin) {
        
        DirecteurMagasin directeur = new DirecteurMagasin();
        
        directeur.setPrenom(prenom);
        directeur.setNom(nom);
        directeur.setLogin(login);
        directeur.setMdp(mdp);
        directeur.setDob(dob);
        directeur.setSexe(sexe);
        directeur.setAdresse(adresse);
        directeur.setCodePostal(codePostal);
        directeur.setMagasin(magasin);

        em.persist(directeur);
        
    }
    
    @Override
    public DirecteurMagasin RechercherDirecteurParId(String idDirecteur)
    {
       Long id=Long.parseLong(idDirecteur);
        DirecteurMagasin directeurRecherche=null;
        Query req=getEntityManager().createQuery("SELECT d from DirecteurMagasin as d where d.id=:idDirecteur");
        req.setParameter("idDirecteur",id);
            Collection<DirecteurMagasin>col=req.getResultList();
            for(DirecteurMagasin d:col)
    {
        directeurRecherche=d;
    }
        return directeurRecherche;
        
    }
    
}
