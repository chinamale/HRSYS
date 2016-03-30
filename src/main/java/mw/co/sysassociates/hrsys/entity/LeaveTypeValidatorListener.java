/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.entity;

import java.util.Date;
import javax.persistence.PersistenceException;
import javax.persistence.PrePersist;

/**
 *
 * @author Clifton T. Mtengezo
 */
public class LeaveTypeValidatorListener {
        private final String[] badwords = {"annual","maternity","compassionate","study","..."};
   	@PrePersist
	public void prePersist(LeaveType lvType) {
            for (String badword:badwords){
                if(lvType.getLeaveDescription().toLowerCase().contains(badword)){
                   System.err.println("bad word in title detected: " + badword );
                   throw new PersistenceException("bad word in title detected: " + badword );
                }
            }
        } 
}
