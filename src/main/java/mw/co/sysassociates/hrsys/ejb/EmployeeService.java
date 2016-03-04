/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import mw.co.sysassociates.hrsys.entity.Dependant;
import mw.co.sysassociates.hrsys.entity.Education;
import mw.co.sysassociates.hrsys.entity.Employee;
import mw.co.sysassociates.hrsys.entity.LeaveDetails;
import mw.co.sysassociates.hrsys.entity.PrevEmployer;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Stateless
@Local(IEmployee.class)
public class EmployeeService implements IEmployee {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Employee> getEmployeeList() {
        return em.createNamedQuery("Employee.findAll").getResultList();
    }

    @Override
    public Employee findByFirstname(String firstname) {
        List<Employee> elementList = em.createNamedQuery("Employee.findByFirstname").setParameter("firstname", firstname).getResultList();
        return elementList.isEmpty() ? null : elementList.get(0);
    }

    @Override
    public int insertEmployee(String employeeNo, String company, String firstname, String surname, String sex, String title) throws EntityExistsException {
       // EntityTransaction userTransaction = em.getTransaction();

        //if (null != em.find(Employee.class, emp.getEmployeenumber())) {
        //		System.out.println("Goodbye!");
        //	    return 0;
        //	}else{
        try {
        //    userTransaction.begin();
            Employee emp;
            emp = new Employee(employeeNo, company, firstname,surname,sex,title);
            //emp.setFirstname(firstname);
            //emp.setSurname(surname);
            //emp.setSex(sex);
            //emp.setTitle(title);
            em.persist(emp);
            em.flush();
        //    userTransaction.commit();
            return 0;
            
        } catch (DatabaseException ex) {
            //Handle errors for JDBC
            System.out.println(ex.getMessage());
            return 3;            
        } catch (PersistenceException ex) {
            //Handle errors for JDBC
            System.out.println(ex.getMessage());
            return 3;
        } catch (Exception e) {
	    //Handle errors for Class.forName
            //e.printStackTrace();
            System.out.println(e.getMessage());
            return 4;
        } finally {
            //System.out.println("Goodbye!");
            return 5;
        }
        //  }
    }

    @Override
    public List<Education> getEmployeeEduDetails(Employee employee) {
        return employee.getEducation();
    }
    
    @Override
    public List<LeaveDetails> getEmployeeLeaveDetails(Employee employee) {
        return employee.getLeaveDetails();
    }
    
//    @Override
//    public List<PrevEmployer> getEmployeePrevEmployer(Employee employee) {
//        return employee.getPrevEmployer();
//    }
    
    @Override
    public List<Dependant> getEmployeeDependant(Employee employee) {
        return employee.getDependant();
    }
    
}
