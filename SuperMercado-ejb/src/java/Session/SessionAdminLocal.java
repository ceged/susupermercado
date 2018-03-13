/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Personne;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Soldat
 */
@Local
public interface SessionAdminLocal {
    
    int SeConnecter(String login, String mp );
    
    void CreerPersonneAdmin ();
    
    void CreerMagasin(String nomMagasin, String adresse, String codePostal);
    
    void CreerDirecteur(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal, String magasin);
    
    Magasin ChercherMagasin(String nomMagasinRecherche);
    
    Personne PersonneConnecte(String login,String mp);
    
    void SupprimerMagasin(String magasin,Magasin magasinasupprimer);
    

    void CreerCategorie (String categorie);

    void CreerSousCategorie(String libelleSousCategorie, String libelleCategorie);
  
}
