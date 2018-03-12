/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.Personne;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface PersonneFacadeLocal {

    void create(Personne personne);

    void edit(Personne personne);

    void remove(Personne personne);

    Personne find(Object id);

    List<Personne> findAll();

    List<Personne> findRange(int[] range);

    int count();
    
    Personne SeConnecter(String login, String mdp);

    void ModifierMdp(long id, String mdpActuel, String mdpNouveau);

    Personne RechercherPersonneParId(String id);

    List RechercherPersonneParNom(String nom);
    
}
