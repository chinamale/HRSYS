/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.jsf;

import java.util.Objects;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import mw.co.sysassociates.hrsys.ejb.IAppraisalScore;
import mw.co.sysassociates.hrsys.ejb.IEmployee;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Named
@RequestScoped
public class NewAppraisalScoreBean {
    @EJB
    IAppraisalScore appScoreSrv;
    
    String company;
    String name;
    String longname;
    String code;
    String abbreviation;

    public NewAppraisalScoreBean() {
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

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    public String register() {
        //String role = "users";
        company = "01";
        int result = appScoreSrv.registerApprScore(company, code, name, longname, abbreviation);
  
        return "index";
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.company);
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.longname);
        hash = 67 * hash + Objects.hashCode(this.code);
        hash = 67 * hash + Objects.hashCode(this.abbreviation);
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
        final NewAppraisalScoreBean other = (NewAppraisalScoreBean) obj;
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.longname, other.longname)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.abbreviation, other.abbreviation)) {
            return false;
        }
        return true;
    }
    
 
}
