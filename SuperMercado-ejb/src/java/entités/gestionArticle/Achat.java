/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités.gestionArticle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Cyril
 */
@Entity
public class Achat implements Serializable {

    @OneToMany(mappedBy = "achat", cascade = {CascadeType.ALL})
    private List<LigneAchat> listeLigneAchats;

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
        if (!(object instanceof Achat)) {
            return false;
        }
        Achat other = (Achat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entit\u00e9s.gestionMagasin.Achat[ id=" + id + " ]";
    }
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAchat;

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public List<LigneAchat> getListeLigneAchats() {
        return listeLigneAchats;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
 
        private String statutAchat;

    public String getStatutAchat() {
        return statutAchat;
    }

    public void setStatutAchat(String statutAchat) {
        this.statutAchat = statutAchat;
    }

}
