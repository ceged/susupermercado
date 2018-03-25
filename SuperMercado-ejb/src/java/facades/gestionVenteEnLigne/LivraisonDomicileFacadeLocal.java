/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionVenteEnLigne;

import entités.gestionVenteEnLigne.AchatEnLigne;
import entités.gestionVenteEnLigne.Creneau;
import entités.gestionVenteEnLigne.LivraisonDomicile;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface LivraisonDomicileFacadeLocal {

    void create(LivraisonDomicile livraisonDomicile);

    void edit(LivraisonDomicile livraisonDomicile);

    void remove(LivraisonDomicile livraisonDomicile);

    LivraisonDomicile find(Object id);

    List<LivraisonDomicile> findAll();

    List<LivraisonDomicile> findRange(int[] range);

    int count();
    
    void CreerLivraisonDomicile(AchatEnLigne achat, String adresse, String codePostal, String ville, Creneau creneau );
}
