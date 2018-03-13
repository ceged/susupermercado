/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Soldat
 */
@Local
public interface SessionAdminLocal {
    
    int SeConnecter(String login, String mp );
    
    void CreerPersonneAdmin ();
    
    void CreerMagasin(String nomMagasin, String adresse, String codePostal);
    
    void CreerDirecteur(String nom, String prenom, String login, String mdp, String sexe, Date dob, String adresse, String codePostal, String magasin);
}
