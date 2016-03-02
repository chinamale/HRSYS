/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;

import java.io.Serializable;
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
	@NamedQuery(name = "ReasonForLeaving.findAll", query = "SELECT r FROM ReasonForLeaving r"),
        @NamedQuery(name = "ReasonForLeaving.findByname", query = "SELECT r FROM ReasonForLeaving r WHERE r.description = :description"),
    })
    @EntityListeners({ReasonForLeavingListener.class})
public class ReasonForLeaving extends AuditFields implements Serializable {
    private static final long serialVersionUID = 1L;    
    @Column(name = "DESCRIPTION",length = 40)
    private String description;  

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }    
}
