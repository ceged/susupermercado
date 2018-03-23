/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionVenteEnLigne;

import entités.gestionVenteEnLigne.AchatEnLigne;
import entités.gestionVenteEnLigne.Creneau;
import entités.gestionVenteEnLigne.LivraisonDomicile;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PC Tim
 */
@Stateless
public class LivraisonDomicileFacade extends AbstractFacade<LivraisonDomicile> implements LivraisonDomicileFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LivraisonDomicileFacade() {
        super(LivraisonDomicile.class);
    }
    
    @Override
    public void CreerLivraisonDomicile(AchatEnLigne achat, String adresse, String codePostal, String ville, Creneau creneau ){
        LivraisonDomicile l = new LivraisonDomicile();
        l.setAchatEnLigne(achat);
        l.setAdresse(adresse);
        l.setCodePostal(codePostal);
        l.setVille(ville);
        l.setCreneau(creneau);
        em.merge(l);
    }
    
}
