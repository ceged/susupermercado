/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités.gestionVenteEnLigne;

import entités.gestionMagasin.Magasin;
import entités.gestionVenteEnLigne.LivraisonDomicile;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author 3138946
 */
@Entity
public class Creneau implements Serializable {

    @OneToMany(mappedBy = "creneau")
    private List<LivraisonDomicile> livraisonDomiciles;

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
        if (!(object instanceof Creneau)) {
            return false;
        }
        Creneau other = (Creneau) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entit\u00e9s.gestionMagasin.Creneau[ id=" + id + " ]";
    }
 


    private Time heureDebut;

    public Time getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Time heureDebut) {
        this.heureDebut = heureDebut;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreneau;

    public Date getDate() {
        return dateCreneau;
    }

    public void setDate(Date dateCreneau) {
        this.dateCreneau = dateCreneau;
    }
    
    

       private Time heureFin;

    public Time getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Time heureFin) {
        this.heureFin = heureFin;
    }

        private Boolean disponibilité;

    public Boolean getDisponibilité() {
        return disponibilité;
    }

    public void setDisponibilité(Boolean disponibilité) {
        this.disponibilité = disponibilité;
    }
    
        private Magasin magasin;
     
        public Magasin getMagasin(){
            return magasin;
        }
        
        public void setMagasin(Magasin magasin){
            this.magasin=magasin;
        }
        

}
