/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.persistence.EntityExistsException;
import mw.co.sysassociates.hrsys.entity.Company;
import mw.co.sysassociates.hrsys.entity.Department;
import mw.co.sysassociates.hrsys.exceptions.EntityFoundException;
import mw.co.sysassociates.hrsys.exceptions.EntityNotFoundException;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Local
public interface IDepartment {
Department findDepartmentByPrimaryKey(String deprtKey) throws EntityNotFoundException,EJBException;
Department findDuplicateDepartmentByPrimaryKey(String departKey) throws EJBException,EntityFoundException;
Department findDepartmentByAbbrev(String departAbbr) throws EntityNotFoundException;
Department findDepartmentByName(String departName) throws EntityNotFoundException;    
}
