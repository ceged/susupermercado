/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionCommande;

import entités.gestionCommande.Fournisseur;
import entités.gestionMagasin.AgentCaisse;
import entités.gestionMagasin.Magasin;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
