/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.AffectationCaisseAgent;
import entités.gestionMagasin.AgentCaisse;
import entités.gestionMagasin.Caisse;
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
public class AffectationCaisseAgentFacade extends AbstractFacade<AffectationCaisseAgent> implements AffectationCaisseAgentFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AffectationCaisseAgentFacade() {
        super(AffectationCaisseAgent.class);
    }

    @Override
    public void CreerAffectation(AgentCaisse agentCaisse, Caisse caisse, Date debut, Date fin) {
        AffectationCaisseAgent affectation = new AffectationCaisseAgent();
        affectation.setAgentCaisse(agentCaisse);
        affectation.setCaisse(caisse);
        affectation.setDateDebut(debut);
        affectation.setDateFin(fin);
        
        em.persist(affectation);
             
    }

    @Override
    public AgentCaisse RechercherAgentParCaisseEtDate(Date date, Caisse caisse) {
        
        AgentCaisse result=null;
        Query req=getEntityManager().createQuery("SELECT a.agentCaisse from AffectationCaisseAgent AS a WHERE a.caisse=:caisse AND a.dateDebut<=:date AND a.dateFin>=:date");       
        req.setParameter("caisse",caisse);
        req.setParameter("date",date);
        
        List<AgentCaisse>l=req.getResultList();
        for(AgentCaisse c:l){
            result = c;
    }
        return result ;
    }
    
    
    
}
