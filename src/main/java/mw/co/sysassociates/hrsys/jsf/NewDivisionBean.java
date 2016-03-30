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
import mw.co.sysassociates.hrsys.ejb.IDivision;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Named
@RequestScoped
public class NewDivisionBean implements Serializable  {
    @EJB
    IDivision divisionSrvc;
    String company;
    String name;
    String longname;
    String code;
    String abbreviation;
    String headedby;

    public NewDivisionBean() {
    }

    public IDivision getDivisionSrvc() {
        return divisionSrvc;
    }

    public void setDivisionSrvc(IDivision divisionSrvc) {
        this.divisionSrvc = divisionSrvc;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongname() {
        return longname;
    }

    public void setLongname(String longname) {
        this.longname = longname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getHeadedby() {
        return headedby;
    }

    public void setHeadedby(String headedby) {
        this.headedby = headedby;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
        public String addDivision() {
        company = "01";
        int result = divisionSrvc.addDivision(company, code, name, longname, abbreviation,headedby);  
        return "index";
    }
    
}
