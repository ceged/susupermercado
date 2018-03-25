/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.LotArticle;
import entités.gestionArticle.ReferentielArticle;
import entités.gestionLivraison.LigneLivraison;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface LotArticleFacadeLocal {

    void create(LotArticle lotArticle);

    void edit(LotArticle lotArticle);

    void remove(LotArticle lotArticle);

    LotArticle find(Object id);

    List<LotArticle> findAll();

    List<LotArticle> findRange(int[] range);

    int count();

    void ModifierQteLotArticle(int qteAModifier, LotArticle LotArticle);

    LotArticle RechercherLotArticleParId(long IdLotArticle);

    void CreerLotArticle(int qteLotArticle, ReferentielArticle refLotArticle, LigneLivraison l);

    LotArticle RechercherLotArticleFIFO(ReferentielArticle article);
    
    LotArticle RechercherLotArticleParNom(String nom);
}
