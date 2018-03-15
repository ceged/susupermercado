/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionMagasin.Caisse;
import entités.gestionMagasin.DirecteurMagasin;
import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Rayon;
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
    
    String CreerChefRayon(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal, String rayon, String magasin);
    
    String CreerSecteur(String libelleSecteur, String magasin);
 

    List ConsultationListeRayonsParMagasin(String nomMagasin);

    List ConsultationListeSecteurParMagasin(String nomMagasin);

    Rayon RechercherRayonParNomRayon(String nomRayon, String nomMagasin);

    String CreerRayon (String secteur, String libelleRayon);
    
    String CreerCaisse(Long id, String nomMagasin);
    
    List<Secteur> ListerSecteur(DirecteurMagasin directeurMagasin);
    
    DirecteurMagasin ChercherDirecteurParId(String id);

    Boolean LoginEstUnique(String login);

    List<Rayon> ConsultationRayonsSansChef(String magasin);

    List<Caisse> ConsultationCaisseParMagasin(String nomMagasin);
    
    String CreerAgentCaisse(String nom, String prenom, String login, String mdp, Date dob, String sexe, String adresse, String codePostal);
}
