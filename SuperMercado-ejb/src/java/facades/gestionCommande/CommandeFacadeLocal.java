/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionCommande;

import entités.gestionCommande.Commande;
import entités.gestionCommande.Fournisseur;
import entités.gestionMagasin.ChefRayon;
import entités.gestionMagasin.Rayon;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface CommandeFacadeLocal {

    void create(Commande commande);

    void edit(Commande commande);

    void remove(Commande commande);

    Commande find(Object id);

    List<Commande> findAll();

    List<Commande> findRange(int[] range);

    int count();
    
    void CreerBonCommande(ChefRayon chefRayon, Date dateCommande, Fournisseur fournisseur);
    
    Commande RechercherCommandeParId(Long idCommande);
    
    void ChangerStatutCommande(Commande commande,String statut);
    
    Commande RechercherDernierCommandeCree();
    
    List<Commande> RechercherListeBonCommmandeParStatutParChefRayon(String statut,ChefRayon chefRayon);
    
    List<Commande> RechercherListeBonCommmandeParChefRayon(ChefRayon chefRayon);
    
    List<Commande> RechercherListeBonCommmandeParFournisseur(Fournisseur fournisseur);
    
    List<Commande> RechercherListeBonCommmandeParRayonValider(Rayon r);
    
}
