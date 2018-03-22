/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionArticle.LigneAchat;
import entités.gestionArticle.LotArticle;
import entités.gestionVenteEnLigne.AchatEnLigne;
import entités.gestionVenteEnLigne.Client;
import java.lang.String;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sophia
 */
@Local
public interface SessionClientLocal {

    String CreationCompteClient(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal);

    AchatEnLigne CreationAchatEnLigne(String idClient);

    AchatEnLigne RechercheAchatParId(String id);

    LotArticle GetLotArticleFIFO(String nomArticle);

    void creationLignePanier(String quantite, String nomArticle, String idAchat);

    List<LigneAchat> GetLignesPanier(String idAchat);

    void SuppressionLigneAchat(String idLigneAchat);
    
    Client ChercherClientParLoginMdp(String login, String mdp);

    void ValidationAchat(String idAchat);
    
}
