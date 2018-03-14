/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.ChefRayon;
import entités.gestionMagasin.Rayon;
import entités.gestionMagasin.Secteur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface RayonFacadeLocal {

    void create(Rayon rayon);

    void edit(Rayon rayon);

    void remove(Rayon rayon);

    Rayon find(Object id);

    List<Rayon> findAll();

    List<Rayon> findRange(int[] range);

    int count();
    
    void CreerRayon(Secteur secteur, String libelleRayon);
    
    void SupprimerRayon(Rayon rayonasupprimer);
    
    void ModifierRayon(Rayon rayon, ChefRayon chefRayon);
    
}
