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
public interface SessionEmployeDeRayonLocal {

    String EnregistrerCasse(int qteCasse, String motifCasse, long idLotArticle, long idAgentRayon);
    
    
}
