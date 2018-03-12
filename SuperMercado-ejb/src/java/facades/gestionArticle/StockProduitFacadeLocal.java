/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.StockProduit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface StockProduitFacadeLocal {

    void create(StockProduit stockProduit);

    void edit(StockProduit stockProduit);

    void remove(StockProduit stockProduit);

    StockProduit find(Object id);

    List<StockProduit> findAll();

    List<StockProduit> findRange(int[] range);

    int count();
    
}
