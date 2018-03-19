/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import facades.gestionMagasin.PersonneFacadeLocal;
import java.lang.String;
import facades.gestionVenteEnLigne.ClientFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Sophia
 */
@Stateless
public class SessionClient implements SessionClientLocal {

    @EJB
    private PersonneFacadeLocal personneFacade;

    @EJB
    private ClientFacadeLocal clientFacade;
    
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String CreationCompteClient(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal) {
        String message;
        if(personneFacade.LoginEstUnique(login)==false)
        {
            message = "login existe déjà";
        }
        else
        {
            clientFacade.CreerClient(nom, prenom, login, mdp, sexe, dob, adresse, codePostal);
            message="Compte créé avec succès";
            }
        return message; 
    }
}
    
