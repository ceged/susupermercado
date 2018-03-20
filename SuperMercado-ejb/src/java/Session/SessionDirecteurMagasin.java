/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionMagasin.AgentCaisse;
import entités.gestionMagasin.Caisse;
import entités.gestionMagasin.DirecteurMagasin;
import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Personne;
import entités.gestionMagasin.Rayon;
import entités.gestionMagasin.Secteur;
import facades.gestionArticle.AchatCaisseFacadeLocal;
import facades.gestionLivraison.AgentLivraisonFacadeLocal;
import facades.gestionMagasin.AffectationCaisseAgentFacadeLocal;
import facades.gestionMagasin.AgentCaisseFacadeLocal;
import facades.gestionMagasin.AgentRayonFacadeLocal;
import facades.gestionMagasin.CaisseFacadeLocal;
import facades.gestionMagasin.ChefRayonFacadeLocal;
import facades.gestionMagasin.DirecteurMagasinFacadeLocal;
import facades.gestionMagasin.MagasinFacadeLocal;
import facades.gestionMagasin.PersonneFacadeLocal;
import facades.gestionMagasin.RayonFacadeLocal;
import facades.gestionMagasin.SecteurFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Soldat
 */
@Stateless
public class SessionDirecteurMagasin implements SessionDirecteurMagasinLocal {

    @EJB
    private AgentLivraisonFacadeLocal agentLivraisonFacade;

    @EJB
    private AffectationCaisseAgentFacadeLocal affectationCaisseAgentFacade;

      @EJB
    private AgentRayonFacadeLocal agentRayonFacade;
      
    @EJB
    private AgentCaisseFacadeLocal agentCaisseFacade;

    @EJB
    private PersonneFacadeLocal personneFacade;

    @EJB
    private CaisseFacadeLocal caisseFacade;

    @EJB
    private RayonFacadeLocal rayonFacade;

    @EJB
    private ChefRayonFacadeLocal chefRayonFacade;

    @EJB
    private SecteurFacadeLocal secteurFacade;

    @EJB
    private MagasinFacadeLocal magasinFacade;

    @EJB
    private DirecteurMagasinFacadeLocal directeurMagasinFacade;
    
    
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override 
    public String CreerChefRayon(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal, String rayon, String nomMagasin){
        String message;
        if(personneFacade.LoginEstUnique(login)==false)
        {
            message = "login existe déjà";
        }
        else
        {
            Magasin magasinRecherche = magasinFacade.RechercherMagasinParNom(nomMagasin);
            Rayon rayonRecherche=rayonFacade.RechercherRayonParNom(rayon, magasinRecherche);
            chefRayonFacade.CreerChefRayon(nom, prenom, login, mdp, dob, sexe, adresse, codePostal, rayonRecherche);
            message="Chef de Rayon créé";
            }
        return message; 
    }
 @Override 
    public String CreerAgentRayon(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal, String rayon, String nomMagasin){
        String message;
        if(personneFacade.LoginEstUnique(login)==false)
        {
            message = "login existe déjà";
        }
        else
        {
           Magasin magasinRecherche = magasinFacade.RechercherMagasinParNom(nomMagasin);
            Rayon rayonRecherche=rayonFacade.RechercherRayonParNom(rayon, magasinRecherche);
            agentRayonFacade.CreerAgentRayon(nom, prenom, login, mdp, dob, sexe, adresse, codePostal, rayonRecherche);
            message="Agent de Rayon créé";
            }
        return message; 
    }
       
@Override
    public String CreerSecteur(String libelleSecteur, String nomMagasin) {
        String message = "magasin inconnu";
        Magasin magasin = magasinFacade.RechercherMagasinParNom(nomMagasin);
        if (magasin != null){
        secteurFacade.CreerSecteur(libelleSecteur, magasin);
        message = "Secteur créé";
        }
    
        return message;
    }

@Override
public String CreerRayon (String secteur, String libelleRayon){
     String message = "secteur inconnu";
     
     Secteur secteurCherche = secteurFacade.RechercherSecteurParLibelle(secteur);
     if (secteurCherche != null ){
   
    rayonFacade.CreerRayon(secteurCherche, libelleRayon);
    message = "Rayon Créé";
    
}
     return message ;
}

