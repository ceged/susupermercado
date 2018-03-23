/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionArticle.Casse;
import entités.gestionCommande.Commande;
import entités.gestionLivraison.Livraison;
import entités.gestionMagasin.AgentRayon;
import entités.gestionMagasin.Rayon;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Soldat
 */
@Local
public interface SessionAgentRayonLocal {
    
    String AjouterCasse(String idAgentRayon, Date dateCasse, String idLotArticle, String motifCasse, int quantiteCasse );
    
    List<Casse> ChercherListeCasseParRayon(String idAgentRayon);
    
    void ModifierQteLotArticle(String idLotArticle, int newQte);
    
    AgentRayon ChercherAgentRayonParId(String idAgent);
    
    List<Livraison> ChercherListeLivraisonParAgentRayon(Rayon r);
    
    List<Commande> ChercherListeCommandeParAgentRayon(Rayon r);
}
