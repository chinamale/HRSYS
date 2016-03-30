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
public class DivisionListener {
  	@PostLoad
	public void postLoad(Division div) {
        System.out.println("In post load");
    }
	@PrePersist
	public void prePersist(Division div) {
        
    //    dep.setInsby("Clifton");
    //    dep.setInsdate(new Date());
    //    System.out.println("In pre persist " + dep.getFirstname() + " " + dep.getSurname());
    }
	@PostPersist
	public void postPersist(Division div) {
        System.out.println("In post persist " );
    }
	@PreUpdate
	public void preUpdate(Division div) {
    //    dep.setAmmdate(new Date());
    //    dep.setAmmby("Clifton");
    //    System.out.println("In pre Update " + dep.getFirstname() + " " + dep.getSurname());
    }
	@PostUpdate
	public void postUpdate(Division div) {
        //System.out.println("In post update");
    }
	@PreRemove
	public void preRemove(Division div) {
        //System.out.println("In pre remove");
    }
	@PostRemove
	public void postRemove(Division div) {
        //System.out.println("In post remove");
    }     
}
