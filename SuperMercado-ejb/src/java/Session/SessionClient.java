/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionArticle.Achat;
import entités.gestionArticle.LigneAchat;
import entités.gestionArticle.LotArticle;
import entités.gestionArticle.ReferentielArticle;
import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Personne;
import entités.gestionVenteEnLigne.AchatEnLigne;
import entités.gestionVenteEnLigne.Client;
import entités.gestionVenteEnLigne.Creneau;
import entités.gestionVenteEnLigne.ModeLivraison;
import facades.gestionArticle.AchatCaisseFacadeLocal;
import facades.gestionArticle.AchatFacadeLocal;
import facades.gestionArticle.LigneAchatFacadeLocal;
import facades.gestionArticle.LotArticleFacadeLocal;
import facades.gestionArticle.ReferentielArticleFacadeLocal;
import facades.gestionMagasin.MagasinFacadeLocal;
import facades.gestionMagasin.PersonneFacadeLocal;
import facades.gestionVenteEnLigne.AchatEnLigneFacadeLocal;
import java.lang.String;
import facades.gestionVenteEnLigne.ClientFacadeLocal;
import facades.gestionVenteEnLigne.CreneauFacadeLocal;
import facades.gestionVenteEnLigne.LivraisonDomicileFacadeLocal;
import facades.gestionVenteEnLigne.RetraitMagasinFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Sophia
 */
@Stateless
public class SessionClient implements SessionClientLocal {

    @EJB
    private CreneauFacadeLocal creneauFacade;

    @EJB
    private LivraisonDomicileFacadeLocal livraisonDomicileFacade;

    @EJB
    private RetraitMagasinFacadeLocal retraitMagasinFacade;

    @EJB
    private MagasinFacadeLocal magasinFacade;

    @EJB
    private LigneAchatFacadeLocal ligneAchatFacade;

    @EJB
    private ReferentielArticleFacadeLocal referentielArticleFacade;

    @EJB
    private LotArticleFacadeLocal lotArticleFacade;

    @EJB
    private AchatFacadeLocal achatFacade;

    @EJB
    private AchatEnLigneFacadeLocal achatEnLigneFacade;

    @EJB
    private AchatCaisseFacadeLocal achatCaisseFacade;

    @EJB
    private PersonneFacadeLocal personneFacade;

    @EJB
    private ClientFacadeLocal clientFacade;
    
    
    
    
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String CreationCompteClient(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal) {
        String message;
        if(personneFacade.LoginEstUnique(login)==false)
        {
            message = "login existe déjà";
        }
        else
        {
            clientFacade.CreerClient(nom, prenom, login, mdp, sexe, dob, adresse, codePostal);
            message="Compte créé avec succès";
            }
        return message; 
    }

    @Override
    public AchatEnLigne CreationAchatEnLigne(String idClient) {
    Long id = Long.valueOf(idClient);
    Personne p = personneFacade.RechercherPersonneParId(id);
    Client c = (Client) p;
    AchatEnLigne a = achatEnLigneFacade.CreationAchatEnLigne(c);
    return a;
    }

    @Override
    public AchatEnLigne RechercheAchatParId(String id) {
        Long idAchat = Long.valueOf(id);
        Achat a = achatFacade.RechercheAchatParId(idAchat);
        AchatEnLigne achatenligne = (AchatEnLigne) a;
        return achatenligne;
    }

    @Override
    public LotArticle GetLotArticleFIFO(String idArticle, String quantite) {
        LotArticle lot;
        Long id = Long.valueOf(idArticle);
        int quantiteInt = Integer.valueOf(quantite);
        ReferentielArticle article = referentielArticleFacade.RechercheReferentielArticleParCodeBarre(id);
        if(lotArticleFacade.RechercherLotArticle(article)!=null){
            lot = lotArticleFacade.RechercherLotArticleFIFO(article);
        }
        else
        {
            lot =null;
        }
        return lot;
    }

    @Override
    public String creationLignePanier(String quantite, String article, String idAchat) {
        String message;
        int quantiteInt = Integer.parseInt(quantite); 
        LotArticle lotselectionne = this.GetLotArticleFIFO(article, quantite);
        if(lotselectionne!=null)
        {
        Long idAchatLong = Long.valueOf(idAchat);
        Achat achat = achatFacade.RechercheAchatParId(idAchatLong);
        
        //Verification si ligne existante 
        
        LigneAchat ligneExistante = ligneAchatFacade.RechercherLigneParLotDansUnAchat(achat, lotselectionne);
        if(ligneExistante==null)
        {
            if(lotselectionne.getQuantiteLot()<quantiteInt)
                {message = "Stock insuffisant, veuillez réduire votre quantité";}
            else
                {ligneAchatFacade.CreerLigneAchat(quantiteInt, lotselectionne, achat);
                message = "article ajouté à votre panier";}
        }
        else
        {
            int qteLot = ligneExistante.getLotArticle().getQuantiteLot();
            int qteLigneExistante = ligneExistante.getQuantiteAchetee();
            int quantiteRestante =  qteLot-qteLigneExistante;
            if(quantiteRestante<quantiteInt)
            {
                message = "Stock insuffisant, veuillez réduire votre quantité";
            }
            else
            {
                ligneAchatFacade.AjouterQuantiteLigne(quantiteInt, ligneExistante);
                message = "article ajouté à votre panier";}
        }
        }
        else
        {
            message = "Désolé ! Rupture de Stock.";
        }
        return message;
    }

     
    
    
    
