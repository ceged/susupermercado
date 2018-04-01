/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionVenteEnLigne;

import entités.gestionVenteEnLigne.AchatEnLigne;
import entités.gestionVenteEnLigne.Client;
import entités.gestionVenteEnLigne.ModeLivraison;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PC Tim
 */
@Stateless
public class AchatEnLigneFacade extends AbstractFacade<AchatEnLigne> implements AchatEnLigneFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AchatEnLigneFacade() {
        super(AchatEnLigne.class);
    }

    @Override
    public AchatEnLigne CreationAchatEnLigne(Client client) {
        AchatEnLigne a = new AchatEnLigne();
        Date dateAchat = new Date();
        a.setClient(client);
        a.setDateAchat(dateAchat);
        a.setStatutAchat("En Cours");
        
        em.persist(a);
        return a;
    }

    @Override
    public AchatEnLigne RechercherAchatEnLigneEnCours(Client client) {
        String statut = "En Cours";
        AchatEnLigne a = null;
        Query req = getEntityManager().createQuery("Select a from AchatEnLigne as a where a.client=:client and a.statutAchat=:statut");
        req.setParameter("client", client);
        req.setParameter("statut", statut);
        List<AchatEnLigne>listeAchat=req.getResultList();
        
        for(AchatEnLigne ac:listeAchat)
    {
        a=ac;
    }
        return a;
    }
    
    @Override
    public void AjouterModeLivraison(AchatEnLigne a,ModeLivraison modeLivraison){
        a.setModeLivraison(modeLivraison);
        em.merge(a);
    }
    
    @Override
    public void SupprimerAchat(AchatEnLigne achatasupprimer) {
        achatasupprimer= em.merge(achatasupprimer);   
        em.remove(achatasupprimer);
    }

    
    
    //cette méthode enlève les référence au client 
    @Override
    public void RechercherAchatsEnLigneClient(Client client) {

        Query req = getEntityManager().createQuery("Select a from AchatEnLigne as a where a.client=:client");
        req.setParameter("client", client);

        List<AchatEnLigne>listeAchat=req.getResultList();
        
        listeAchat.forEach((ac) -> {
            ac.setClient(null);
        });
 
    }
    
    
    
}
