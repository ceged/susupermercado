/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionArticle.ReferentielArticle;
import entités.gestionArticle.SousCategorie;
import entités.gestionCommande.Commande;
import entités.gestionCommande.Fournisseur;
import entités.gestionCommande.LigneCommande;
import entités.gestionMagasin.ChefRayon;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface SessionChefDeRayonLocal {
    
    String CreerReferentielArticle(String libelleArticle,String magasin, String rayon, String marque, Float prixVente, String libelleSousCategorieRecherche, List<Fournisseur> listeFournisseur);
    
    List<SousCategorie> ListerSousCategorie();
    
    List<Fournisseur> ListerFournisseur();
    
    String ModifierPrixReferentielArticle(String libelleArticle, String rayon,String magasin, float newPrix);
    
    ChefRayon ChercherChefRayonParId(String id);
    
    String SupprimerReferentielArticle(Long idArticle, String rayon,String magasin);
    
    List<ReferentielArticle> ConsulterListeArticleParChefRayon(ChefRayon chefRayon);
    
    String CreerFournisseur(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal);
    
    Fournisseur ChercherFournisseurParId(Long idFournisseur);
    
    String CreerBonCommande(String idChefRayon, Date dateCommande, String fournisseur);
    
    Commande ChercherDernierCommande();
    
    void CreerLigneBonCommande(Long idArticle, Long idCommande, float Prix, int Quantite );
    
    Commande RechercherCommandeParId(Long id);
    
    List<LigneCommande> RechercherListLigneCommandeParCommande(Commande commande);
    
    void ValiderBonCommande(Commande commande);
    
    void SupprimerLigneCommande(LigneCommande ligneCommande);
    
    LigneCommande ChercherLigneCommandeParId(Long id);
    
    List<Commande>RechercherListeCommandeParStatutParChefRayon(String statut, String idChefRayon);
    
    List<Commande>RecherListeCommandeParChefRayon(String idChefRayon);
    
}
