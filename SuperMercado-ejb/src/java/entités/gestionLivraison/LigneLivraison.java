/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités.gestionLivraison;

import entités.gestionArticle.ReferentielArticle;
import entités.gestionCommande.LigneCommande;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author 3138946
 */
@Entity
public class LigneLivraison implements Serializable {
    
    @OneToOne(mappedBy = "ligneLivraison")
    private Reclamation reclamation;

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
        if (!(object instanceof LigneLivraison)) {
            return false;
        }
        LigneLivraison other = (LigneLivraison) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entit\u00e9s.gestionMagasin.ligneLivraison[ id=" + id + " ]";
    }
 
    @OneToOne
    private LigneCommande ligneCommande; 
    
    public LigneCommande getLigneCommande(){
        return ligneCommande;
    }
    
    public void setLigneCommande(LigneCommande ligneCommande){
        this.ligneCommande = ligneCommande;
    }
    
    private int quantiteFournisseur;

    public int getQuantiteFournisseur() {
        return quantiteFournisseur;
    }

    public void setQuantiteFournisseur(int quantiteFournisseur) {
        this.quantiteFournisseur = quantiteFournisseur;
    }

        private int quantiteLivree;

    public int getQuantiteLivree() {
        return quantiteLivree;
    }

    public void setQuantiteLivree(int quantiteLivree) {
        this.quantiteLivree = quantiteLivree;
    }

        private int quantiteReceptionnee;

    public int getQuantiteReceptionnee() {
        return quantiteReceptionnee;
    }

    public void setQuantiteReceptionnee(int quantiteReceptionnee) {
        this.quantiteReceptionnee = quantiteReceptionnee;
    }

    @ManyToOne
    private Livraison livraison;

    public Livraison getLivraison() {
        return livraison;
    }

    public void setLivraison(Livraison livraison) {
        this.livraison = livraison;
    }
    
    @ManyToOne
        private ReferentielArticle article;

    public ReferentielArticle getArticle() {
        return article;
    }

    public void setArticle(ReferentielArticle article) {
        this.article = article;
    }

    private Mention mentionStatut;

    public Mention getMentionStatut() {
        return mentionStatut;
    }

    public void setMentionStatut(Mention mentionStatut) {
        this.mentionStatut = mentionStatut;
    }

}
