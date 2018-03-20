/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionMagasin.Personne;
import javax.ejb.Local;

/**
 *
 * @author Sophia
 */
@Local
public interface SessionPersonneLocal {

    void ModificationMdp(String ancienMdp, String nouveauMdp, String idPersonne);

    Personne RechercherPersonneParId(String idPersonne);
    
}
