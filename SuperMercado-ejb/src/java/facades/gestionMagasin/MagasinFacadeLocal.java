/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.Magasin;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface MagasinFacadeLocal {

    void create(Magasin magasin);

    void edit(Magasin magasin);

    void remove(Magasin magasin);

    Magasin find(Object id);

    List<Magasin> findAll();

    List<Magasin> findRange(int[] range);

    int count();
    
    void CreerMagasin(String nomMagasin,String adresse, String codePostal);
    
    void SupprimerMagasin(Magasin magasinasupprimer);
    
    Magasin RechercherMagasinParNom(String nomMagasinRecherche);

    Collection ConsulterListeMagasins();
}
