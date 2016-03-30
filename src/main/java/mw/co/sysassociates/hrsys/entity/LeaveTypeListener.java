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
public class LeaveTypeListener {
         @PostLoad
	public void postLoad(LeaveType lvType) {
        System.out.println("In post load");
        }
	@PrePersist
	public void prePersist(LeaveType lvType) {
        lvType.setInsby("Clifton");
        lvType.setInsdate(new Date());
        System.out.println("In pre persist" + lvType.getLeaveDescription());
        }
	@PostPersist
	public void postPersist(LeaveType lvType) {
        //System.out.println("In post persist" + cust.getFirstname());
        }
	@PreUpdate
	public void preUpdate(LeaveType lvType) {
            lvType.setAmmdate(new Date());
            lvType.setAmmby("Clifton");
            System.out.println("In pre update");
        }
	@PostUpdate
	public void postUpdate(LeaveType lvType) {
        System.out.println("In post update");
        }
	@PreRemove
	public void preRemove(LeaveType lvType) {
        System.out.println("In pre remove");
        }
	@PostRemove
	public void postRemove(LeaveType lvType) {
        System.out.println("In post remove");
        }       
}
