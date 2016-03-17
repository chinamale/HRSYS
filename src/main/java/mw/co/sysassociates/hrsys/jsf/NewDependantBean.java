/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.jsf;

import java.util.Date;
import java.util.Objects;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import mw.co.sysassociates.hrsys.ejb.IDependant;
import mw.co.sysassociates.hrsys.ejb.IEmployee;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Named
@RequestScoped
public class NewDependantBean {
    @EJB
    IDependant dependantSrv;
    private String employee;
    private String company;
    private String firstname;
    private String surname;
    private Date dateofbirth;
    private String rlship; 

    public NewDependantBean() {
    }

    public IDependant getDependantSrv() {
        return dependantSrv;
    }

    public void setDependantSrv(IDependant dependantSrv) {
        this.dependantSrv = dependantSrv;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getRlship() {
        return rlship;
    }

    public void setRlship(String rlship) {
        this.rlship = rlship;
    }

    public String addDependant() {
        //String role = "users";
    company = "01";
    int result = dependantSrv.inputDependant(employee, company, firstname, surname, dateofbirth, rlship);  
        return "index";
    }
        
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.employee);
        hash = 61 * hash + Objects.hashCode(this.company);
        hash = 61 * hash + Objects.hashCode(this.firstname);
        hash = 61 * hash + Objects.hashCode(this.surname);
        hash = 61 * hash + Objects.hashCode(this.rlship);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NewDependantBean other = (NewDependantBean) obj;
        if (!Objects.equals(this.employee, other.employee)) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.rlship, other.rlship)) {
            return false;
        }
        return true;
    }
    
}
