/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import java.util.Collection;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityExistsException;
import mw.co.sysassociates.hrsys.entity.Dependant;
import mw.co.sysassociates.hrsys.entity.Education;
import mw.co.sysassociates.hrsys.entity.Employee;
import mw.co.sysassociates.hrsys.entity.LeaveDetails;
import mw.co.sysassociates.hrsys.entity.PrevEmployer;

/**
 *
 * @author Clifton T. Mtengezo
*/
@Local
public interface IEmployee {
    List<Employee> getEmployeeList();
    Employee findByCompAndEmplono(String company, String employeeNo);
    Employee findByFirstname(String firstname);
    int insertEmployee(String employeeNo, String company, String firstname, String surname, String sex, String title, String division) throws EntityExistsException; 
//        int insertPrevEmployers(String employeeNo, String company, List<PrevEmployer> prevEmployer) throws EntityExistsException; 
    int addEducationDetails(String Employee, String company, String quali, String instit, String yearFrom, String yearTo);
    List<Education> getEmployeeEduDetails(Employee employee);
    List<LeaveDetails> getEmployeeLeaveDetails(Employee employee);
//    List<PrevEmployer> getEmployeePrevEmployer(Employee employee);
    Collection getEmployeeDependant(Employee employee);
}