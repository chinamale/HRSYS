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
import mw.co.sysassociates.hrsys.ejb.ICertificate;
import mw.co.sysassociates.hrsys.ejb.IRelationship;
import mw.co.sysassociates.hrsys.exceptions.EntityNotFoundException;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Named
@RequestScoped
public class CertificateBean implements Serializable {
    @EJB
    ICertificate certificateSrv;
    private String company;
    private String code;
    private String certId;
    private String longname;
    private String name;
    private String abbreviation; 

    public CertificateBean() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId;
    }

    public String getLongname() {
        return longname;
    }

    public void setLongname(String longname) {
        this.longname = longname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
    
    public String search() throws EntityNotFoundException {
        String role = "users";
        certificateSrv.findCertificateByPrimaryKey(certId);
        return "index";
    }
    public String addCertificate() throws EntityNotFoundException {
        String comp = "01";
        int result = certificateSrv.addCertificate(comp, code, name, longname, abbreviation);
        return "index";
    }
}
