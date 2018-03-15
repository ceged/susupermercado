/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.ReferentielArticle;
import entités.gestionArticle.SousCategorie;
import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Rayon;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC Tim
 */
@Local
public interface ReferentielArticleFacadeLocal {

    void create(ReferentielArticle referentielArticle);

    void edit(ReferentielArticle referentielArticle);

    void remove(ReferentielArticle referentielArticle);

    ReferentielArticle find(Object id);

    List<ReferentielArticle> findAll();

    List<ReferentielArticle> findRange(int[] range);

    int count();
    
    public void CreerReferentielArticle (String libelleArticle, Rayon rayon, String marque, float prixVente, SousCategorie sousCategorie );
    
    public ReferentielArticle RechercheReferentielArticleParCodeBarre(Long codeBarreRecherche);
    
    public void ModifierPrixReferentielArticle (ReferentielArticle referentielArticleModifie,float newPrixVente);
    
    public void SupprimerReferentielArticle (ReferentielArticle referentielArticleSupprime);
    
    ReferentielArticle RechercherReferentielArticleParRayon(Rayon rayonRecherche, String referentielArticle);
    
}