    @Override
    public List <Rayon> ConsultationListeRayonsParMagasin(String nomMagasin) {
        Magasin magasin = magasinFacade.RechercherMagasinParNom(nomMagasin);
        return rayonFacade.ConsulterListeRayonsParMagasin(magasin);
    }
    @Override
    public List <Rayon> ConsultationListeSecteurParMagasin(String nomMagasin) {
        Magasin magasin = magasinFacade.RechercherMagasinParNom(nomMagasin);
        return secteurFacade.ConsulterSecteursParMagasin(magasin);
 
    }  

    @Override
    public Rayon RechercherRayonParNomRayon(String libelleRayon, String nomMagasin) {
        Magasin magasin = magasinFacade.RechercherMagasinParNom(nomMagasin);
        return rayonFacade.RechercherRayonParNom(libelleRayon, magasin);
    }
    @Override
    public Caisse RechercherCaisseParIdCaisse(Long id, String nomMagasin) {
        Magasin magasin = magasinFacade.RechercherMagasinParNom(nomMagasin);
        return caisseFacade.RechercherCaisseParId(id, magasin);
    }
    @Override
    public String CreerCaisse(Long id, String nomMagasin) {
        String message = "magasin inconnu";
        Magasin magasinRecherche = magasinFacade.RechercherMagasinParNom(nomMagasin);
        if (magasinRecherche != null ){
        caisseFacade.CreerCaisse(id, magasinRecherche);
        message = "Caisse Créée";
    }
        return message ;
    }

@Override
    public List <Secteur> ConsultationListeSecteursParMagasin(String nomMagasin) {
        Magasin magasin = magasinFacade.RechercherMagasinParNom(nomMagasin);
        return secteurFacade.ConsulterSecteursParMagasin(magasin);
    }

@Override
public DirecteurMagasin ChercherDirecteurParId(String id){
    DirecteurMagasin directeurCherche =directeurMagasinFacade.RechercherDirecteurParId(id);
    return directeurCherche;
}

    @Override
    public Boolean LoginEstUnique(String login) {
        Personne personneTrouve = personneFacade.GetPersonneParLogin(login);
        return personneTrouve == null;
    }

    @Override
    public List<Rayon> ConsultationRayonsSansChef(String nomMagasin) {
        Magasin magasinRecherche = magasinFacade.RechercherMagasinParNom(nomMagasin);
        List<Rayon> liste=rayonFacade.ConsulterRayonsSansChef(magasinRecherche);
        return liste;
    }

    @Override
    public List<Caisse> ConsultationCaisseParMagasin(String nomMagasin) {
        Magasin magasin = magasinFacade.RechercherMagasinParNom(nomMagasin);
        return caisseFacade.ConsulterListeCaisseParMagasin(magasin);
    }

    @Override
    public String CreerAgentCaisse(String nom, String prenom, String login, String mdp, Date dob, String sexe, String adresse, String codePostal, String nomMagasin) {
        String message;
        if(personneFacade.LoginEstUnique(login)==false)
        {
            message = "login existe déjà";
        }
        else
        {
            Magasin magasinRecherche = magasinFacade.RechercherMagasinParNom(nomMagasin);
            agentCaisseFacade.CreerAgentCaisse(prenom, nom, login, mdp, dob, sexe, adresse, codePostal, magasinRecherche);
            message="Agent de caisse créé";
            }
        return message; 
    }
    
