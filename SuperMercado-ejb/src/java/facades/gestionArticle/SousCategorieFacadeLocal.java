/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.Categorie;
import entités.gestionArticle.SousCategorie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface SousCategorieFacadeLocal {

    void create(SousCategorie sousCategorie);

    void edit(SousCategorie sousCategorie);

    void remove(SousCategorie sousCategorie);

    SousCategorie find(Object id);

    List<SousCategorie> findAll();

    List<SousCategorie> findRange(int[] range);

    int count();
    
    void CreerSousCategorie(String libelleSousCategorie, Categorie categorie);
    
    SousCategorie RechercherSousCategorie(String libelleSousCategorieRecherche);
    
}
