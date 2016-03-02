/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Embeddable
public class EmployeePK implements Serializable {
    @Column(name = "COMPANY", nullable = false,length = 2)
    private String company;
    @Basic(optional = false)
    @Column(name = "EMPLOYEENUMBER", nullable = false, length = 10)
    private String employeenumber;  

    public EmployeePK() {
    }

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.company);
        hash = 83 * hash + Objects.hashCode(this.employeenumber);
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
        final EmployeePK other = (EmployeePK) obj;
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        if (!Objects.equals(this.employeenumber, other.employeenumber)) {
            return false;
        }
        return true;
    }    
}
