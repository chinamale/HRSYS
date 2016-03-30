/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.jsf;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import mw.co.sysassociates.hrsys.ejb.IEmployee;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Named
@RequestScoped
public class NewEducationBean {
    @EJB
    IEmployee employeeSrv;
    private String employee;
    private String company;
    private String yearFrom;
    private String yearTo;
    private String institution;
    private String qualification;

    public NewEducationBean() {
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

    public String getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(String yearFrom) {
        this.yearFrom = yearFrom;
    }

    public String getYearTo() {
        return yearTo;
    }

    public void setYearTo(String yearTo) {
        this.yearTo = yearTo;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
   
    public String register() {
        //String role = "users";
        company = "01";
        int result = employeeSrv.addEducationDetails(employee, company, qualification, institution, yearFrom, yearTo);  
        return "index";
    }
    
}
