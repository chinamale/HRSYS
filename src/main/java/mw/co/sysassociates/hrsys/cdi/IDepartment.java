/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.cdi;

import java.util.List;
import javax.ejb.EJBException;
import mw.co.sysassociates.hrsys.entity.Department;
import mw.co.sysassociates.hrsys.exceptions.EntityFoundException;
import mw.co.sysassociates.hrsys.exceptions.EntityNotFoundException;

/**
 *
 * @author Clifton T. Mtengezo
 */
public interface IDepartment {
int insertDepartment(Department department) throws EntityFoundException;    
Department findDepartment(Department department) throws EntityNotFoundException,EJBException;
Department findDuplicateDepartment(Department department) throws EJBException,EntityFoundException;
Department findDepartmentByPrimaryKey(Integer deprtKey) throws EntityNotFoundException,EJBException;
Department findDuplicateDepartmentByPrimaryKey(Integer departKey) throws EJBException,EntityFoundException;
Department findDuplicateDepartment(String comp, String code) throws EJBException,EntityFoundException;
Department findDepartmentByAbbrev(String comp, String departAbbr) throws EntityNotFoundException;
Department findDepartmentByName(String comp, String departName) throws EntityNotFoundException; 
List<Department> findAllDepartmentByComp(String comp) throws EntityNotFoundException;
}
