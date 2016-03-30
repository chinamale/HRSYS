/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.jsf;

/**
 *
 * @author Madalitso Chinamale
 */
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import mw.co.sysassociates.hrsys.ejb.IUserService;

@Named
@RequestScoped
public class RegistrationBean {

    @EJB
    IUserService usrSrv;
    
    String username;
    String userpassword;
    String firstname;
    String surname;
    String role;
    public RegistrationBean() {

    }

    //call the injected EJB
    public String register() {
        String role = "users";
        usrSrv.registerUser(username,  surname,firstname, role,userpassword);
  
        return "index";
    }
    
    
  
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
}
