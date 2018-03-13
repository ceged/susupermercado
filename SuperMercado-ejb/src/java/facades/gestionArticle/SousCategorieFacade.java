/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.Categorie;
import entités.gestionArticle.SousCategorie;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PC Tim
 */
@Stateless
public class SousCategorieFacade extends AbstractFacade<SousCategorie> implements SousCategorieFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SousCategorieFacade() {
        super(SousCategorie.class);
    }
    
    @Override
    public void CreerSousCategorie(String libelleSousCategorie, Categorie categorie){
        SousCategorie sousCategorieCree = new SousCategorie ();
        sousCategorieCree.setLibelleSousCategorie(libelleSousCategorie);
        sousCategorieCree.setCategorie(categorie);
        em.persist(sousCategorieCree);
    }
    
    @Override
    public SousCategorie RechercherSousCategorie(String libelleSousCategorieRecherche){
        SousCategorie sousCategorieRecherche = null;
        Query req = getEntityManager().createQuery("Select s from SousCategorie as s where s.libelleSousCategorie=:libelleSousCategorieRecherche ");
        req.setParameter("libelleSousCategorieRecherche", libelleSousCategorieRecherche);
        Collection<SousCategorie>col=req.getResultList();
            for(SousCategorie s:col)
    {
        sousCategorieRecherche=s;
    }
        return sousCategorieRecherche;
    }
    
        
    
}
