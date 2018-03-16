/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionArticle.Promotion;
import entités.gestionArticle.ReferentielArticle;
import entités.gestionArticle.SousCategorie;
import entités.gestionCommande.Fournisseur;
import entités.gestionMagasin.ChefRayon;
import entités.gestionMagasin.DirecteurMagasin;
import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Rayon;
import entités.gestionMagasin.Secteur;
import facades.gestionArticle.CategorieFacadeLocal;
import facades.gestionArticle.PromotionFacadeLocal;
import facades.gestionArticle.ReferentielArticleFacadeLocal;
import facades.gestionArticle.SousCategorieFacadeLocal;
import facades.gestionCommande.FournisseurFacade;
import facades.gestionCommande.FournisseurFacadeLocal;
import facades.gestionMagasin.AgentRayonFacadeLocal;
import facades.gestionMagasin.ChefRayonFacadeLocal;
import facades.gestionMagasin.MagasinFacadeLocal;
import facades.gestionMagasin.PersonneFacadeLocal;
import facades.gestionMagasin.RayonFacadeLocal;
import java.util.Date;
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
    private FournisseurFacadeLocal fournisseurFacade;

    @EJB
    private PersonneFacadeLocal personneFacade;

    @EJB
    private PromotionFacadeLocal promotionFacade;

    @EJB
    private ChefRayonFacadeLocal chefRayonFacade;

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
    public String CreerReferentielArticle(String libelleArticle,String magasin, String rayon, String marque, Float prixVente, String libelleSousCategorieRecherche, List<Fournisseur> listeFournisseur){
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
        referentielArticleFacade.CreerReferentielArticle(libelleArticle, rayonRecherche, marque, prixVente, sousCategorieRecherche,listeFournisseur);
        return message;
    }
    
    
    
    @Override
    public List<SousCategorie> ListerSousCategorie(){
        List<SousCategorie> listeSousCategorie=sousCategorieFacade.findAll();
        return listeSousCategorie;
    }
    
    @Override
    public List<Fournisseur> ListerFournisseur(){
        List<Fournisseur> listeFournisseur=fournisseurFacade.ConsulterListeFournisseur();
        return listeFournisseur;
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
        ReferentielArticle referentielArticle=referentielArticleFacade.RechercheReferentielArticleParLibelleParRayon(rayonRecherche, libelleArticle);
        if(referentielArticle==null){
            message="article inconnu";
        }
        Promotion p= promotionFacade.RechercherPromotionEnCoursParArticle(referentielArticle);
        if(p!=null){
            message="promotion en cours";
        }
        else{
            referentielArticleFacade.ModifierPrixReferentielArticle(referentielArticle,newPrix);
        }
        
        return message;
    }
    
    @Override
    public String SupprimerReferentielArticle(String libelleArticle, String rayon,String magasin){
        String message ="Article supprimé";
        Magasin magasinRecherche=magasinFacade.RechercherMagasinParNom(magasin);
        if(magasinRecherche==null){
            message="magasin inconnu";
        }
        Rayon rayonRecherche=rayonFacade.RechercherRayonParNom(rayon, magasinRecherche);
        if(rayonRecherche==null){
            message="rayon inconnu";
        }
        ReferentielArticle referentielArticle=referentielArticleFacade.RechercheReferentielArticleParLibelleParRayon(rayonRecherche, libelleArticle);
        if(referentielArticle==null){
            message="article inconnu";
        }
        referentielArticleFacade.SupprimerReferentielArticle(referentielArticle);
        return message;
    }
    
    @Override
    public ChefRayon ChercherChefRayonParId(String id){
    ChefRayon chefCherche = chefRayonFacade.RechercherChefRayonParId(id);
    return chefCherche;
}


@Override
public List<ReferentielArticle> ConsulterListeArticleParChefRayon(ChefRayon chefRayon){
    List<ReferentielArticle> listeArticle =null;
    listeArticle=referentielArticleFacade.RechercherListeArticleParRayon(chefRayon.getRayon());
    return listeArticle;
}

    @Override 
    public String CreerFournisseur(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal){
        String message;
        if(personneFacade.LoginEstUnique(login)==false)
        {
            message = "login existe déjà";
        }
        else
        {
            fournisseurFacade.CreerFournisseur(prenom, nom, login, mdp, dob, sexe, adresse, codePostal);
            message="Fournisseur créé";
            }
        return message; 
    }
   
    
    @Override
    public Fournisseur ChercherFournisseurParId(Long idFournisseur){
        Fournisseur f=fournisseurFacade.RechercheFournisseurParId(idFournisseur);
        return f;
    }
    
}
