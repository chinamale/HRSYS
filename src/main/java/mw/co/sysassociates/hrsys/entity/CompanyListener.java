/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;
import java.util.Date;
import javax.persistence.*;
/*
 * This is the callback class for CUSTOMER entity
 */
public class CompanyListener {
	@PostLoad
	public void postLoad(Company comp) {
        System.out.println("In post load");
    }
	@PrePersist
	public void prePersist(Company comp) {
        comp.setAmmDate(new Date());
        comp.setInsDate(new Date());
        comp.setInsBy("User 1"); 
        comp.setAmmBy("User Ammend");
        //System.out.println("In pre persist" + cust.getFirstname());
    }
	@PostPersist
	public void postPersist(Company comp) {
        System.out.println("In post persist " + comp.getCompanyName());
    }
	@PreUpdate
	public void preUpdate(Company comp) {
            comp.setAmmDate(new Date());
            System.out.println("In pre update");
    }
	@PostUpdate
	public void postUpdate(Company comp) {
        System.out.println("In post update");
    }
	@PreRemove
	public void preRemove(Company comp) {
        System.out.println("In pre remove");
    }
	@PostRemove
	public void postRemove(Company comp) {
        System.out.println("In post remove");
    }
}
