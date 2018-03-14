/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.Caisse;
import entités.gestionMagasin.Magasin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC Tim
 */
@Stateless
public class CaisseFacade extends AbstractFacade<Caisse> implements CaisseFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CaisseFacade() {
        super(Caisse.class);
    }
    
    @Override
    public void CreerCaisse(Long id,Magasin magasin) {
    Caisse caisseCree = new Caisse();
    caisseCree.setId (id);
    caisseCree.setMagasin(magasin);
    em.persist(caisseCree);
    }
    
    @Override
    public void SupprimerCaisse(Caisse caisseasupprimer) {
        
        em.remove(caisseasupprimer);
    }

   
}
