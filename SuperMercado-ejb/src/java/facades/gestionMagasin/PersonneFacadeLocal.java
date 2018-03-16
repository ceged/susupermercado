/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import com.sun.org.apache.xpath.internal.operations.Bool;
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

    Personne RechercherPersonneParId(Long id);

    List RechercherPersonneParNom(String nom);

    void SupprimerPersonne(Personne personne);

    Personne GetPersonneParLogin(String login);   

    Boolean LoginEstUnique(String login);
}
