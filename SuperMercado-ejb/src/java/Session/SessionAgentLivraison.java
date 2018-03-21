/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionArticle.ReferentielArticle;
import entités.gestionLivraison.AgentLivraison;
import entités.gestionLivraison.LigneLivraison;
import entités.gestionLivraison.Livraison;
import entités.gestionVenteEnLigne.Creneau;
import facades.gestionArticle.ElectromenagerFacadeLocal;
import facades.gestionArticle.LotArticleFacadeLocal;
import facades.gestionArticle.ProduitFraisFacadeLocal;
import facades.gestionArticle.ReferentielArticleFacadeLocal;
import facades.gestionArticle.VetementFacadeLocal;
import facades.gestionLivraison.AgentLivraisonFacadeLocal;
import facades.gestionLivraison.LigneLivraisonFacadeLocal;
import facades.gestionLivraison.LivraisonFacadeLocal;
import facades.gestionVenteEnLigne.CreneauFacadeLocal;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Soldat
 */
@Stateless
public class SessionAgentLivraison implements SessionAgentLivraisonLocal {

    @EJB
    private CreneauFacadeLocal creneauFacade;

    @EJB
    private ElectromenagerFacadeLocal electromenagerFacade;

    @EJB
    private ProduitFraisFacadeLocal produitFraisFacade;

    @EJB
    private VetementFacadeLocal vetementFacade;

    @EJB
    private LigneLivraisonFacadeLocal ligneLivraisonFacade;

    @EJB
    private ReferentielArticleFacadeLocal referentielArticleFacade;

    @EJB
    private LotArticleFacadeLocal lotArticleFacade;

    @EJB
    private LivraisonFacadeLocal livraisonFacade;

    @EJB
    private AgentLivraisonFacadeLocal agentLivraisonFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public AgentLivraison ChercherAgentLivraisonParId(String idAgentLivraison){
        AgentLivraison agent= new AgentLivraison();
                agent=agentLivraisonFacade.RechercherAgentLivraison(idAgentLivraison);
                return agent;
    }
    
    @Override
    public List<Livraison> ChercherListeLivraisonParAgent(AgentLivraison agentLivraison){
        List<Livraison> liste= livraisonFacade.ChercherListeLivraisonParMagasin(agentLivraison.getMagasin());
        return liste;
    }
    
    @Override 
    public void ModifierDateLivraisonEffectiveParLivraison(String Idlivraison, Date dateEffective){
        Long id=Long.parseLong(Idlivraison);
        Livraison l=livraisonFacade.ChercherLivraisonParId(id);
        livraisonFacade.ModifierDateLivraisonEffectiveParLivraison(l, dateEffective);
    }
    
    @Override
    public void CreerLotArticle(Long idRefArticle,int quantite){
        ReferentielArticle article=referentielArticleFacade.RechercheReferentielArticleParCodeBarre(idRefArticle);
        lotArticleFacade.CreerLotArticle(quantite, article);
    }
    @Override
    public void CreerLotArticleElectromenager(int qteLotArticle, Long idRefArticle,int garantie){
        ReferentielArticle article=referentielArticleFacade.RechercheReferentielArticleParCodeBarre(idRefArticle);
        electromenagerFacade.CreerLotArticleElectromenager(qteLotArticle, article, garantie);
    }
    @Override
    public void CreerLotArticleFrais(int qteProduitFrais, Long idRefArticle,Date datePeremption){
        ReferentielArticle article=referentielArticleFacade.RechercheReferentielArticleParCodeBarre(idRefArticle);
        produitFraisFacade.CreerLotArticleFrais(qteProduitFrais, article, datePeremption);
    }
    
    @Override
    public void CreerLotArticleVetement(int qteLotArticle, Long idRefArticle,String taille, String couleur){
        ReferentielArticle article=referentielArticleFacade.RechercheReferentielArticleParCodeBarre(idRefArticle);
        vetementFacade.CreerLotArticleVetement(qteLotArticle, article, taille, couleur);
    }
    
    @Override
    public void ModifierQuantiteLigneLivraison(String idLigneLivraison, int qtReceptionner, int qtLivrer){
        Long id=Long.parseLong(idLigneLivraison);
        LigneLivraison l=ligneLivraisonFacade.ChercherLigneLivraisonParId(id);
        ligneLivraisonFacade.ModifierQuantiteLigneLivraison(l, qtReceptionner, qtLivrer);
    }
    
    @Override
    public void CreerCreneau(Time heureDebut, Time heureFin, Date date, String idAgent){
        AgentLivraison a=agentLivraisonFacade.RechercherAgentLivraison(idAgent);
        creneauFacade.CreerCreneau(heureDebut, heureFin, date, a.getMagasin());
    }
    
    @Override
    public List<Creneau> ListeCreneauDispoParMagasin (AgentLivraison a){
        return creneauFacade.ChercherCreneauDispoParMagasin(a.getMagasin());
    }
    
    @Override
    public void ModifierCreneau(String idCreneau){
        Creneau c=creneauFacade.ChercherCreneauParId(idCreneau);
        creneauFacade.ModifierCreneau(c);
    }
            
}
