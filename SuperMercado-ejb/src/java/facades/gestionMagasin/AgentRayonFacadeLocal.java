/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.AgentRayon;
import entités.gestionMagasin.Rayon;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface AgentRayonFacadeLocal {

    void create(AgentRayon agentRayon);

    void edit(AgentRayon agentRayon);

    void remove(AgentRayon agentRayon);

    AgentRayon find(Object id);

    List<AgentRayon> findAll();

    List<AgentRayon> findRange(int[] range);

    int count();
    
    void CreerAgentRayon(String nom, String prenom, String login, String mdp, Date dob, String sexe, String adresse, String codePostal, Rayon rayon);

    AgentRayon RechercherAgentDeRayonParId(long idAgentRayon);
    
}
