/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.jsf;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import mw.co.sysassociates.hrsys.ejb.IAppraisal;
import mw.co.sysassociates.hrsys.ejb.IAppraisalScore;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Named
@RequestScoped
public class AppraisalBean implements Serializable{
    @EJB
    IAppraisal appSrv;
    
    String company;
    String employee;
    Date appr_date;
    String appr_quarter;
    String appr_period;
    String appr_score;

    public AppraisalBean() {
    }

    public IAppraisal getAppSrv() {
        return appSrv;
    }

    public void setAppSrv(IAppraisal appSrv) {
        this.appSrv = appSrv;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Date getAppr_date() {
        return appr_date;
    }

    public void setAppr_date(Date appr_date) {
        this.appr_date = appr_date;
    }

    public String getAppr_quarter() {
        return appr_quarter;
    }

    public void setAppr_quarter(String appr_quarter) {
        this.appr_quarter = appr_quarter;
    }

    public String getAppr_period() {
        return appr_period;
    }

    public void setAppr_period(String appr_period) {
        this.appr_period = appr_period;
    }

    public String getAppr_score() {
        return appr_score;
    }

    public void setAppr_score(String appr_score) {
        this.appr_score = appr_score;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.company);
        hash = 97 * hash + Objects.hashCode(this.employee);
        hash = 97 * hash + Objects.hashCode(this.appr_date);
        hash = 97 * hash + Objects.hashCode(this.appr_quarter);
        hash = 97 * hash + Objects.hashCode(this.appr_period);
        hash = 97 * hash + Objects.hashCode(this.appr_score);
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
        final AppraisalBean other = (AppraisalBean) obj;
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        if (!Objects.equals(this.employee, other.employee)) {
            return false;
        }
        if (!Objects.equals(this.appr_date, other.appr_date)) {
            return false;
        }
        if (!Objects.equals(this.appr_quarter, other.appr_quarter)) {
            return false;
        }
        if (!Objects.equals(this.appr_period, other.appr_period)) {
            return false;
        }
        if (!Objects.equals(this.appr_score, other.appr_score)) {
            return false;
        }
        return true;
    }
       public String inputAppraisal() {
        //String role = "users";
        company = "01";
        int result = appSrv.inputAppraisal(employee, company, appr_date, appr_quarter, appr_period, appr_score);
  
        return "index";
    }
    
}
