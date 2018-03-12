/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités.gestionCommande;

import entités.gestionCommande.Fournisseur;
import entités.gestionLivraison.Livraison;
import entités.gestionMagasin.ChefRayon;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author 3138946
 */
@Entity
public class Commande implements Serializable {

    @OneToMany(mappedBy = "commande")
    private List<Livraison> listeLivraisons;

    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> listeLigneCommandes;

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
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entit\u00e9s.gestionMagasin.Commande[ id=" + id + " ]";
    }
    
    @Temporal(javax.persistence.TemporalType.DATE)
        private java.util.Date dateCommande;

    public java.util.Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(java.util.Date dateCommande) {
        this.dateCommande = dateCommande;
    }
    
    @ManyToOne
    private ChefRayon chefRayon;

    public ChefRayon getChefRayon() {
        return chefRayon;
    }

    public void setChefRayon(ChefRayon chefRayon) {
        this.chefRayon = chefRayon;
    }

    @ManyToOne
    private Fournisseur fournisseur;

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

}
