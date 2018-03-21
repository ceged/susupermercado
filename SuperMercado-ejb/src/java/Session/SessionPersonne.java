/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionArticle.ReferentielArticle;
import entités.gestionLivraison.AgentLivraison;
import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Personne;
import entités.gestionVenteEnLigne.Creneau;
import facades.gestionArticle.ReferentielArticleFacadeLocal;
import facades.gestionLivraison.AgentLivraisonFacadeLocal;
import facades.gestionMagasin.MagasinFacadeLocal;
import facades.gestionMagasin.PersonneFacadeLocal;
import facades.gestionVenteEnLigne.CreneauFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Sophia
 */
@Stateless
public class SessionPersonne implements SessionPersonneLocal {

    @EJB
    private AgentLivraisonFacadeLocal agentLivraisonFacade;

    @EJB
    private CreneauFacadeLocal creneauFacade;

    @EJB
    private ReferentielArticleFacadeLocal referentielArticleFacade;

    @EJB
    private MagasinFacadeLocal magasinFacade;

    @EJB
    private PersonneFacadeLocal personneFacade;

    
    @Override
    public void ModificationMdp(String ancienMdp, String nouveauMdp, String idPersonne) {
        Long id=Long.parseLong(idPersonne);
        Personne personne = personneFacade.RechercherPersonneParId(id);
        personneFacade.ModifierMdp(personne, ancienMdp, nouveauMdp);
    }

    @Override
    public Personne RechercherPersonneParId(String idPersonne) {
        
        Long id=Long.parseLong(idPersonne);
        return personneFacade.RechercherPersonneParId(id);
    }
    
    

    @Override
    public List <Magasin> ConsultationMagasins() {
        return magasinFacade.findAll();
    }

    @Override
    public List<ReferentielArticle> ConsultationArticlesParMagasin(String nomMagasin) {
        Magasin magasin= magasinFacade.RechercherMagasinParNom(nomMagasin);
        return referentielArticleFacade.RechercheReferentielArticleParMagasin(magasin);
    }

    @Override
    public Magasin RechercherMagasinParNom(String nomMagasin) {
        return magasinFacade.RechercherMagasinParNom(nomMagasin);
    }

    
    
}
