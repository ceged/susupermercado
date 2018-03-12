/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités.gestionArticle;

import entités.gestionMagasin.AgentRayon;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author 3138946
 */
@Entity
public class Casse implements Serializable {

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
        if (!(object instanceof Casse)) {
            return false;
        }
        Casse other = (Casse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entit\u00e9s.gestionMagasin.Casse[ id=" + id + " ]";
    }
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCasse;

    public Date getDateCasse() {
        return dateCasse;
    }

    public void setDateCasse(Date dateCasse) {
        this.dateCasse = dateCasse;
    }
    
        private int quantiteCasse;

    public int getQuantiteCasse() {
        return quantiteCasse;
    }

    public void setQuantiteCasse(int quantiteCasse) {
        this.quantiteCasse = quantiteCasse;
    }

        private String motifCasse;

    public String getMotifCasse() {
        return motifCasse;
    }

    public void setMotifCasse(String motifCasse) {
        this.motifCasse = motifCasse;
    }

    @ManyToOne
    private AgentRayon agentRayon;

    public AgentRayon getAgentRayon() {
        return agentRayon;
    }

    public void setAgentRayon(AgentRayon agentRayon) {
        this.agentRayon = agentRayon;
    }

    @OneToOne
    private LotArticle lotArticleCasse;

    public LotArticle getLotArticleCasse() {
    return lotArticleCasse;
    }

    public void setLotArticleCasse(LotArticle lotArticleCasse) {
    this.lotArticleCasse = lotArticleCasse;
    }


}
