/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionVenteEnLigne;

import entités.gestionVenteEnLigne.Client;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC Tim
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    @Override
    public void CreerClient(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal) {
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(nom);
        client.setPrenom(prenom);
        client.setLogin(login);
        client.setMdp(mdp);
        client.setSexe(sexe);
        client.setDob(dob);
        client.setAdresse(adresse);
        client.setCodePostal(codePostal);
        
        em.persist(client);
    }
    
    
}
