/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités.gestionLivraison;

import entités.gestionLivraison.LigneLivraison;
import entités.gestionCommande.Commande;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
public class Livraison implements Serializable {

    @OneToMany(mappedBy = "livraison")
    private List<LigneLivraison> listeLigneLivraisons;

    public List<LigneLivraison> getListeLigneLivraisons() {
        return listeLigneLivraisons;
    }

    public void setListeLigneLivraisons(List<LigneLivraison> listeLigneLivraisons) {
        this.listeLigneLivraisons = listeLigneLivraisons;
    }

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
        if (!(object instanceof Livraison)) {
            return false;
        }
        Livraison other = (Livraison) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entit\u00e9s.gestionMagasin.Livraison[ id=" + id + " ]";
    }
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePrevue;

    public Date getDatePrevue() {
        return datePrevue;
    }

    public void setDatePrevue(Date datePrevue) {
        this.datePrevue = datePrevue;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
        private Date dateLivraison;

    public Date getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }
    
        private String Statut;

    public String getStatut() {
        return Statut;
    }

    public void setStatut(String Statut) {
        this.Statut = Statut;
    }

    @ManyToOne
        private Commande commande;

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
    
    @ManyToOne
    private AgentLivraison agentLivraison;

    public AgentLivraison getAgentLivraison() {
        return agentLivraison;
    }

    public void setAgentLivraison(AgentLivraison agentLivraison) {
        this.agentLivraison = agentLivraison;
    }


}
