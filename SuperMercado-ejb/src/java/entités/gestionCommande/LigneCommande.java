/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités.gestionCommande;

import entités.gestionCommande.Commande;
import entités.gestionArticle.ReferentielArticle;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author 3138946
 */
@Entity
public class LigneCommande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LigneCommande)) {
            return false;
        }
        LigneCommande other = (LigneCommande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entit\u00e9s.gestionMagasin.ligneCommande[ id=" + id + " ]";
    }
    
    private int quantiteLigne;

    public int getQuantiteLigne() {
        return quantiteLigne;
    }

    public void setQuantiteLigne(int quantiteLigne) {
        this.quantiteLigne = quantiteLigne;
    }

    private float prixAchatUnitaire;

    public float getPrixAchatUnitaire() {
        return prixAchatUnitaire;
    }

    public void setPrixAchatUnitaire(float prixAchatUnitaire) {
        this.prixAchatUnitaire = prixAchatUnitaire;
    }


    @ManyToOne
        private Commande commande;

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @ManyToOne
    private ReferentielArticle article;

    public ReferentielArticle getArticle() {
        return article;
    }

    public void setArticle(ReferentielArticle article) {
        this.article = article;
    }


}
