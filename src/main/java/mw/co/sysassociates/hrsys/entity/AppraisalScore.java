/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Clifton T. Mtengezo
 *
 *  
 */
@Table(indexes = {@Index(name="I_APP_SCORE",columnList="code,company",unique=true)})
@Entity
        @NamedQueries({
	@NamedQuery(name = "AppraisalScore.findAllByCompany", query = "SELECT d FROM AppraisalScore d where d.company = :comp"),
        @NamedQuery(name = "AppraisalScore.findByCompAndName", query = "SELECT d FROM AppraisalScore d WHERE d.company = :comp AND d.name = :name"),
        @NamedQuery(name = "AppraisalScore.findByCompAndCode", query = "SELECT d FROM AppraisalScore d WHERE d.company = :comp AND d.code = :code"),
    })
    @EntityListeners({AppraisalScoreListener.class})
public class AppraisalScore extends  BasicFields implements Serializable {
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
    
    public AppraisalScore() {
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
