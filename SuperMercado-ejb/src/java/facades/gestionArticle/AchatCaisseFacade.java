/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.AchatCaisse;
import entités.gestionMagasin.Caisse;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC Tim
 */
@Stateless
public class AchatCaisseFacade extends AbstractFacade<AchatCaisse> implements AchatCaisseFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AchatCaisseFacade() {
        super(AchatCaisse.class);
    }
    
    @Override
    public AchatCaisse CreerAchatCaisse(Date dateAchat,Caisse caisse) {
        AchatCaisse achatCaisse = new AchatCaisse ();
        achatCaisse.setDateAchat(dateAchat);
        achatCaisse.setCaisse(caisse);
        
       
        em.persist(achatCaisse);
        
        return achatCaisse;
    }
    
}
