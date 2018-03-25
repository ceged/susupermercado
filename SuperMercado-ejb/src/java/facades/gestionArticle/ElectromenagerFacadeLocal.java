/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.Electromenager;
import entités.gestionArticle.ReferentielArticle;
import entités.gestionLivraison.LigneLivraison;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface ElectromenagerFacadeLocal {

    void create(Electromenager electromenager);

    void edit(Electromenager electromenager);

    void remove(Electromenager electromenager);

    Electromenager find(Object id);

    List<Electromenager> findAll();

    List<Electromenager> findRange(int[] range);
    
    void CreerLotArticleElectromenager(int qteLotArticle, ReferentielArticle refLotArticle,int garantie, LigneLivraison l);
   
    int count();
    
}
