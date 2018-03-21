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
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface AffectationCaisseAgentFacadeLocal {

    void create(AffectationCaisseAgent affectationCaisseAgent);

    void edit(AffectationCaisseAgent affectationCaisseAgent);

    void remove(AffectationCaisseAgent affectationCaisseAgent);

    AffectationCaisseAgent find(Object id);

    List<AffectationCaisseAgent> findAll();

    List<AffectationCaisseAgent> findRange(int[] range);

    int count();

    void CreerAffectation(AgentCaisse agentCaisse, Caisse caisse, Date debut, Date fin);

    AgentCaisse RechercherAgentParCaisseEtDate(Date date, Caisse caisse);

    
}
