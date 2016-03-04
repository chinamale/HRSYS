/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import javax.ejb.Local;

/**
 *
 * @author Madalitso Chinamale
 */
@Local
public interface IUserService {
void registerUser(String  username, String surname, String firstname, String role, String userpassword);
}
