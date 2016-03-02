/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;

import java.io.Serializable;
import java.util.Date;
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
	@NamedQuery(name = "Dependant.findAll", query = "SELECT d FROM Dependant d"),
        @NamedQuery(name = "Dependant.findByname", query = "SELECT d FROM Dependant d WHERE d.firstname = :firstname"),
    })
    @EntityListeners({DependantListener.class})
public class Dependant extends AuditFields implements Serializable {
  private static final long serialVersionUID = 1L;
    
    //@Id
    //@Basic(optional = false)
    //@Column(name = "ID", nullable = false)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //private Integer id;  
    
    @Column(name = "FIRSTNAME", nullable = true,length = 30)
    private String firstname;
    
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
    @Column(name = "SURNAME", nullable = true,length = 30)
    private String surname;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATEOFBIRTH")
    private Date dateofbirth;
    @ManyToOne
    @JoinColumn(name = "RELATIONSHIP", nullable = true)
    private Relationship relationship;
    //@Column(name = "INSBY", nullable = true,length=30)
    //private String insby;
    //@Temporal(TemporalType.DATE)
    //@Column(name = "INSDATE")
    //private Date insdate;
    //@Column(name = "AMMBY", nullable = true,length = 30)
    //private String ammby;
    //@Temporal(TemporalType.DATE)
    //@Column(name = "AMMDATE")
    //private Date ammdate;  
    public Dependant() {
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }
    
}
