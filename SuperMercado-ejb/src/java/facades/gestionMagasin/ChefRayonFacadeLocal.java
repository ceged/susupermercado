/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.ChefRayon;
import entités.gestionMagasin.Rayon;
import java.util.Date;
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
    
    void CreerChefRayon(String nom, String prenom, String login, String mdp, Date dob, String sexe, String adresse, String codePostal, Rayon rayon);

    ChefRayon RechercherChefRayonParId(String idChefRayon);
    
}
