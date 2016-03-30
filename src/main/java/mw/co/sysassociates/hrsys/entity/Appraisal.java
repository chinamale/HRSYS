/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Clifton T. Mtengezo
 */
    @Entity
        @NamedQueries({
	@NamedQuery(name = "Appraisal.findAll", query = "SELECT a FROM Appraisal a"),
        @NamedQuery(name = "Appraisal.findByname", query = "SELECT a FROM Appraisal a WHERE a.employee = :employe"),
    })
    @EntityListeners({AppraisalListener.class})
public class Appraisal extends AuditFields implements Serializable {
    private static final long serialVersionUID = 1L;    
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "COMPANY", referencedColumnName = "COMPANY"),
        @JoinColumn(name = "EMPLOYEE", referencedColumnName = "EMPLOYEENUMBER")
    })
    private Employee employee;

    @Temporal(TemporalType.DATE)
    @Column(name = "APPR_DATE")
    private Date apprdate;
    @Column(name = "APPR_PERIOD")
    private String apprPeriod;
    @Column(name = "APPR_QUARTER")
    private String apprQuarter;
//    @Column(name = "APPR_SCORE")
//    private String apprscore;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APPR_SCORE", referencedColumnName = "CODE")
    private AppraisalScore appraisalscore;

    public Appraisal() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getApprdate() {
        return apprdate;
    }

    public void setApprdate(Date apprdate) {
        this.apprdate = apprdate;
    }

    public String getApprPeriod() {
        return apprPeriod;
    }

    public void setApprPeriod(String apprPeriod) {
        this.apprPeriod = apprPeriod;
    }

    public String getApprQuarter() {
        return apprQuarter;
    }

    public void setApprQuarter(String apprQuarter) {
        this.apprQuarter = apprQuarter;
    }

    public AppraisalScore getAppraisalscore() {
        return appraisalscore;
    }

    public void setAppraisalscore(AppraisalScore appraisalscore) {
        this.appraisalscore = appraisalscore;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.employee);
        hash = 29 * hash + Objects.hashCode(this.apprdate);
        hash = 29 * hash + Objects.hashCode(this.apprPeriod);
        hash = 29 * hash + Objects.hashCode(this.apprQuarter);
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
        final Appraisal other = (Appraisal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.employee, other.employee)) {
            return false;
        }
        if (!Objects.equals(this.apprdate, other.apprdate)) {
            return false;
        }
        if (!Objects.equals(this.apprPeriod, other.apprPeriod)) {
            return false;
        }
        if (!Objects.equals(this.apprQuarter, other.apprQuarter)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", employee=" + employee + ", apprdate=" + apprdate + ", apprPeriod=" + apprPeriod + ", apprQuarter=" + apprQuarter + ", appraisalscore=" + appraisalscore + '}';
    }

}
