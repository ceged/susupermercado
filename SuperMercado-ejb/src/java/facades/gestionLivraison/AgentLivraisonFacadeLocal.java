/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionLivraison;

import entités.gestionLivraison.AgentLivraison;
import entités.gestionMagasin.Magasin;
import java.util.Date;
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
    
    AgentLivraison RechercherAgentLivraison(String idAgentLivraison);
    
    void CreerAgentLivraison(String prenom, String nom, String login, String mdp, Date dob, String sexe, String adresse, String codePostal, Magasin magasin);
    
}
