/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface SessionChefDeRayonLocal {
    
    void CreerArticle(String libelleArticle, String magasin, String marque, Float prixVente, String libelleSousCategorieRecherche);
}
