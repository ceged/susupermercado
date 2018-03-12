/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

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
public class MagasinFacade extends AbstractFacade<Magasin> implements MagasinFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MagasinFacade() {
        super(Magasin.class);
    }
    @Override
    public void CreerMagasin(String adresse, String codePostal) {
    Magasin m = new Magasin();
    m.setAdresse(adresse);
    m.setCodePostal(codePostal);
    em.persist(m);
    }

    @Override
    public void SupprimerMagasin(Magasin magasinasupprimer) {
        
        em.remove(magasinasupprimer);
    }
    
    @Override
    public List<Magasin> RechercherMagasinParId(int id)
    {
       List<Magasin> listeMagasinsRecherche=null;
        Query req=getEntityManager().createQuery("SELECT m from Magasin as m where m.id=:id");
        req.setParameter("id",id);
        listeMagasinsRecherche=req.getResultList();
        return listeMagasinsRecherche;
        
    }
    
}
