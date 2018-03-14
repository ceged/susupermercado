/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionMagasin.DirecteurMagasin;
import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Secteur;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Soldat
 */
@Local
public interface SessionDirecteurMagasinLocal {
    
    void CreerChefRayon(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal, String rayon);
    
    void CreerSecteur(String libelleSecteur, String magasin);
    
    void CreerRayon (String secteur, String libelleRayon);
    
    List<Secteur> ListerSecteur(DirecteurMagasin directeurMagasin);
    
    DirecteurMagasin ChercherDirecteurParId(String id);
    
}
