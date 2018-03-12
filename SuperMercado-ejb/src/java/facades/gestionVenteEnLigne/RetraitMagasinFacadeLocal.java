/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionVenteEnLigne;

import entités.gestionVenteEnLigne.RetraitMagasin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface RetraitMagasinFacadeLocal {

    void create(RetraitMagasin retraitMagasin);

    void edit(RetraitMagasin retraitMagasin);

    void remove(RetraitMagasin retraitMagasin);

    RetraitMagasin find(Object id);

    List<RetraitMagasin> findAll();

    List<RetraitMagasin> findRange(int[] range);

    int count();
    
}