     @Override
    public List<Rayon> ListerRayon() {
        
        List<Rayon> listeRayon = rayonFacade.findAll();
        return listeRayon;
        
    }
     @Override
    public List<Caisse> ListerCaisse() {
        
        List<Caisse> listeCaisse= caisseFacade.findAll();
        return listeCaisse;
        
    }
    @Override
    public String SupprimerRayon(String magasin, String rayon) {
        String message="SOS problem";
        
        /*Magasin magasinRecherche =magasinFacade.RechercherMagasinParNom(magasin) ;
        if(magasinRecherche==null){
            message="magasin inconnu";
        }
        Rayon rayonRecherche =rayonFacade.RechercherRayonParNom(rayon, magasinRecherche) ;
        if(rayonRecherche==null){
            message="rayon inconnu";
        }*/
        
        Rayon rayonRecherche=this.RechercherRayonParNomRayon(magasin,rayon);
        
       if (rayonRecherche!=null){
        rayonFacade.SupprimerRayon(rayonRecherche);
        message = "rayon supprimé avec succès";
        
    }
        return message;
    }
     @Override
    public String SupprimerCaisse(Long caisse,String magasin) {
        String message="problem";
        
        /*Magasin magasinRecherche =magasinFacade.RechercherMagasinParNom(magasin) ;
        if(magasinRecherche==null){
            message="magasin inconnu";
        }
        Caisse caisseRecherche =caisseFacade.RechercherCaisseParNom(caisse, magasinRecherche) ;
        if(caisseRecherche==null){
            message="caisse inconnu";
        }*/
        
        Caisse caisseRecherche= this.RechercherCaisseParIdCaisse(caisse,magasin);
        
       if (caisseRecherche!=null){
        caisseFacade.SupprimerCaisse(caisseRecherche);
        message = "caisse supprimé avec succès";
        
    }
    return message;}
    @Override
    public String CreationAffectation(String idCaisseString, String idAgentCaisse, Date dateDebut, Date dateFin, String nomMagasin) {
        
        String message;
        
        Long idCaisse = Long.parseLong(idCaisseString);
        
        Magasin magasin=magasinFacade.RechercherMagasinParNom(nomMagasin);
        Caisse caisse = caisseFacade.RechercherCaisseParId(idCaisse, magasin);
        AgentCaisse agentCaisse = agentCaisseFacade.RechercherAgentCaisse(idAgentCaisse, magasin);
        affectationCaisseAgentFacade.CreerAffectation(agentCaisse, caisse, dateDebut, dateFin);
        message = "affectation effectuée";
        return message;
    }


    @Override
    public List <AgentCaisse> ConsultationListeAgentCaisseParMagasin(String nomMagasin) {
        Magasin magasin = magasinFacade.RechercherMagasinParNom(nomMagasin);
        return agentCaisseFacade.ConsulterListeAgentCaisseParMagasin(magasin);
    }

    
    @Override
    public String ModifierLibelleRayon(String LibelleRayon, String newLibelleRayon, String nomMagasin){
        String message ="Rayon modifié";
        Rayon rayonRecherche=this.RechercherRayonParNomRayon(LibelleRayon, nomMagasin);
       
        if(rayonRecherche==null){
            message="rayon inconnu";
        }
       
        else{
            rayonFacade.ModifierRayon(newLibelleRayon,rayonRecherche);
        }
        
        return message;
    }
    
    @Override
    public List<Rayon> ConsulterListeRayonParDirecteur(DirecteurMagasin directeur){
    List<Rayon> listeRayon;
    listeRayon=rayonFacade.ConsulterListeRayonsParMagasin(directeur.getMagasin());
    return listeRayon;
}
    @Override
    public void CreerAgentLivraison(String prenom, String nom, String login, String mdp, Date dob, String sexe, String adresse, String codePostal, String nomMagasin){
        Magasin m=magasinFacade.RechercherMagasinParNom(nomMagasin);
        agentLivraisonFacade.CreerAgentLivraison(prenom, nom, login, mdp, dob, sexe, adresse, codePostal, m);
    }
  
}
