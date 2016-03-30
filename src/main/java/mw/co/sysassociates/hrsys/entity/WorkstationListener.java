/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;

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
public class WorkstationListener {
         @PostLoad
	public void postLoad(Workstation workstation) {
        System.out.println("In post load");
        }
	@PrePersist
	public void prePersist(Workstation workstation) {
        //mobappuser.setRole("mobappuser111");
        //lvType.setInsdate(new Date());
        //System.out.println("In pre persist ");
        }
	@PostPersist
	public void postPersist(Workstation workstation) {
        //System.out.println("In post persist" + cust.getFirstname());
        }
	@PreUpdate
	public void preUpdate(Workstation workstation) {
            //mobappuser.setRole("mobappuser");
            //System.out.println("In pre update");
        }
	@PostUpdate
	public void postUpdate(Workstation workstation) {
        //System.out.println("In post update");
        }
	@PreRemove
	public void preRemove(Workstation workstation) {
        //System.out.println("In pre remove");
        }
	@PostRemove
	public void postRemove(Workstation workstation) {
        //System.out.println("In post remove");
        }     
}
