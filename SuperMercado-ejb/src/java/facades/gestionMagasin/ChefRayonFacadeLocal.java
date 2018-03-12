/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.ChefRayon;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface ChefRayonFacadeLocal {

    void create(ChefRayon chefRayon);

    void edit(ChefRayon chefRayon);

    void remove(ChefRayon chefRayon);

    ChefRayon find(Object id);

    List<ChefRayon> findAll();

    List<ChefRayon> findRange(int[] range);

    int count();
    
}