    @Override
    public Client ChercherClientParLoginMdp(String login, String mdp){
        Client c= new Client();
        c=clientFacade.ChercherClientParLoginMdp(login, mdp);
                return c;
    }

    @Override
    public List<LigneAchat> GetLignesPanier(String idAchat) {
        Long idAchatLong = Long.valueOf(idAchat);
        Achat achat = achatFacade.RechercheAchatParId(idAchatLong);
        return ligneAchatFacade.RechercherLigneAchatsParPanier(achat);
    }

    @Override
    public void SuppressionLigneAchat(String idLigneAchat) {
        Long idLigneAchatLong = Long.valueOf(idLigneAchat);
        LigneAchat a = ligneAchatFacade.RechercherLigneAchatParId(idLigneAchatLong);
        ligneAchatFacade.SupprimerLigneAchat(a);
    }

    @Override
    public String ValidationAchat(String idAchat) {
        String message;
        Long idAchatLong = Long.valueOf(idAchat);
        Achat a = achatFacade.RechercheAchatParId(idAchatLong);
        if(!achatFacade.getListeLigneAchat(a).isEmpty())
        {
        this.ReduireStockPourAchat(a);
        achatFacade.ValiderAchat(a);
        message = "Panier Validé";
        }
        else
        {
        message="panier vide, aucun achat à valider"; 
        }
        return message;
    }

    @Override
    public AchatEnLigne RechercherAchatEnCours(String idClient) {
        Long idClientLong = Long.valueOf(idClient);
        Client client = (Client) personneFacade.RechercherPersonneParId(idClientLong);
        return achatEnLigneFacade.RechercherAchatEnLigneEnCours(client);
    }

    @Override
    public void ReduireStockPourAchat(Achat achat) {
 
        List <LigneAchat> listelignesAchat = achatFacade.getListeLigneAchat(achat);
        listelignesAchat.forEach((ligne) -> {
            LotArticle lot = ligne.getLotArticle();
            int qte = ligne.getQuantiteAchetee();
            lotArticleFacade.ModifierQteLotArticle(qte, lot);
        });
    }

    @Override
    public void ViderPanier(List<LigneAchat> liste) {
        liste.forEach((LigneAchat ligne) -> {
            ligneAchatFacade.SupprimerLigneAchat(ligne);
        });
    }
    
    @Override
    public void AjouterChoixModeLivraison(Achat a, ModeLivraison modeLivraison){
        AchatEnLigne al= achatEnLigneFacade.find(a.getId());
        achatEnLigneFacade.AjouterModeLivraison(al, modeLivraison);
        
    }
    
    @Override
    public void CreerRetraitMagasin(String idAchatLigne, Date dateRecup, String magasinId){
        Long idAchat=Long.parseLong(idAchatLigne);
        Long idMag=Long.parseLong(magasinId);
        AchatEnLigne a=achatEnLigneFacade.find(idAchat);
        Magasin m=magasinFacade.find(idMag);
        retraitMagasinFacade.CreerRetraitMagasin(a, dateRecup, m);
        
    }
    
    @Override
    public void CreerLivraisonDomicile(String idAchatLigne, String adresse, String codePostal, String ville, String  creneauId){
        Long idAchat=Long.parseLong(idAchatLigne);
        AchatEnLigne a=achatEnLigneFacade.find(idAchat);
        Creneau creneau=creneauFacade.ChercherCreneauParId(creneauId);
        livraisonDomicileFacade.CreerLivraisonDomicile(a, adresse, codePostal, ville, creneau);
        creneauFacade.ModifierCreneau(creneau);
    }

    @Override
    public void SupprimerAchatEnLigne(AchatEnLigne achat) {
        achatEnLigneFacade.SupprimerAchat(achat);
    }

    @Override
    public String SupprimerClient(Client client) {
        try{
        achatEnLigneFacade.RechercherAchatsEnLigneClient(client);
        clientFacade.SupprimerCompteClient(client);
        return "Votre compte a bien été supprimé";}
        catch(Exception e )
        {
            return"erreur lors de la suppression du client dans la base";
        }
    }
    
    
}  
