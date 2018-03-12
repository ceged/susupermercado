/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionLivraison;

import entités.gestionLivraison.Reclamation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface ReclamationFacadeLocal {

    void create(Reclamation reclamation);

    void edit(Reclamation reclamation);

    void remove(Reclamation reclamation);

    Reclamation find(Object id);

    List<Reclamation> findAll();

    List<Reclamation> findRange(int[] range);

    int count();
    
}
