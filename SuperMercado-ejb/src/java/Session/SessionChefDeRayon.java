/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionArticle.ReferentielArticle;
import entités.gestionArticle.SousCategorie;
import entités.gestionMagasin.ChefRayon;
import entités.gestionMagasin.DirecteurMagasin;
import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Rayon;
import entités.gestionMagasin.Secteur;
import facades.gestionArticle.CategorieFacadeLocal;
import facades.gestionArticle.ReferentielArticleFacadeLocal;
import facades.gestionArticle.SousCategorieFacadeLocal;
import facades.gestionMagasin.MagasinFacadeLocal;
import facades.gestionMagasin.RayonFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author PC Tim
 */
@Stateless
public class SessionChefDeRayon implements SessionChefDeRayonLocal {

    @EJB
    private RayonFacadeLocal rayonFacade;

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
    public String CreerReferentielArticle(String libelleArticle,String magasin, String rayon, String marque, Float prixVente, String libelleSousCategorieRecherche){
        String message="Article créé";
        Magasin magasinRecherche =magasinFacade.RechercherMagasinParNom(magasin) ;
        if(magasinRecherche==null){
            message="magasin inconnu";
        }
            Rayon rayonRecherche =rayonFacade.RechercherRayonParNom(rayon, magasinRecherche) ;
        if(rayonRecherche==null){
            message="rayon inconnu";
        }
        SousCategorie sousCategorieRecherche= sousCategorieFacade.RechercherSousCategorie(libelleSousCategorieRecherche);
        if(sousCategorieRecherche==null){
            message="Sous catégorie inconnu";
        }
        referentielArticleFacade.CreerReferentielArticle(libelleArticle, rayonRecherche, marque, prixVente, sousCategorieRecherche);
        return message;
    }
    
    
    
    @Override
    public List<SousCategorie> ListerSousCategorie(){
        List<SousCategorie> listeSousCategorie=sousCategorieFacade.findAll();
        return listeSousCategorie;
    }
    
    @Override
    public String ModifierPrixReferentielArticle(String libelleArticle, String rayon,String magasin, float newPrix){
        String message ="Prix modifié";
        Magasin magasinRecherche=magasinFacade.RechercherMagasinParNom(magasin);
        if(magasinRecherche==null){
            message="magasin inconnu";
        }
        Rayon rayonRecherche=rayonFacade.RechercherRayonParNom(rayon, magasinRecherche);
        if(rayonRecherche==null){
            message="rayon inconnu";
        }
        ReferentielArticle referentielArticle=referentielArticleFacade.RechercherReferentielArticleParRayon(rayonRecherche, libelleArticle);
        if(referentielArticle==null){
            message="article inconnu";
        }
        referentielArticleFacade.ModifierPrixReferentielArticle(referentielArticle,newPrix);
        return message;
    }
    
    @Override
public ChefRayon ChercherChefRayonParId(String id){
    ChefRayon chefCherche =ChercherChefRayonParId(id);
    return chefCherche;
}

    @Override
public List<ReferentielArticle> ListerArticleDuChefRayon(ChefRayon chefRayon){
    List<ReferentielArticle> listeArticle= chefRayon.getRayon().getListeReferentielArticles();
    return listeArticle;
}
    
}
