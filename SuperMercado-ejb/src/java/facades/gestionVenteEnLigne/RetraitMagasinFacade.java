/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionVenteEnLigne;

import entités.gestionMagasin.Magasin;
import entités.gestionVenteEnLigne.AchatEnLigne;
import entités.gestionVenteEnLigne.RetraitMagasin;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC Tim
 */
@Stateless
public class RetraitMagasinFacade extends AbstractFacade<RetraitMagasin> implements RetraitMagasinFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RetraitMagasinFacade() {
        super(RetraitMagasin.class);
    }
    
    @Override
    public void CreerRetraitMagasin(AchatEnLigne achat, Date dateRecup, Magasin m){
        RetraitMagasin r= new RetraitMagasin();
        r.setAchatEnLigne(achat);
        r.setDateRecuperation(dateRecup);
        r.setMagasin(m);
        em.merge(r);
    }
    
}
