/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;

import java.util.Date;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

/**
 *
 * @author Clifton T. Mtengezo
 */
public class RelationshipListener {
        @PostLoad
	public void postLoad(Relationship relship) {
        System.out.println("In post load");
        }
	@PrePersist
	public void prePersist(Relationship relship) {
        relship.setAmmdate(new Date());
        relship.setInsby("Clifton");
        relship.setInsdate(new Date());
        System.out.println("In pre persist" + relship.getDescription());
        }
	@PostPersist
	public void postPersist(Relationship relship) {
        //System.out.println("In post persist" + cust.getFirstname());
        }
	@PreUpdate
	public void preUpdate(Relationship relship) {
            relship.setAmmdate(new Date());
            System.out.println("In pre update");
        }
	@PostUpdate
	public void postUpdate(Relationship relship) {
        System.out.println("In post update");
        }
	@PreRemove
	public void preRemove(Relationship relship) {
        System.out.println("In pre remove");
        }
	@PostRemove
	public void postRemove(Relationship relship) {
        System.out.println("In post remove");
        }       
}
