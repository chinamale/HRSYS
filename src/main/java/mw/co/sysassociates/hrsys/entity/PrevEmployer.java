/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Clifton T. Mtengezo
 */
    @Entity
        @NamedQueries({
	@NamedQuery(name = "PrevEmployer.findAll", query = "SELECT p FROM PrevEmployer p"),
        @NamedQuery(name = "PrevEmployer.findByname", query = "SELECT p FROM PrevEmployer p WHERE p.organisation = :organisation"),
    })
    @EntityListeners({PrevEmployerListener.class})
public class PrevEmployer extends AuditFields implements Serializable {
    @Column(name = "YEARFROM", nullable = true,length = 4)
    private String yearfrom;
    @ManyToOne
    @JoinColumns({
    @JoinColumn(name="COMPANY", referencedColumnName="COMPANY"),
    @JoinColumn(name="EMPLOYEE", referencedColumnName="EMPLOYEENUMBER")
    })
    private Employee employee;
    @Column(name = "YEARTO", nullable = true,length = 4)
    private String yearto;
    @Column(name = "ORGANISATION", nullable = true,length = 40)
    private String organisation;
    @Column(name = "POST", nullable = true,length = 40)
    private String post;
    @ManyToOne
    @JoinColumn(name = "ReasonForLeaving", nullable = true)
    private ReasonForLeaving reasonForLeaving;

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    
    public String getYearfrom() {
        return yearfrom;
    }

    public void setYearfrom(String yearfrom) {
        this.yearfrom = yearfrom;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getYearto() {
        return yearto;
    }

    public void setYearto(String yearto) {
        this.yearto = yearto;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public ReasonForLeaving getReasonForLeaving() {
        return reasonForLeaving;
    }

    public void setReasonForLeaving(ReasonForLeaving reasonForLeaving) {
        this.reasonForLeaving = reasonForLeaving;
    }    
}
