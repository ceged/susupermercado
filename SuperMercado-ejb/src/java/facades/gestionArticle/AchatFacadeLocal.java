/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.Achat;
import entités.gestionArticle.LigneAchat;
import entités.gestionVenteEnLigne.Client;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface AchatFacadeLocal {

    void create(Achat achat);

    void edit(Achat achat);

    void remove(Achat achat);

    Achat find(Object id);

    List<Achat> findAll();

    List<Achat> findRange(int[] range);

    int count();

    Achat CreerAchat(Date dateAchat);
    
    Achat RechercheAchatParId(Long idAchat);

    List<LigneAchat> getListeLigneAchat(Achat achat);

    void ValiderAchat(Achat achat);
    
}
