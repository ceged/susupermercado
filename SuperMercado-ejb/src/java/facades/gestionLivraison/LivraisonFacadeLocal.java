/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionLivraison;

import entités.gestionCommande.Commande;
import entités.gestionCommande.Fournisseur;
import entités.gestionLivraison.Livraison;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface LivraisonFacadeLocal {

    void create(Livraison livraison);

    void edit(Livraison livraison);

    void remove(Livraison livraison);

    Livraison find(Object id);

    List<Livraison> findAll();

    List<Livraison> findRange(int[] range);

    int count();
    
    Livraison CreerLivraison(Commande commande,String Statut);
    
    Livraison ChercherLivraisonParCommandeParStatut(String statut,Commande commande);
    
    List<Livraison> ChercherListeLivraisonParFournisseur(Fournisseur fournisseur);
    
     Livraison ChercherLivraisonParId(Long idLivraison);
     
     void ModifierStatutLivraison(Livraison livraison, String statut);
    
}
