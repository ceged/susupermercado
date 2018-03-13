/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionArticle.SousCategorie;
import entités.gestionMagasin.Magasin;
import facades.gestionArticle.CategorieFacadeLocal;
import facades.gestionArticle.ReferentielArticleFacadeLocal;
import facades.gestionArticle.SousCategorieFacadeLocal;
import facades.gestionMagasin.MagasinFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author PC Tim
 */
@Stateless
public class SessionChefDeRayon implements SessionChefDeRayonLocal {

    @EJB
    private CategorieFacadeLocal categorieFacade;

    @EJB
    private MagasinFacadeLocal magasinFacade;

    @EJB
    private ReferentielArticleFacadeLocal referentielArticleFacade;

    @EJB
    private SousCategorieFacadeLocal sousCategorieFacade;
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override 
    public void CreerReferentielArticle(String libelleArticle, String magasin, String marque, Float prixVente, String libelleSousCategorieRecherche){
        Magasin magasinRecherche =magasinFacade.RechercherMagasinParNom(magasin) ;
        SousCategorie sousCategorieRecherche= sousCategorieFacade.RechercherCategorie(libelleSousCategorieRecherche);
        referentielArticleFacade.CreerReferentielArticle(libelleArticle, magasinRecherche, marque, 0, sousCategorieRecherche);
    }
    
    @Override
    public void CreerCategorie (String categorie){
        categorieFacade.CreerCategorie(categorie);
    }
    
}
