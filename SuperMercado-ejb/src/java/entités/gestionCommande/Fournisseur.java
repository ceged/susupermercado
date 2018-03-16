/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités.gestionCommande;

import entités.gestionArticle.ReferentielArticle;
import entités.gestionMagasin.Personne;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author 3138946
 */
@Entity
public class Fournisseur extends Personne implements Serializable {

    @OneToMany(mappedBy = "fournisseur")
    private List<Commande> listeCommandes;

    public List<Commande> getListeCommandes() {
        return listeCommandes;
    }

    public void setListeCommandes(List<Commande> listeCommandes) {
        this.listeCommandes = listeCommandes;
    }

    public List<ReferentielArticle> getListeReferentielArticles() {
        return listeReferentielArticles;
    }

    public void setListeReferentielArticles(List<ReferentielArticle> listeReferentielArticles) {
        this.listeReferentielArticles = listeReferentielArticles;
    }

    @ManyToMany(mappedBy = "listeFournisseurs")
    private List<ReferentielArticle> listeReferentielArticles;

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
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entit\u00e9s.gestionMagasin.Fournisseur[ id=" + id + " ]";
    }
    
}
