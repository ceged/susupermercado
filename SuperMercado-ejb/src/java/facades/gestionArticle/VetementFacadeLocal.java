/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.ReferentielArticle;
import entités.gestionArticle.Vetement;
import entités.gestionLivraison.LigneLivraison;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface VetementFacadeLocal {

    void create(Vetement vetement);

    void edit(Vetement vetement);

    void remove(Vetement vetement);

    Vetement find(Object id);

    List<Vetement> findAll();

    List<Vetement> findRange(int[] range);
    
    void CreerLotArticleVetement(int qteLotArticle, ReferentielArticle refLotArticle,String taille, String couleur, LigneLivraison l);

    int count();
    
}
