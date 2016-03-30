/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

/**
 *
 * @author Clifton T. Mtengezo
 */ @Table(indexes = {@Index(name="I_DIV_CODE_COMPANY",columnList="code,company",unique=true)})
    @Entity
        @NamedQueries({
	@NamedQuery(name = "Division.findAllByCompany", query = "SELECT d FROM Division d where d.company = :comp"),
        @NamedQuery(name = "Division.findByCompAndName", query = "SELECT d FROM Division d WHERE d.company = :comp AND d.name = :name"),
        @NamedQuery(name = "Division.findByCompAndCode", query = "SELECT d FROM Division d WHERE d.company = :comp AND d.code = :code"),
    })
    @EntityListeners({DivisionListener.class})
public class Division extends BasicFields implements Serializable {
  private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;  
    @ManyToOne
    @JoinColumn(name = "COMPANY", nullable = true)
    private Company company;
    
    @OneToMany(mappedBy="division",targetEntity=Employee.class,fetch=FetchType.EAGER)
    private List<Employee> employees;
    
    //@ManyToOne
    //    @JoinColumns({
    //    @JoinColumn(name="COMPANY", referencedColumnName="COMPANY"),
    //    @JoinColumn(name="EMPLOYEE", referencedColumnName="EMPLOYEENUMBER")
    //})
    //private Employee employee;

    
    public Division() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

//    public Employee getHeadedby() {
//        return headedby;
//    }
//
//    public void setHeadedby(Employee headedby) {
//        this.headedby = headedby;
//    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }


    
}
