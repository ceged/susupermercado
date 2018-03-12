/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionLivraison;

import entités.gestionLivraison.LigneLivraison;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface LigneLivraisonFacadeLocal {

    void create(LigneLivraison ligneLivraison);

    void edit(LigneLivraison ligneLivraison);

    void remove(LigneLivraison ligneLivraison);

    LigneLivraison find(Object id);

    List<LigneLivraison> findAll();

    List<LigneLivraison> findRange(int[] range);

    int count();
    
}
