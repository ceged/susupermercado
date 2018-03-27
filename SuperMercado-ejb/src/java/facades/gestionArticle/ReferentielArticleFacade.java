/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades.gestionArticle;

import entités.gestionArticle.ReferentielArticle;
import entités.gestionArticle.SousCategorie;
import entités.gestionCommande.Fournisseur;
import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Rayon;
import java.util.Collection;
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
public class ReferentielArticleFacade extends AbstractFacade<ReferentielArticle> implements ReferentielArticleFacadeLocal {

    @PersistenceContext(unitName = "SuperMercado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReferentielArticleFacade() {
        super(ReferentielArticle.class);
    }
    
    @Override
    public void CreerReferentielArticle (String libelleArticle, Rayon rayon, String marque, float prixVente, SousCategorie sousCategorie,List<Fournisseur> listeFournisseur ){
        ReferentielArticle referentielArticleCree = new ReferentielArticle();
        referentielArticleCree.setLibelleArticle(libelleArticle);
        referentielArticleCree.setRayon(rayon);
        referentielArticleCree.setMarque(marque);
        referentielArticleCree.setPrixVenteMagasin(prixVente);
        referentielArticleCree.setSousCategorie(sousCategorie);
        referentielArticleCree.setListeFournisseurs(listeFournisseur);
        em.persist(referentielArticleCree);   
    }
    
    @Override
    public ReferentielArticle RechercheReferentielArticleParCodeBarre(Long codeBarreRecherche){
        ReferentielArticle referentielArticleRecherche = null;
        Query req = getEntityManager().createQuery("Select r from ReferentielArticle as r where r.codeBarre=:codeBarreRecherche ");
        req.setParameter("codeBarreRecherche", codeBarreRecherche);
        Collection<ReferentielArticle>col=req.getResultList();
            for(ReferentielArticle r:col)
    {
        referentielArticleRecherche=r;
    }
        return referentielArticleRecherche;
    }
    
    @Override
    public void ModifierPrixReferentielArticle (ReferentielArticle referentielArticleModifie,float newPrixVente){
        referentielArticleModifie.setPrixVenteMagasin(newPrixVente);
        em.merge(referentielArticleModifie);
    }
    
    @Override
    public void SupprimerReferentielArticle (ReferentielArticle referentielArticleSupprime){
        em.remove(referentielArticleSupprime);
    }
    
    @Override
    public ReferentielArticle RechercheReferentielArticleParLibelleParRayon(Rayon rayon,String libelleRecherche){
        ReferentielArticle referentielArticleRecherche = null;
        Query req = getEntityManager().createQuery("Select r from ReferentielArticle as r where r.libelleArticle=:libelleRecherche AND r.rayon=:rayon ");
        req.setParameter("rayon", rayon);
        req.setParameter("libelleRecherche", libelleRecherche);
        Collection<ReferentielArticle>col=req.getResultList();
            for(ReferentielArticle r:col)
    {
        referentielArticleRecherche=r;
    }
        return referentielArticleRecherche;
    }
    
    @Override
    public ReferentielArticle RechercheReferentielArticleParLibelle(String libelleRecherche){
        ReferentielArticle referentielArticleRecherche = null;
        Query req = getEntityManager().createQuery("Select r from ReferentielArticle as r where r.libelleArticle=:libelleRecherche");
        req.setParameter("libelleRecherche", libelleRecherche);
        Collection<ReferentielArticle>col=req.getResultList();
            for(ReferentielArticle r:col)
    {
        referentielArticleRecherche=r;
    }
        return referentielArticleRecherche;
    }
    
    @Override
    public List<ReferentielArticle> RechercherListeArticleParRayon(Rayon rayon){
        Query req=getEntityManager().createQuery("SELECT r from ReferentielArticle AS r WHERE r.rayon=:rayon ");
        req.setParameter("rayon",rayon);
        List result = req.getResultList();
        return result;
        
    }

    @Override
    public List<ReferentielArticle> RechercheReferentielArticleParMagasin(Magasin magasin) {
        Query req = getEntityManager().createQuery("Select r from ReferentielArticle as r where r.rayon.secteur.magasin=:magasin");
        req.setParameter("magasin", magasin);
        List<ReferentielArticle> result = req.getResultList();
        return result;
    }   

    @Override
    public List<ReferentielArticle> RechercherListeArticleParFournisseur(Fournisseur fournisseur) {
        Long idFournisseur = fournisseur.getId();
        Query req=getEntityManager().createQuery("select distinct m from ReferentielArticle m left join m.listeFournisseurs g where g.id = :idFournisseur");
        req.setParameter("idFournisseur",idFournisseur);
        List <ReferentielArticle>result = req.getResultList();
        return result;
    }
    
}
