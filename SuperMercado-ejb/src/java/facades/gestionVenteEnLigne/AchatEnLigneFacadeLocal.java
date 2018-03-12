/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionVenteEnLigne;

import entités.gestionVenteEnLigne.AchatEnLigne;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface AchatEnLigneFacadeLocal {

    void create(AchatEnLigne achatEnLigne);

    void edit(AchatEnLigne achatEnLigne);

    void remove(AchatEnLigne achatEnLigne);

    AchatEnLigne find(Object id);

    List<AchatEnLigne> findAll();

    List<AchatEnLigne> findRange(int[] range);

    int count();
    
}
