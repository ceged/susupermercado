/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionCommande;

import entités.gestionArticle.ReferentielArticle;
import entités.gestionCommande.Fournisseur;
import entités.gestionMagasin.AgentCaisse;
import entités.gestionMagasin.Magasin;
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
public class FournisseurFacade extends AbstractFacade<Fournisseur> implements FournisseurFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FournisseurFacade() {
        super(Fournisseur.class);
    }
    
    @Override
    public void CreerFournisseur(String prenom, String nom, String login, String mdp, Date dob, String sexe, String adresse, String codePostal) {
        Fournisseur fournisseur = new Fournisseur();
        
        fournisseur.setPrenom(prenom);
        fournisseur.setNom(nom);
        fournisseur.setLogin(login);
        fournisseur.setMdp(mdp);
        fournisseur.setDob(dob);
        fournisseur.setSexe(sexe);
        fournisseur.setAdresse(adresse);
        fournisseur.setCodePostal(codePostal);

        em.persist(fournisseur);
        
    }
    @Override
    public List<Fournisseur>ConsulterListeFournisseur(){
        List<Fournisseur> listeFournisseur=findAll();
        return listeFournisseur;
    }
    
    @Override
    public Fournisseur RechercheFournisseurParId(Long idFournisseur){
        Fournisseur fournisseurCherche = null;
        Query req = getEntityManager().createQuery("Select f from Fournisseur as f where f.id=:idFournisseur");
        req.setParameter("idFournisseur", idFournisseur);
        Collection<Fournisseur>col=req.getResultList();
            for(Fournisseur f:col)
    {
        fournisseurCherche=f;
    }
        return fournisseurCherche;
    }
    
}
