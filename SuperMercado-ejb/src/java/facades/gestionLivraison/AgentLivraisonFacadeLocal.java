/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionLivraison;

import entités.gestionLivraison.AgentLivraison;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface AgentLivraisonFacadeLocal {

    void create(AgentLivraison agentLivraison);

    void edit(AgentLivraison agentLivraison);

    void remove(AgentLivraison agentLivraison);

    AgentLivraison find(Object id);

    List<AgentLivraison> findAll();

    List<AgentLivraison> findRange(int[] range);

    int count();
    
}
