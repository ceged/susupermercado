/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionLivraison;

import entités.gestionCommande.Commande;
import entités.gestionCommande.Fournisseur;
import entités.gestionLivraison.Livraison;
import entités.gestionMagasin.Magasin;
import java.util.ArrayList;
import java.util.Collection;
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
public class LivraisonFacade extends AbstractFacade<Livraison> implements LivraisonFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LivraisonFacade() {
        super(Livraison.class);
    }
    
    @Override
    public Livraison CreerLivraison(Commande commande,String Statut){
        Livraison l=new Livraison();
        l.setCommande(commande);
        l.setStatut(Statut);
        em.persist(l);
        return l;
    }
    
    @Override
    public Livraison ChercherLivraisonParCommandeParStatut(String statut,Commande commande){
        Livraison livraison=new Livraison();
        Query req=getEntityManager().createQuery("SELECT l from Livraison as l where l.commande=:commande AND l.Statut=:statut");
        req.setParameter("commande",commande);
        req.setParameter("statut",statut);
            Collection<Livraison>col=req.getResultList();
            for(Livraison l:col)
    {
        livraison=l;
    }
        return livraison;
    }
    
    @Override
    public Livraison ChercherLivraisonParId(Long idLivraison){
       Livraison livraison=new Livraison();
        Query req=getEntityManager().createQuery("SELECT l from Livraison as l where l.id=:idLivraison");
        req.setParameter("idLivraison",idLivraison);
            Collection<Livraison>col=req.getResultList();
            for(Livraison l:col)
    {
        livraison=l;
    }
        return livraison; 
    }
    
    @Override
    public List<Livraison> ChercherListeLivraisonParFournisseur(Fournisseur fournisseur){
        List<Livraison> liste= new ArrayList<Livraison>();
        Query req=getEntityManager().createQuery("SELECT l from Livraison as l where l.commande.fournisseur=:fournisseur");
        req.setParameter("fournisseur",fournisseur);
            Collection<Livraison>col=req.getResultList();
            for(Livraison l:col)
    {
        liste.add(l);
    }
        return liste;
    }
    
}
