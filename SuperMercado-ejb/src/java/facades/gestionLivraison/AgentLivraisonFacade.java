/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionLivraison;

import entités.gestionLivraison.AgentLivraison;
import entités.gestionMagasin.Magasin;
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
public class AgentLivraisonFacade extends AbstractFacade<AgentLivraison> implements AgentLivraisonFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgentLivraisonFacade() {
        super(AgentLivraison.class);
    }
    
    @Override
    public void CreerAgentLivraison(String prenom, String nom, String login, String mdp, Date dob, String sexe, String adresse, String codePostal, Magasin magasin) {
        AgentLivraison agent = new AgentLivraison();
        
        agent.setPrenom(prenom);
        agent.setNom(nom);
        agent.setLogin(login);
        agent.setMdp(mdp);
        agent.setDob(dob);
        agent.setSexe(sexe);
        agent.setAdresse(adresse);
        agent.setCodePostal(codePostal);
        agent.setMagasin(magasin);
        em.persist(agent);
    }
    
    @Override
    public AgentLivraison RechercherAgentLivraison(String idAgentLivraison) {
        
        AgentLivraison result = null ;
        Long id=Long.parseLong(idAgentLivraison);
        Query req=getEntityManager().createQuery("SELECT a from AgentLivraison as a where a.id=:id");
        req.setParameter("id",id);
        List<AgentLivraison>l=req.getResultList();
        for(AgentLivraison c:l){
            result = c;
    }
        return result ;
    }
    
    
}
