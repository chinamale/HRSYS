/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;

import java.io.Serializable;
import java.util.Collection;
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
	@NamedQuery(name = "Relationship.findAll", query = "SELECT r FROM Relationship r"),
        @NamedQuery(name = "Relationship.findByname", query = "SELECT r FROM Relationship r WHERE r.description = :description"),
    })
    @EntityListeners({RelationshipListener.class})
public class Relationship extends AuditFields implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "DESCRIPTION",length = 20, nullable = false)
    private String description;   
    
    @ManyToOne
    @JoinColumn(name = "COMPANY", nullable = false)
    private Company company;
    
    /* Reasons for which the relationship can be recognised, eg. Medical Aid purpose, Benefits purpose
    */    
    @Column(name = "VALIDFOR",length = 10)
    private String validfor;
    /* Age above which dependents will not be recognised
    */
    @Column(name = "AGELIMIT")
    private int agelimit;

    public int getAgelimit() {
        return agelimit;
    }

    public void setAgelimit(int agelimit) {
        this.agelimit = agelimit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getValidfor() {
        return validfor;
    }

    public void setValidfor(String validfor) {
        this.validfor = validfor;
    }  
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.description);
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
        final Relationship other = (Relationship) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
    
}
