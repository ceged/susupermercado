/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import javax.ejb.Local;

/**
 *
 * @author Soldat
 */
@Local
public interface SessionAdminLocal {
    
    int SeConnecter(String login, String mp );
}
