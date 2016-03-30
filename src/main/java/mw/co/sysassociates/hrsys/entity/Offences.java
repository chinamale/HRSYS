/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Clifton T. Mtengezo
 *
 *  
 */
@Table(indexes = {@Index(name="IDX_OFFENCES_1",columnList="code,company",unique=true)})
@Entity
        @NamedQueries({
	@NamedQuery(name = "Offences.findAllByCompany", query = "SELECT d FROM Offences  d where d.company = :comp"),
        @NamedQuery(name = "Offences.findByCompAndName", query = "SELECT d FROM Offences d WHERE d.company = :comp AND d.name = :name"),
        @NamedQuery(name = "Offences.findByCompAndCode", query = "SELECT d FROM Offences d WHERE d.company = :comp AND d.code = :code"),
    })
    @EntityListeners({OffencesListener.class})
public class Offences extends  BasicFields implements Serializable {
    private static final long serialVersionUID = 1L;    
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "COMPANY", nullable = true)
    private Company company;
//@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
//private List<Appraisal> appraisal;
    
    public Offences() {
    }
      
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }    
}
