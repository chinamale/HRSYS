/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.jsf;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import mw.co.sysassociates.hrsys.ejb.IRelationship;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Named
@RequestScoped
public class NewRelationshipBean implements Serializable {
    @EJB
    IRelationship rltionshipSrv;
    
    String company;
    String description;
    String validfor;
    int agelimit;

    public NewRelationshipBean() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValidfor() {
        return validfor;
    }

    public void setValidfor(String validfor) {
        this.validfor = validfor;
    }

    public int getAgelimit() {
        return agelimit;
    }

    public void setAgelimit(int agelimit) {
        this.agelimit = agelimit;
    }
    
    public String addRelationship() {
        company = "01";
        int result = rltionshipSrv.addRelationship(company, description, validfor, agelimit);  
        return "index";
    }

}
