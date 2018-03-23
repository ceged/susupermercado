/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.Achat;
import entités.gestionArticle.LigneAchat;
import entités.gestionArticle.LotArticle;
import entités.gestionVenteEnLigne.AchatEnLigne;
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
public class LigneAchatFacade extends AbstractFacade<LigneAchat> implements LigneAchatFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LigneAchatFacade() {
        super(LigneAchat.class);
    }

    @Override
    public void CreerLigneAchat(int qteAchetees, LotArticle lotArticle, Achat achat) {
        
        LigneAchat ligneAchat = new LigneAchat () ;
        ligneAchat.setQuantiteAchetee(qteAchetees);
        ligneAchat.setLotArticle(lotArticle);
        ligneAchat.setAchat(achat);
        em.persist(ligneAchat);
    }

    @Override
    public void SupprimerLigneAchat(LigneAchat ligneAchat) {
        em.remove(ligneAchat);
    }

    @Override
    public LigneAchat RechercherLigneAchatParId(Long idLigne) {
        LigneAchat a = null;
        Query req = getEntityManager().createQuery("Select a from LigneAchat as a where a.id =:idLigneAchat ");
        req.setParameter("idLigneAchat", idLigne);
        List<LigneAchat>listeLigneAchat=req.getResultList();
            for(LigneAchat ac:listeLigneAchat)
    {
        a=ac;
    }
        return a;
    }

    @Override
    public LigneAchat RechercherLigneParLotDansUnAchat(Achat achat, LotArticle lot) {
        LigneAchat a = null;
        Query req = getEntityManager().createQuery("Select a from LigneAchat as a where a.achat=:achat and a.lotArticle=:lot");
        req.setParameter("achat", achat);
        req.setParameter("lot", lot);
        List<LigneAchat>listeLigneAchat=req.getResultList();
            for(LigneAchat ac:listeLigneAchat)
    {
        a=ac;
    }
        return a;
    }

    @Override
    public void AjouterQuantiteLigne(int quantiteAjoute, LigneAchat ligne) {
        ligne.setQuantiteAchetee(quantiteAjoute+ligne.getQuantiteAchetee());
        em.merge(ligne);
    }
    
    
   
}
