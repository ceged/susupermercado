/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionArticle.Categorie;
import entités.gestionArticle.ReferentielArticle;
import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Personne;
import java.util.Date;
import java.util.List;
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
    
    String CreerDirecteur(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal, String magasin);
    
    Magasin ChercherMagasin(String nomMagasinRecherche);
    
    Personne PersonneConnecte(String login,String mp);

    void CreerCategorie (String categorie);

    String CreerSousCategorie(String libelleSousCategorie, String libelleCategorie);

    List<Categorie> ListerCategorie();

    
    String SupprimerMagasin(String nomMagasin);
    
    List<Magasin> ListerMagasin();


    String CreerPromotion(Date dateDeb,Date dateFin,float prixPromo, String libelle);

    List<ReferentielArticle>  ListerReferentielArticle();

    
    

  
}
