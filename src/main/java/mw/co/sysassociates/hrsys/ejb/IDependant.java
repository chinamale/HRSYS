/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import java.util.Date;
import javax.ejb.EJBException;
import javax.ejb.Local;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Local
public interface IDependant {
public int inputDependant(String emplono, String company, String firstname, String surname, Date dateofbirth, String relationship) throws EJBException, DatabaseException;    
}
