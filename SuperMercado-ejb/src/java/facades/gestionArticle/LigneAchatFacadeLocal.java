/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.Achat;
import entités.gestionArticle.LigneAchat;
import entités.gestionArticle.LotArticle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface LigneAchatFacadeLocal {

    void create(LigneAchat ligneAchat);

    void edit(LigneAchat ligneAchat);

    void remove(LigneAchat ligneAchat);

    LigneAchat find(Object id);

    List<LigneAchat> findAll();

    List<LigneAchat> findRange(int[] range);

    int count();

    void CreerLigneAchat(int qteAchetees, LotArticle lotArticle, Achat achat);
    
}
