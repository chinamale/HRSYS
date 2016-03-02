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
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

    @Entity
        @NamedQueries({
	@NamedQuery(name = "Workstation.findAllByCompany", query = "SELECT d FROM Workstation d where d.company = :comp"),
        @NamedQuery(name = "Workstation.findByCompAndName", query = "SELECT d FROM Workstation d WHERE d.company = :comp AND d.name = :name"),
        @NamedQuery(name = "Workstation.findByCompAndCode", query = "SELECT d FROM Workstation d WHERE d.company = :comp AND d.code = :code"),
    })
    @EntityListeners({WorkstationListener.class})
public class Workstation extends DivisionFields implements Serializable {
    private static final long serialVersionUID = 1L;    
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; 
    @ManyToOne
    @JoinColumn(name = "COMPANY", nullable = true)
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.company);
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
        final Workstation other = (Workstation) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        return true;
    }
    
    
}
