/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;
import java.io.Serializable;
import java.util.Collection;
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
	@NamedQuery(name = "Certificate.findAll", query = "SELECT c FROM Certificate c"),
        @NamedQuery(name = "Certificate.findByname", query = "SELECT c FROM Certificate c WHERE c.description = :description"),
    })
    @EntityListeners({CertificateListener.class})
public class Certificate extends AuditFields implements Serializable {

    private static final long serialVersionUID = 1L;    
    @Column(name = "DESCRIPTION",length = 40)
    private String description;
    @Column(name = "TYPE",length = 2)
    private String type;
    
//    @Id
//    @Basic(optional = false)
//    @Column(name = "ID", nullable = false)
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//
//    @Column(name = "TYPE",length = 2)
//    private String type;
//    @Temporal(TemporalType.DATE)
//    @Column(name = "INSDATE")
//    private Date insdate;
//    @Column(name = "INSBY",length = 20)
//    private String insby;
//    @Temporal(TemporalType.DATE)
//    @Column(name = "AMMDATE")
//    private Date ammdate;
//    @Column(name = "AMMBY",length = 20)
//    private String ammby;
    
 //   @OneToMany(cascade={CascadeType.ALL},targetEntity=Education.class,mappedBy="certificate",fetch=FetchType.EAGER)
    private Collection<Education> education;
    //@OneToOne(mappedBy = "certificate")
    //private Education education;

    public Collection<Education> getEducation() {
        return education;
    }

    public void setEducation(Collection<Education> education) {
        this.education = education;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

   
    @Override
    public int hashCode() {
        int hash = 5;
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
        final Certificate other = (Certificate) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
}
