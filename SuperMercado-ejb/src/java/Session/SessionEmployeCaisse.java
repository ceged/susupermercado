/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionArticle.Achat;
import entités.gestionArticle.AchatCaisse;
import entités.gestionArticle.LigneAchat;
import entités.gestionArticle.LotArticle;
import entités.gestionMagasin.AgentCaisse;
import entités.gestionMagasin.Caisse;
import facades.gestionArticle.AchatCaisseFacadeLocal;
import facades.gestionArticle.AchatFacadeLocal;
import facades.gestionArticle.LigneAchatFacadeLocal;
import facades.gestionArticle.LotArticleFacadeLocal;
import facades.gestionMagasin.AffectationCaisseAgentFacadeLocal;
import facades.gestionMagasin.AgentCaisseFacadeLocal;
import facades.gestionMagasin.CaisseFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author CGAILLOTDREVON
 */
@Stateless
public class SessionEmployeCaisse implements SessionEmployeCaisseLocal {


    @EJB
    private AffectationCaisseAgentFacadeLocal affectationCaisseAgentFacade;

    @EJB
    private AgentCaisseFacadeLocal agentCaisseFacade;

    @EJB
    private CaisseFacadeLocal caisseFacade;

    @EJB
    private AchatCaisseFacadeLocal achatCaisseFacade;

    @EJB
    private AchatFacadeLocal achatFacade;

    @EJB
    private LigneAchatFacadeLocal ligneAchatFacade;

    @EJB
    private LotArticleFacadeLocal lotArticleFacade;

    @Override
    public String CreerLigneAchat(long codeLotArticle, int qteAchetee, long codeAchat) {
        
        String message = "l'achat n'a pas été retrouvé";
        
        LotArticle la = null ;
        Achat a = null ;
        
         a = achatFacade.RechercheAchatParId(codeAchat);
         
         if (a!= null){
             la = lotArticleFacade.RechercherLotArticleParId(codeLotArticle);
             
             if (la !=null){
                 
                 ligneAchatFacade.CreerLigneAchat(qteAchetee, la, a);
                 lotArticleFacade.ModifierQteLotArticle(qteAchetee, la);
                 message = "la ligne a été correctement ajoutée";
                 
             } else {
                 message = "le lot article est inconnu";
             }
             
         }
         
         
        
        return message;
    }

    @Override
    public void CreerAchat() {
        
        
        Date dateAchat = new Date();
        Achat a = null ;
        
        a = achatFacade.CreerAchat(dateAchat);
               
}
    @Override
    public AchatCaisse CreerAchatCaisse(String idAgent){
        AchatCaisse achat=null;
        Date dateAchat= new Date();
        AgentCaisse a=this.ChercherAgentCaisseParId(idAgent);
        Caisse c=affectationCaisseAgentFacade.RechercherAffectionParDateAgent(dateAchat, a).getCaisse();
        achat=achatCaisseFacade.CreerAchatCaisse(dateAchat, c);
        return achat;
    }
    
    @Override
    public AgentCaisse ChercherAgentCaisseParId(String idAgent){
        return agentCaisseFacade.RechercherAgentCaisseParId(idAgent);
    }
    
    @Override
    public List<LigneAchat> ChercherLigneAchatParAchat(AchatCaisse a){
        List<LigneAchat> result=achatCaisseFacade.ChercherListeLigneAchatParAchatCaisse(a);
        return result;
    }
    
    @Override
    public LotArticle ChercherLotArticleParId(String idLot){
        Long id=Long.parseLong(idLot);
        LotArticle lot=lotArticleFacade.RechercherLotArticleParId(id);
        return lot;
    }
    
    @Override
    public AchatCaisse ChercherAchatCaisseParId(String idAchat){
        Long id=Long.parseLong(idAchat);
        return achatCaisseFacade.find(id);
    }
    
    @Override
    public LigneAchat ChercherLigneAchat (String idLigneAchat){
        Long id=Long.parseLong(idLigneAchat);
        return ligneAchatFacade.find(id);
    }
}
