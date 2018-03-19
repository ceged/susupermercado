/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionCommande.Commande;
import entités.gestionCommande.Fournisseur;
import entités.gestionCommande.LigneCommande;
import entités.gestionLivraison.LigneLivraison;
import entités.gestionLivraison.Livraison;
import facades.gestionCommande.CommandeFacadeLocal;
import facades.gestionCommande.FournisseurFacadeLocal;
import facades.gestionCommande.LigneCommandeFacadeLocal;
import facades.gestionLivraison.LigneLivraisonFacadeLocal;
import facades.gestionLivraison.LivraisonFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Soldat
 */
@Stateless
public class SessionFournisseur implements SessionFournisseurLocal {

    @EJB
    private LigneCommandeFacadeLocal ligneCommandeFacade;

    @EJB
    private LigneLivraisonFacadeLocal ligneLivraisonFacade;

    @EJB
    private LivraisonFacadeLocal livraisonFacade;

    @EJB
    private CommandeFacadeLocal commandeFacade;

    @EJB
    private FournisseurFacadeLocal fournisseurFacade;

    
    @Override
    public Fournisseur ChercherFournisseurParId(String id){
        Long idFournisseur=Long.parseLong(id);
        Fournisseur f=fournisseurFacade.RechercheFournisseurParId(idFournisseur);
        return f;
    }
    
    @Override
    public List<Commande> ChercherListeCommandeParFournisseur(String fournisseurId){
        Fournisseur fournisseur = this.ChercherFournisseurParId(fournisseurId);
        List<Commande> liste=commandeFacade.RechercherListeBonCommmandeParFournisseur(fournisseur);
        return liste;
    }
    
    @Override
    public void CreerLivraison(Commande commande){
        String statut="encours";
        Livraison livraison=livraisonFacade.CreerLivraison(commande, statut);
        List<LigneCommande>liste=ligneCommandeFacade.RechercherListeLigneCommandeParCommande(commande);
        for (LigneCommande l:liste){
            this.CreerLigneLivraison(livraison, l);
        }
    }
    
    @Override
    public void ModifierStatutLivraison(String idLivraison, String statut){
        Long id=Long.parseLong(idLivraison);
        Livraison livraison = livraisonFacade.ChercherLivraisonParId(id);
        livraisonFacade.ModifierStatutLivraison(livraison, statut);
    }
    
    @Override
    public void CreerLigneLivraison(Livraison livraison,LigneCommande lc){
        ligneLivraisonFacade.CreerLigneLivraison(livraison,lc.getArticle(),lc.getQuantiteLigne());
    }
    
    @Override
    public Livraison ChercherLivraisonParCommandeParStatut(String statut, Commande commande){
        Livraison l= new Livraison();
        l=livraisonFacade.ChercherLivraisonParCommandeParStatut(statut, commande);
        return l;
    }
    
    @Override
    public List<Livraison> ChercherListeLivraisonParFournisseur(String idFournisseur){
        Long id=Long.parseLong(idFournisseur);
        Fournisseur fournisseur=fournisseurFacade.RechercheFournisseurParId(id);
        List<Livraison> liste=livraisonFacade.ChercherListeLivraisonParFournisseur(fournisseur);
        return liste;
    }
    
    @Override
    public Livraison ChercherLivraisonParId(String idLivraison){
            Long id=Long.parseLong(idLivraison);
            Livraison livraison=livraisonFacade.ChercherLivraisonParId(id);
            return livraison;
    }
            
     @Override
     public List<LigneLivraison> ChercherListeLigneLivraisonParLivraison(Livraison livraison){
        List<LigneLivraison> liste= ligneLivraisonFacade.ChercherListeLigneLivraisonParLivraison(livraison);
        return liste;
    }
     
     @Override
     public LigneLivraison ChercherLigneLivraisonParId(String idLigne){
         Long id=Long.parseLong(idLigne);
         LigneLivraison l=ligneLivraisonFacade.ChercherLigneLivraisonParId(id);
         return l;
     }
     
     @Override
     public void ModifierStatutLigneLivraison(LigneLivraison ligne, String statut){
         ligneLivraisonFacade.ModifierStatutLigneLivraison(ligne, statut);
     }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
