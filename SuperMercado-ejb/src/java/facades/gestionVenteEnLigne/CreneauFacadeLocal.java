/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionVenteEnLigne;

import entités.gestionMagasin.Magasin;
import entités.gestionVenteEnLigne.Creneau;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface CreneauFacadeLocal {

    void create(Creneau creneau);

    void edit(Creneau creneau);

    void remove(Creneau creneau);

    Creneau find(Object id);

    List<Creneau> findAll();

    List<Creneau> findRange(int[] range);

    int count();
    
   void CreerCreneau(Time heureDebut, Time heureFin, Date date, Magasin magasin);
    
    void ModifierCreneau(Creneau creneau);
    
    Creneau ChercherCreneauParId(String idCreneau);
    
    Creneau ChercherCreneauHoraire(Date heureDebut, Date heureFin);
    
    List<Creneau> ChercherCreneauDispo();
    
    List<Creneau> ChercherCreneauDispoParMagasin(Magasin magasin);
    
    List<Creneau> ChercherCreneauDispoParMagasinParDate(Magasin magasin,Date date);
    
    List<Creneau> ChercherCreneauParMagasin(Magasin magasin);
    
}
