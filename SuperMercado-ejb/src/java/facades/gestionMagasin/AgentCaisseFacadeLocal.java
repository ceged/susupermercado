/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.AgentCaisse;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface AgentCaisseFacadeLocal {

    void create(AgentCaisse agentCaisse);

    void edit(AgentCaisse agentCaisse);

    void remove(AgentCaisse agentCaisse);

    AgentCaisse find(Object id);

    List<AgentCaisse> findAll();

    List<AgentCaisse> findRange(int[] range);

    int count();
    
    void CreerAgentCaisse(String prenom, String nom, String login, String mdp, Date dob, String sexe, String adresse, String codePostal);
    
}
