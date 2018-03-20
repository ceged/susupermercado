/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionArticle.Achat;
import entités.gestionMagasin.Personne;
import entités.gestionVenteEnLigne.AchatEnLigne;
import entités.gestionVenteEnLigne.Client;
import facades.gestionArticle.AchatCaisseFacadeLocal;
import facades.gestionArticle.AchatFacadeLocal;
import facades.gestionMagasin.PersonneFacadeLocal;
import facades.gestionVenteEnLigne.AchatEnLigneFacadeLocal;
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
    private AchatFacadeLocal achatFacade;

    @EJB
    private AchatEnLigneFacadeLocal achatEnLigneFacade;

    @EJB
    private AchatCaisseFacadeLocal achatCaisseFacade;

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

    @Override
    public AchatEnLigne CreationAchatEnLigne(String idClient) {
    Long id = Long.valueOf(idClient);
    Personne p = personneFacade.RechercherPersonneParId(id);
    Client c = (Client) p;
    AchatEnLigne a = achatEnLigneFacade.CreationAchatEnLigne(c);
    return a;
    }

    @Override
    public AchatEnLigne RechercheAchatParId(String id) {
        Long idAchat = Long.valueOf(id);
        Achat a = achatFacade.RechercheAchatParId(idAchat);
        AchatEnLigne achatenligne = (AchatEnLigne) a;
        return achatenligne;
    }
    
    
}
    
