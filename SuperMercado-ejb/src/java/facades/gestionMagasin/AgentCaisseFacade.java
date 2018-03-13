/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.AgentCaisse;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC Tim
 */
@Stateless
public class AgentCaisseFacade extends AbstractFacade<AgentCaisse> implements AgentCaisseFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgentCaisseFacade() {
        super(AgentCaisse.class);
    }
    
    @Override
    public void CreerAgentCaisse(String prenom, String nom, String login, String mdp, Date dob, String sexe, String adresse, String codePostal) {
        AgentCaisse agent = new AgentCaisse();
        
        agent.setPrenom(prenom);
        agent.setNom(nom);
        agent.setLogin(login);
        agent.setMdp(mdp);
        agent.setDob(dob);
        agent.setSexe(sexe);
        agent.setAdresse(adresse);
        agent.setCodePostal(codePostal);

        em.persist(agent);
        
    }
    
}
