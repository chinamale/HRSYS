/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Embeddable
public class EducationPK {
    @Column(name = "COMPANY", nullable = false,length = 2)
    @Basic(optional = false)
    private String company;
    @Basic(optional = false)
    @Column(name = "EMPLOYEENUMBER", nullable = false, length = 10)
    private String employeenumber; 
    @Column(name = "CERTIFICATE", nullable = false, length = 4)
    private String Certificate;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmployeenumber() {
        return employeenumber;
    }

    public void setEmployeenumber(String employeenumber) {
        this.employeenumber = employeenumber;
    }

    public String getCertificate() {
        return Certificate;
    }

    public void setCertificate(String Certificate) {
        this.Certificate = Certificate;
    }
    
}
