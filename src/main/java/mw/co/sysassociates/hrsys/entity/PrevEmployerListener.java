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
public class PrevEmployerListener {
        @PostLoad
	public void postLoad(PrevEmployer prevEmp) {
        System.out.println("In post load");
        }
	@PrePersist
	public void prePersist(PrevEmployer prevEmp) {
        prevEmp.setInsby("Clifton");
        prevEmp.setInsdate(new Date());
        System.out.println("In pre persist" + prevEmp.getOrganisation());
        }
	@PostPersist
	public void postPersist(PrevEmployer prevEmp) {
        //System.out.println("In post persist" + cust.getFirstname());
        }
	@PreUpdate
	public void preUpdate(PrevEmployer prevEmp) {
            prevEmp.setAmmdate(new Date());
            prevEmp.setAmmby("Clifton");
            System.out.println("In pre update");
        }
	@PostUpdate
	public void postUpdate(PrevEmployer prevEmp) {
        System.out.println("In post update");
        }
	@PreRemove
	public void preRemove(PrevEmployer prevEmp) {
        System.out.println("In pre remove");
        }
	@PostRemove
	public void postRemove(PrevEmployer prevEmp) {
        System.out.println("In post remove");
        }    
}
