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
import javax.persistence.EmbeddedId;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 *
 * @author Clifton T. Mtengezo
 */
    @Entity
        @NamedQueries({
	@NamedQuery(name = "Education.findAll", query = "SELECT e FROM Education e"),
        @NamedQuery(name = "Education.findByInst", query = "SELECT e FROM Education e WHERE e.institution = :institution"),
    })
    @Table(indexes = {@Index(name="EDUCATION_INDEX_0",columnList="COMPANY,EMPLOYEE,QUALIFICATION")})
    @EntityListeners({EducationListener.class})
public class Education extends AuditFields implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "YEARFROM", nullable = true,length = 4)
    private String yearfrom;
    @ManyToOne
        @JoinColumns({
        @JoinColumn(name="COMPANY", referencedColumnName="COMPANY"),
        @JoinColumn(name="EMPLOYEE", referencedColumnName="EMPLOYEENUMBER")
    })
    private Employee employee;
    @Column(name = "YEARTO", nullable = true,length = 4)
    private String yearto;
    @Column(name = "INSTITUTION", nullable = true,length = 40)
    private String institution;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "QUALIFICATION", referencedColumnName = "ID",nullable = false)
    private Certificate certificate;
   
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

    public String getYearfrom() {
        return yearfrom;
    }

    public void setYearfrom(String yearfrom) {
        this.yearfrom = yearfrom;
    }

    public String getYearto() {
        return yearto;
    }

    public void setYearto(String yearto) {
        this.yearto = yearto;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }
    @Override
    public int hashCode() {
        int hash = 7;
       // hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.yearfrom);
        hash = 23 * hash + Objects.hashCode(this.yearto);
        hash = 23 * hash + Objects.hashCode(this.institution);
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
        final Education other = (Education) obj;
       // if (!Objects.equals(this.id, other.id)) {
       //     return false;
       // }
        if (!Objects.equals(this.yearfrom, other.yearfrom)) {
            return false;
        }
        if (!Objects.equals(this.yearto, other.yearto)) {
            return false;
        }
        if (!Objects.equals(this.institution, other.institution)) {
            return false;
        }
        return true;
    }
        
}
