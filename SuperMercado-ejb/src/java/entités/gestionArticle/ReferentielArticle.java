/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités.gestionArticle;

import entités.gestionArticle.Promotion;
import entités.gestionArticle.SousCategorie;
import entités.gestionCommande.Fournisseur;
import entités.gestionCommande.LigneCommande;
import entités.gestionLivraison.LigneLivraison;
import entités.gestionMagasin.Magasin;
import entités.gestionMagasin.Rayon;
import java.io.Serializable;
import java.util.List;
import static javax.persistence.CascadeType.REMOVE;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author 3138946
 */
@Entity
public class ReferentielArticle implements Serializable {

    

    @OneToMany(mappedBy = "article")
    private List<LotArticle> listeLotArticles;

    @OneToMany(mappedBy = "article")
    private List<LigneCommande> listeLigneCommandes;

    @OneToMany(cascade=REMOVE, mappedBy = "article")
    private List<Promotion> listePromotions;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (nullable=false,unique=true)
    private Long codeBarre;

    public Long getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(Long codeBarre) {
        this.codeBarre = codeBarre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeBarre != null ? codeBarre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReferentielArticle)) {
            return false;
        }
        ReferentielArticle other = (ReferentielArticle) object;
        if ((this.codeBarre == null && other.codeBarre != null) || (this.codeBarre != null && !this.codeBarre.equals(other.codeBarre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entit\u00e9s.gestionMagasin.ReferentielArticle[ id=" + codeBarre + " ]";
    }
    
    @ManyToOne
    private SousCategorie sousCategorie;

    public SousCategorie getSousCategorie() {
        return sousCategorie;
    }

    public void setSousCategorie(SousCategorie sousCategorie) {
        this.sousCategorie = sousCategorie;
    }
    
        private String libelleArticle;

    public String getLibelleArticle() {
        return libelleArticle;
    }

    public void setLibelleArticle(String libelleArticle) {
        this.libelleArticle = libelleArticle;
    }

    private float prixVenteMagasin;

    public float getPrixVenteMagasin() {
        return prixVenteMagasin;
    }

    public void setPrixVenteMagasin(float prixVenteMagasin) {
        this.prixVenteMagasin = prixVenteMagasin;
    }

    
    @ManyToMany
    private List <Fournisseur> listeFournisseurs;

        private String marque;

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @ManyToOne
        private Rayon rayon;

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        this.rayon = rayon;
    }


    public List<LotArticle> getListeLotArticles() {
        return listeLotArticles;
    }

    public List<LigneCommande> getListeLigneCommandes() {
        return listeLigneCommandes;
    }

    public List<Promotion> getListePromotions() {
        return listePromotions;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Fournisseur> getListeFournisseurs() {
        return listeFournisseurs;
    }
    public void setListeFournisseurs(List<Fournisseur> listeFournisseur) {
        this.listeFournisseurs = listeFournisseur;
    }



}
