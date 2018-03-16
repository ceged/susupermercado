/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités.gestionMagasin;

import entités.gestionArticle.ReferentielArticle;
import java.io.Serializable;
import java.util.List;
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
public class Rayon implements Serializable {

    @OneToMany(mappedBy = "rayon")
    private List<ReferentielArticle> listeReferentielArticles;

    @OneToMany(mappedBy = "rayon")
    private List<AgentRayon> listeAgentRayons;

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
        if (!(object instanceof Rayon)) {
            return false;
        }
        Rayon other = (Rayon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entit\u00e9s.gestionMagasin.Rayon[ id=" + id + " ]";
    }
    
    private String libelleRayon;

    public String getLibelleRayon() {
        return libelleRayon;
    }

    public void setLibelleRayon(String libelleRayon) {
        this.libelleRayon = libelleRayon;
    }
 
    @ManyToOne
    private Secteur secteur;

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    @OneToOne(mappedBy = "rayon")
    private ChefRayon chefRayon;

    public ChefRayon getChefRayon() {
        return chefRayon;
    }

    public void setChefRayon(ChefRayon chefRayon) {
        this.chefRayon = chefRayon;
    }

}
