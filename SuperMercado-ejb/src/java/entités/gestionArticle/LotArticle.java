/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entités.gestionArticle;

import entités.gestionArticle.StockProduit;
import entités.gestionArticle.Casse;
import entités.gestionArticle.ReferentielArticle;
import entités.gestionArticle.LigneAchat;
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
public class LotArticle implements Serializable {

    @OneToMany(mappedBy = "lotArticle")
    private List<LigneAchat> listeLigneAchats;

    @OneToOne(mappedBy = "lotArticleCasse")
    private Casse casse;

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
        if (!(object instanceof LotArticle)) {
            return false;
        }
        LotArticle other = (LotArticle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entit\u00e9s.gestionMagasin.LotArticle[ id=" + id + " ]";
    }
    
        private int quantiteLot;

    public int getQuantiteLot() {
        return quantiteLot;
    }

    public void setQuantiteLot(int quantiteLot) {
        this.quantiteLot = quantiteLot;
    }

    @ManyToOne
        private ReferentielArticle article;

    public ReferentielArticle getArticle() {
        return article;
    }

    public void setArticle(ReferentielArticle article) {
        this.article = article;
    }
    
    @ManyToOne
    private StockProduit stockProduit;

    public StockProduit getStockProduit() {
        return stockProduit;
    }

    public void setStockProduit(StockProduit stockProduit) {
        this.stockProduit = stockProduit;
    }


}
