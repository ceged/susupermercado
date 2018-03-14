/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionMagasin.DirecteurMagasin;
import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Rayon;
import entités.gestionMagasin.Secteur;
import facades.gestionMagasin.ChefRayonFacadeLocal;
import facades.gestionMagasin.DirecteurMagasinFacadeLocal;
import facades.gestionMagasin.MagasinFacadeLocal;
import facades.gestionMagasin.RayonFacadeLocal;
import facades.gestionMagasin.SecteurFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Soldat
 */
@Stateless
public class SessionDirecteurMagasin implements SessionDirecteurMagasinLocal {

    @EJB
    private RayonFacadeLocal rayonFacade;

    @EJB
    private ChefRayonFacadeLocal chefRayonFacade;

    @EJB
    private SecteurFacadeLocal secteurFacade;

    @EJB
    private MagasinFacadeLocal magasinFacade;

    @EJB
    private DirecteurMagasinFacadeLocal directeurMagasinFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
@Override 
    public void CreerChefRayon(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal, String rayon){
        //Faire methode recherche rayon
        Rayon rayonRecherche=null;
        chefRayonFacade.CreerChefRayon(nom, prenom, login, mdp, dob, sexe, adresse, codePostal, rayonRecherche);
    }
@Override
    public String CreerSecteur(String libelleSecteur, String nomMagasin) {
        String message = "magasin inconnu";
        Magasin magasin = magasinFacade.RechercherMagasinParNom(nomMagasin);
        if (magasin != null){
        secteurFacade.CreerSecteur(libelleSecteur, magasin);
        message = "Secteur créé";
        }
    
        return message;
    }

@Override 
public String CreerRayon (String secteur, String libelleRayon){
     String message = "secteur inconnu";
     
     Secteur secteurCherche = secteurFacade.RechercherSecteurParLibelle(secteur);
     if (secteurCherche != null ){
   
    rayonFacade.CreerRayon(secteurCherche, libelleRayon);
    message = "Rayon Créé";
    
}
     return message ;
}

@Override
public List<Secteur> ListerSecteur(DirecteurMagasin directeurMagasin){
    List<Secteur> listeSecteur= directeurMagasin.getMagasin().getListeSecteurs();
    return listeSecteur;
}

@Override
public DirecteurMagasin ChercherDirecteurParId(String id){
    DirecteurMagasin directeurCherche =directeurMagasinFacade.RechercherDirecteurParId(id);
    return directeurCherche;
}

}