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
import org.eclipse.persistence.jpa.JpaEntityManager;

/**
 *
 * @author Clifton T. Mtengezo
 */
public class SystemUserGroupListener {
         @PostLoad
	public void postLoad(SystemUserGroup systemusergroup) {
        System.out.println("In post load");
        }
	@PrePersist
	public void prePersist(SystemUserGroup systemusergroup) {
        //mobappuser.setRole("mobappuser111");
        //lvType.setInsdate(new Date());
        //System.out.println("In pre persist ");
        }
	@PostPersist
	public void postPersist(SystemUserGroup systemusergroup) {
        //System.out.println("In post persist" + cust.getFirstname());
        }
	@PreUpdate
	public void preUpdate(SystemUserGroup systemusergroup) {
            //mobappuser.setRole("mobappuser");
            //System.out.println("In pre update");
        }
	@PostUpdate
	public void postUpdate(SystemUserGroup systemusergroup) {
        //System.out.println("In post update");
        }
	@PreRemove
	public void preRemove(SystemUserGroup systemusergroup) {
        //System.out.println("In pre remove");
        }
	@PostRemove
	public void postRemove(SystemUserGroup systemusergroup) {
        //System.out.println("In post remove");
        }    
}
