/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.AgentRayon;
import entités.gestionMagasin.Rayon;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC Tim
 */
@Stateless
public class AgentRayonFacade extends AbstractFacade<AgentRayon> implements AgentRayonFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgentRayonFacade() {
        super(AgentRayon.class);
    }
 
    
    @Override
    public void CreerAgentRayon(String nom, String prenom, String login, String mdp, Date dob, String sexe, String adresse, String codePostal, Rayon rayon) {
        
        AgentRayon agent = new AgentRayon();
        
        agent.setPrenom(prenom);
        agent.setNom(nom);
        agent.setLogin(login);
        agent.setMdp(mdp);
        agent.setDob(dob);
        agent.setSexe(sexe);
        agent.setAdresse(adresse);
        agent.setCodePostal(codePostal);
        agent.setRayon(rayon);

        em.persist(agent);
        
    }
}
