/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.Caisse;
import entités.gestionMagasin.Magasin;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    @Override
    public List<Caisse> ConsulterListeCaisseParMagasin(Magasin magasin) {
        
      Query req=getEntityManager().createQuery("SELECT c from Caisse AS c WHERE c.magasin=:magasin ");
      req.setParameter("magasin",magasin);
      List result = req.getResultList();
      return result;
    }

    @Override
    public Caisse RechercherCaisseParId(Long idCaisse, Magasin magasin) {
        Caisse result = null ;
        Query req=getEntityManager().createQuery("SELECT c from Caisse as c where c.id=:id AND c.magasin=:magasin");
        req.setParameter("id",idCaisse);
        req.setParameter("magasin",magasin);
        List<Caisse>l=req.getResultList();
        for(Caisse c:l){
            result = c;
    }
        return result ;
    }
    
}
