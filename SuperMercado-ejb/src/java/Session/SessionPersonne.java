/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionMagasin.Personne;
import facades.gestionMagasin.PersonneFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Sophia
 */
@Stateless
public class SessionPersonne implements SessionPersonneLocal {

@EJB
    private PersonneFacadeLocal personneFacade;

    @Override
    public void ModificationMdp(String ancienMdp, String nouveauMdp, String idPersonne) {
        Long id=Long.parseLong(idPersonne);
        Personne personne = personneFacade.RechercherPersonneParId(id);
        personneFacade.ModifierMdp(personne, ancienMdp, nouveauMdp);
    }

    @Override
    public Personne RechercherPersonneParId(String idPersonne) {
        
        Long id=Long.parseLong(idPersonne);
        return personneFacade.RechercherPersonneParId(id);
    }

    
}
