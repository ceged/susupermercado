/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionVenteEnLigne;

import entités.gestionVenteEnLigne.AchatEnLigne;
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
public class AchatEnLigneFacade extends AbstractFacade<AchatEnLigne> implements AchatEnLigneFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AchatEnLigneFacade() {
        super(AchatEnLigne.class);
    }

    @Override
    public AchatEnLigne CreationAchatEnLigne(Client client) {
        AchatEnLigne a = new AchatEnLigne();
        Date dateAchat = new Date();
        a.setClient(client);
        a.setDateAchat(dateAchat);
        
        em.persist(a);
        return a;
    }
    
    
}
