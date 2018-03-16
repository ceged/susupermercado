/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import entités.gestionArticle.Achat;
import entités.gestionArticle.LotArticle;
import facades.gestionArticle.AchatFacadeLocal;
import facades.gestionArticle.LigneAchatFacadeLocal;
import facades.gestionArticle.LotArticleFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author CGAILLOTDREVON
 */
@Stateless
public class SessionEmployeCaisse implements SessionEmployeCaisseLocal {

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
}
