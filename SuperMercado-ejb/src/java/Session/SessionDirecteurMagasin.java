/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Rayon;
import facades.gestionMagasin.ChefRayonFacadeLocal;
import facades.gestionMagasin.DirecteurMagasinFacadeLocal;
import facades.gestionMagasin.MagasinFacadeLocal;
import facades.gestionMagasin.SecteurFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Soldat
 */
@Stateless
public class SessionDirecteurMagasin implements SessionDirecteurMagasinLocal {

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
    public void CreerSecteur(String libelleSecteur, String nomMagasin) {
        Magasin magasin = magasinFacade.RechercherMagasinParNom(nomMagasin);
        secteurFacade.CreerSecteur(libelleSecteur, magasin);
    }  }
