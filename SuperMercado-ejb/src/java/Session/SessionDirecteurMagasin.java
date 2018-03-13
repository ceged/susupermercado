/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionMagasin.Magasin;
import facades.gestionMagasin.DirecteurMagasinFacadeLocal;
import facades.gestionMagasin.MagasinFacadeLocal;
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
    private MagasinFacadeLocal magasinFacade;

    @EJB
    private DirecteurMagasinFacadeLocal directeurMagasinFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override 
    public void CreerDirecteur(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal, String magasin){
        Magasin magasinRecherche = magasinFacade.RechercherMagasinParNom(magasin);
        directeurMagasinFacade.CreerDirecteurMagasin(nom, prenom, login, mdp, sexe, dob, adresse, codePostal, magasinRecherche);
    }
}
