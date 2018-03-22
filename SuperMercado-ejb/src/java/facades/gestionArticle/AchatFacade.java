/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.Achat;
import entités.gestionArticle.LigneAchat;
import java.util.Date;
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
public class AchatFacade extends AbstractFacade<Achat> implements AchatFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AchatFacade() {
        super(Achat.class);
    }

    @Override
    public Achat CreerAchat(Date dateAchat) {
        Achat achat = new Achat ();
        achat.setDateAchat(dateAchat);
       
        em.persist(achat);
        
        return achat;
    }
    
    @Override
    public Achat RechercheAchatParId(Long idAchat){
        Achat a = null;
        Query req = getEntityManager().createQuery("Select a from Achat as a where a.id =:idAchat ");
        req.setParameter("idAchat", idAchat);
        List<Achat>listeAchat=req.getResultList();
            for(Achat ac:listeAchat)
    {
        a=ac;
    }
        return a;
    }

    @Override
    public List<LigneAchat> getListeLigneAchat(Achat achat) {
        List<LigneAchat> result;
        Query req = getEntityManager().createQuery("Select a from LigneAchat as a where a.achat=:achat");
        req.setParameter("achat", achat);
        result = req.getResultList();
        return result;
    }
    
    
    
}
