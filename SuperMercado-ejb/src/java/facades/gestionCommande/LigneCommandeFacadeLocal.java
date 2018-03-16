/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionCommande;

import entités.gestionArticle.ReferentielArticle;
import entités.gestionCommande.Commande;
import entités.gestionCommande.LigneCommande;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface LigneCommandeFacadeLocal {

    void create(LigneCommande ligneCommande);

    void edit(LigneCommande ligneCommande);

    void remove(LigneCommande ligneCommande);

    LigneCommande find(Object id);

    List<LigneCommande> findAll();

    List<LigneCommande> findRange(int[] range);

    int count();
    
    void SupprimerLigneCommande(LigneCommande ligneCommandeSupp);
    
    void CreerLigneCommandeParBonCommande(ReferentielArticle articleAchat, Commande commandeEnCours, Float prix, int quantite );
    
    List<LigneCommande> RechercherListeLigneCommandeParCommande(Commande commande);
    
}
