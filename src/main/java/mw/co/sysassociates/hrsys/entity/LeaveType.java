/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Clifton T. Mtengezo
 */
    @Entity
        @NamedQueries({
	@NamedQuery(name = "LeaveType.findAll", query = "SELECT lvt FROM LeaveType lvt"),
        @NamedQuery(name = "LeaveType.findByname", query = "SELECT lvt FROM LeaveType lvt WHERE lvt.leaveDescription = :leavedescription"),
    })
    @EntityListeners({LeaveTypeListener.class,LeaveTypeValidatorListener.class})
public class LeaveType extends AuditFields implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "LEAVEDESCRIPTION",length = 40)
    private String leaveDescription;
    @Column(name = "CALCULATEENTITLEMENT",length = 1)
    private String calculateentitlement;
    @Column(name = "HASMAXIMUMDAYS",length = 1)
    private String hasmaximumdays;

    public String getCalculateentitlement() {
        return calculateentitlement;
    }

    public void setCalculateentitlement(String calculateentitlement) {
        this.calculateentitlement = calculateentitlement;
    }

    public String getHasmaximumdays() {
        return hasmaximumdays;
    }

    public void setHasmaximumdays(String hasmaximumdays) {
        this.hasmaximumdays = hasmaximumdays;
    }
    
    public void setLeaveDescription(String leaveDescription) {
        this.leaveDescription = leaveDescription;
    }
    
    public String getLeaveDescription() {
        return leaveDescription;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.leaveDescription);
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
        final LeaveType other = (LeaveType) obj;
        if (!Objects.equals(this.leaveDescription, other.leaveDescription)) {
            return false;
        }
        return true;
    }

}
