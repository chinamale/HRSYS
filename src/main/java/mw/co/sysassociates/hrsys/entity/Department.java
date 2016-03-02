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

/**
 *
 * @author Clifton T. Mtengezo
 */
    @Entity
        @NamedQueries({
	@NamedQuery(name = "Department.findAllByCompany", query = "SELECT d FROM Department d where d.company = :comp"),
        @NamedQuery(name = "Department.findByCompAndName", query = "SELECT d FROM Department d WHERE d.company = :comp AND d.name = :name"),
        @NamedQuery(name = "Department.findByCompAndCode", query = "SELECT d FROM Department d WHERE d.company = :comp AND d.code = :code"),
    })
    @EntityListeners({DepartmentListener.class})
public class Department extends DivisionFields implements Serializable {
    private static final long serialVersionUID = 1L;    
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;  
    
    //@Column(name = "NAME", nullable = true,length = 30)
    //private String name;
    
    //@ManyToOne
    //    @JoinColumns({
    //    @JoinColumn(name="COMPANY", referencedColumnName="COMPANY"),
    //    @JoinColumn(name="EMPLOYEE", referencedColumnName="EMPLOYEENUMBER")
    //})
    //private Employee employee;
    @ManyToOne
    @JoinColumn(name = "COMPANY", nullable = true)
    private Company company;
    
    
//    @JoinColumn(name = "COMPANY", nullable = false)
//    private Company company;
//    @Column(name = "LONGNAME", nullable = true,length = 60)
//    private String longname;
//    
//    @Column(name = "CODE", nullable = true,length = 10)
//    private String code;
//    
//    @Column(name = "NAME", nullable = true,length = 30)
//    private String name;
//    
//    @Column(name = "ABBREVIATION", nullable = true,length = 30)
//    private String abbreviation;
//    
//    @Column(name = "LOCATION", nullable = true,length = 30)
//    private String location;
//
//    @Column(name = "ADDRESS1", nullable = true,length = 30)
//    private String address1;
//    
//    @Column(name = "ADDRESS2", nullable = true,length = 30)
//    private String address2;
//    
//    @Column(name = "ADDRESS3", nullable = true,length = 30)
//    private String address3;
//    
//    @Column(name = "ADDRESS4", nullable = true,length = 30)
//    private String address4;
//    
//    @Column(name = "TELEPHONE", nullable = true,length = 30)
//    private String telephone;
//    
//    @Column(name = "EMAILADDRESS", nullable = true,length = 30)
//    private String emailaddress;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.company);
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
        final Department other = (Department) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        return true;
    }
    
}
