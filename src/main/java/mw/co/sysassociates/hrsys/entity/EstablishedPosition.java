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
	@NamedQuery(name = "EstablishedPosition.findAllByCompany", query = "SELECT d FROM EstablishedPosition d where d.company = :comp"),
        @NamedQuery(name = "EstablishedPosition.findByCompAndName", query = "SELECT d FROM EstablishedPosition d WHERE d.company = :comp AND d.name = :name"),
        @NamedQuery(name = "EstablishedPosition.findByCompAndCode", query = "SELECT d FROM EstablishedPosition d WHERE d.company = :comp AND d.code = :code"),
    })
@EntityListeners({EstablishedPositionListener.class})
public class EstablishedPosition extends BasicFields implements Serializable {
    private static final long serialVersionUID = 1L; 
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;  
    @ManyToOne
    @JoinColumn(name = "COMPANY", nullable = true)
    private Company company; 

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
    
}
