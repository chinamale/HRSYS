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
	@NamedQuery(name = "Division.findAllByCompany", query = "SELECT d FROM Division d where d.company = :comp"),
        @NamedQuery(name = "Division.findByCompAndName", query = "SELECT d FROM Division d WHERE d.company = :comp AND d.name = :name"),
        @NamedQuery(name = "Division.findByCompAndCode", query = "SELECT d FROM Division d WHERE d.company = :comp AND d.code = :code"),
    })
    @EntityListeners({DivisionListener.class})
public class Division extends DivisionFields implements Serializable {
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
    
//@JoinColumn(name = "COMPANY", nullable = false)
    //private Company company;
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
//    
    
  //  @Temporal(TemporalType.DATE)
  //  @Column(name = "DATEOFBIRTH")
  //  private Date dateofbirth;
    @ManyToOne
    @JoinColumn(name = "COMPANY", nullable = true)
    private Company company;
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
    public Division() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

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
