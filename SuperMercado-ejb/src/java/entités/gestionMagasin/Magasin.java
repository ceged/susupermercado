/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités.gestionMagasin;

import entités.gestionLivraison.AgentLivraison;
import entités.gestionArticle.ReferentielArticle;
import entités.gestionVenteEnLigne.RetraitMagasin;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author 3138946
 */
@Entity
public class Magasin implements Serializable {

    @OneToMany(mappedBy = "magasin")
    private List<ReferentielArticle> listeReferentielArticles;

    @OneToMany(mappedBy = "magasin")
    private List<RetraitMagasin> listeRetraitMagasins;

    @OneToOne(mappedBy = "magasin")
    private DirecteurMagasin directeurMagasin;

    @OneToMany(mappedBy = "magasin")
    private List<Caisse> listeCaisses;

    @OneToMany(mappedBy = "magasin")
    private List<AgentLivraison> listeAgentLivraisons;

    @OneToMany(mappedBy = "magasin")
    private List<Secteur> listeSecteurs;

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
        if (!(object instanceof Magasin)) {
            return false;
        }
        Magasin other = (Magasin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entit\u00e9s.gestionMagasin.Magasin[ id=" + id + " ]";
    }
    
        private String adresse;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    private String codePostal;

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public List<AgentLivraison> getListeAgentLivraisons() {
        return listeAgentLivraisons;
    }

    public List<Secteur> getListeSecteurs() {
        return listeSecteurs;
    }

    @Column (unique=true)
    private String nomMagasin;

    /**
     * Get the value of nomMagasin
     *
     * @return the value of nomMagasin
     */
    public String getNomMagasin() {
        return nomMagasin;
    }

    /**
     * Set the value of nomMagasin
     *
     * @param nomMagasin new value of nomMagasin
     */
    public void setNomMagasin(String nomMagasin) {
        this.nomMagasin = nomMagasin;
    }


}