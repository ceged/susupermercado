/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionMagasin.AgentCaisse;
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
    
    Caisse RechercherCaisseParIdCaisse(Long idCaisse, String nomMagasin);

    String CreerRayon (String secteur, String libelleRayon);
    
    String CreerCaisse(Long id, String nomMagasin);
    
    DirecteurMagasin ChercherDirecteurParId(String id);

    Boolean LoginEstUnique(String login);

    List<Rayon> ConsultationRayonsSansChef(String magasin);

    List<Caisse> ConsultationCaisseParMagasin(String nomMagasin);
    
    String CreerAgentCaisse(String nom, String prenom, String login, String mdp, Date dob, String sexe, String adresse, String codePostal, String nomMagasin);
    
    List <Secteur> ConsultationListeSecteursParMagasin(String nomMagasin);
    
    List<Rayon> ListerRayon();
    
    List<Caisse> ListerCaisse();
    
    String SupprimerRayon(String magasin, String rayon);
    
    String SupprimerCaisse(Long caisse,String magasin);
    
    String ModifierLibelleRayon(String LibelleRayon, String newLibelleRayon, String magasin);
    
    List<Rayon> ConsulterListeRayonParDirecteur(DirecteurMagasin directeur);
    
    String CreerAgentRayon(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal, String rayon, String nomMagasin);
    
    

    String CreationAffectation(String nomCaisse, String nomAgentCaisse, Date dateDebut, Date dateFin, String nomMagasin);
    
    List <AgentCaisse> ConsultationListeAgentCaisseParMagasin(String nomMagasin);
    
    void CreerAgentLivraison(String prenom, String nom, String login, String mdp, Date dob, String sexe, String adresse, String codePostal, String nomMagasin);
}
