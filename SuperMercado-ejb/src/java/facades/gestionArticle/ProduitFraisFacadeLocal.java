/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.ProduitFrais;
import entités.gestionArticle.ReferentielArticle;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface ProduitFraisFacadeLocal {

    void create(ProduitFrais produitFrais);

    void edit(ProduitFrais produitFrais);

    void remove(ProduitFrais produitFrais);

    ProduitFrais find(Object id);

    List<ProduitFrais> findAll();

    List<ProduitFrais> findRange(int[] range);
    
    void CreerLotArticleFrais(int qteProduitFrais, ReferentielArticle refLotArticle,Date datePeremption);

    int count();
    
}
