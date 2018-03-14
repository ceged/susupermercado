/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionMagasin.ChefRayon;
import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Secteur;
import facades.gestionMagasin.ChefRayonFacadeLocal;
import facades.gestionMagasin.DirecteurMagasinFacadeLocal;
import facades.gestionMagasin.MagasinFacadeLocal;
import facades.gestionMagasin.RayonFacadeLocal;
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
    public void CreerChefRayon(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal, String magasin){
        Magasin magasinRecherche = magasinFacade.RechercherMagasinParNom(magasin);
        directeurMagasinFacade.CreerDirecteurMagasin(nom, prenom, login, mdp, sexe, dob, adresse, codePostal, magasinRecherche);
    }
@Override
    public void CreerSecteur(String libelleSecteur, String nomMagasin) {
        Magasin magasin = magasinFacade.RechercherMagasinParNom(nomMagasin);
        secteurFacade.CreerSecteur(libelleSecteur, magasin);
    } 
@Override 
    public void CreerRayon(String libelleRayon, String libelleSecteur, String chefRayon){
        Secteur secteurRecherche = secteurFacade.RechercherSecteurParLibelle(libelleSecteur);
        ChefRayon chefRayonRecherche = chefRayonFacade.RechercherChefRayonParNom(chefRayon);
        rayonFacade.CreerRayon(secteurRecherche,libelleSecteur,chefRayonRecherche);
    }
}
