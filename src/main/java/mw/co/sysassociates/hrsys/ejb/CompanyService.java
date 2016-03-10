/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import mw.co.sysassociates.hrsys.entity.Company;
import mw.co.sysassociates.hrsys.entity.Employee;
import mw.co.sysassociates.hrsys.entity.EmployeePK;
import mw.co.sysassociates.hrsys.entity.PrevEmployer;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Stateless
@Local(ICompany.class)
public class CompanyService implements ICompany {

    @PersistenceContext
    EntityManager em;

    @Override
    public int insertEmployee(String employeeNo, String firstname, String surname, String sex, String title) throws EntityExistsException {
       // EntityTransaction userTransaction = em.getTransaction();

        //if (null != em.find(Employee.class, emp.getEmployeenumber())) {
        //		System.out.println("Goodbye!");
        //	    return 0;
        //	}else{

        try {
            //userTransaction.begin();
            Company comp = em.find(Company.class,"01");
            Employee emp;
            EmployeePK emplopk;
            PrevEmployer  prevemp;
            
            //emp = new Employee(employeeNo, comp.getCompanyId(), firstname, surname, sex, title);
            emplopk = new EmployeePK();
            emplopk.setCompany(comp.getCompanyId());
            emplopk.setEmployeenumber(employeeNo);
            
            emp = new Employee();
            emp.setEmploPK(emplopk);         
            emp.setFirstname(firstname);
            emp.setSurname(surname);
            emp.setSex(sex);
            emp.setTitle(title);
            
            prevemp = new PrevEmployer();
            prevemp.setEmployee(emp);
            prevemp.setOrganisation("National Bank");
            prevemp.setYearfrom("1999");
            prevemp.setPost("Manager");
            //em.persist(prevemp);
            comp.getEmployees().add(emp);
   //         em.refresh(emp);
            //Employee emp1 = em.find(Employee.class,emplopk);
    //        emp.getPrevEmployer().add(prevemp);
            //em.merge(emp);
            //emp.getPrevEmployer().add(prevemp);
            //comp.
            em.persist(prevemp);
            
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

}
