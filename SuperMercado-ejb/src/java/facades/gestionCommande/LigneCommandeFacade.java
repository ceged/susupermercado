/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionCommande;

import entités.gestionArticle.ReferentielArticle;
import entités.gestionCommande.Commande;
import entités.gestionCommande.LigneCommande;
import java.util.ArrayList;
import java.util.Collection;
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
public class LigneCommandeFacade extends AbstractFacade<LigneCommande> implements LigneCommandeFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LigneCommandeFacade() {
        super(LigneCommande.class);
    }
    
    @Override
    public void SupprimerLigneCommande(LigneCommande ligneCommandeSupp){
        em.remove(ligneCommandeSupp);
    }
    
    @Override
    public void CreerLigneCommandeParBonCommande(ReferentielArticle articleAchat, Commande commandeEnCours, Float prix, int quantite ){
        LigneCommande ligneCommande = new LigneCommande();
        ligneCommande.setArticle(articleAchat);
        ligneCommande.setCommande(commandeEnCours);
        ligneCommande.setPrixAchatUnitaire(prix);
        ligneCommande.setQuantiteLigne(quantite);
        em.persist(ligneCommande);
        
    }
    
    @Override
    public LigneCommande ChercherLigneCommandeParId(Long idLCommande){
        LigneCommande l=null;
        Query req = getEntityManager().createQuery("Select l from LigneCommande as l where l.id=:idLCommande");
        req.setParameter("idLCommande", idLCommande);
        Collection<LigneCommande>col=req.getResultList();
            for(LigneCommande c:col)
    {
        l=c;
    }
        return l;
    }
    
    
    @Override
    public List<LigneCommande> RechercherListeLigneCommandeParCommande(Commande commande){
        List<LigneCommande> listeLigneCommande = new ArrayList();
        Query req = getEntityManager().createQuery("Select l from LigneCommande as l where l.commande=:commande");
        req.setParameter("commande", commande);
        Collection<LigneCommande>col=req.getResultList();
            for(LigneCommande c:col)
    {
        listeLigneCommande.add(c);
    }
        return listeLigneCommande;
    }
    
}
