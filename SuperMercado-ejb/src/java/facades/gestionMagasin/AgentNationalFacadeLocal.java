/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.AgentNational;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface AgentNationalFacadeLocal {

    void create(AgentNational agentNational);

    void edit(AgentNational agentNational);

    void remove(AgentNational agentNational);

    AgentNational find(Object id);

    List<AgentNational> findAll();

    List<AgentNational> findRange(int[] range);

    int count();
    
    public void CreerAgentNational(String nom, String prenom, String login, String mdp);
    
}
