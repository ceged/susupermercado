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
import entités.gestionMagasin.Magasin;
import entités.gestionVenteEnLigne.Creneau;
import facades.gestionArticle.ElectromenagerFacadeLocal;
import facades.gestionArticle.LotArticleFacadeLocal;
import facades.gestionArticle.ProduitFraisFacadeLocal;
import facades.gestionArticle.ReferentielArticleFacadeLocal;
import facades.gestionArticle.VetementFacadeLocal;
import facades.gestionLivraison.AgentLivraisonFacadeLocal;
import facades.gestionLivraison.LigneLivraisonFacadeLocal;
import facades.gestionLivraison.LivraisonFacadeLocal;
import facades.gestionMagasin.MagasinFacadeLocal;
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
    private MagasinFacadeLocal magasinFacade;

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
    public void CreerLotArticle(Long idRefArticle,int quantite, LigneLivraison l){
        ReferentielArticle article=referentielArticleFacade.RechercheReferentielArticleParCodeBarre(idRefArticle);
        lotArticleFacade.CreerLotArticle(quantite, article,l);
    }
    @Override
    public void CreerLotArticleElectromenager(int qteLotArticle, Long idRefArticle,int garantie, LigneLivraison l){
        ReferentielArticle article=referentielArticleFacade.RechercheReferentielArticleParCodeBarre(idRefArticle);
        electromenagerFacade.CreerLotArticleElectromenager(qteLotArticle, article, garantie,l );
    }
    @Override
    public void CreerLotArticleFrais(int qteProduitFrais, Long idRefArticle,Date datePeremption, LigneLivraison l){
        ReferentielArticle article=referentielArticleFacade.RechercheReferentielArticleParCodeBarre(idRefArticle);
        produitFraisFacade.CreerLotArticleFrais(qteProduitFrais, article, datePeremption,l);
    }
    
    @Override
    public void CreerLotArticleVetement(int qteLotArticle, Long idRefArticle,String taille, String couleur, LigneLivraison l){
        ReferentielArticle article=referentielArticleFacade.RechercheReferentielArticleParCodeBarre(idRefArticle);
        vetementFacade.CreerLotArticleVetement(qteLotArticle, article, taille, couleur,l);
    }
    
    @Override
    public void ModifierQuantiteLigneLivraison(String idLigneLivraison, int qtReceptionner, int qtLivrer){
        Long id=Long.parseLong(idLigneLivraison);
        LigneLivraison l=ligneLivraisonFacade.ChercherLigneLivraisonParId(id);
        ligneLivraisonFacade.ModifierQuantiteLigneLivraison(l, qtReceptionner, qtLivrer);
    }
    
    @Override
    public String CreerCreneau(Time heureDebut, Time heureFin, Date date, String idAgent){
        String message=null;
        AgentLivraison a=agentLivraisonFacade.RechercherAgentLivraison(idAgent);
        if(heureFin.before(heureDebut)){
            message="Heure de fin inférieur à heure de début";
        }
        else{
            creneauFacade.CreerCreneau(heureDebut, heureFin, date, a.getMagasin());
            message="Créneau créé";
        }
        return message;
    }
    
    @Override
    public List<Creneau> ListeCreneauDispoParMagasin (Magasin m){
        return creneauFacade.ChercherCreneauDispoParMagasin(m);
    }
    
    @Override
    public List<Creneau> ListeCreneauDispoParMagasinParDate(Magasin m, Date d){
        return creneauFacade.ChercherCreneauDispoParMagasinParDate(m, d);
    }
    
    @Override
    public void ModifierCreneau(String idCreneau){
        Creneau c=creneauFacade.ChercherCreneauParId(idCreneau);
        creneauFacade.ModifierCreneau(c);
    }
    
    @Override
    public Magasin ChercherMagasinParNom(String nomMagasin){
        return magasinFacade.RechercherMagasinParNom(nomMagasin);
    }
            
}
