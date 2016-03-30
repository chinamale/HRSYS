/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import java.util.Date;
import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import mw.co.sysassociates.hrsys.entity.AppraisalScore;
import mw.co.sysassociates.hrsys.entity.Company;
import mw.co.sysassociates.hrsys.entity.Dependant;
import mw.co.sysassociates.hrsys.entity.Employee;
import mw.co.sysassociates.hrsys.entity.EmployeePK;
import mw.co.sysassociates.hrsys.entity.Relationship;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author Clifton T. Mtengezo
 */
@Stateless
@Local(IDependant.class)
public class DependantService implements IDependant{
    
    @PersistenceContext
    EntityManager em;
    
    @Override
public int inputDependant(String emplono, String company, String firstname, String surname, Date dateofbirth, String rltionship) throws EJBException,DatabaseException {
        try {
        EmployeePK emplopk;
        
        Company comp = em.find(Company.class, company);
        System.out.print("Setting employee to :" + emplono);
        System.out.print("Setting company to :" + company);
        
        emplopk = new EmployeePK();
        emplopk.setCompany(company);
        emplopk.setEmployeenumber(emplono);
        
        Employee employee = em.find(Employee.class, emplopk);
        
        Dependant dependant= new Dependant();
        dependant.setEmployee(employee);
        dependant.setFirstname(firstname);
        dependant.setSurname(surname);
        dependant.setDateofbirth(dateofbirth);
        
        int rlship = Integer.parseInt(rltionship);
        Relationship relationship = em.find(Relationship.class,rlship);
        dependant.setRelationship(relationship);
        em.persist(dependant);
        return 0;         
        } catch (DatabaseException ex) {
            //Handle errors for JDBC
            System.out.println(ex.getMessage());
            return 3;            
        } catch (PersistenceException ex) {
            //Handle errors for JDBC
            System.out.println(ex.getMessage());
            return 3;
        } catch (EJBException e) {
	    //Handle errors for Class.forName
            //e.printStackTrace();
            System.out.println(e.getMessage());
            return 4;
        } catch (Exception e) {
	    //Handle errors for Class.forName
            //e.printStackTrace();
            System.out.println(e.getMessage());
            return 5;   
        } finally {
            //System.out.println("Goodbye!");
            return 5;
        }
    }    
}
