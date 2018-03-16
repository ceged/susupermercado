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
    
    
}
