/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import mw.co.sysassociates.hrsys.entity.Company;
import mw.co.sysassociates.hrsys.entity.Employee;
import mw.co.sysassociates.hrsys.entity.EmployeePK;
import mw.co.sysassociates.hrsys.exceptions.EntityFoundException;
import mw.co.sysassociates.hrsys.exceptions.EntityNotFoundException;
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
            Company comp = em.find(Company.class, "01");
            Employee emp;
            EmployeePK emplopk;
            //PrevEmployer  prevemp;            
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
            comp.getEmployees().add(emp);

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
    public int insertCompany(String companyno,String companyname, String companyshortname) throws EntityExistsException {
       //userTransaction.begin();
       // Company comp = em.find(Company.class, companyno);
       // if (comp == null) {
            Company comp1 = new Company();
            comp1.setCompanyId(companyno);
            comp1.setCompanyShortname(companyshortname);
            comp1.setCompanyName(companyname);
            em.persist(comp1);
            return 1;
       // } else {
       //     throw new EntityExistsException("A Company with ID : " + companyno + " already exists");
        //}

    }
    
    
    @Override
    public int insertCompany(Company company) throws EntityExistsException {

            em.persist(company);
            return 1;
    }
    

    @Override
    public Company findCompanyByPrimaryKey(String compKey) throws EntityNotFoundException,EJBException {
        Company comp;
        try {
        comp = em.find(Company.class, compKey);
        } catch (EJBException  e) {
            comp = null;
        }
      if (comp == null) {
            throw new EntityNotFoundException("A Company with ID : " + compKey + " does not exists");
        } else {
            return comp;
        }
    }

        @Override
    public Company findDuplicateCompanyByPrimaryKey(String compKey) throws EJBException, EntityFoundException {
        Company comp;
        try {
        comp = em.find(Company.class, compKey);
        } catch (EJBException e) {
            comp = null;
        }
      if (comp == null) {
return comp;  
        } else {
            throw new EntityFoundException("A Company with ID : " + compKey + " already exists");
        }
    }
    @Override
    public Company findCompanyByAbbrev(String compAbbr) throws EntityNotFoundException {

        List<Company> elementList = em.createNamedQuery("Company.findByAbbreviation").setParameter("abbrev", compAbbr).getResultList();

        return elementList.isEmpty() ? null : elementList.get(0);

    }

    @Override
    public Company findCompanyByName(String compName) throws EntityNotFoundException {
        //System.out.println("AdminEJB----Searching for user:" + loginname);
        List<Company> elementList = em.createNamedQuery("Company.findByName").setParameter("companyName", compName).getResultList();
        // Collection listOfActivities = elementList.get(0).getActivity();
        return elementList.isEmpty() ? null : elementList.get(0);
//        if (elementList.isEmpty()) {
//            throw new EntityNotFoundException("A Company with abbreviation : " + compName + " does not exists");
//        } else {
//            return elementList.get(0);
//        }
    }

}
