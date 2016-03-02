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
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Clifton T. Mtengezo
 */
@MappedSuperclass
public class AuditFields {
private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
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
    @Temporal(TemporalType.DATE)
    @Column(name = "DELDATE")
    private Date deldate;
    @Column(name = "DELBY",length = 20)
    private String delby;
    @Column(name = "RECSTATUS",length = 3)
    private String recstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDeldate() {
        return deldate;
    }

    public void setDeldate(Date deldate) {
        this.deldate = deldate;
    }

    public String getDelby() {
        return delby;
    }

    public void setDelby(String delby) {
        this.delby = delby;
    }

    public String getRecstatus() {
        return recstatus;
    }

    public void setRecstatus(String recstatus) {
        this.recstatus = recstatus;
    }
    
}
