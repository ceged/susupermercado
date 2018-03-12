/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.DirecteurMagasin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface DirecteurMagasinFacadeLocal {

    void create(DirecteurMagasin directeurMagasin);

    void edit(DirecteurMagasin directeurMagasin);

    void remove(DirecteurMagasin directeurMagasin);

    DirecteurMagasin find(Object id);

    List<DirecteurMagasin> findAll();

    List<DirecteurMagasin> findRange(int[] range);

    int count();
    
}
