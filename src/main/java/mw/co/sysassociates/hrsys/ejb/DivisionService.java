/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mw.co.sysassociates.hrsys.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import mw.co.sysassociates.hrsys.entity.Appraisal;
import mw.co.sysassociates.hrsys.entity.AppraisalScore;
import mw.co.sysassociates.hrsys.entity.Company;
import mw.co.sysassociates.hrsys.entity.Division;
import mw.co.sysassociates.hrsys.entity.Employee;
import mw.co.sysassociates.hrsys.entity.EmployeePK;
import org.eclipse.persistence.exceptions.DatabaseException;

/**
 *
 * @author Clifton T. Mtengezo
 */    
@Stateless
@Local(IDivision.class)
public class DivisionService implements IDivision {
    
    @PersistenceContext
    EntityManager em;

    @Override
    public int addDivision(String company, String code, String name, String longname, String abbreviation, String headedby) {
        try {
        AppraisalScore appscore;
        EmployeePK emplopk;
        
        Company comp = em.find(Company.class, company);       
       // Employee employee = em.find(Employee.class, headedby);
        
        Division division = new Division();
        division.setCompany(comp);
//        division.setHeadedby(employee);
        division.setAbbreviation(abbreviation);
        division.setName(name);
        division.setLongname(longname);
        division.setCode(code);
        em.persist(division);
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

    @Override
    public Division findDivisionByCompAndCode(Company comp, String divcode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
