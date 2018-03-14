/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionArticle.Categorie;
import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Personne;
import facades.gestionArticle.CategorieFacadeLocal;
import facades.gestionArticle.SousCategorieFacadeLocal;
import facades.gestionMagasin.AdminFacadeLocal;
import facades.gestionMagasin.ChefRayonFacadeLocal;
import facades.gestionMagasin.DirecteurMagasinFacadeLocal;
import facades.gestionMagasin.MagasinFacadeLocal;
import facades.gestionMagasin.PersonneFacadeLocal;
import facades.gestionMagasin.SecteurFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Soldat
 */
@Stateless
public class SessionAdmin implements SessionAdminLocal {

    @EJB
    private ChefRayonFacadeLocal chefRayonFacade;

    @EJB
    private SousCategorieFacadeLocal sousCategorieFacade;

    @EJB
    private CategorieFacadeLocal categorieFacade;

    @EJB
    private DirecteurMagasinFacadeLocal directeurMagasinFacade;

    @EJB
    private MagasinFacadeLocal magasinFacade;

    @EJB
    private AdminFacadeLocal adminFacade;

    @EJB
    private PersonneFacadeLocal personneFacade;
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


  
    
  
    @Override
    public int  SeConnecter(String login, String mp){
        int i = 0;
        Personne personneConnecte =null;
        personneConnecte=personneFacade.SeConnecter(login, mp);
        if(adminFacade.findAll().contains(personneConnecte)){
            i=1;
        }
        else if (chefRayonFacade.findAll().contains(personneConnecte)){
            i=2;
        }
        else if (directeurMagasinFacade.findAll().contains(personneConnecte)){
            i=3;
        }
        return i;
    }
    
    @Override
    public Personne PersonneConnecte(String login,String mp){
        Personne personneConnecte =null;
        personneConnecte=personneFacade.SeConnecter(login, mp);
        return personneConnecte;
    }
    
    @Override
    public void CreerPersonneAdmin (){
        String login = "admin";
        String mdp="admin";
        adminFacade.CreerAdmin(login, mdp);
    }
    
    @Override
    public void CreerMagasin(String nomMagasin, String adresse, String codePostal){
        magasinFacade.CreerMagasin(nomMagasin, adresse, codePostal);
    }
    
        @Override 
    public String CreerDirecteur(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal, String magasin){
        String message ="Magasin inconnu";
        Magasin magasinRecherche = magasinFacade.RechercherMagasinParNom(magasin);
        if(magasinRecherche!=null){
            message="Directeur créé";
        }
        directeurMagasinFacade.CreerDirecteurMagasin(nom, prenom, login, mdp, sexe, dob, adresse, codePostal, magasinRecherche);
        return message;
    }
    
    @Override
    public Magasin ChercherMagasin(String nomMagasinRecherche){
        Magasin magasinRecherche=magasinFacade.RechercherMagasinParNom(nomMagasinRecherche);
        return magasinRecherche;
    }
    
    @Override
    public void CreerCategorie (String categorie){
        categorieFacade.CreerCategorie(categorie);
    }

    @Override
    public String CreerSousCategorie(String libelleSousCategorie, String libelleCategorie) {
        String message = "Catégorie incconnu";
        Categorie c = null ;
        
        c=categorieFacade.RechercherCategorie(libelleCategorie);
        
        if (c!=null){
            sousCategorieFacade.CreerSousCategorie(libelleSousCategorie, c);
            message = "Sous catégorie créé";
        } 
        return message;
    }
}
