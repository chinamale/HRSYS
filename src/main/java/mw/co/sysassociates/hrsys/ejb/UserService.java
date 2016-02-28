/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mw.co.sysassociates.hrsys.entity.SystemUser;
import mw.co.sysassociates.hrsys.entity.SystemUserGroup;

/**
 *
 * @author Madalitso Chinamale
 */
@Stateless
@Local(IUserService.class)
public class UserService implements IUserService{
    @PersistenceContext
    EntityManager em;

    public UserService() {
    }
    @Override
    public void registerUser(String  username, String surname, String firstname, String userrole, String userpassword) {
        try{
        SystemUser sys_user;
            SystemUserGroup sys_user_group;

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String passwd = userpassword;
            md.update(passwd.getBytes("UTF-8"));
            byte[] digest = md.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            String paswdToStoreInDB = bigInt.toString(16);

            // apart from the default constructor which is required by JPA
            // you need to also implement a constructor that will make the following code succeed
            sys_user = new SystemUser(username,  surname,firstname,paswdToStoreInDB,userrole);
           
           
            sys_user_group = new SystemUserGroup(username, userrole);

            em.persist(sys_user);
            em.persist(sys_user_group);
            
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
