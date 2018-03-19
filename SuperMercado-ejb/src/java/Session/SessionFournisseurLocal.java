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
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Soldat
 */
@Local
public interface SessionFournisseurLocal {
    
    Fournisseur ChercherFournisseurParId(String id);
    
    List<Commande> ChercherListeCommandeParFournisseur(String fournisseurId);
    
    void CreerLivraison(Commande commande);
    
    void CreerLigneLivraison(Livraison livraison,LigneCommande lc);
    
    Livraison ChercherLivraisonParCommandeParStatut(String statut, Commande commande);
    
    List<Livraison> ChercherListeLivraisonParFournisseur(String idFournisseur);
    
    Livraison ChercherLivraisonParId(String idLivraison);
    
    List<LigneLivraison> ChercherListeLigneLivraisonParLivraison(Livraison livraison);
    
    LigneLivraison ChercherLigneLivraisonParId(String idLigne);
    
    void ModifierStatutLigneLivraison(LigneLivraison ligne, String statut);
}
