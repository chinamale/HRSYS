/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import java.util.Collection;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import mw.co.sysassociates.hrsys.entity.Appraisal;
import mw.co.sysassociates.hrsys.entity.AppraisalScore;
import mw.co.sysassociates.hrsys.entity.Certificate;
import mw.co.sysassociates.hrsys.entity.Company;
import mw.co.sysassociates.hrsys.entity.Dependant;
import mw.co.sysassociates.hrsys.entity.Division;
import mw.co.sysassociates.hrsys.entity.Education;
import mw.co.sysassociates.hrsys.entity.Employee;
import mw.co.sysassociates.hrsys.entity.EmployeePK;
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
    public Employee findByCompAndEmplono(String company, String employeeNo) {
            EmployeePK emplopk;
            emplopk = new EmployeePK();
            emplopk.setCompany(company);
            emplopk.setEmployeenumber(employeeNo);
            return em.find(Employee.class, emplopk);
    }

    @Override
    public int insertEmployee(String employeeNo, String company, String firstname, String surname, String sex, String title, String division) throws EntityExistsException {
       // EntityTransaction userTransaction = em.getTransaction();

        //if (null != em.find(Employee.class, emp.getEmployeenumber())) {
        //		System.out.println("Goodbye!");
        //	    return 0;
        //	}else{
        try {
        //    userTransaction.begin();
            //Company comp = em.find(Company.class,company);
            Employee emp;
            EmployeePK emplopk;
            //PrevEmployer  prevemp;
            
            //emp = new Employee(employeeNo, comp.getCompanyId(), firstname, surname, sex, title);
            emplopk = new EmployeePK();
            emplopk.setCompany(company);
            emplopk.setEmployeenumber(employeeNo);
            
            emp = new Employee();
            emp.setEmploPK(emplopk); 
            emp.setFirstname(firstname);
            emp.setSurname(surname);
            emp.setSex(sex);
            emp.setTitle(title);
            int divkey = Integer.parseInt(division);
            Division div = em.find(Division.class,divkey);
            emp.setDivision(div);
            em.persist(emp);
         //   em.flush();
        //    userTransaction.commit();
            return 0;
            
        } catch (DatabaseException ex) {
            //Handle errors for JDBC
            System.out.println(ex.getMessage());
            return 1;            
        } catch (PersistenceException ex) {
            //Handle errors for JDBC
            System.out.println(ex.getMessage());
            return 2;
        } catch (Exception e) {
	    //Handle errors for Class.forName
            //e.printStackTrace();
            System.out.println(e.getMessage());
            return 3;
        } finally {
            //System.out.println("Goodbye!");
            return 4;
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
    public Collection getEmployeeDependant(Employee employee) {
        return employee.getDependant();
    }

    @Override
    public int addEducationDetails(String emplono, String company, String qualif, String instit, String yearFrom, String yearTo) {
       try {
        AppraisalScore appscore;
        EmployeePK emplopk;
        
        Company comp = em.find(Company.class, company);
        
        emplopk = new EmployeePK();
        emplopk.setCompany(company);
        emplopk.setEmployeenumber(emplono);
        
        Employee employee = em.find(Employee.class, emplopk);
        
        Education education = new Education();
        education.setEmployee(employee);
        education.setInstitution(instit);
        education.setYearfrom(yearFrom);
        education.setYearto(yearTo);
        
         List<Certificate> elementList = em.createNamedQuery("Certificate.findByCode").setParameter("code", qualif).setParameter("company", comp).getResultList();
         Certificate qualification = elementList.isEmpty() ? null : elementList.get(0);
        //if not found, abort the transaction
        education.setCertificate(qualification);
        employee.getEducation().add(education);
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
    }
    
}
