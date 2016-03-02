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
public class LeaveDetailsListener {
        @PostLoad
	public void postLoad(LeaveDetails lv) {
        System.out.println("In post load");
        }
	@PrePersist
	public void prePersist(LeaveDetails lv) {
        lv.setInsby("Clifton");
        lv.setInsdate(new Date());
        System.out.println("In pre persist" + lv.getLeavetype().getLeaveDescription());
        }
	@PostPersist
	public void postPersist(LeaveDetails lv) {
        //System.out.println("In post persist" + cust.getFirstname());
        }
	@PreUpdate
	public void preUpdate(LeaveDetails lv) {
            lv.setAmmdate(new Date());
            lv.setAmmby("Clifton");
            System.out.println("In pre update");
        }
	@PostUpdate
	public void postUpdate(LeaveDetails lv) {
        System.out.println("In post update");
        }
	@PreRemove
	public void preRemove(LeaveDetails lv) {
        System.out.println("In pre remove");
        }
	@PostRemove
	public void postRemove(LeaveDetails lv) {
        System.out.println("In post remove");
        }     
}
