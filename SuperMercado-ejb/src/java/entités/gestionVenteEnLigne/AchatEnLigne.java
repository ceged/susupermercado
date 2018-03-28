/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Hello la team
package entités.gestionVenteEnLigne;

import entités.gestionArticle.Achat;
import entités.gestionVenteEnLigne.LivraisonDomicile;
import entités.gestionVenteEnLigne.RetraitMagasin;
import entités.gestionVenteEnLigne.ModeLivraison;
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
public class AchatEnLigne extends Achat implements Serializable {

    
    @OneToOne(mappedBy = "achatEnLigne")
    private RetraitMagasin retraitMagasin;

    public RetraitMagasin getRetraitMagasin() {
        return retraitMagasin;
    }

    public void setRetraitMagasin(RetraitMagasin retraitMagasin) {
        this.retraitMagasin = retraitMagasin;
    }

    public LivraisonDomicile getLivraisonDomicile() {
        return livraisonDomicile;
    }

    public void setLivraisonDomicile(LivraisonDomicile livraisonDomicile) {
        this.livraisonDomicile = livraisonDomicile;
    }

   
    @OneToOne(mappedBy = "achatEnLigne")
    private LivraisonDomicile livraisonDomicile;


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        if (!(object instanceof AchatEnLigne)) {
            return false;
        }
        AchatEnLigne other = (AchatEnLigne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entit\u00e9s.gestionMagasin.AchatEnLigne[ id=" + id + " ]";
    }
 
    @ManyToOne
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    private ModeLivraison modeLivraison;
    
    

    public ModeLivraison getModeLivraison() {
        return modeLivraison;
    }
    public void setModeLivraison(ModeLivraison modeLivraison) {
        this.modeLivraison = modeLivraison;
    }
    

}
