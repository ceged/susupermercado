/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.DirecteurMagasin;
import entités.gestionMagasin.Magasin;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface DirecteurMagasinFacadeLocal {

    void create(DirecteurMagasin directeurMagasin);

    void edit(DirecteurMagasin directeurMagasin);

    void remove(DirecteurMagasin directeurMagasin);

    DirecteurMagasin find(Object id);

    List<DirecteurMagasin> findAll();

    List<DirecteurMagasin> findRange(int[] range);

    int count();
    
    void CreerDirecteurMagasin(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal, Magasin magasin);
    
    DirecteurMagasin RechercherDirecteurParId(String idDirecteur);
    
}
