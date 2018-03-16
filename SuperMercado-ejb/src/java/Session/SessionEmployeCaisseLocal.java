/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import javax.ejb.Local;

/**
 *
 * @author CGAILLOTDREVON
 */
@Local
public interface SessionEmployeCaisseLocal {

    String CreerLigneAchat(long codeLotArticle, int qteAchetee, long codeAchat);
    void CreerAchat();
    
}
