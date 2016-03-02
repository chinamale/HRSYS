/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Clifton T. Mtengezo
 */
public class Descriptions {
private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "DESCRIPTION",length = 40)
    private String description;
    @Temporal(TemporalType.DATE)
    @Column(name = "INSDATE")
    private Date insdate;
    @Column(name = "INSBY",length = 20)
    private String insby;
    @Temporal(TemporalType.DATE)
    @Column(name = "AMMDATE")
    private Date ammdate;
    @Column(name = "AMMBY",length = 20)
    private String ammby; 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getInsdate() {
        return insdate;
    }

    public void setInsdate(Date insdate) {
        this.insdate = insdate;
    }

    public String getInsby() {
        return insby;
    }

    public void setInsby(String insby) {
        this.insby = insby;
    }

    public Date getAmmdate() {
        return ammdate;
    }

    public void setAmmdate(Date ammdate) {
        this.ammdate = ammdate;
    }

    public String getAmmby() {
        return ammby;
    }

    public void setAmmby(String ammby) {
        this.ammby = ammby;
    }
    
}
