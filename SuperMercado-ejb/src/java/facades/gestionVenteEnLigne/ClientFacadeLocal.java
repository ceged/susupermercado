/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionVenteEnLigne;

import entités.gestionVenteEnLigne.Client;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface ClientFacadeLocal {

    void create(Client client);

    void edit(Client client);

    void remove(Client client);

    Client find(Object id);

    List<Client> findAll();

    List<Client> findRange(int[] range);

    int count();

    void CreerClient(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal);
    
    Client ChercherClientParLoginMdp(String Login, String mdp);

    void SupprimerCompteClient(Client client);
}
