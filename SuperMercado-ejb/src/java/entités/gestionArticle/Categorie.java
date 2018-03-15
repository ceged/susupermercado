/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités.gestionArticle;

import entités.gestionArticle.SousCategorie;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author 3138946
 */
@Entity
public class Categorie implements Serializable {

    @OneToMany(mappedBy = "categorie")
    private List<SousCategorie> listeSousCategories;

    private static final long serialVersionUID = 1L;
    @Column (nullable=false,unique=true)
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
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entit\u00e9s.gestionMagasin.Categorie[ id=" + id + " ]";
    }
    
    @Column (nullable=false,unique=true)
    private String libelleCategorie;

    public String getLibelleCategorie() {
        return libelleCategorie;
    }

    public void setLibelleCategorie(String libelleCategorie) {
        this.libelleCategorie = libelleCategorie;
    }

    public List<SousCategorie> getListeSousCategories() {
        return listeSousCategories;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

}
