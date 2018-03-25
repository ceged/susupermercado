/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.Casse;
import entités.gestionArticle.LotArticle;
import entités.gestionMagasin.AgentRayon;
import entités.gestionMagasin.Rayon;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface CasseFacadeLocal {

    void create(Casse casse);

    void edit(Casse casse);

    void remove(Casse casse);

    Casse find(Object id);

    List<Casse> findAll();

    List<Casse> findRange(int[] range);

    int count();
    
    List<Casse> ChercherListeCasseParRayon(Rayon rayon);
    
    void CreerCasse(AgentRayon agent, Date dateCasse, LotArticle lot, String motifCasse, int quantiteCasse );
    
}
