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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@NamedQuery(name = "Disciplinary.findAll", query = "SELECT d FROM Disciplinary d"),
        @NamedQuery(name = "Disciplinary.findByname", query = "SELECT d FROM Disciplinary d WHERE d.employee = :employe"),
    })
    @EntityListeners({DisciplinaryListener.class})
public class Disciplinary extends AuditFields implements Serializable {
    private static final long serialVersionUID = 1L;    
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; 
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "COMPANY", referencedColumnName = "COMPANY",nullable = false),
        @JoinColumn(name = "EMPLOYEE", referencedColumnName = "EMPLOYEENUMBER",nullable = false)
    })
    private Employee employee;
    @Column(name = "OFFENCECODE")
    private String offencecode;
    @Temporal(TemporalType.DATE)
    @Column(name = "OFFENCEDATE")
    private Date offencedate;
    @Column(name = "DISPACTION")
    private String dispaction;
    @Temporal(TemporalType.DATE)
    @Column(name = "DISPACTIONDATE")
    private Date dispactiondate;
    @Column(name = "NOTES")
    private String notes;

    public Disciplinary() {
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

    public String getOffencecode() {
        return offencecode;
    }

    public void setOffencecode(String offencecode) {
        this.offencecode = offencecode;
    }

    public Date getOffencedate() {
        return offencedate;
    }

    public void setOffencedate(Date offencedate) {
        this.offencedate = offencedate;
    }

    public String getDispaction() {
        return dispaction;
    }

    public void setDispaction(String dispaction) {
        this.dispaction = dispaction;
    }

    public Date getDispactiondate() {
        return dispactiondate;
    }

    public void setDispactiondate(Date dispactiondate) {
        this.dispactiondate = dispactiondate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.employee);
        hash = 43 * hash + Objects.hashCode(this.offencecode);
        hash = 43 * hash + Objects.hashCode(this.offencedate);
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
        final Disciplinary other = (Disciplinary) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.employee, other.employee)) {
            return false;
        }
        if (!Objects.equals(this.offencecode, other.offencecode)) {
            return false;
        }
        if (!Objects.equals(this.offencedate, other.offencedate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", employee=" + employee + ", offencecode=" + offencecode + ", offencedate=" + offencedate + ", dispaction=" + dispaction + ", dispactiondate=" + dispactiondate + ", notes=" + notes + '}';
    }    
}
