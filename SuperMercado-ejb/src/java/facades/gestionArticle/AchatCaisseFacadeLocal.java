/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.AchatCaisse;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface AchatCaisseFacadeLocal {

    void create(AchatCaisse achatCaisse);

    void edit(AchatCaisse achatCaisse);

    void remove(AchatCaisse achatCaisse);

    AchatCaisse find(Object id);

    List<AchatCaisse> findAll();

    List<AchatCaisse> findRange(int[] range);

    int count();
    
}
