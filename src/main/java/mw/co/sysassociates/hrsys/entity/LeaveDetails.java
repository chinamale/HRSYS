/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Clifton T. Mtengezo
 */
    @Entity
        @NamedQueries({
	@NamedQuery(name = "LeaveDetails.findAll", query = "SELECT l FROM LeaveDetails l"),
        @NamedQuery(name = "LeaveDetails.findByname", query = "SELECT l FROM LeaveDetails l WHERE l.insby = :firstname"),
    })
    @EntityListeners({LeaveDetailsListener.class})
public class LeaveDetails extends AuditFields implements Serializable {
private static final long serialVersionUID = 1L;
    public LeaveDetails() {
    }
    @ManyToOne
        @JoinColumns({
        @JoinColumn(name="COMPANY", referencedColumnName="COMPANY"),
        @JoinColumn(name="EMPLOYEE", referencedColumnName="EMPLOYEENUMBER")
    })
    //    @JoinColumn(name="COMPANY", referencedColumnName="COMPANY"),
    //    @JoinColumn(name="EMPLOYEE", referencedColumnName="emploPK")
    
    //@JoinColumn(name = "EMPLOYEE", nullable = false)
    private Employee employee;
    //@JoinColumn(name = "COMPANY", nullable = false)
    //private Company company;
    @Column(name = "NOOFDAYS")
    private Double noofdays;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATEFROM")
    private Date datefrom;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATETO")
    private Date dateto;
    @ManyToOne
    @JoinColumn(name = "LEAVETYPE", nullable = true)
    private LeaveType leavetype;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Double getNoofdays() {
        return noofdays;
    }

    public void setNoofdays(Double noofdays) {
        this.noofdays = noofdays;
    }

    public Date getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public Date getDateto() {
        return dateto;
    }

    public void setDateto(Date dateto) {
        this.dateto = dateto;
    }

    public LeaveType getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(LeaveType leavetype) {
        this.leavetype = leavetype;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.noofdays);
        hash = 47 * hash + Objects.hashCode(this.datefrom);
        hash = 47 * hash + Objects.hashCode(this.dateto);
        hash = 47 * hash + Objects.hashCode(this.leavetype);
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
        final LeaveDetails other = (LeaveDetails) obj;
        if (!Objects.equals(this.noofdays, other.noofdays)) {
            return false;
        }
        if (!Objects.equals(this.datefrom, other.datefrom)) {
            return false;
        }
        if (!Objects.equals(this.dateto, other.dateto)) {
            return false;
        }
        return true;
    }    
}
