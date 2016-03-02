/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Clifton T. Mtengezo
 */
@MappedSuperclass
public class DivisionFields extends AuditFields {
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
    @Column(name = "LONGNAME", nullable = true,length = 60)
    private String longname;
    
    @Column(name = "CODE", nullable = true,length = 10)
    private String code;
    
    @Column(name = "NAME", nullable = true,length = 30)
    private String name;
    
    @Column(name = "ABBREVIATION", nullable = true,length = 30)
    private String abbreviation; 

    public String getLongname() {
        return longname;
    }

    public void setLongname(String longname) {
        this.longname = longname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
    
}
