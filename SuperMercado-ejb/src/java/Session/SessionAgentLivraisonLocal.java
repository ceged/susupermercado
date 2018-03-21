/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionLivraison.AgentLivraison;
import entités.gestionLivraison.Livraison;
import entités.gestionVenteEnLigne.Creneau;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Soldat
 */
@Local
public interface SessionAgentLivraisonLocal {
    
    AgentLivraison ChercherAgentLivraisonParId(String idAgentLivraison);
    
    List<Livraison> ChercherListeLivraisonParAgent(AgentLivraison agentLivraison);
    
    void ModifierDateLivraisonEffectiveParLivraison(String Idlivraison, Date dateEffective);
    
    void CreerLotArticle(Long idRefArticle,int quantite);
    
    void ModifierQuantiteLigneLivraison(String idLigneLivraison, int qtReceptionner, int qtLivrer);
    
    void CreerLotArticleVetement(int qteLotArticle, Long idRefArticle,String taille, String couleur);
    
    void CreerLotArticleFrais(int qteProduitFrais, Long idRefArticle,Date datePeremption);
    
    void CreerLotArticleElectromenager(int qteLotArticle, Long idRefArticle,int garantie);
    
      void CreerCreneau(Time heureDebut, Time heureFin, Date date, String idAgent);
    
    void ModifierCreneau(String idCreneau);
    
    List<Creneau> ListeCreneauDispoParMagasin (AgentLivraison a);
    
}
