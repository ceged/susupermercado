/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionCommande;

import entités.gestionCommande.Commande;
import entités.gestionCommande.Fournisseur;
import entités.gestionCommande.LigneCommande;
import entités.gestionMagasin.ChefRayon;
import java.util.ArrayList;
import java.util.Collection;
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
public class CommandeFacade extends AbstractFacade<Commande> implements CommandeFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeFacade() {
        super(Commande.class);
    }
    
    @Override
    public void CreerBonCommande(ChefRayon chefRayon, Date dateCommande, Fournisseur fournisseur){
        Commande c = new Commande();
        c.setChefRayon(chefRayon);
        c.setDateCommande(dateCommande);
        c.setFournisseur(fournisseur);
        c.setStatutCommande("encours");
        em.persist(c);
    }
    
    @Override//encours;valider;livrer;reclamer;
    public void ChangerStatutCommande(Commande commande,String statut){
        commande.setStatutCommande(statut);
        em.merge(commande);
    }
    
    @Override
    public Commande RechercherCommandeParId(Long idCommande){
        Commande commandeCherche = null;
        Query req = getEntityManager().createQuery("Select c from Commande as c where c.id=:idCommande");
        req.setParameter("idCommande", idCommande);
        Collection<Commande>col=req.getResultList();
            for(Commande c:col)
    {
        commandeCherche=c;
    }
        return commandeCherche;
    }
    
    @Override
    public Commande RechercherDernierCommandeCree(){
        Commande commandeCherche = new Commande();
        Query req = getEntityManager().createQuery("Select c from Commande as c ORDER BY c.id DESC");
        
        Collection<Commande>col=req.getResultList();
        int i=0;{
            for(Commande c:col)
        {
        if(i==0){
            commandeCherche=c;
        }
        i++;
        }
      }
        return commandeCherche;
    }
    
    @Override
    public List<Commande> RechercherListeBonCommmandeParStatutParChefRayon(String statut,ChefRayon chefRayon){
        List<Commande> listeCommande = new ArrayList<Commande>();
        Query req=getEntityManager().createQuery("Select c from Commande as c WHERE c.statut=:statut and c.chefRayon=:chefRayon");
        req.setParameter("statut", statut);
        req.setParameter("chefRayon", chefRayon);
        Collection<Commande>col=req.getResultList();
        for(Commande c:col){
            listeCommande.add(c);
        }
        return listeCommande;
    }
    
    @Override
    public List<Commande> RechercherListeBonCommmandeParChefRayon(ChefRayon chefRayon){
        List<Commande> listeCommande = new ArrayList<Commande>();
        Query req=getEntityManager().createQuery("Select c from Commande as c WHERE c.chefRayon=:chefRayon");
        req.setParameter("chefRayon", chefRayon);
        Collection<Commande>col=req.getResultList();
        for(Commande c:col){
            listeCommande.add(c);
        }
        return listeCommande;
    }
    
    @Override
    public List<Commande> RechercherListeBonCommmandeParFournisseur(Fournisseur fournisseur){
        String statut="valider";
        List<Commande> listeCommande = new ArrayList<Commande>();
        Query req=getEntityManager().createQuery("Select c from Commande as c WHERE c.fournisseur=:fournisseur AND c.statut=:statut");
        req.setParameter("fournisseur", fournisseur);
        req.setParameter("statut", statut);
        Collection<Commande>col=req.getResultList();
        for(Commande c:col){
            listeCommande.add(c);
        }
        return listeCommande;
    }
    
}
