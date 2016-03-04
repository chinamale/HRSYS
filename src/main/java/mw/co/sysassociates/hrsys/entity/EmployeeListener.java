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
public class EmployeeListener {
	@PostLoad
	public void postLoad(Employee cust) {
        System.out.println("In post load");
    }
	@PrePersist
	public void prePersist(Employee cust) {
            cust.setAmmdate(new Date());
        System.out.println("In pre persist " + cust.getFirstname());
    }
	@PostPersist
	public void postPersist(Employee cust) {
        System.out.println("In post persist " + cust.getFirstname());
    }
	@PreUpdate
	public void preUpdate(Employee cust) {
            cust.setAmmdate(new Date());
            System.out.println("In pre update");
    }
	@PostUpdate
	public void postUpdate(Employee cust) {
        System.out.println("In post update");
    }
	@PreRemove
	public void preRemove(Employee cust) {
        System.out.println("In pre remove");
    }
	@PostRemove
	public void postRemove(Employee cust) {
        System.out.println("In post remove");
    }
}
