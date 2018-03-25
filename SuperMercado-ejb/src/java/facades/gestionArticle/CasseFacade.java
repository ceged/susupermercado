/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.Casse;
import entités.gestionArticle.LotArticle;
import entités.gestionMagasin.AgentRayon;
import entités.gestionMagasin.Rayon;
import java.util.ArrayList;
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
public class CasseFacade extends AbstractFacade<Casse> implements CasseFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CasseFacade() {
        super(Casse.class);
    }
    
    @Override
    public void CreerCasse(AgentRayon agent, Date dateCasse, LotArticle lot, String motifCasse, int quantiteCasse ){
        Casse c=new Casse();
        c.setAgentRayon(agent);
        c.setDateCasse(dateCasse);
        c.setLotArticleCasse(lot);
        c.setMotifCasse(motifCasse);
        c.setQuantiteCasse(quantiteCasse);
        em.merge(c);
    }
    
    @Override
    public List<Casse> ChercherListeCasseParRayon(Rayon rayon){
        List<Casse> result= new ArrayList<Casse>();
        Query req = getEntityManager().createQuery("SELECT c FROM Casse AS c WHERE c.agentRayon.rayon=:rayon");
        req.setParameter("rayon", rayon);
        List<Casse> liste=req.getResultList();
        for (Casse c:liste){
            result.add(c);
        }
        return result;
    }
    
}
