/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionMagasin.Personne;
import facades.gestionMagasin.AdminFacadeLocal;
import facades.gestionMagasin.PersonneFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Soldat
 */
@Stateless
public class SessionAdmin implements SessionAdminLocal {

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
        return i;
    }
    
    @Override
    public void CreerPersonneAdmin (){
        String login = "admin";
        String mdp="admin";
        adminFacade.CreerAdmin(login, mdp);
    }
}
