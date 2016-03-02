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
public class ReasonForLeavingListener {
        @PostLoad
	public void postLoad(ReasonForLeaving ReasonForL) {
        System.out.println("In post load");
        }
	@PrePersist
	public void prePersist(ReasonForLeaving ReasonForL) {
        ReasonForL.setInsby("Clifton");
        ReasonForL.setInsdate(new Date());
        System.out.println("In pre persist" + ReasonForL.getDescription());
        }
	@PostPersist
	public void postPersist(ReasonForLeaving ReasonForL) {
        //System.out.println("In post persist" + cust.getFirstname());
        }
	@PreUpdate
	public void preUpdate(ReasonForLeaving ReasonForL) {
            ReasonForL.setAmmdate(new Date());
            ReasonForL.setAmmby("Clifton");
            System.out.println("In pre update");
        }
	@PostUpdate
	public void postUpdate(ReasonForLeaving ReasonForL) {
        System.out.println("In post update");
        }
	@PreRemove
	public void preRemove(ReasonForLeaving ReasonForL) {
        System.out.println("In pre remove");
        }
	@PostRemove
	public void postRemove(ReasonForLeaving ReasonForL) {
        System.out.println("In post remove");
        }        
}
