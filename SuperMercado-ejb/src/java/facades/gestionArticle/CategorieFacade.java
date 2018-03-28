/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.Categorie;
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
public class CategorieFacade extends AbstractFacade<Categorie> implements CategorieFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategorieFacade() {
        super(Categorie.class);
    }
    
    @Override
    public void CreerCategorie (String libelleCategorie){
        Categorie categorieCree = new Categorie();
        categorieCree.setLibelleCategorie(libelleCategorie);
        em.persist(categorieCree);
    }
    
    @Override
    public Categorie RechercherCategorie(String libelleCategorieRecherche){
        Categorie categorieRecherche = null;
        Query req = getEntityManager().createQuery("Select categorieRecherche from Categorie as categorieRecherche where categorieRecherche.libelleCategorie=:libelleCategorieRecherche ");
        req.setParameter("libelleCategorieRecherche", libelleCategorieRecherche);
        List<Categorie>list=req.getResultList();
            for(Categorie s:list)
    {
        categorieRecherche=s;
    }
        return categorieRecherche;
    }
    
     @Override
    public Categorie RechercherCategorieParId(Long idCategorieRecherche){
        Categorie categorieRecherche = null;
        Query req = getEntityManager().createQuery("Select categorieRecherche from Categorie as categorieRecherche where categorieRecherche.id=:idCategorieRecherche ");
        req.setParameter("idCategorieRecherche", idCategorieRecherche);
        List<Categorie>list=req.getResultList();
            for(Categorie s:list)
    {
        categorieRecherche=s;
    }
        return categorieRecherche;
    }
    
}
