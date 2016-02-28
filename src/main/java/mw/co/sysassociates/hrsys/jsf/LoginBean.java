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

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class LoginBean implements Serializable {
private String username;
private String password;
private String usserrole;
private int userid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsserrole() {
        return usserrole;
    }

    public void setUsserrole(String usserrole) {
        this.usserrole = usserrole;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    
    
   public String login() {
        String homepage = "";
        String loginuser = "";
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        System.out.println("Logging in with username: " + this.username);
        System.out.println("Logging in with password: " + this.password);
        try {
            request.login(this.username, this.password);
            System.out.println("Logged in");
            loginuser = request.getRemoteUser();
            //System.out.println("Found user details :" + CloggedinUser); 
//            if (request.isUserInRole("Users")){
//                homepage = "users";
//                Individual individual = loggedinUser1.findIndividualByEmail(loginuser); 
//                username = individual.getFirname() + " " + individual.getSurname();                               userid= individual.getId();
//                userrole = "Users";
//            }
//            //System.out.println("Logged in")
//            if (request.isUserInRole("Charity")){
//                homepage = "charity";
//                Charity charity = loggedInuser.findCharityByEmail(loginuser);
//                username =  charity.getCharityname();
//                userid= charity.getId();
//                userrole = "Charity";
//            }
//            if (request.isUserInRole("Admin")){
//                homepage = "/admin/adminHomePage";
//                System.out.println("logged in user is admin");
//                SystemUser sysUser = usrSrvc.findUserByLoginName(loginuser);
//                userid = sysUser.getId();
//                userrole = "Admin";
//                username = sysUser.getFirstname() + " " + sysUser.getSurname();
//            }
//            
            System.out.println("Log in successful : " + username);
            context.addMessage(null, new FacesMessage(username + " logged in"));
            System.out.println("Home page is " + homepage);
            
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Login failed:" + e.getMessage()));
            return "error";
        }
        System.out.println(request.getRequestURI());
        return homepage;
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.logout();
            context.addMessage(null, new FacesMessage("User is logged out"));
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Logout failed."));
        }
        System.out.println("logging out....");
        return "logout";
    }
 
}
