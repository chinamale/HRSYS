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
public class EstablishedPositionListener {
	@PostLoad
	public void postLoad(EstablishedPosition estPos) {
        // System.out.println("In post load");
        }
	@PrePersist
	public void prePersist(EstablishedPosition estPos) {
   //     edu.setInsby("Clifton");
   //     edu.setInsdate(new Date());
   //     System.out.println("In pre persist" + edu.getInstitution());
        }
	@PostPersist
	public void postPersist(EstablishedPosition estPos) {
        //System.out.println("In post persist" + cust.getFirstname());
        }
	@PreUpdate
	public void preUpdate(EstablishedPosition estPos) {
         //   edu.setAmmby("Clifton");
         //   edu.setAmmdate(new Date());
         //   System.out.println("In pre update");
        }
	@PostUpdate
	public void postUpdate(EstablishedPosition estPos) {
        //System.out.println("In post update");
        }
	@PreRemove
	public void preRemove(EstablishedPosition estPos) {
        //System.out.println("In pre remove");
        }
	@PostRemove
	public void postRemove(EstablishedPosition estPos) {
        //System.out.println("In post remove");
        }        
}
