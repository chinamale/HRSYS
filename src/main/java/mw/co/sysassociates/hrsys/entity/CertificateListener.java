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
public class CertificateListener {
  	@PostLoad
	public void postLoad(Certificate cert) {
        System.out.println("In post load");
    }
	@PrePersist
	public void prePersist(Certificate cert) {
        cert.setInsby("Clifton");
        cert.setInsdate(new Date());
        System.out.println("In pre persist" + cert.getAbbreviation());
    }
	@PostPersist
	public void postPersist(Certificate cert) {
        System.out.println("In post persist " );
    }
	@PreUpdate
	public void preUpdate(Certificate cert) {
        cert.setAmmdate(new Date());
        cert.setAmmby("Clifton");
        System.out.println("In pre update" + cert.getAbbreviation());
    }
	@PostUpdate
	public void postUpdate(Certificate cert) {
        System.out.println("In post update");
    }
	@PreRemove
	public void preRemove(Certificate cert) {
        System.out.println("In pre remove");
    }
	@PostRemove
	public void postRemove(Certificate cert) {
        System.out.println("In post remove");
    }  
}
