/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.AgentNational;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC Tim
 */
@Stateless
public class AgentNationalFacade extends AbstractFacade<AgentNational> implements AgentNationalFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgentNationalFacade() {
        super(AgentNational.class);
    }
    
     @Override
    public void CreerAgentNational(String nom, String prenom, String login, String mdp) {
        AgentNational agent = new AgentNational();
        
        agent.setPrenom(prenom);
        agent.setNom(nom);
        agent.setLogin(login);
        agent.setMdp(mdp);

        em.persist(agent);
    }
}
