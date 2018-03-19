/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.AgentCaisse;
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
    public void CreerAgentCaisse(String prenom, String nom, String login, String mdp, Date dob, String sexe, String adresse, String codePostal, Magasin magasin) {
        AgentCaisse agent = new AgentCaisse();
        
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
    public AgentCaisse RechercherAgentCaisse(String idAgentCaisse, Magasin magasin) {
        
        AgentCaisse result = null ;
        Long id=Long.parseLong(idAgentCaisse);
        Query req=getEntityManager().createQuery("SELECT a from AgentCaisse as a where a.id=:id AND a.magasin=:magasin");
        req.setParameter("id",id);
        req.setParameter("magasin",magasin);
        List<AgentCaisse>l=req.getResultList();
        for(AgentCaisse c:l){
            result = c;
    }
        return result ;
    }

    @Override
    public List<AgentCaisse> ConsulterListeAgentCaisseParMagasin(Magasin magasin) {
        
        Query req=getEntityManager().createQuery("SELECT a from AgentCaisse AS a WHERE a.magasin=:magasin");
        req.setParameter("magasin",magasin);
        List result = req.getResultList();
        return result;
        
    }

    
}
    
    

