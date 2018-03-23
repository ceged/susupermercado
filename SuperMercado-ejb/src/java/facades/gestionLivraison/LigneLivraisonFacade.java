/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionLivraison;

import entités.gestionArticle.ReferentielArticle;
import entités.gestionCommande.LigneCommande;
import entités.gestionLivraison.LigneLivraison;
import entités.gestionLivraison.Livraison;
import entités.gestionLivraison.Mention;
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
public class LigneLivraisonFacade extends AbstractFacade<LigneLivraison> implements LigneLivraisonFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LigneLivraisonFacade() {
        super(LigneLivraison.class);
    }
    
    @Override
    public void CreerLigneLivraison(Livraison livraison, ReferentielArticle article, int quantite, LigneCommande ligneCommande){
        LigneLivraison l= new LigneLivraison();
        l.setLivraison(livraison);
        l.setLigneCommande(ligneCommande);
        l.setArticle(article);
        l.setQuantiteFournisseur(quantite);
        l.setMentionStatut(Mention.attente);
        em.persist(l);
    }
    
    @Override
    public void ModifierStatutLigneLivraison(LigneLivraison l,String statut){
        if(statut.compareTo("receptionner")==0){
        l.setMentionStatut(Mention.receptionner);}
        if(statut.compareTo("attente")==0){
        l.setMentionStatut(Mention.attente);}
        if(statut.compareTo("encours")==0){
        l.setMentionStatut(Mention.enCours);}
        else if(statut.compareTo("nonlivrer")==0){
        l.setMentionStatut(Mention.nonlivrer);}
        else if(statut.compareTo("valider")==0){
        l.setMentionStatut(Mention.validation);}
        else if(statut.compareTo("reclamationCommande")==0){
        l.setMentionStatut(Mention.reclamationCommande);}
        else if(statut.compareTo("reclamationLivraison")==0){
        l.setMentionStatut(Mention.reclamationLivraison);}
        else if(statut.compareTo("reclamationQualite")==0){
        l.setMentionStatut(Mention.reclamationQualite);}
        em.merge(l);
    }
            
    
    @Override
    public List<LigneLivraison> ChercherListeLigneLivraisonParLivraison(Livraison livraison){
        List<LigneLivraison> liste= new ArrayList<LigneLivraison>();
        Query req=getEntityManager().createQuery("SELECT l from LigneLivraison as l where l.livraison=:livraison");
        req.setParameter("livraison",livraison);
            Collection<LigneLivraison>col=req.getResultList();
            for(LigneLivraison l:col)
    {
        liste.add(l);
    }
        return liste;
    }
    
    @Override
    public LigneLivraison ChercherLigneLivraisonParId(Long ligneId){
        LigneLivraison ligne= new LigneLivraison();
        Query req=getEntityManager().createQuery("SELECT l from LigneLivraison as l where l.id=:ligneId");
        req.setParameter("ligneId",ligneId);
            Collection<LigneLivraison>col=req.getResultList();
            for(LigneLivraison l:col)
    {
        ligne=l;
    }
        return ligne;
    }
    
    @Override
    public void ModifierQuantiteLigneLivraison(LigneLivraison l, int qtReceptionner, int qtLivrer){
        l.setQuantiteReceptionnee(qtReceptionner);
        l.setQuantiteLivree(qtLivrer);
        em.merge(l);
    }
    
    
}
