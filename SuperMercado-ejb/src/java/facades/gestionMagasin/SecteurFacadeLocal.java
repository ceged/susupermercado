/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionMagasin;

import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Secteur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface SecteurFacadeLocal {

    void create(Secteur secteur);

    void edit(Secteur secteur);

    void remove(Secteur secteur);

    Secteur find(Object id);

    List<Secteur> findAll();

    List<Secteur> findRange(int[] range);

    int count();
    
    public void CreerSecteur(String libelle, Magasin magasin);
    
    public void ModifierSecteur(Secteur secteur, String libelle);
    
    void SupprimerSecteur(Secteur secteur);
    
    Secteur RechercherSecteurParId (int id);
    
    Secteur RechercherSecteurParLibelle (String libelleSecteur);
}
