/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionCommande;

import entités.gestionCommande.Fournisseur;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface FournisseurFacadeLocal {

    void create(Fournisseur fournisseur);

    void edit(Fournisseur fournisseur);

    void remove(Fournisseur fournisseur);

    Fournisseur find(Object id);

    List<Fournisseur> findAll();

    List<Fournisseur> findRange(int[] range);

    int count();
    
    void CreerFournisseur(String prenom, String nom, String login, String mdp, Date dob, String sexe, String adresse, String codePostal);
    
    List<Fournisseur>ConsulterListeFournisseur();
    
    Fournisseur RechercheFournisseurParId(Long idFournisseur);
    
    Fournisseur RechercheFournisseurParNom(String nomFournisseur);
    
}
